package in.com.preapared_statement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class UpdateRecord  {

	public static void main(String[] args)  throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
          PreparedStatement ps=conn.prepareStatement("update marksheet set name='Rohan' where id=2525 ");
        int i=  ps.executeUpdate();
        System.out.println("update record successfuuly"+i);
	}

}
