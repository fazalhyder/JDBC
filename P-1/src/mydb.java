import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class mydb {
public static void main(String[] args)throws ClassNotFoundException,
SQLException {

String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/jfs";
String user = "root";
String password = "root";
String query = "select *from product";
//1. Loading Driver class
Class.forName(driver);
//2. Establish connection
Connection con = DriverManager.getConnection(url, user, password);
//3. Create Statement object
Statement stmt = con.createStatement();
//4. Get Result
ResultSet rs = stmt.executeQuery(query);
while(rs.next()) {
//System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getInt("price"));
}
//5. Close resources
stmt.close();
con.close();
}
}