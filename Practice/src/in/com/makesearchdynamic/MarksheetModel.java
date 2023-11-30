package in.com.makesearchdynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {
	public static List search(MarksheetBean bean,int pagesize,int pageno)  throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		StringBuffer sql=new StringBuffer("select * from marksheet where  1=1");
		if(bean!=null) {
			if(bean.getName()!=null && bean.getName().length()>0) {
		sql.append(" and name like  '" + bean.getName() + "%'  ");
		}
			if(bean.getRollNo()>0) {
				sql.append(" and roll_no = '"+ bean.getRollNo()+ "'");
				
			}
			if(pagesize>0) {
				pageno= (pageno-1)* pagesize;
				sql.append(" limit "+ pageno +"," + pagesize );
			}
		}
		PreparedStatement ps=conn.prepareStatement(sql.toString());
		
		System.out.println(sql);
		ResultSet rs=ps.executeQuery();
		List list=new ArrayList();
		while(rs.next()) {
			 
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));bean.setPhyscis(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}
		return list;
	}
	public MarksheetBean findByPk1(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select * from marksheet where id=?");
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		MarksheetBean bean=null;
		while(rs.next()) {
			bean=new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhyscis(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		
		return bean;
	}
	public Integer nextPk() throws Exception {
		int pk=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select max(id) from marksheet");
	    ResultSet rs=ps.executeQuery();
	    while(rs.next()) {
	    	 pk=rs.getInt(1);
	    }
	    
		return pk+1;
	}
	public void addData(MarksheetBean bean) throws Exception {
		int pk=nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		
		ps.setInt(1,pk );
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRollNo());
		ps.setInt(4, bean.getPhyscis());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());
		int i=ps.executeUpdate();
		System.out.println("Data inserted  "+i);
	}
	

}
