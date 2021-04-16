package com.servlet.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.empty.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO dao ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/VIEWS/auth/Login.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("chao cac ban");
		String user = request.getParameter("email");
		String pass = request.getParameter("password");
		System.out.print(user+pass);
		User entity = this.dao.loginU(user, pass);
		if(entity == null) {
			response.sendRedirect(request.getContextPath()+"/LoginServlet");
		}else {
			// đi vào trang chủ
			HttpSession session = request.getSession();
			session.setAttribute("user", entity); //lưu thông tin vào session
			response.sendRedirect(request.getContextPath()+"/admin/user");
		}
//		doGet(request, response);
	}
//private User Login(String user, String pass) {
//	return this.dao.loginU(user, pass);
//}
}
