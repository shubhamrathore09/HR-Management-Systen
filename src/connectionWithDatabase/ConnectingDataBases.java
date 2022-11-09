package connectionWithDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectingDataBases {
	
public static Connection DatabaseConnetion() {
	Connection con=null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
	String url="jdbc:mysql://localhost:3306/organization";
	
	try {
		con=DriverManager.getConnection(url, "root", "qwerty");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		
	}
	return con;
}



}
