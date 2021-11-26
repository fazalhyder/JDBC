import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class details {
public static void main(String[] args) {
String query = "SELECT *FROM customer";
Properties props = null;
InputStream is = null;
Connection con = null;
Statement stmt = null;
try {
is = new FileInputStream("src/db.properties");
props = new Properties();
props.load(is);
} catch (FileNotFoundException e) {
System.out.println("db.properties file not found");
} catch (Exception e) {
e.printStackTrace();
}finally {
try {
is.close();
} catch (IOException e) {
e.printStackTrace();
}
}

try {
con =

DriverManager.getConnection(props.getProperty("jdbc.url"),props.getProperty("jdbc.user"),props.getProperty("jdbc.password"));
stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
if(rs != null) {
while(rs.next()) {

System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));

}
}
}catch (Exception e) {
e.printStackTrace();
}
finally {
try {
stmt.close();
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}
}