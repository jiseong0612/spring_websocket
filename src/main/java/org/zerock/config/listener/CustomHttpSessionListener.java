package org.zerock.config.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CustomHttpSessionListener implements HttpSessionListener {
	private static int userCount;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		++userCount;

		System.out.println("생성된 session id >>> " + se.getSession().getId());
		System.out.println("로그인된 사용자 수  >>> " + userCount);
		HttpSessionListener.super.sessionCreated(se);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		--userCount;

		System.out.println("제거된 session id >>> " + se.getSession().getId());
		System.out.println("로그인된 사용자 수  >>> " + userCount);
		HttpSessionListener.super.sessionDestroyed(se);
	}
}
