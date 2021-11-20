import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class mydb5 {
public static void main(String[] args)throws Exception {
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/jfs";
String user = "root";
String password = "root";
try (Scanner in = new Scanner(System.in)) {
	System.out.println("Enter product id: ");
	int id = in.nextInt();
	String sql = "DELETE FROM product WHERE id=?";
	
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, user, password);
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, id);
	int result = ps.executeUpdate();
	if(result > 0) {
	System.out.println("record is deleted");
	}else {
	System.out.println("something went wrong");
	}
	ps.close();
	con.close();
}
}
}