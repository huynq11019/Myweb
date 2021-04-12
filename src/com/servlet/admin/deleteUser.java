package com.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;
import com.empty.User;

/**
 * Servlet implementation class deleteUser
 */
@WebServlet("/admin/user/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDAO dao ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUser() {
        super();
        this.dao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//phương thức delete nhận vào đối tượng và xóa nó theo id của dối tượng
		String getID = request.getParameter("id");
		System.out.print(getID);
		if(getID==null) {
			//bad 404
			System.out.print(getID);
		}else {
			int ID = Integer.parseInt(getID);
			User empty = dao.getUserByid(ID);		
			this.dao.deleteUser(empty);
			response.sendRedirect(request.getContextPath()+"/admin/user");
		}
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
