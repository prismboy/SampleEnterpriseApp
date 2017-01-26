package com.ibm.jp.blmx.sample.ejb.local;

import java.util.Map;

import javax.ejb.Local;

import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ImageClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ImageFace;

@Local
public interface VisualRecognizerLocal {
	String _ENV_NAME = "VCAP_SERVICES";
	String _WATSON_VISUAL_RECOGNITION = "watson_vision_combined";
	String _CLASSIFIER_IDS = "CLASSIFIER_IDS";

	ImageClassification classifyImage(String url, Map<String, String> headers);
	ImageFace detectFaces(String url);
}
