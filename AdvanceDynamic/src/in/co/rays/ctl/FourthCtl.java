package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/FourthCtl")
public class FourthCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname=req.getParameter("firstName");
		String lname=req.getParameter("lastName");
		String address=req.getParameter("address");
		System.out.println(" Fourth doget() method call");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(address);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname=req.getParameter("firstName");
		String lname=req.getParameter("lastName");
		String address=req.getParameter("address");
		System.out.println("doPost()  FourthCtl method call");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(address);
	}

}
