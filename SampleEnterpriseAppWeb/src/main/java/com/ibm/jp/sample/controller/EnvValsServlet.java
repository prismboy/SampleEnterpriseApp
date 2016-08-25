/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.sample.bean.EnvValsBean;

/**
 * Servlet implementation class EnvValsServlet
 * 
 * @author y_akamatsu
 */
@WebServlet("/env")
public class EnvValsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private EnvValsBean bean;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public EnvValsServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		bean = new EnvValsBean();

		bean.setEnvMap(System.getenv());

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("bean", bean);
		forwardNext(request, response, "/WEB-INF/jsp/envvals.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
