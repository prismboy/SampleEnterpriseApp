package com.ibm.jp.blmx.sample.bean;

import java.util.Map;

public class ClassifyResults extends VisualRecognitionResults {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1407178748268721856L;

	public ClassifyResults() {
		// TODO Auto-generated constructor stub
	}

	private Map<String, Map<String, Double>> classMap;

	public final Map<String, Map<String, Double>> getClassMap() {
		return classMap;
	}

	public final void setClassMap(Map<String, Map<String, Double>> classMap) {
		this.classMap = classMap;
	}
}
