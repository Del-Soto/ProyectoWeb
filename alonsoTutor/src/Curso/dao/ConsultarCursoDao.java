package Curso.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Curso.bean.Curso;

public class ConsultarCursoDao extends BDconexion{
	
	
	public Curso consultarCurso(Curso curso) {
		try {
			getConnection();
			if(connection != null) {
				String query = "SELECT * FROM cursos";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultado = preparedStatement.executeQuery();
				
				while(resultado.next()) {
				
					curso.setNombre((String) resultado.getString("nombre"));
					curso.setFechaInicio((String) resultado.getString("fechaInicio"));
					curso.setFechaFin((String) resultado.getString("fechaFin"));
					System.out.println((String) resultado.getString("nombre"));
				}
				
			}
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curso;
		
	}
	
	public Curso findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
