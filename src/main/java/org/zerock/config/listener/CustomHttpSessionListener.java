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

		System.out.println("������ session id >>> " + se.getSession().getId());
		System.out.println("�α��ε� ����� ��  >>> " + userCount);
		HttpSessionListener.super.sessionCreated(se);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		--userCount;

		System.out.println("���ŵ� session id >>> " + se.getSession().getId());
		System.out.println("�α��ε� ����� ��  >>> " + userCount);
		HttpSessionListener.super.sessionDestroyed(se);
	}
}
