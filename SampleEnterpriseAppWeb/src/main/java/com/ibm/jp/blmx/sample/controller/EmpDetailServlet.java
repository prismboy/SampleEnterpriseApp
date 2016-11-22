/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.blmx.sample.controller;

import static com.ibm.jp.blmx.sample.constants.SampleEnterpriseAppConstants._JNDI_NAME_EJB_002;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.blmx.sample.bean.EmpDetailBean;
import com.ibm.jp.blmx.sample.ejb.local.SampleJpaSessionBeanLocal;

/**
 * Servlet implementation class EmpDetailServlet
 * 
 * @author y_akamatsu
 */
@WebServlet("/empDetail")
public class EmpDetailServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private static final String _NEXT_URL = "/WEB-INF/jsp/empdetail.jsp";

	private SampleJpaSessionBeanLocal local;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpDetailServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			local = (SampleJpaSessionBeanLocal) getSessionBean(_JNDI_NAME_EJB_002);
		} catch (NamingException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpDetailBean bean = new EmpDetailBean();
		String empNo = request.getParameter("empNo");
		if (isEmpty(empNo)) {
			bean.setMessage("Please input employee number.");
		} else if (local != null) {
			bean.setCondition(request.getParameter("condition"));
			bean.setEntiry(local.findById(empNo));
			if(bean.getEntiry()==null) {
				bean.setMessage("Employee no. \"" + empNo + "\" not found.");
			}
		}
		request.setAttribute("bean", bean);

		forwardNext(request, response, _NEXT_URL);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpDetailBean bean = new EmpDetailBean();
		request.setAttribute("bean", bean);

		forwardNext(request, response, _NEXT_URL);
	}
	*/

}
