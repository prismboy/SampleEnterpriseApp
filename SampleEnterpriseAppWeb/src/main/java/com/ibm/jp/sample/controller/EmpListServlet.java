/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.controller;

import static com.ibm.jp.sample.constants.SampleEnterpriseAppConstants._JNDI_NAME_EJB_002;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.sample.bean.EmpListBean;
import com.ibm.jp.sample.ejb.local.SampleJpaSessionBeanLocal;
import com.ibm.jp.sample.model.EmpListModel;

/**
 * Servlet implementation class EmpListServlet
 * 
 * @author y_akamatsu
 */
@WebServlet("/empList")
public class EmpListServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private static final String _NEXT_URL = "/WEB-INF/jsp/emplist.jsp";

	private SampleJpaSessionBeanLocal local;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpListServlet() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpListBean bean = new EmpListBean();
		String condition = request.getParameter("condition");
		if (!isEmpty(condition)) {
			EmpListModel model = EmpListModel.getInstance(local);
			bean = model.execute(condition);
		}
		request.setAttribute("bean", bean);
		forwardNext(request, response, _NEXT_URL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpListBean bean = new EmpListBean();
		String condition = request.getParameter("condition");
		if (isEmpty(condition)) {
			bean.setMessage("検索条件を入力してください");
		} else {
			EmpListModel model = EmpListModel.getInstance(local);
			bean = model.execute(condition);
		}
		request.setAttribute("bean", bean);
		forwardNext(request, response, _NEXT_URL);
	}

}
