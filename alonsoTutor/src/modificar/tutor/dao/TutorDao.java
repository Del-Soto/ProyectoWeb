package modificar.tutor.dao;

import modificar.tutor.beans.Tutor;

import java.sql.*;

public class TutorDao extends BDConnection{
	
	
	
	public int actualizarTutor(Tutor tutor2, Tutor tutor3) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query = "UPDATE tutor2 SET nombre = (?), apellido1 =(?), apellido2 = (?) WHERE nombre = (?)";
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, tutor2.getNombre());
				preparedStatement.setString(2, tutor2.getPrimerapellido() );
				preparedStatement.setString(3, tutor2.getSegundoapellido() );
				preparedStatement.setString(4, tutor3.getNombre());
				
				Integer row = preparedStatement.executeUpdate();
				
				if (row > 0) {
					tutor2.setCodigo(1);
					System.err.println("Se actualizo la informacion correctamente");
				} else {
					tutor2.setCodigo(-1);
					System.err.println("No se puedo realizar la actualizacion");
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public Tutor buscarTutor(Tutor tutor1) {
		
		Tutor tutor4 = new Tutor();
		
		try {
			
			getConnection();
			if (connection != null) {
				
				String query ="SELECT * FROM tutor2 WHERE nombre = (?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, tutor1.getNombre());
				ResultSet rs = preparedStatement.executeQuery();
				
				//System.out.println("Numero de coincidencias: " + rs.getRow());
				if (rs.getRow() >= 0) {
					if (rs.next()) {
						tutor4.setNombre(rs.getNString("nombre"));
						tutor4.setPrimerapellido(rs.getString(3));
						tutor4.setSegundoapellido(rs.getString(4));
						tutor4.setCodigo(1);
					}
				} else {
					tutor4.setCodigo(-1);// Error
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return tutor4;
		
		
	}
	
	public String registrarTutor(Tutor tutor2, int id)
	{
		String resp="";
		try {
			
			getConnection();
			if (connection != null) {
				
				String query = "INSERT INTO tutor2 VALUES ((?),(?),(?),(?))";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, tutor2.getNombre());
				preparedStatement.setString(3, tutor2.getPrimerapellido());
				preparedStatement.setString(4, tutor2.getSegundoapellido());
				int resultado = preparedStatement.executeUpdate();
				if (resultado >= 1) {
					System.out.println("Se insertaron " + resultado + " columnas");
					resp="registro correctamente";
				} else {
					System.err.println("No se logro insertr ningun registro");
					resultado=-1;
					resp="registro incorrectamente";
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return resp;
	}
	
	public String eliminarTutor(Tutor tutor2)
	{
		String resp="";
		try
		{
			getConnection();
			if(connection != null)
			{
				String query ="DELETE FROM tutor2 WHERE nombre = (?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, tutor2.getNombre());
				int resultado = preparedStatement.executeUpdate();
				if (resultado >= 1)
				{
					System.out.println("Se elimino correctamente el registro ");
					resp="se elimino correctamente";
				} else 
				{
					System.err.println("No se logro eliminar el registro");
					resultado=-1;
					resp="no se elimino incorrectamente";
				}
				
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return resp;
	}
	
	public int buscarUltimoReg()
	{
		int id=0;
		try
		{
			getConnection();
			if(connection != null)
			{
				String query ="SELECT * FROM tutor2 WHERE id = (SELECT MAX(id) from tutor2)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.getRow() >= 0) 
				{
					if (rs.next()) 
					{
						id=rs.getInt("id");
						
					}
				} 
				
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return id;
	}
	

	public Tutor buscarTutorApelllido(Tutor tutor1) {
		
		Tutor tutor4 = new Tutor();
		
		try {
			
			getConnection();
			if (connection != null) {
				
				String query ="SELECT * FROM tutor2 WHERE apellido1 = (?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, tutor1.getPrimerapellido());
				ResultSet rs = preparedStatement.executeQuery();
				
				//System.out.println("Numero de coincidencias: " + rs.getRow());
				if (rs.getRow() >= 0) {
					if (rs.next()) {
						tutor4.setNombre(rs.getNString("nombre"));
						tutor4.setPrimerapellido(rs.getString(3));
						tutor4.setSegundoapellido(rs.getString(4));
						tutor4.setCodigo(1);
					}
				} else {
					tutor4.setCodigo(-1);// Error
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return tutor4;
		
		
	}
	

}


