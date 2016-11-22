package com.ibm.jp.blmx.sample.ejb.session;

import com.ibm.jp.blmx.sample.ejb.entity.EmpPhoto;
import com.ibm.jp.blmx.sample.ejb.entity.EmpPhotoPK;
import com.ibm.jp.blmx.sample.ejb.local.EmpPhotoSessionBeanLocal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class EmpPhotoSessionBean
 */
@Stateless
@LocalBean
public class EmpPhotoSessionBean implements EmpPhotoSessionBeanLocal {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public EmpPhotoSessionBean() {
	}

	@Override
	public EmpPhoto findByPk(EmpPhotoPK pk) {
		EmpPhoto empPhoto = em.find(EmpPhoto.class, pk);
		return empPhoto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmpPhoto> listByEmpNo(String empNo) {
		Query query = em.createNamedQuery("empPhoto.findByEmpno");
		query.setParameter("empNo", empNo);
		List<EmpPhoto> list = query.getResultList();

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmpPhoto> listAll() {
		Query query = em.createNamedQuery("empPhoto.findAll");
		return query.getResultList();
	}

}
