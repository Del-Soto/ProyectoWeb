package Curso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDconexion {
	protected Connection connection = null;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/proyectoweb", "guru2b","g00r002b");
		}catch(SQLException ex){
			System.err.println("-->SQL errorConexionexitosa");
		}catch(ClassNotFoundException e) {
			System.err.println("-->E errorConexionexitosa");
			e.printStackTrace();
		}
		return connection;
	}
	
	public void cerrarConexion() {
		try {
			if(connection!=null) {
				connection.close();
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
