package com.ibm.jp.blmx.sample.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.blmx.sample.ejb.entity.EmpPhoto;
import com.ibm.jp.blmx.sample.ejb.entity.EmpPhotoPK;
import com.ibm.jp.blmx.sample.ejb.local.EmpPhotoSessionBeanLocal;

/**
 * Servlet implementation class EmpPhotoServlet
 */
@WebServlet({ "/EmpPhotoServlet", "/empPhoto" })
public class EmpPhotoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private static final String _JNDI_EJB_EMP_PHOTO = "java:global/SampleEnterpriseApp/SampleEnterpriseAppEJB/EmpPhotoSessionBean!com.ibm.jp.blmx.sample.ejb.local.EmpPhotoSessionBeanLocal";

	private EmpPhotoSessionBeanLocal local;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpPhotoServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Context ctx = new InitialContext();
			local = (EmpPhotoSessionBeanLocal) ctx.lookup(_JNDI_EJB_EMP_PHOTO);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controlCache(response);
		String empNo = request.getParameter("empNo");

		if (empNo != null && !"".equals(empNo)) {
			EmpPhotoPK pk = new EmpPhotoPK();
			pk.setEmpno(empNo);
			pk.setPhotoFormat("gif");
			EmpPhoto ep = local.findByPk(pk);
			if (ep != null) {
				response.setContentType("image/gif");
				response.setContentLength(ep.getPicture().length);
				OutputStream os = response.getOutputStream();
				os.write(ep.getPicture());
				os.flush();
				os.close();
			} else {
				response.getOutputStream().close();
			}
		} else {
			response.getOutputStream().close();
		}
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
