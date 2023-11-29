package in.com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateRecord  {
	
	public static void main(String[] args)  {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
			 Statement stmt=conn.createStatement();
			int i=stmt.executeUpdate("update marksheet set id=17855 where id=789");
			System.out.println("Data Updated Successfuuly"+i);
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	

	}

}
