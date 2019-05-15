package com.cafe24.mystie.action.guestbook;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

public class GuestbookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if("add".equals(actionName)) {
			action = new AddAction();
		}else if("delete".equals(actionName)) {
			action = new DeleteAction();
			
		}else if("deleteform".equals(actionName)) {
			action = new DeleteformAction();
		}else {
			
			action = new ListAction();
		}
		return action;
	}

}
