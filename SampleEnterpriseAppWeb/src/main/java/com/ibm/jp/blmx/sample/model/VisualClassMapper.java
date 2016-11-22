package com.ibm.jp.blmx.sample.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ibm.jp.blmx.sample.bean.ClassifyResults;
import com.ibm.jp.blmx.sample.bean.FaceResults;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ImageClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ImageFace;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier.VisualClass;

public class VisualClassMapper {

	public VisualClassMapper() {
		// TODO Auto-generated constructor stub
	}

	public static ClassifyResults mapVisualClass(ImageClassification classification) {
		ClassifyResults cr = new ClassifyResults();

		cr.setSourceUrl(classification.getSourceUrl());

		Iterator<VisualClassifier> ite = classification.getClassifiers().iterator();
		Map<String, Map<String, Double>> classifyMap = new HashMap<String, Map<String, Double>>();
		while (ite.hasNext()) {
			VisualClassifier classifier = ite.next();
			Iterator<VisualClass> iteClass = classifier.getClasses().iterator();
			Map<String, Double> classMap = new HashMap<>();
			while (iteClass.hasNext()) {
				VisualClass vc = iteClass.next();
				classMap.put(vc.getName(), vc.getScore());
			}
			classifyMap.put(classifier.getName(), classMap);
		}
		cr.setClassMap(classifyMap);

		return cr;
	}

	public static FaceResults mapFaceResult(ImageFace imageFace) {
		FaceResults results = new FaceResults();
		results.setSourceUrl(imageFace.getSourceUrl());
		results.setFaces(imageFace.getFaces());
		return results;
	}
}
