package com.ibm.jp.blmx.sample.ejb.bean;

import java.io.Serializable;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.openstack4j.model.common.Identifier;

public class ObjectStrageCredentials implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2404373647731748591L;
	private static final String _VCAP_SERVICES = "VCAP_SERVICES";
	private static final String _OBJECT_STRAGE = "Object-Storage";
	private static final String _CREDENTIALS = "credentials";
	private static final String _USER_NAME = "username";
	private static final String _PASSWORD = "password";
	private static final String _AUTH_URL = "auth_url";
	private static final String _DOMAIN_ID = "domainId";
	private static final String _PROJECT_ID = "projectId";
	private static final String _REGION = "region";

	private String userName;
	private String password;
	private String auth_url;
	private String domainId;
	private String projectId;
	private Identifier domainIdent;
	private Identifier projectIdent;
	private String region;

	public ObjectStrageCredentials() {
		StringReader sr = new StringReader(System.getenv(_VCAP_SERVICES));
		JsonReader reader = Json.createReader(sr);
		JsonObject vcapServices = reader.readObject();
		JsonObject vcap = vcapServices.getJsonArray(_OBJECT_STRAGE).getJsonObject(0);
		JsonObject credentials = vcap.getJsonObject(_CREDENTIALS);
		setUserName(credentials.getString(_USER_NAME));
		setPassword(credentials.getString(_PASSWORD));
		setAuth_url(credentials.getString(_AUTH_URL)+"/v3");
		setDomainId(credentials.getString(_DOMAIN_ID));
		setProjectId(credentials.getString(_PROJECT_ID));
		setDomainIdent(Identifier.byId(getDomainId()));
		setProjectIdent(Identifier.byId(getProjectId()));
		setRegion(credentials.getString(_REGION));
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final String getAuth_url() {
		return auth_url;
	}

	public final void setAuth_url(String auth_url) {
		this.auth_url = auth_url;
	}

	public final Identifier getDomainIdent() {
		return domainIdent;
	}

	public final void setDomainIdent(Identifier domainIdent) {
		this.domainIdent = domainIdent;
	}

	public final Identifier getProjectIdent() {
		return projectIdent;
	}

	public final void setProjectIdent(Identifier projectIdent) {
		this.projectIdent = projectIdent;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public final String getUserName() {
		return userName;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final String getRegion() {
		return region;
	}

	public final void setRegion(String region) {
		this.region = region;
	}

}
