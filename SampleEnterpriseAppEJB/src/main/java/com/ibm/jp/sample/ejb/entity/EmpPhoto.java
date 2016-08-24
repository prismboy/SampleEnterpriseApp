/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMP_PHOTO database table.
 * 
 * @author y_akamatsu
 */
@Entity
@Table(name="EMP_PHOTO")
@NamedQueries({
	@NamedQuery(name="EmpPhoto.findAll", query="SELECT e FROM EmpPhoto e"),
	@NamedQuery(name="EmpPhoto.contains", query="SELECT e FROM EmpPhoto e WHERE e.id.empno = (:empno)")
})
public class EmpPhoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmpPhotoPK id;

	@Lob
	private byte[] picture;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPNO")
	private Employee employee;

	public EmpPhoto() {
	}

	public EmpPhotoPK getId() {
		return this.id;
	}

	public void setId(EmpPhotoPK id) {
		this.id = id;
	}

	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}