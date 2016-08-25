/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.bean;

import java.io.Serializable;

/**
 * システム日付を保持する。
 * 
 * @author y_akamatsu
 *
 */
public class SysTimeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7919575754334444324L;

	private String currentDateTime;
	private Long currentTimeMillis;

	public SysTimeBean() {
	}

	public final String getCurrentDateTime() {
		return currentDateTime;
	}

	public final void setCurrentDateTime(String currentDateTime) {
		this.currentDateTime = currentDateTime;
	}

	public final Long getCurrentTimeMillis() {
		return currentTimeMillis;
	}

	public final void setCurrentTimeMillis(Long currentTimeMillis) {
		this.currentTimeMillis = currentTimeMillis;
	}

}
