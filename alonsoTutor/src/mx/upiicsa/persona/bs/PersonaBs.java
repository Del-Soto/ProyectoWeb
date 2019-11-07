package mx.upiicsa.persona.bs;

import java.util.ArrayList;
import java.lang.StringBuilder;
import mx.upiicsa.persona.bean.Persona;
import mx.upiicsa.persona.dao.PersonaDao;

public class PersonaBs {
	public int registraPersona(Persona persona) {
		
		PersonaDao personaDao = new PersonaDao();
		int codigo=(Integer)personaDao.registrarPersona(persona);
		return codigo;
	}

	public Persona findById(int id) {
		PersonaDao personaDAO = new PersonaDao();
		Persona persona;
		persona = personaDAO.findById(id);
		System.out.println("--->BS.persona" + persona);
		return persona;
	}
	public int actualizaPersona(Persona persona) {
		PersonaDao personaDao = new PersonaDao();
		int codigo=(Integer)personaDao.actualizaPersona(persona);
		return codigo;
	}

	public static void main(String[] args) {
		PersonaDao personaDao = new PersonaDao();
		Persona persona;
		persona = personaDao.findById(1);
		if (persona != null) {
			System.out.println("nombre: " + persona.getNombre());
		} else {
			System.out.println("Se genero algun error");
		}
	}
	
	public int eliminaPersona(Persona persona) {
		
		PersonaDao personaDao = new PersonaDao();
		int codigo=(Integer)personaDao.eliminaPersona(persona);
		return codigo;
	}

/*
 * Falta terminar construccion de tabla con StringBuilder
 * 
 * public void GetListaPersona(String[] listaPersona){
    PersonaDao personaDao = new PersonaDao();
    int contador=0;
	//ArrayList<Persona>listaPersona = new ArrayList<Persona>();
	//listaPersona=personaDao.GetListaPersona();
	
	StringBuilder listaPersona1;
	for(int contador=0; contador < listaPersona1.size; contador++) {
			listaPersona1;
			}
	}*/
	
}
