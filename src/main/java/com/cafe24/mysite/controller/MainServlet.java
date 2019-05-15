package com.cafe24.mysite.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.action.main.MainActionFactory;
import com.cafe24.mystie.action.guestbook.GuestbookActionFactory;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

//@WebServlet({"","/main","/index"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//initparam 설정하고 받아오기
	@Override //완전구현
	public void init() throws ServletException {
		String configPath = getServletConfig().getInitParameter("config");
		System.out.println("init() called: "+configPath);
		
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionName = request.getParameter("a");
		Action action=new MainActionFactory().getAction(actionName);
		action.execute(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
