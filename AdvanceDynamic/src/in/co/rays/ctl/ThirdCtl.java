package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ThirdCtl")
public class ThirdCtl extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String fname=req.getParameter("firstName");
	String lname=req.getParameter("lastName");
	String address=req.getParameter("address");
	System.out.println("doGet() method call");
	System.out.println(fname);
	System.out.println(lname);
	System.out.println(address);
	resp.sendRedirect("FourthCtl");
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String fname=req.getParameter("firstName");
	String lname=req.getParameter("lastName");
	String address=req.getParameter("address");
	System.out.println(" ThirdCtl doPost() method call");
	System.out.println(fname);
	System.out.println(lname);
	System.out.println(address);
	RequestDispatcher rs=req.getRequestDispatcher("FourthCtl");
	rs.forward(req, resp);
	//resp.sendRedirect("FourthCtl");
	}
}
