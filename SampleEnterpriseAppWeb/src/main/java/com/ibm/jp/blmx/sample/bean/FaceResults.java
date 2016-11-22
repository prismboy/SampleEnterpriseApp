package com.ibm.jp.blmx.sample.bean;

import java.util.List;

import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Face;

public class FaceResults extends VisualRecognitionResults {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1407178748268721856L;

	public FaceResults() {
		// TODO Auto-generated constructor stub
	}

	private List<Face> faces;

	public final List<Face> getFaces() {
		return faces;
	}

	public final void setFaces(List<Face> faces) {
		this.faces = faces;
	}
}
