package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {
	public Integer nextPk() throws Exception {
		int pk = 0;
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select  max(id) from user");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		rs.close();
		return pk + 1;
	}

	public void addData(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
//	Class.forName("com.mysql.cj.jdbc.Driver");
//	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06","root","root");
		PreparedStatement ps = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?, ?)");
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());
		int i = ps.executeUpdate();
		System.out.println("Data inserted sueecssfully" + i);
	}

	public static void deleteRecord(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
//	Class.forName("com.mysql.cj.jdbc.Driver");
//	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps = conn.prepareStatement("delete from user where id =?");
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		System.out.println("Record Deleted Successfully!!  " + i);
		ps.close();
		conn.close();
	}

	public static void UpdateRecord(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
//	Class.forName("com.mysql.cj.jdbc.Driver");
//	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps = conn.prepareStatement(
				"update  user set firstname = ?, lastname = ? , loginid = ?, password = ?, dob = ?, address = ? where id=?");

		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getAddress());
		ps.setInt(7, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("Record Updated Successfully " + i);

		ps.close();
		conn.close();
	}

	public UserBean findByPk(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
//	Class.forName("com.mysql.cj.jdbc.Driver");
//	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from user where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		}
		return bean;

	}

	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
//	Class.forName("com.mysql.cj.jdbc.Driver");
//	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06","root","root");
		StringBuffer sql = new StringBuffer("select * from user where 1=1");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstname like '" + bean.getFirstName() + "%'");
			}
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
			}

		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}
		System.out.println(sql);
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}
		return list;
	}

	public static UserBean authenticate(String loginid, String password) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
//    	  Class.forName("com.mysql.cj.jdbc.Driver");
//    		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06","root","root");
		PreparedStatement ps = conn.prepareStatement("select * from user where loginid = ? and password= ?");
		ps.setString(1, loginid);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setAddress(rs.getString(7));
			bean.setDob(rs.getDate(6));
		}
		return bean;
	}

	public List search2() throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user");
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			UserBean bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}
		return list;
	}

}