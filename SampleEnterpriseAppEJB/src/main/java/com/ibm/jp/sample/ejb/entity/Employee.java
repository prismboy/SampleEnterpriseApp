/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the EMPLOYEE database table.
 * 
 * @author y_akamatsu
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
	@NamedQuery(name = "Employee.list", query = "SELECT e FROM Employee e WHERE e.empno LIKE (:empNo)")
})
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String empno;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private BigDecimal bonus;

	@Column(name = "\"COMM\"")
	private BigDecimal comm;

	private short edlevel;

	private String firstnme;

	@Temporal(TemporalType.DATE)
	private Date hiredate;

	private String job;

	private String lastname;

	private String midinit;

	private String phoneno;

	private BigDecimal salary;

	private String sex;

	private String workdept;

	// bi-directional many-to-one association to EmpPhoto
	@OneToMany(mappedBy = "employee")
	private List<EmpPhoto> empPhotos;

	public Employee() {
	}

	public String getEmpno() {
		return this.empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public BigDecimal getBonus() {
		return this.bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public BigDecimal getComm() {
		return this.comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	public short getEdlevel() {
		return this.edlevel;
	}

	public void setEdlevel(short edlevel) {
		this.edlevel = edlevel;
	}

	public String getFirstnme() {
		return this.firstnme;
	}

	public void setFirstnme(String firstnme) {
		this.firstnme = firstnme;
	}

	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMidinit() {
		return this.midinit;
	}

	public void setMidinit(String midinit) {
		this.midinit = midinit;
	}

	public String getPhoneno() {
		return this.phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWorkdept() {
		return this.workdept;
	}

	public void setWorkdept(String workdept) {
		this.workdept = workdept;
	}

	public List<EmpPhoto> getEmpPhotos() {
		return this.empPhotos;
	}

	public void setEmpPhotos(List<EmpPhoto> empPhotos) {
		this.empPhotos = empPhotos;
	}

	public EmpPhoto addEmpPhoto(EmpPhoto empPhoto) {
		getEmpPhotos().add(empPhoto);
		empPhoto.setEmployee(this);

		return empPhoto;
	}

	public EmpPhoto removeEmpPhoto(EmpPhoto empPhoto) {
		getEmpPhotos().remove(empPhoto);
		empPhoto.setEmployee(null);

		return empPhoto;
	}

}