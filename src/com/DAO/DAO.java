package com.DAO;

import org.hibernate.Session;

import com.hibernateUtils.hibernateUtils;

abstract public class DAO<T> {
	public DAO(){
		
	}
	
	abstract public String getBaseClass();
	abstract public Class<T> getFullClass();
	public T create(T empty) {
		try {
			Session  hsession = hibernateUtils.getSetsion();
			hsession.beginTransaction();
			int id =(Integer)hsession.save(empty);
			hsession.getTransaction().commit();
			return empty;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	}
	