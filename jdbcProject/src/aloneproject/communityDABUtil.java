package aloneproject;

import java.sql.Connection;
//ojdbc11.jar
import java.sql.DriverManager;

public class communityDABUtil {
	//DB접속정보 활용 -> 세션(Connection객체)
	public static Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
