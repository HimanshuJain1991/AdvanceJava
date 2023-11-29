package in.com.raystest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06","root","root");
	    Statement st=conn.createStatement();
	    int i=st.executeUpdate("insert into marksheet values(55,'Deepak Sir',255,85,78,55)");
	     System.out.println("Data Inserted"+i);
	}

}
