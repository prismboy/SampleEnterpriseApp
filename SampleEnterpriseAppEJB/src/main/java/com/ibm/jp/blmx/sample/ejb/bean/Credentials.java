package com.ibm.jp.blmx.sample.ejb.bean;

import java.io.Serializable;

public class Credentials implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4560356690559080992L;

	private String url;
	private String note;
	private String api_key;

	public Credentials() {
		// TODO Auto-generated constructor stub
	}

	public final String getUrl() {
		return url;
	}

	public final void setUrl(String url) {
		this.url = url;
	}

	public final String getNote() {
		return note;
	}

	public final void setNote(String note) {
		this.note = note;
	}

	public final String getApi_key() {
		return api_key;
	}

	public final void setApi_key(String api_key) {
		this.api_key = api_key;
	}

}
