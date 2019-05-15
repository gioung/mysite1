package com.cafe24.mystie.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite1.dao.GuestbookDao;
import com.cafe24.mysite1.vo.GuestbookVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Long no = Long.valueOf(request.getParameter("no"));
		String password = request.getParameter("password");
		request.setAttribute("no",no);
		
		
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);
		new GuestbookDao().delete(vo);
		
		WebUtil.redirect(request, response,request.getContextPath()+"/guestbook");

	}

}
