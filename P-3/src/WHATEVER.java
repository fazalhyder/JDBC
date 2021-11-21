import java.sql.*;
public class WHATEVER {
public static void main(String args[]) throws Exception {
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/jfs";
String userid = "root";
String password = "root";
String query = "{ call getProducts() }";
Class.forName(driver);
Connection con = DriverManager.getConnection(url,userid,password);
CallableStatement stmt = con.prepareCall(query);
System.out.println("id"+"\t"+"name"+"\t"+"price");
System.out.println("---"+"\t"+"-----"+"\t"+"-----");
ResultSet rs = stmt.executeQuery();
while (rs.next()){
System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
}
con.close();
}
}