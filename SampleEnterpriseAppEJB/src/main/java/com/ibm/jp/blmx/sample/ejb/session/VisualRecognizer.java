package com.ibm.jp.blmx.sample.ejb.session;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.ibm.jp.blmx.sample.ejb.bean.Credentials;
import com.ibm.jp.blmx.sample.ejb.bean.WatsonVisionCombined;
import com.ibm.jp.blmx.sample.ejb.local.VisualRecognizerLocal;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ImageClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ImageFace;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;

/**
 * Session Bean implementation class VisualRecongizer
 */
@Stateless
@LocalBean
public class VisualRecognizer implements VisualRecognizerLocal {

	private WatsonVisionCombined wvc;

	/**
	 * Default constructor.
	 */
	public VisualRecognizer() {
	}

	public ImageClassification classifyImage(String url, Map<String, String> headers) {
		if (wvc == null) {
			setCredentionsInfo();
		}
		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20,
				wvc.getCredentials().getApi_key());
		//service.setDefaultHeaders(headers);
		List<String> classifiers = null;
		if (System.getenv(_CLASSIFIER_IDS) != null) {
			String[] classifierIds = System.getenv(_CLASSIFIER_IDS).split(",");
			classifiers = Arrays.asList(classifierIds);
		} else {
			classifiers = new ArrayList<>();
			classifiers.add("default");
		}
		ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().url(url).classifierIds(classifiers).build();
		VisualClassification result = service.classify(options).execute();

		return result.getImages().get(0);
	}

	@Override
	public ImageFace detectFaces(String url) {
		if (wvc == null) {
			setCredentionsInfo();
		}
		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20,
				wvc.getCredentials().getApi_key());

		VisualRecognitionOptions options = new VisualRecognitionOptions.Builder().url(url).build();
		DetectedFaces result = service.detectFaces(options).execute();
		return result.getImages().get(0);
	}

	private void setCredentionsInfo() {
		StringReader sr = new StringReader(System.getenv(_ENV_NAME));
		JsonReader reader = Json.createReader(sr);
		JsonObject vcapServices = reader.readObject();
		JsonArray wvcArray = vcapServices.getJsonArray(_WATSON_VISUAL_RECOGNITION);

		wvc = toBean(wvcArray.getJsonObject(0));
	}

	private WatsonVisionCombined toBean(JsonObject obj) {
		WatsonVisionCombined wvc = new WatsonVisionCombined();
		wvc.setLabel(obj.getString("label"));
		wvc.setName(obj.getString("name"));
		wvc.setPlan(obj.getString("plan"));
		// wvc.setProvider(obj.getString("provider"));
		// wvc.setSyslog_drain_url(obj.getString("syslog_drain_url"));

		Credentials credentials = new Credentials();
		JsonObject objCre = obj.getJsonObject("credentials");
		credentials.setApi_key(objCre.getString("api_key"));
		credentials.setNote(objCre.getString("note"));
		credentials.setUrl(objCre.getString("url"));
		wvc.setCredentials(credentials);

		JsonArray jsonArray = obj.getJsonArray("tags");
		List<String> tags = new ArrayList<>();
		for (int i = 0; i < jsonArray.size(); i++) {
			tags.add(jsonArray.getString(i));
		}
		wvc.setTags(tags);

		return wvc;
	}
}
