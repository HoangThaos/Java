package dddd;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class connect {
	Connection con;
	public Connection conect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=java;", "sa", "123");
			System.out.println("");

		} catch (Exception e) {
			System.out.println("Connection fail");
		}
		return con;
	}
}