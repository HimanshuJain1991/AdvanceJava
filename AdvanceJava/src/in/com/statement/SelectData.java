package in.com.statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;

public class SelectData {

	public static void main(String[] args)  throws ClassNotFoundException,SQLException{
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
      Statement stmt=conn.createStatement();
      ResultSet rs=stmt.executeQuery("select * from marksheet   ");
      
      while(rs.next()) {
    	
    	  System.out.println(rs.getInt(1)+" \t"+rs.getString(2)+"\t"+rs.getInt(3)
    	  +"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6));
 
      }
      stmt.close();conn.close();
	}

}
