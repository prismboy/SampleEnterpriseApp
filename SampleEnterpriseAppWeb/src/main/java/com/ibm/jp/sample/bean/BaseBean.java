/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.bean;

import java.io.Serializable;

/**
 * アプリケーション共通基底クラス
 * 
 * @author y_akamatsu
 *
 */
public abstract class BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 画面表示メッセージ
	 */
	protected String message;

	/**
	 * 
	 */
	public BaseBean() {
	}

	public final String getMessage() {
		return message;
	}

	public final void setMessage(String message) {
		this.message = message;
	}

}
