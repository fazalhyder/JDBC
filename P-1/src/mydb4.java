import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class mydb4 {
public static void main(String[] args)throws Exception {
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/jfs";
String user = "root";
String password = "root";
try (Scanner in = new Scanner(System.in)) {
	System.out.println("Enter product id: ");
	int id = in.nextInt();
	System.out.println("Enter product name: ");
	String name = in.next();
	System.out.println("Enter product price: ");
	String price = in.nextLine();
	String sql = "UPDATE product SET name=?, price=? WHERE id=?";
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, user, password);
	PreparedStatement ps = con.prepareStatement(sql);
	
	ps.setString(1, name);
	ps.setString(2, price);
	ps.setInt(3, id);
	int result = ps.executeUpdate();
	if(result > 0) {
	System.out.println("record is updated");
	}else {
	System.out.println("something went wrong");
	}
	ps.close();
	con.close();
}
}
}