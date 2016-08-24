/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EMP_PHOTO database table.
 * 
 * @author y_akamatsu
 */
@Embeddable
public class EmpPhotoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String empno;

	@Column(name="PHOTO_FORMAT")
	private String photoFormat;

	public EmpPhotoPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmpPhotoPK)) {
			return false;
		}
		EmpPhotoPK castOther = (EmpPhotoPK)other;
		return 
			this.empno.equals(castOther.empno)
			&& this.photoFormat.equals(castOther.photoFormat);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.empno.hashCode();
		hash = hash * prime + this.photoFormat.hashCode();
		
		return hash;
	}
}