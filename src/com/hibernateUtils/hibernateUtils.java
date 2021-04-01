package com.hibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.bytebuddy.implementation.bytecode.Throw;

public class hibernateUtils {
	private static SessionFactory factory;
	private static Session session;
	
	
	public static Session getSetsion() {
		if(session ==null || !session.isOpen());
		session = getFactory().openSession();
		return session;
	}
	public static SessionFactory getFactory() {
		if(factory == null || !factory.isOpen()) {
			Configuration  cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			factory =  cfg.buildSessionFactory();
		}
		return factory;
	}
	public static SessionFactory getSessionFactory() {
		try {
			Configuration  cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory(); //trả về đối tượng sess
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return null;
	}
}
