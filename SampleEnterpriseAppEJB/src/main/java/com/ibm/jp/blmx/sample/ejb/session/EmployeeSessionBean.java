package com.ibm.jp.blmx.sample.ejb.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ibm.jp.blmx.sample.ejb.entity.Employee;
import com.ibm.jp.blmx.sample.ejb.local.EmployeeSessionBeanLocal;

/**
 * Session Bean implementation class EmployeeSessionBean
 */
@Stateless
@LocalBean
public class EmployeeSessionBean implements EmployeeSessionBeanLocal {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public EmployeeSessionBean() {
	}

	@Override
	public Employee findById(String empno) {
		return em.find(Employee.class, empno);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		Query query = em.createNamedQuery("Employee.findAll");
		return query.getResultList();
	}

}
