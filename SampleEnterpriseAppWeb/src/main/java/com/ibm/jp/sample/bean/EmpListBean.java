/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.bean;

import java.util.List;
import java.util.Map;

import com.ibm.jp.sample.ejb.entity.Employee;

/**
 * テーブルの一覧検索結果を保持する。
 * 
 * @author y_akamatsu
 *
 */
public class EmpListBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9220359200956799840L;

	private String condition;

	private List<Employee> list;

	private Map<String, Boolean> containsPhoto;

	/**
	 * 
	 */
	public EmpListBean() {
		// TODO Auto-generated constructor stub
	}

	public final String getCondition() {
		return condition;
	}

	public final void setCondition(String condition) {
		this.condition = condition;
	}

	public final List<Employee> getList() {
		return list;
	}

	public final void setList(List<Employee> list) {
		this.list = list;
	}

	public final Map<String, Boolean> getContainsPhoto() {
		return containsPhoto;
	}

	public final void setContainsPhoto(Map<String, Boolean> containsPhoto) {
		this.containsPhoto = containsPhoto;
	}

}
