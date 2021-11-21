import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class BatchInsert {
public static void main(String[] args)throws Exception {
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/jfs";
String user = "root";
String password = "root";
String[] queries = {
		"CREATE TABLE employee(eid INT,ename VARCHAR(20),esal INT)",
"INSERT INTO employee VALUES(101,'Wills',55000)",
"INSERT INTO employee VALUES(102,'Smith',45000)",
"INSERT INTO employee VALUES(103,'Anna',35000)",
"INSERT INTO employee VALUES(104,'Alex',25000)"
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