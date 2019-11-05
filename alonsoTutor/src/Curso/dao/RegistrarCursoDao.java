package Curso.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Curso.bean.Curso;

public class RegistrarCursoDao extends BDconexion{
	public int registrarCurso(Curso curso) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query = "insert into cursos (nombre,fechaInicio,fechaFin) values(?,?,?)";
				PreparedStatement preparedStatement =  connection.prepareStatement(query);
				preparedStatement.setString(1, curso.getNombre());
				preparedStatement.setString(2, curso.getFechaInicio());
				preparedStatement.setString(3, curso.getFechaFin());
				 resultado = preparedStatement.executeUpdate();
				if (resultado >= 1) {
					System.out.println("Se insertaron " + resultado + " columnas");
				} else {
					System.err.println("No se logro insertar ningun registro");
					resultado=-1;
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public Curso findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
