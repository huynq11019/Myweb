package com.hibernateUtils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.bytebuddy.implementation.bytecode.Throw;

public class hibernateUtils {
	public static SessionFactory getSessionFactory() {
		try {
			Configuration  cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory(); //trả về đối tượng sess
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
//			throw new Throwable ("lỗi tạo SesstionFactory ");
		}
		return null;
	}
}
