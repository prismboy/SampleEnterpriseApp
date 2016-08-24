/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.ejb.local;

import java.util.List;

import javax.ejb.Local;

import com.ibm.jp.sample.ejb.entity.EmpPhoto;
import com.ibm.jp.sample.ejb.entity.Employee;

/**
 * JPAを使用してデータベースにアクセスするEJBのサンプル
 * 
 * @author y_akamatsu
 *
 */
@Local
public interface SampleJpaSessionBeanLocal {

	List<Employee> listEmployee(String id_part);

	Employee findById(String id);

	int containsPhoto(String empno);
	
	EmpPhoto getPhoto(String empno);
}
