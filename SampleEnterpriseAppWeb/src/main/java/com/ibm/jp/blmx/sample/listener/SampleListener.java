package com.ibm.jp.blmx.sample.listener;

import static com.ibm.jp.blmx.sample.constants.SampleEnterpriseAppConstants._ATTR_NAME_EJB_001;
import static com.ibm.jp.blmx.sample.constants.SampleEnterpriseAppConstants._JNDI_NAME_EJB_001;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class SampleListener
 *
 */
@WebListener
public class SampleListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public SampleListener() {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Context ctx = new InitialContext();
			Object obj = null;
			try {
				obj = ctx.lookup(_JNDI_NAME_EJB_001);
			} catch (Exception e) {
				System.out.print("JNDI name not found \"" + _JNDI_NAME_EJB_001 + "\"");
			}
			sce.getServletContext().setAttribute(_ATTR_NAME_EJB_001, obj);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
