package in.com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
     Statement stmt=conn.createStatement();
     int i=stmt.executeUpdate("delete from marksheet where id =55");
     System.out.println("Data deleted Successfully"+i);
	}

}
