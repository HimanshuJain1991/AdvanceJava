package in.co.rays.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/GetCookie")
public class GetCookie extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	Cookie[] coookies=req.getCookies();
	for (Cookie c : coookies) {
		String name=c.getName();
		String value=c.getValue();
		out.println(name+" "+value);
		System.out.println(name+""+value);
	}
	
}	
}
