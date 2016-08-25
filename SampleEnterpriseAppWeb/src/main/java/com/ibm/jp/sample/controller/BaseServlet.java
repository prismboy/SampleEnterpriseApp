/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.controller;

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
 * 
 * @author y_akamatsu
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
	 * 
	 * 
	 */
	protected void forwardNext(HttpServletRequest request, HttpServletResponse response, String next)
			throws ServletException, IOException {
		controlCache(response);

		request.getRequestDispatcher(next).forward(request, response);
	}

	protected void controlCache(HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache", "no-cache");
		response.setDateHeader("Expires", 0);
	}

	protected Object getSessionBean(String jndiName) throws NamingException {
		Context ctx;
		Object local = null;
		ctx = new InitialContext();
		local = ctx.lookup(jndiName);

		return local;
	}

	protected boolean isEmpty(String val) {
		return val == null || "".equals(val);
	}
}
