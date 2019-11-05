package Dao;

import java.sql.*;

import Bean.Contacto;

public class BDConnection {
	
	protected Connection connection = null;
	
	public static void main (String[] args)
	{
		String nn="";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//1.- Get connection 
			Connection myconection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Direccion?useTimezone=true&serverTimezone=UTC", "root", "1234");
			System.out.println("paso 1 echo");
			
			//2.- create statement
			Statement mysts = myconection.createStatement();
			System.out.println("paso 2 echo");
			
			//3.- Execute SQL query
			String name="alonso";
			ResultSet myRs = mysts.executeQuery("SELECT * FROM tutor2 WHERE nombre="+"'"+name+"'");
			//ResultSet myRs = mysts.executeQuery("SELECT * FROM tutor");
			System.out.println("paso 3 echo");
			
			//4.- process the result 
			while(myRs.next()) 
			{
				System.out.println(myRs.getString("nombre")+", "+myRs.getString("apellido1")+", "+myRs.getString("apellido2"));
				nn = myRs.getString("nombre");
				
				
			}
			System.out.println("se guardo correctamente " + nn);
			System.out.println("paso 4 echo");
			
			
		}	
			catch(Exception exc)
			{
				exc.printStackTrace();
				System.out.println("valiovergaraza");
			}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Direccion?useTimezone=true&serverTimezone=UTC", "root", "1234");
			System.err.println("-->Conexionexitosa");
		}
		catch (SQLException ex) {
	    	 System.err.println("-->SQL errorConexionexitosa");
	    	 ex.printStackTrace();
	     } catch (ClassNotFoundException e) {
	    	 System.err.println("-->E errorConexionexitosa");
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public  void cerrrarConexion() {
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