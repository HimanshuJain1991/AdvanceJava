package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
@WebServlet("/LoginPageCtl")
public class LoginPageCtl extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     String operation=req.getParameter("operation");
	     if(operation!=null) {
	    	 HttpSession session=req.getSession();
	    	 session.invalidate();
	     }
	     resp.sendRedirect("LoginPageView.jsp");
	     
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loginId=req.getParameter("loginId");
		String password=req.getParameter("password");
		System.out.println(loginId+"  "+password);
		
		try {
			UserBean bean=UserModel.authenticate(loginId, password);
			if(bean!=null) {
				HttpSession session=req.getSession();
				session.setAttribute("user", bean);
				RequestDispatcher rd=req.getRequestDispatcher("Welcome.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("msg", "Incorect Id & Password");
				RequestDispatcher rd=req.getRequestDispatcher("LoginPageView.jsp");
				
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
