package easyJDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcconnection {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.28:1521/orcl", "HR", "oracle");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from EMPLOYEES");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - - " + rs.getString(3));
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("fin da lista que vem da bd");
		}


	}

}
