import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class mydb2 {
public static void main(String[] args)throws ClassNotFoundException,
SQLException {

String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/jfs";
String user = "root";
String password = "root";
Scanner in = new Scanner(System.in);
System.out.println("Enter product id: ");
int id = in.nextInt();
String query = "select *from product where id = ?";
Class.forName(driver);
Connection con = DriverManager.getConnection(url, user, password);
PreparedStatement ps = con.prepareStatement(query);
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
while(rs.next()) {
//System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getInt("price"));
}
ps.close();
con.close();
}
}