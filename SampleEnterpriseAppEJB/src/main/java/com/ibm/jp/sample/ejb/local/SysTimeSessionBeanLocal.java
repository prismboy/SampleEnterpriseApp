/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.ejb.local;

import javax.ejb.Local;

/**
 * システム日付を取得する。
 * 
 * @author y_akamatsu
 *
 */
@Local
public interface SysTimeSessionBeanLocal {

	Long getCurrentTimeMillis();
}
