package in.com.preapared_statement;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertData {

	public static void main(String[] args) throws Exception {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
     PreparedStatement ps = conn.prepareStatement("insert into marksheet values(2525,'Deepak Sir',539,45,56,95)");
	 int i= ps.executeUpdate();
	  System.out.println("Data Inserted using prepared statement"+i);
	}

}
