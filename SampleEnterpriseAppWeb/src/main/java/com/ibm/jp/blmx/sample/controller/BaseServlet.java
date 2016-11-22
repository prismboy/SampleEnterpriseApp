package com.ibm.jp.blmx.sample.controller;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void controlCache(HttpServletResponse response){
		response.setContentType("text/html; charset=utf-8");
		response.setHeader("Cache", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
	}

	protected boolean isEmpty(String val) {
		return val == null || "".equals(val);
	}

	protected void forwardNext(HttpServletRequest request, HttpServletResponse response, String next)
			throws ServletException, IOException {
		controlCache(response);

		request.getRequestDispatcher(next).forward(request, response);
	}

	protected Object getSessionBean(String jndiName) throws NamingException {
		Context ctx;
		Object local = null;
		ctx = new InitialContext();
		local = ctx.lookup(jndiName);

		return local;
	}
}
