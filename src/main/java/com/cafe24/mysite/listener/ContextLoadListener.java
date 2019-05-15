package com.cafe24.mysite.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


//@WebListener 컨텍스트 변수같은거 설정하거나할때
public class ContextLoadListener implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent sce)  { 
         
    }

	
    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
    	
    	ServletContext sc=servletContextEvent.getServletContext();
         System.out.println("Container Starts..." +sc.getInitParameter("contextConfigLocation") );

    }
	
}
