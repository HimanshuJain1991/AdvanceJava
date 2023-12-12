package in.co.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("LoginPageView.jsp");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String fname=req.getParameter("firstName");
	   String lname=req.getParameter("lastName");
	   String lid=req.getParameter("loginId");
	   String password=req.getParameter("password");
	   String dob=req.getParameter("dob");
	   String address=req.getParameter("address");
	   
	   System.out.println(fname);
	   System.out.println(lname);
	   System.out.println(lid);
       System.out.println(password);
       System.out.println(dob);
       System.out.println(address);
      
       UserBean bean=new UserBean();
       bean.setFirstName(fname);
       bean.setLastName(lname);
       bean.setLoginId(lid);
       bean.setPassword(password);
       bean.setAddress(address);
       bean.setDob(DataUtility.stringToDate(dob));
	
      UserModel  model=new UserModel();
      try {
		model.addData(bean);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     // RequestDispatcher rd=req.getRequestDispatcher("LoginPageCtl");
      //rd.forward(req, resp);
    //  resp.sendRedirect("LoginPageView.jsp");
	}

}
