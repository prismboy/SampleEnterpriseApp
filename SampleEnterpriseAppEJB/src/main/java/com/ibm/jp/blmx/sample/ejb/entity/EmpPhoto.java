package com.ibm.jp.blmx.sample.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emp_photo database table.
 * 
 */
@Entity
@Table(name="emp_photo")
@NamedQueries({
	@NamedQuery(name="EmpPhoto.findAll", query="SELECT e FROM EmpPhoto e"),
	@NamedQuery(name="EmpPhoto.findByPk", query="SELECT e FROM EmpPhoto e WHERE e.id.empno = :empno AND e.id.photoFormat = :photoFormat"),
	@NamedQuery(name="EmpPhoto.findByEmpno", query="SELECT e FROM EmpPhoto e WHERE e.empno = :empNo"),
	@NamedQuery(name="EmpPhoto.contains", query="SELECT e FROM EmpPhoto e WHERE e.id.empno = (:empno)")
})
public class EmpPhoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmpPhotoPK id;

	private String empno;

	@Column(name="PHOTO_FORMAT")
	private String photoFormat;

	@Lob
	private byte[] picture;

	public EmpPhoto() {
	}

	public EmpPhotoPK getId() {
		return this.id;
	}

	public void setId(EmpPhotoPK id) {
		this.id = id;
	}

	public String getEmpno() {
		return this.empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getPhotoFormat() {
		return this.photoFormat;
	}

	public void setPhotoFormat(String photoFormat) {
		this.photoFormat = photoFormat;
	}

	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

}