/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.blmx.sample.model;

import static com.ibm.jp.blmx.sample.constants.SampleEnterpriseAppConstants._DATE_TIME_FORMAT;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ibm.jp.blmx.sample.bean.SysTimeBean;
import com.ibm.jp.blmx.sample.ejb.local.SysTimeSessionBeanLocal;

/**
 * システム日付取得ロジック
 * 
 * @author y_akamatsu
 *
 */
public class SysTimeModel {
	private SimpleDateFormat sdf;

	public SysTimeModel() {
		sdf = new SimpleDateFormat(_DATE_TIME_FORMAT);
	}

	public SysTimeBean execute(SysTimeSessionBeanLocal session) throws Exception {
		SysTimeBean bean = new SysTimeBean();
		if (session != null) {
			bean.setCurrentTimeMillis(session.getCurrentTimeMillis());
			bean.setCurrentDateTime(sdf.format(new Date(bean.getCurrentTimeMillis())));
		}

		return bean;
	}
}
