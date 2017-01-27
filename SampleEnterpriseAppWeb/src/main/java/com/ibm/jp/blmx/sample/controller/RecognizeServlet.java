package com.ibm.jp.blmx.sample.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.jp.blmx.sample.bean.ClassifyResults;
import com.ibm.jp.blmx.sample.bean.FaceResults;
import com.ibm.jp.blmx.sample.ejb.local.VisualRecognizerLocal;
import com.ibm.jp.blmx.sample.model.VisualClassMapper;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ImageClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ImageFace;

/**
 * Servlet implementation class RecognizeServlet
 */
@WebServlet("/recognize")
public class RecognizeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String _RECOGNIZE_BEAN = "java:global/SampleEnterpriseApp/SampleEnterpriseAppEJB/VisualRecognizer!com.ibm.jp.blmx.sample.ejb.session.VisualRecognizer";
	private static final String _INPUT_PAGE = "/WEB-INF/jsp/recognize.jsp";
	private static final String _RESULT_CLASSIFY = "/WEB-INF/jsp/classifyResult.jsp";
	private static final String _RESULT_FACE = "/WEB-INF/jsp/faceResult.jsp";
	private static final String _KIND_CLASSIFY = "classify";
	private static final String _ACCEPT_LANGUAGE = "Accept-Language";

	private VisualRecognizerLocal local;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecognizeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		try {
			Context context = new InitialContext();
			local = (com.ibm.jp.blmx.sample.ejb.session.VisualRecognizer) context.lookup(_RECOGNIZE_BEAN);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setHeaders(response);
		ClassifyResults results = new ClassifyResults();
		results.setApiKind(request.getParameter("apiKind"));
		request.setAttribute("bean", results);
		request.getRequestDispatcher(_INPUT_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setHeaders(response);
		String apiKind = request.getParameter("apiKind");
		String url = request.getParameter("url");
		Map<String, String> headers = new HashMap<>();
		String al = request.getHeader(_ACCEPT_LANGUAGE);
		headers.put(_ACCEPT_LANGUAGE, al);
		/*
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String val = request.getHeader(name);
			headers.put(name, val);
		}
		*/

		if (_KIND_CLASSIFY.equals(apiKind)) {
			ImageClassification ic = local.classifyImage(url, headers);
			ClassifyResults results = VisualClassMapper.mapVisualClass(ic);
			results.setApiKind(apiKind);
			request.setAttribute("bean", results);
			request.getRequestDispatcher(_RESULT_CLASSIFY).forward(request, response);
		} else {
			ImageFace face = local.detectFaces(url);
			FaceResults results = VisualClassMapper.mapFaceResult(face);
			results.setApiKind(apiKind);
			request.setAttribute("bean", results);
			request.getRequestDispatcher(_RESULT_FACE).forward(request, response);
		}
	}

	private void setHeaders(HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	}
}
