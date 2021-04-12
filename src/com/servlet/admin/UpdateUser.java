package com.servlet.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import com.DAO.UserDAO;
import com.empty.User;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/admin/user/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	UserDAO dao;

	public UpdateUser() {
		super();
		// TODO Auto-generated constructor stub
		dao = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		User user = this.dao.getUserByid(id);
		request.setAttribute("user", user);
//		System.out.println(user.toString());
		request.getRequestDispatcher("/VIEWS/admin/UpdateUser.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User empty = new User();	
		try {// lấy đối tượng từ form
			BeanUtils.populate(empty, request.getParameterMap()); // lấy dữ liệu trên form về đối tượng
			System.out.println(empty.toString());	
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		empty.setId(id);
//		System.out.println("abcS"+empty.toString());
		this.dao.UpdateUser(empty);
		response.sendRedirect(request.getContextPath()+"/admin/user");
//		doGet(request, response);
	}

}
