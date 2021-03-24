import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/poly.html")
public class HeloJSP extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException{
//	resp.getWriter().println("<h1>hello servlet </h1>");
			String bugMaker ="bug any where";
			String pa = req.getParameter("name");
			String name = pa == null ? "BugAny where":pa;
			req.setAttribute("myBuTT", name);
			req.getRequestDispatcher("VIEWS/Buoi2/HelloJSP.jsp").forward(req, resp);//chuyển tiếp sang jsp để xử lý
			
}
}
