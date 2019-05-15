package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite1.dao.UserDao;
import com.cafe24.mysite1.vo.UserVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		UserVo vo = (UserVo)session.getAttribute("authUser");
		
		String update_name = request.getParameter("name");
		
		vo.setName(update_name);
		String update_email = request.getParameter("email");
		vo.setEmail(update_email);
	
		String update_password = request.getParameter("password");
		vo.setPassword(update_password);
	
		
		new UserDao().update(vo);
		
		WebUtil.redirect(request, response, request.getContextPath());
		
	}

}
