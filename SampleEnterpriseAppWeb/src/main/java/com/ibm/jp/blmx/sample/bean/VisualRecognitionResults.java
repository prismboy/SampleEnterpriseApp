package com.ibm.jp.blmx.sample.bean;

import java.io.Serializable;

public class VisualRecognitionResults implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1407178748268721856L;

	public VisualRecognitionResults() {
		// TODO Auto-generated constructor stub
	}

	private String sourceUrl;
	private String apiKind;

	public final String getSourceUrl() {
		return sourceUrl;
	}

	public final void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public final String getApiKind() {
		return apiKind;
	}

	public final void setApiKind(String apiKind) {
		this.apiKind = apiKind;
	}
}
