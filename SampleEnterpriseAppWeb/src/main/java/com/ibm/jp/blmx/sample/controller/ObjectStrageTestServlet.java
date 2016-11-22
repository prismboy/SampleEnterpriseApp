package com.ibm.jp.blmx.sample.controller;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.blmx.sample.ejb.local.ObjectStorageSessionBeanLocal;

/**
 * Servlet implementation class ObjectStrageTestServlet
 */
@WebServlet("/osTest")
public class ObjectStrageTestServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private static final String _NEXT_PAGE = "/WEB-INF/jsp/ostest.jsp";
	private static final String _CONTAINER_NAME = "Storage-AK";
	private static final String _JNDI_EJB_OBJECT_STORAGE = "java:global/SampleEnterpriseApp/SampleEnterpriseAppEJB/ObjectStorageSessionBean!com.ibm.jp.blmx.sample.ejb.local.ObjectStorageSessionBeanLocal";

	private ObjectStorageSessionBeanLocal local;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ObjectStrageTestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Context ctx = new InitialContext();
			local = (ObjectStorageSessionBeanLocal) ctx.lookup(_JNDI_EJB_OBJECT_STORAGE);
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
		controlCache(response);
		request.setAttribute("bean", "");

		request.getRequestDispatcher(_NEXT_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controlCache(response);
		String path = request.getParameter("path");
		String data = request.getParameter("data");
		String container = request.getParameter("container");
		String containerName = !isEmpty(container) ? container : _CONTAINER_NAME;
		String msg = "";
		if (!isEmpty(path) && !isEmpty(data)) {
			local.write(containerName, path, data);
			msg = "Write success at " + containerName + "/" + path;
		}
		request.setAttribute("bean", msg);
		request.getRequestDispatcher(_NEXT_PAGE).forward(request, response);
	}

}
