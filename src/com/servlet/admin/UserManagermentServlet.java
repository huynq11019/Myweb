package com.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;
import com.empty.User;
import com.hibernateUtils.hibernateUtils;

@WebServlet("/admin/user")
public class UserManagermentServlet extends HttpServlet {
	private UserDAO userDAO;

	public UserManagermentServlet() {
		// TODO Auto-generated constructor stub

		this.userDAO = new UserDAO();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TO DO:
		String pageStr = request.getParameter("page"), limitStr = request.getParameter("limit");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int limit = limitStr == null ? 5 : Integer.parseInt(limitStr);
		int offset = limit * (page - 1);
		if (offset <= 0)
			offset = 1;
		TypedQuery<User> query = hibernateUtils.getSetsion().createNamedQuery("user.getListActive", User.class);
		query.setFirstResult(offset);
		query.setMaxResults(limit);

//		List<User> userList = this.userDAO.paninate(offset, limit);
		List<User> userList = query.getResultList();
		request.setAttribute("listUser", userList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/VIEWS/admin/Admin.jsp").forward(request, response);
	}
}
