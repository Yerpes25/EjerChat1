package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	private static final String JCBC_URL = "jdbc:mysql://localhost:3306/nba?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=Europe/Madrid";
	
	private static Connection instance = null;
	
	public Conexion() {}
	
	public static Connection getConnection() throws SQLException {
		if(instance == null) {
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "");
			
			instance = DriverManager.getConnection(JCBC_URL, props);
			
		}
		return instance;
	}
}
