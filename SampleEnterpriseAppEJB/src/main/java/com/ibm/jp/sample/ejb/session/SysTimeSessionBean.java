/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.ejb.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ibm.jp.sample.ejb.local.SysTimeSessionBeanLocal;

/**
 * Session Bean implementation class SysTimeSessionBean
 * 
 * @author y_akamatsu
 */
@Stateless
@LocalBean
public class SysTimeSessionBean implements SysTimeSessionBeanLocal {

    /**
     * Default constructor. 
     */
    public SysTimeSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}

}
