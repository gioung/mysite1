package com.cafe24.mysite.action.user;

import com.cafe24.mysite.action.main.MainAction;
import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("Joinform".equals(actionName)) {
			action = new JoinformAction();
		}
		else if("Join".equals(actionName)) {
			action = new JoinAction();
		}
		else if("Joinsuccess".equals(actionName)) {
			action = new JoinsuccessAction();
		}
		else if("Loginform".equals(actionName)) {
			action = new LoginformAction();
		}
		else if("Login".equals(actionName)) {
			action = new LoginAction();
		}
		else if("Logoutform".equals(actionName)) {
			action = new LogoutAction();
		}
		else if("Updateform".equals(actionName)) {
			action = new UpdateformAction();
		}
		else if("Update".equals(actionName)) {
			action = new UpdateAction();
		}
		else {
			action = new MainAction();
		}
		
		
		return action;
	}

}
