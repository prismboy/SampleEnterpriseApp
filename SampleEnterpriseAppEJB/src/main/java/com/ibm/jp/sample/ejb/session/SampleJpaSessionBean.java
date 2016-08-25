/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.ejb.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ibm.jp.sample.ejb.entity.EmpPhoto;
import com.ibm.jp.sample.ejb.entity.EmpPhotoPK;
import com.ibm.jp.sample.ejb.entity.Employee;
import com.ibm.jp.sample.ejb.local.SampleJpaSessionBeanLocal;

/**
 * Session Bean implementation class SampleJpaSessionBean
 * 
 * @author y_akamatsu
 */
@Stateless
@LocalBean
public class SampleJpaSessionBean implements SampleJpaSessionBeanLocal {
	private static final String _PHOTO_FORMAT_BITMAP = "bitmap";
	private static final String _PHOTO_FORMAT_GIF = "gif";

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public SampleJpaSessionBean() {
	}

	@Override
	public List<Employee> listEmployee(String id_part) {
		String cond = id_part.replaceAll("\\*", "%");
		if (!cond.contains("%")) {
			cond = cond + "%";
		}

		return em.createNamedQuery("Employee.list", Employee.class).setParameter("empNo", cond).getResultList();
	}

	@Override
	public Employee findById(String id) {
		return em.find(Employee.class, id);
	}

	@Override
	public int containsPhoto(String empno) {
		EmpPhotoPK pk = new EmpPhotoPK();
		pk.setEmpno(empno);
		pk.setPhotoFormat("%");
		List<EmpPhoto> list = em.createNamedQuery("EmpPhoto.contains",EmpPhoto.class).setParameter("empno", empno).getResultList();
		return list.size();
	}

	@Override
	public EmpPhoto getPhoto(String empno) {
		EmpPhotoPK pk = new EmpPhotoPK();
		pk.setEmpno(empno);
		pk.setPhotoFormat(_PHOTO_FORMAT_BITMAP);
		EmpPhoto photo = em.find(EmpPhoto.class, pk);
		if(photo == null){
			pk.setPhotoFormat(_PHOTO_FORMAT_GIF);
			photo = em.find(EmpPhoto.class, pk);
		}

		return photo;
	}
}
