import java.sql.*;
public class Transaction {
public static void main(String args[]) throws Exception {
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/jfs";
String userid = "root";
String password = "root";
String sql1 = "UPDATE account SET balance = balance-20000 WHERE ano = 111000";
String sql2 = "UPDATE account SET balance = balance+20000 WHERE ano = 111001";
Class.forName(driver);
Connection con = DriverManager.getConnection(url, userid, password);
// step 1
con.setAutoCommit(false);
Statement stmt = con.createStatement();
// step 2
stmt.addBatch(sql1);
stmt.addBatch(sql2);
// step 3
int[] x = stmt.executeBatch();
System.out.println(x[0] + " " + x[1]);
if (x[0] == 1 && x[1] == 1) {
con.commit();
System.out.println("Transaction successful");
} else {
con.rollback();
System.out.println("Transaction failed");
}
con.close();
}
}