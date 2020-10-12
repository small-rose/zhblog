package com.zzy.blog.web.base.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionManager {

	private static Map<String, Object> sessionMap = new HashMap<String, Object>();

	public static synchronized void addSession(HttpSession session) {
		 if (session != null) {
		 	sessionMap.put(session.getId(), session);
		 }
	}

	public static synchronized void delSession(HttpSession session) {
		if(null != session) {
			sessionMap.remove(session.getId());
		}
	}

	public static synchronized HttpSession getSession(String session_id) {
		if (sessionMap.containsKey(session_id)) {
			return (HttpSession) sessionMap.get(session_id);
		} else {
			return null;
		}
	}

}
