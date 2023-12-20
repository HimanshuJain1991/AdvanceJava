package in.co.rays.ctl;

import java.io.IOException;import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
@WebServlet("/UserListCtl.do")
public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel  model=new UserModel();
		UserBean bean=new UserBean();

		
		int pageNo = 1;
		int pageSize = 5;
		try {
			List list=model.search(bean,pageNo,pageSize);
			List nextList=model.search(bean, pageNo+1, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd=req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//resp.sendRedirect("UserListView.jsp");
		
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserBean bean=null;
	UserModel model=new UserModel();
	int pageNo=1;
	int pageSize=5;
	pageNo=Integer.parseInt(req.getParameter("pageNo"));
	
	String ope=req.getParameter("operation");
	 if(ope.equals("search")) {
		  pageNo=1;
		String fname= req.getParameter("firstName");
		bean=new UserBean();
		bean.setFirstName(fname);
		
	 }
		
		if(ope.equals("next")) {
			pageNo++;
		}
		if(ope.equals("previous")) {
			if(pageNo>1);
			pageNo--;
		}
		if (ope.equals("delete")) {

			pageNo = 1;

			String[] ids = req.getParameterValues("ids");

			for (String id : ids) {

				try {
					
					model.deleteRecord(Integer.parseInt(id));

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
		
	 
	
	    try {
			List list= model.search(bean,pageNo,pageSize);
			List nextList= model.search(bean,pageNo+1,pageSize);
			req.setAttribute("nextList", nextList);
			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd=req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
