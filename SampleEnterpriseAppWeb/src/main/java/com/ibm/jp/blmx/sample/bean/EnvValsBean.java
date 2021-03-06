/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.blmx.sample.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * ランタイムの環境変数を保持する。
 * 
 * @author y_akamatsu
 *
 */
public class EnvValsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4577508419669866526L;
	private Map<String, String> envMap;

	public EnvValsBean() {
	}

	public final Map<String, String> getEnvMap() {
		return envMap;
	}

	public final void setEnvMap(Map<String, String> envMap) {
		this.envMap = envMap;
	}
}
