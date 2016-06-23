package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtil {
	

	
	private static final String URL = "jdbc:mysql://localhost:3306/MuseuDigital?autoReconnect=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "123456";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static JDBCUtil instancia;
	private Connection con;
	
	private JDBCUtil() { 
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static JDBCUtil getInstancia() { 
		if (instancia == null) { 
			instancia = new JDBCUtil();
		}
		return instancia;
	}
	
	public Connection openConnection() { 
		if (con == null) { 
			try {
				con = DriverManager.getConnection(URL, USER, PASS);
				System.out.println("teste que esta passando aqui");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public void closeConnection() { 
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
	}
	

}
