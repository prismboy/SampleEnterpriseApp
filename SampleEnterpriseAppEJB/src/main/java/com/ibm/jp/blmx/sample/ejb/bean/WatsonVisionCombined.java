package com.ibm.jp.blmx.sample.ejb.bean;

import java.io.Serializable;
import java.util.List;

public class WatsonVisionCombined implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4006242166908060299L;

	private Credentials credentials;
	private String syslog_drain_url;
	private String label;
	private String provider;
	private String plan;
	private String name;
	private List<String> tags;

	public WatsonVisionCombined() {
		// TODO Auto-generated constructor stub
	}

	public final Credentials getCredentials() {
		return credentials;
	}

	public final void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public final String getSyslog_drain_url() {
		return syslog_drain_url;
	}

	public final void setSyslog_drain_url(String syslog_drain_url) {
		this.syslog_drain_url = syslog_drain_url;
	}

	public final String getLabel() {
		return label;
	}

	public final void setLabel(String label) {
		this.label = label;
	}

	public final String getProvider() {
		return provider;
	}

	public final void setProvider(String provider) {
		this.provider = provider;
	}

	public final String getPlan() {
		return plan;
	}

	public final void setPlan(String plan) {
		this.plan = plan;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final List<String> getTags() {
		return tags;
	}

	public final void setTags(List<String> tags) {
		this.tags = tags;
	}

}
