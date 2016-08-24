/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.bean;

import java.io.Serializable;

/**
 * HTTPセッションの状況を保持する。
 * 
 * @author y_akamatsu
 *
 */
public class SessionStatusBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -348916038973075472L;

	private boolean created;

	private String createTime;

	private String instanceIndex;

	private int accessCount;

	/**
	 * 
	 */
	public SessionStatusBean() {
		// TODO Auto-generated constructor stub
	}

	public final String getCreateTime() {
		return createTime;
	}

	public final void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public final boolean isCreated() {
		return created;
	}

	public final void setCreated(boolean created) {
		this.created = created;
	}

	public String getInstanceIndex() {
		return instanceIndex;
	}

	public void setInstanceIndex(String instanceIndex) {
		this.instanceIndex = instanceIndex;
	}

	public final int getAccessCount() {
		return accessCount;
	}

	public final void increment() {
		accessCount++;
	}

}
