/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.jp.sample.bean.SessionStatusBean;

/**
 * Servlet implementation class SessionStatusServlet
 * 
 * @author y_akamatsu
 */
@WebServlet("/sessionStatus")
public class SessionStatusServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private static final String _BEAN_LABEL = "bean";
	private static final String _DESTINATION = "/WEB-INF/jsp/sessionstatus.jsp";
	private static final String _INSTANCE_INDEX = "CF_INSTANCE_INDEX";

	/**
	 * @see BaseServlet#BaseServlet()
	 */
	public SessionStatusServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		SessionStatusBean bean = null;

		if (session != null) {
			bean = (SessionStatusBean) session.getAttribute(_BEAN_LABEL);
		} else {
			session = request.getSession();
		}

		if (bean == null) {
			bean = new SessionStatusBean();
			bean.setCreated(true);
			bean.setCreateTime(new Date().toString());
			session.setAttribute(_BEAN_LABEL, bean);
		} else {
			bean.setCreated(false);
			bean.increment();
		}
		bean.setInstanceIndex(System.getenv(_INSTANCE_INDEX));
		request.getRequestDispatcher(_DESTINATION).forward(request, response);
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
