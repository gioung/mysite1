package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite1.vo.UserVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//세션 종료
		HttpSession session = request.getSession();
		if(session == null ) {
			WebUtil.redirect(request, response, request.getContextPath());
			return; //빼먹으면안됨 뒤에 코드가 실행될 여지가 있다.
		}
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null){
			WebUtil.redirect(request, response, request.getContextPath());
			return;
		}
		
		session.removeAttribute("authUser"); //UserVo가 날라감
		session.invalidate(); //세션ID 삭제. 
		//HttpSession 은 30분 후면 날라감.
		
		WebUtil.redirect(request, response, request.getContextPath());

	}

}
