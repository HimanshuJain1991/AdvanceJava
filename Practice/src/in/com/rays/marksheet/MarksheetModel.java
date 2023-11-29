package in.com.rays.marksheet;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class MarksheetModel {
	public static Integer nextPk()  throws Exception {
		int pk=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select max(id) from marksheet" );
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
		pk=rs.getInt(1);
		
	
		}
		//System.out.println(pk+1);
		return pk+1;
	}
	public static void insertData( MarksheetBean bean1) throws Exception {
		int pk=nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		ps.setInt(1, pk);ps.setString(2, bean1.getName());ps.setInt(3,bean1.getRoll_no() );
		ps.setInt(4, bean1.getPhyscis());ps.setInt(5, bean1.getChemistry());ps.setInt(6, bean1.getMaths());
		int i=ps.executeUpdate();
	    System.out.println("Data Inserted ="+ i);
	}
	public static void deleteData(MarksheetBean bean3)throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps=conn.prepareStatement("delete from marksheet where id=?");	
	    ps.setInt(1, bean3.getId());
	   int i= ps.executeUpdate();
	   System.out.println("Record Deleted "+i);
	}
	
	public static void getData() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select * from marksheet ");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getInt(3));
			System.out.print("\t"+rs.getInt(4));
			System.out.print("\t"+rs.getInt(5));
			System.out.println("\t"+rs.getInt(6));
		}
		
			
		}
	public  MarksheetBean  findByPk(int id)throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select  * from marksheet where id=? ");
		ps.setInt(1,id );
		ResultSet rs=ps.executeQuery();
		MarksheetBean bean=null;
		while(rs.next()) {
			bean=new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setId(rs.getInt(3));
			bean.setPhyscis(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		
		return bean;
		
		
	}
	public MarksheetBean findByName(String name) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select  * from marksheet where name=? ");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		MarksheetBean bean=null;
		while(rs.next()) {
			bean=new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setPhyscis(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			
		}
		
		return bean;
	}
	public List search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select  * from marksheet  ");
		ResultSet rs=ps.executeQuery();
		List list=new ArrayList();
		while(rs.next()) {
			MarksheetBean bean=new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setPhyscis(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}
		
		return list;
	}
	

}
