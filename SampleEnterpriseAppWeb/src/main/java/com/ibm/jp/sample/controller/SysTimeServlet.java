/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.controller;

import static com.ibm.jp.sample.constants.SampleEnterpriseAppConstants._ATTR_NAME_EJB_001;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.sample.bean.SysTimeBean;
import com.ibm.jp.sample.ejb.local.SysTimeSessionBeanLocal;
import com.ibm.jp.sample.model.SysTimeModel;

/**
 * Servlet implementation class SysTimeServlet
 * 
 * @author y_akamatsu
 */
@WebServlet("/systime")
public class SysTimeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private SysTimeSessionBeanLocal sessionBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SysTimeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		sessionBean = (SysTimeSessionBeanLocal) config.getServletContext().getAttribute(_ATTR_NAME_EJB_001);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SysTimeModel model = new SysTimeModel();
		try {
			SysTimeBean bean = model.execute(sessionBean);
			request.setAttribute("bean", bean);
			forwardNext(request, response, "/WEB-INF/jsp/systime.jsp");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
