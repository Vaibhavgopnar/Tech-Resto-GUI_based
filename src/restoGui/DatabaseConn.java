package restoGui;

import java.sql.*;

public class DatabaseConn {

	static Connection con;

	public static Connection creatC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/Tech_Resto";
			String user = "root";
			String pass = "V2169@gpatil";

			con = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return con;

	}

}
