import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class kk {
public static void main(String[] args)throws Exception {
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/jfs";
String user = "root";
String password = "root";
String[] queries = {
		
		"UPDATE customer SET id = 102 WHERE id=111",
		
};
Class.forName(driver);
Connection con = DriverManager.getConnection(url, user, password);
Statement st = con.createStatement();
for(String query : queries) {
st.addBatch(query);
}
int[] result = st.executeBatch();
System.out.println("Batch is executed: "+result.length);
st.close();
con.close();
}
}