package com.ibm.jp.blmx.sample.ejb.local;

import java.util.List;

import javax.ejb.Local;

import com.ibm.jp.blmx.sample.ejb.entity.Employee;

@Local
public interface EmployeeSessionBeanLocal {

	Employee findById(String empno);

	List<Employee> findAll();
}
