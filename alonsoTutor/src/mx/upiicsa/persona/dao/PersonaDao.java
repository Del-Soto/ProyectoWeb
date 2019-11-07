package mx.upiicsa.persona.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.upiicsa.persona.bean.Persona;
import mx.upiicsa.persona.dao.BDConnection;

public class PersonaDao extends BDConnection {

	public int registrarPersona(Persona persona) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query = "insert into Persona(nombre, primerApellido, segundoApellido, curp, genero, tipoSangre) values(?,?,?,?,?,?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, persona.getNombre());
				preparedStatement.setString(2, persona.getPrimerApellido());
				preparedStatement.setString(3, persona.getSegundoApellido());
				preparedStatement.setString(4, persona.getCurp());
				// preparedStatement.setInt(5, persona.getFolio());
				preparedStatement.setString(5, persona.getGenero());
				preparedStatement.setString(6, persona.getTipoSangre());
				 resultado = preparedStatement.executeUpdate();
				if (resultado >= 1) {
					System.out.println("Se insertaron " + resultado + " columnas");
				} else {
					System.err.println("No se logro insertr ningun registro");
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

	public Persona findById(int id) {
		Persona persona = new Persona();
		try {
			Connection connection = getConnection();

			if (connection != null) {

				String query = "select * from Persona where idPersona=?";
				PreparedStatement preparestatement = connection.prepareStatement(query);
				preparestatement.setString(1, Integer.toString(id));
				ResultSet rs = preparestatement.executeQuery();
				System.out.println("Numero de concidencias:" + rs.getRow());
				if (rs.getRow() > 0) {
					if (rs.next()) {
						persona.setNombre(rs.getString(1));
						persona.setPrimerApellido(rs.getString(1));
						persona.setSegundoApellido(rs.getString(1));
						persona.setCurp(rs.getString(1));
						persona.setGenero(rs.getString(1));
						persona.setTipoSangre(rs.getString(1));
						persona.setCodigo(1);
					}
				} else {
					persona.setCodigo(-1);// Error
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		return persona;
	}


	public Integer actualizaPersona(Persona persona) {
		System.out.println("--->"+persona.getId());
		try {
			int id = persona.getId();
			String query = "UPDATE Persona SET nombre='"+persona.getNombre()+"' primerApellido='"+persona.getPrimerApellido()+"',segundoApellido='"+persona.getSegundoApellido()+"',curp='"+persona.getCurp()+"',genero='"+persona.getGenero()+"',tipoSangre='"+persona.getTipoSangre()+"' WHERE idPersona="+(id);
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			Integer row = preparedStatement.executeUpdate();
			if (row > 0) {
				persona.setCodigo(1);
				System.err.println("Se actualizo la información correctamente");
			} else {
				persona.setCodigo(-1);
				System.err.println("No se puedo realizar la actualización");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persona.getCodigo();
	}
	
	
	public int eliminaPersona(Persona persona){
		Connection connection = getConnection();
		try {
		if (persona != null) {
		String query = "delete from Persona where nombre=? and primerApellido=? and segundoApellido=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, persona.getNombre());
		preparedStatement.setString(2, persona.getPrimerApellido());
		preparedStatement.setString(3, persona.getSegundoApellido());
		Integer row = preparedStatement.executeUpdate();
		if (row > 0) {
			persona.setCodigo(1);
			System.err.println("Se elimino la información correctamente");
		} else {
			persona.setCodigo(-1);
			System.err.println("No se pudo eliminar la informacion");
		}
	}
		} catch (SQLException sqle) {
		sqle.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
		cerrrarConexion();
	return persona.getCodigo();
		}
	
	/*
	 * Falta terminar construccion de tabla con StringBuilder
	 *
	public ArrayList<Persona> GetListaPersona(){
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
		try	 {
			Connection connection = getConnection();
			if (connection != null) {
				String query = "select * from Persona order by Id";
				PreparedStatement preparedstatement = connection.prepareStatement(query);
				ResultSet rs = preparedstatement.executeQuery();
				while (rs.next()) {
				Persona p=new Persona();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setPrimerApellido(rs.getString(3));
				p.setSegundoApellido(rs.getString(4));
				p.setCurp(rs.getString(5));
				p.setGenero(rs.getString(6));
				listaPersona.add(p);
			}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return listaPersona;
	}*/
	
	
	
	
	
}
