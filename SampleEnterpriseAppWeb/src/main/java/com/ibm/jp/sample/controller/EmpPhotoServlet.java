/*
 * Bluemix Liberty for Java
 * 
 * Enterprise Application Sample source.
 */
package com.ibm.jp.sample.controller;

import static com.ibm.jp.sample.constants.SampleEnterpriseAppConstants._JNDI_NAME_EJB_002;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.sample.ejb.entity.EmpPhoto;
import com.ibm.jp.sample.ejb.local.SampleJpaSessionBeanLocal;

/**
 * Servlet implementation class EmpPhotoServlet
 * 
 * @author y_akamatsu
 */
@WebServlet("/empPhoto")
public class EmpPhotoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private static final String _NO_IMAGE_PATH = "/images/no_image.png";

	private static Map<String, String> mimeMap = new TreeMap<String, String>();
	private ServletContext servletContext;

	private SampleJpaSessionBeanLocal local;
       
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
			local = (SampleJpaSessionBeanLocal) getSessionBean(_JNDI_NAME_EJB_002);
		} catch (NamingException e) {
			throw new ServletException(e);
		}
		mimeMap.put("bitmap", "image/x-bmp");
		mimeMap.put("gif", "image/gif");
		mimeMap.put("png", "image/png");
		servletContext = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empNo = request.getParameter("empNo");
		if(!isEmpty(empNo)){
			EmpPhoto empPhoto = local.getPhoto(empNo);
			if(empPhoto!=null){
				putEmpPhoto(response, empPhoto);
			} else {
				putNoImage(response);
			}
		} else {
			putNoImage(response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void putEmpPhoto(HttpServletResponse response, EmpPhoto empPhoto) throws IOException {
		response.setContentType(mimeMap.get(empPhoto.getId().getPhotoFormat()));
		byte[] buf = empPhoto.getPicture();
		response.setContentLength(buf.length);
		controlCache(response);
		ServletOutputStream sos = response.getOutputStream();
		sos.write(buf, 0, buf.length);
		sos.flush();
		sos.close();
	}

	private void putNoImage(HttpServletResponse response) throws IOException {
		response.setContentType(mimeMap.get("png"));
		InputStream is = servletContext.getResourceAsStream(_NO_IMAGE_PATH);
		ServletOutputStream sos = response.getOutputStream();
		byte[] buf = new byte[256];
		int reads = 0;
		while ((reads = is.read(buf, 0, 256)) > 0) {
			sos.write(buf, 0, reads);
		}
		sos.flush();
		sos.close();
		is.close();
	}

}
