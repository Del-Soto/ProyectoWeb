package modificar.tutor.bs;

import modificar.tutor.beans.Tutor;
import modificar.tutor.dao.TutorDao;


public class TutorBs {
	
	private static String nombreBusq;
	
	public int actualizarTutor(Tutor tutor2) {
		
		Tutor tutor3 = new Tutor();
		tutor3.setNombre(nombreBusq);
		TutorDao tutorDao1 = new TutorDao();
		int codigo=(Integer)tutorDao1.actualizarTutor(tutor2, tutor3);
		return codigo;
	}
	
	public String buscarTutor(Tutor tutor1)
	{
		String res="";
		
		TutorDao dao1 = new TutorDao();
		Tutor tutor2 = new Tutor();
		
		tutor2= dao1.buscarTutor(tutor1);
				
		if ((tutor2.getNombre()!=null)&&(tutor2.getPrimerapellido()!=null)&&(tutor2.getSegundoapellido()!=null))
		{
			nombreBusq=tutor2.getNombre();
			res="Se encontro la siguiente coincidencia, Nombre:"+tutor2.getNombre()+" Primer Apellido: " + tutor2.getPrimerapellido() + " Segundo Apellido: " + tutor2.getSegundoapellido();
			//System.out.println("Prueba: "+res);
		}
		else
		{
			System.out.println("no existe");
			res="no existe";
		}
		
		return res;
	}
	
	
	public String resgitartutor(Tutor tutor1)
	{
		
		TutorDao dao2 = new TutorDao();
		
		int id = dao2.buscarUltimoReg();
		//System.out.println("Ultimo id registrado" + id);
		id++;
		
		String res = dao2.registrarTutor(tutor1, id);
		
		return res;
		
	}
	
	public String eliminarTutor(Tutor tutor1)
	{
		
		TutorDao dao2 = new TutorDao();
		
		String res = dao2.eliminarTutor(tutor1);
		
		return res;
		
	}
	
	public String buscarTutorApellido(Tutor tutor1)
	{
		String res="";
		
		TutorDao dao1 = new TutorDao();
		Tutor tutor2 = new Tutor();
		
		tutor2= dao1.buscarTutorApelllido(tutor1);
				
		if ((tutor2.getNombre()!=null)&&(tutor2.getPrimerapellido()!=null)&&(tutor2.getSegundoapellido()!=null))
		{
			nombreBusq=tutor2.getNombre();
			res="<p>Se encontro la siguiente coincidencia, Nombre:"+tutor2.getNombre()+" Primer Apellido: " + tutor2.getPrimerapellido() + " Segundo Apellido: " + tutor2.getSegundoapellido()+"</p>";
		}
		else
		{
			System.out.println("no existe");
			res="no existe";
		}
		
		return res;
	}
	

	

}
