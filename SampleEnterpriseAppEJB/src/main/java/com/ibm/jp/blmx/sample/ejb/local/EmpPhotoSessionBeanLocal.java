package com.ibm.jp.blmx.sample.ejb.local;

import java.util.List;

import javax.ejb.Local;

import com.ibm.jp.blmx.sample.ejb.entity.EmpPhoto;
import com.ibm.jp.blmx.sample.ejb.entity.EmpPhotoPK;

@Local
public interface EmpPhotoSessionBeanLocal {

	EmpPhoto findByPk(EmpPhotoPK pk);

	List<EmpPhoto> listByEmpNo(String empNo);

	List<EmpPhoto> listAll();
}
