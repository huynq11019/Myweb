package com.servlet.auth;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.empty.User;
import com.hibernateUtils.hibernateUtils;

//import com.mysql.jdbc.*;

//import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class RegiterServlet
 */
@WebServlet("/Regiter")
public class RegiterServlet extends HttpServlet {
	static final SessionFactory factory = hibernateUtils.getSessionFactory();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegiterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("VIEWS/auth/Regiter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		System.out.println("heelo");
//		response.setContentType("text/html;charset=UTF-8");
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		String number = request.getParameter("number");
//		String gender = request.getParameter("gender");
//		
//		System.out.println(name+'-'+password+'-'+email+'-'+number+'-'+gender);
//		System.out.println("URI: "+ request.getRequestURI());
//		System.out.println("URL: "+ request.getRequestURL());
		Session  session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		User empty = new User();
//		empty.setName(name);
//		empty.setEmail(email);
//		empty.setNumber(number);
//		empty.setPassword(password);
//		empty.setGender(0);
		try {// lấy đối tượng từ form
			BeanUtils.populate(empty, request.getParameterMap()); // lấy dữ liệu trên form về đối tượng
			System.out.println(empty.toString());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.save(empty);
		tx.commit();
// kết nối với DB
//		String url = "jdbc:mysql://localhost:3306/my_demo";
//		String userName = "root", psw = "";
//	    try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(url, userName, psw);
//            System.out.print("đã kết nối thành công");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
////            throw new Throwable("Can't create connection");
//        }
		doGet(request, response);

	}
	@Override
	public void init() throws ServletException {
		System.out.println("innit..........");
		super.init();
	}
	@Override
	public void destroy() {
		System.out.println("destroy..........");
		super.destroy();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Processing...........");
		super.service(request, response);
	}
}
