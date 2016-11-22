/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.blmx.sample.model;

import java.util.HashMap;
import java.util.Map;

import com.ibm.jp.blmx.sample.bean.EmpListBean;
import com.ibm.jp.blmx.sample.ejb.entity.Employee;
import com.ibm.jp.blmx.sample.ejb.local.SampleJpaSessionBeanLocal;

/**
 * テーブルの一覧検索を実行する。
 * 
 * @author y_akamatsu
 *
 */
public class EmpListModel {
	private SampleJpaSessionBeanLocal sessionBean;

	/**
	 * 
	 */
	private EmpListModel() {
	}

	public static final EmpListModel getInstance(SampleJpaSessionBeanLocal local) {
		EmpListModel model = new EmpListModel();
		model.setSessionBean(local);

		return model;
	}

	public EmpListBean execute(String condition) {
		EmpListBean bean = new EmpListBean();
		bean.setCondition(condition);
		bean.setList(sessionBean.listEmployee(condition));
		Map<String, Boolean> map = new HashMap<>();
		for(Employee employee : bean.getList()){
			int contains = sessionBean.containsPhoto(employee.getEmpno());
			if(contains>0){
				map.put(employee.getEmpno(), true);
			} else {
				map.put(employee.getEmpno(), false);
			}
		}

		bean.setContainsPhoto(map);

		return bean;
	}

	private final void setSessionBean(SampleJpaSessionBeanLocal sessionBean) {
		this.sessionBean = sessionBean;
	}

}
