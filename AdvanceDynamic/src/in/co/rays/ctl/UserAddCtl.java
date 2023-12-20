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
import in.co.rays.util.DataUtility;
@WebServlet("/UserAddCtl.do")
public class UserAddCtl extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserModel  model=new UserModel();
	UserBean bean=new UserBean();
	String edit=req.getParameter("edit");
	if(edit!=null) {
		try {
			bean=model.findByPk(Integer.parseInt(edit));
			req.setAttribute("editmsg", "Edit your record here!!!");
			req.setAttribute("userbean", bean);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=req.getRequestDispatcher("UserAddView.jsp");
		rd.forward(req, resp);
  	
		
	}
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation=req.getParameter("operation");
		 if(operation.equals("Save")) {
			 
		 
		
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
    req.setAttribute("msg", "User Detail Added");
    RequestDispatcher rd=req.getRequestDispatcher("UserAddView.jsp");
    rd.forward(req, resp);
		 }
		 if(operation.equals("Update")) {
			 
			 String id= req.getParameter("id");
			 String fname=req.getParameter("firstName");
			   String lname=req.getParameter("lastName");
			   String lid=req.getParameter("loginId");
			   String password=req.getParameter("password");
			   String dob=req.getParameter("dob");
			   String address=req.getParameter("address");
			
		    
		     UserBean bean=new UserBean();
		     bean.setId(Integer.parseInt(id));
		     bean.setFirstName(fname);
		     bean.setLastName(lname);
		     bean.setLoginId(lid);
		     bean.setPassword(password);
		     bean.setAddress(address);
		     bean.setDob(DataUtility.stringToDate(dob));
			
		    UserModel  model=new UserModel();
		    try {
				model.UpdateRecord(bean);
		    bean=model.findByPk(Integer.parseInt(id));
				req.setAttribute("userbean", bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    req.setAttribute("msg", " Record Updated Successfully ");
		    RequestDispatcher rd=req.getRequestDispatcher("UserAddView.jsp");
		    rd.forward(req, resp);
				 }
		 }
	
	}

