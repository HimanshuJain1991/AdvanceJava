package in.com.preapared_statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

public class DeleteRecord {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java06", "root", "root");
        PreparedStatement ps=conn.prepareStatement("delete from marksheet where id=2525 ");
	    int i=ps.executeUpdate();
	    System.out.println("Record Deleted Successfully"+i);
	}

}
