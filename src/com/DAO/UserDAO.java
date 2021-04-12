package com.DAO;

import org.hibernate.Session;
import javax.persistence.Query;
//import javax.transaction.Transaction;
//import javax.transaction.Transactional;
import org.hibernate.Transaction;
import java.util.List;
import com.empty.User;
import com.hibernateUtils.hibernateUtils;

//import antlr.collections.List;

public class UserDAO {

//	private static final String User = null;
	private Session session;
	
	public UserDAO() {
		 this.session = hibernateUtils.getSetsion();
	}

	public User insertUser(User user) {
		try {
			this.session.clear();
			this.session.beginTransaction();
			Integer id = (Integer) this.session.save(user);
			this.session.getTransaction().commit();
			user.setId(id);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	public List<User> paninate(int offSet, int perPage) {
		String hql = "FROM User";
		Query query = this.session.createQuery(hql);
		query.setFirstResult(offSet);
		query.setMaxResults(perPage + offSet);
		List<User> result = query.getResultList();
		return result;
	}

	public int deleteUser(User obj) {
		this.session.clear();
		Session session = hibernateUtils.getSetsion();
		Transaction transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		return 0;
	}

	public User getUserByid(Integer id) {

//		this.session.getTransaction().commit();
		User u = this.session.get(User.class, id);
		User getUser = this.session.find(User.class, id);

		return u;
	}

	public void UpdateUser(User curUser) {
		try {

			this.session.clear();
			this.session.beginTransaction();
			this.session.update(curUser);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.session.getTransaction().rollback();
		}
	}

	public User loginU(String u, String p) {
		String hql = "SELECT e FROM User e WHERE e.email = :email AND e.password = :password ";
		
		Query query = this.session.createQuery(hql);
		System.out.println(u+p);
		query.setParameter("email", u);
		query.setParameter("password", p);
		User empty;
		try {
			System.out.println("dã tìm thấy");
			empty = (User) query.getSingleResult();
			return empty;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("không tìm thấy");
			e.printStackTrace();
			
		}
		return null;
	}
}
