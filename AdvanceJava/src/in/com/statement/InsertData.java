package in.com.statement;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public class InsertData {  

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
        Statement stmt=con.createStatement();
        int i=stmt.executeUpdate("insert into marksheet values(9597,'aKASH Sharma',7755,45,54,69)");
         System.out.println("Record inserted"+i);
         
	}

}
