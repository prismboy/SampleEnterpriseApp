package com.ibm.jp.blmx.sample.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.blmx.sample.model.PhysicalFileTestModel;

/**
 * Servlet implementation class PhysicalFileTestServlet
 */
@WebServlet("/pft")
public class PhysicalFileTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String _NEXT_PAGE = "/WEB-INF/jsp/PhysicalFileTest.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhysicalFileTestServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getParameter("path");
		String msg = "";
		if (path != null && !"".equals(path)) {
			PhysicalFileTestModel model = new PhysicalFileTestModel();
			try {
				model.writeFile(path);
				msg = path + " write ok.";
			} catch (Exception e) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PrintWriter s = new PrintWriter(baos);
				e.printStackTrace(s);
				s.flush();
				s.close();
				msg = new String(baos.toByteArray());
			}
		}

		request.setAttribute("bean", msg);
		request.getRequestDispatcher(_NEXT_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
