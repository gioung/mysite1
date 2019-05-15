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

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVo authUser = new UserDao().get(email, password);
		if(authUser == null) {
			request.setAttribute("result", "fail");
			WebUtil.forward(request, response, "WEB-INF/views/user/loginform.jsp");
			return;
		}
		
		//login 처리
		HttpSession session= request.getSession(true); //true는 없으면 달라는 뜻
		session.setAttribute("authUser", authUser);
		WebUtil.redirect(request, response, request.getContextPath());
		
		
		//session.setAttribute("name", );
		

	}

}
