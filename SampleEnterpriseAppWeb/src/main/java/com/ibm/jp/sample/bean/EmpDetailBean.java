/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.bean;

import java.io.Serializable;

import com.ibm.jp.sample.ejb.entity.Employee;

/**
 * 行のデータを保持する。
 * 
 * @author y_akamatsu
 *
 */
public class EmpDetailBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8626391923461917521L;

	private Employee entiry;
	private String message;
	private String condition;

	public EmpDetailBean() {
		// TODO Auto-generated constructor stub
	}

	public final Employee getEntiry() {
		return entiry;
	}

	public final void setEntiry(Employee entiry) {
		this.entiry = entiry;
	}

	public final String getMessage() {
		return message;
	}

	public final void setMessage(String message) {
		this.message = message;
	}

	public final String getCondition() {
		return condition;
	}

	public final void setCondition(String condition) {
		this.condition = condition;
	}

}
