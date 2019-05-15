package com.cafe24.web.mvc;

public abstract class ActionFactory {
	//팩토리 메서드
	public abstract Action getAction(String actionName);
}
