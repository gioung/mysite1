package com.cafe24.mysite.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCircleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		super.init();
		Map map = new HashMap<>();
		this.getServletContext().setAttribute("cacheUser", map); //전역 
		// 서블릿을 모아둔 정보들을 getServletContext라 한다.
		System.out.println("init called");
	}

	public void destroy() {
		super.destroy();
		System.out.println("destroy called");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
		System.out.println("service called");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("DoGets called");
		
		response.getWriter().println("<h1>Servlet Life Circle</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
