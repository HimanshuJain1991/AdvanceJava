package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
@WebServlet("/LoginPageCtl")
public class LoginPageCtl extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String ope=req.getParameter("operation");
	if(ope!=null) {	
	HttpSession session=req.getSession();
	session.invalidate();
	
	}
	resp.sendRedirect("LoginPageView.jsp"); 
	 
	
}
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loginid=req.getParameter("loginId");
		String password=req.getParameter("password");
		String uri=req.getParameter("uri");
		System.out.println(loginid);
		System.out.println(password);
		UserModel model=new UserModel();
		
		try {
		UserBean bean=model.authenticate(loginid, password);
			if(bean!=null) {
				HttpSession session= req.getSession();
			//	session.setMaxInactiveInterval(10);
				session.setAttribute("user", bean);
				if(uri.equalsIgnoreCase("null")) {
					resp.sendRedirect("Welcome1Ctl");
				}
				else {
					resp.sendRedirect(uri);
				
				
				
			//	req.setAttribute("user", bean);
//				RequestDispatcher rs=req.getRequestDispatcher("WelcomeView1.jsp");
//		    	rs.forward(req, resp);
				}
				}
			else {
				req.setAttribute("msg", "Wrong id & password");
				RequestDispatcher rs=req.getRequestDispatcher("LoginPageView.jsp");
		    	rs.forward(req, resp);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//resp.sendRedirect("LoginPageView.jsp");
	}
}
