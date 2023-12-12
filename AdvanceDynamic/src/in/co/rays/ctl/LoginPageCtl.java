package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
@WebServlet("/LoginPageCtl")
public class LoginPageCtl extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(req, resp);
	
}
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loginid=req.getParameter("loginId");
		String password=req.getParameter("password");
		System.out.println(loginid);
		System.out.println(password);
		UserModel model=new UserModel();
		UserBean bean=new UserBean();
		try {
			bean=model.authonticate(loginid, password);
			if(bean!=null) {
				RequestDispatcher rs=req.getRequestDispatcher("Hello.jsp");
			rs.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("LoginPageView.jsp");
	}
}
