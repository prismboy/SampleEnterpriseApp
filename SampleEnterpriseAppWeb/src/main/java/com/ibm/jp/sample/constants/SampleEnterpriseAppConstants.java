/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.constants;

/**
 * アプリケーションで使用する定数を一括で保持する。
 * 
 * @author y_akamatsu
 *
 */
public class SampleEnterpriseAppConstants {

	public static final String _DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss.SSS zZ";
	public static final String _ATTR_NAME_EJB_001 = "SysTimeSessionBean";

	public static final String _JNDI_NAME_EJB_001 = "java:global/SampleEnterpriseApp/SampleEnterpriseAppEJB/SysTimeSessionBean!com.ibm.jp.sample.ejb.local.SysTimeSessionBeanLocal";

	public static final String _JNDI_NAME_EJB_002 = "java:global/SampleEnterpriseApp/SampleEnterpriseAppEJB/SampleJpaSessionBean!com.ibm.jp.sample.ejb.local.SampleJpaSessionBeanLocal";

}
