package Curso.bs;

import java.util.ArrayList;

import Curso.bean.Curso;
import Curso.dao.ConsultarCursoDao;
import Curso.dao.EliminarCursoDao;

public class ConsultaCursoBs {
	public Curso consultarCurso(Curso curso) {
		
	    ConsultarCursoDao consultarCursoDao = new ConsultarCursoDao();
	    curso = consultarCursoDao.consultarCurso(curso);
		return curso;
	}
	
	public static void main(String[] args) {
		ConsultarCursoDao consultarCursoDao = new ConsultarCursoDao();
		Curso curso;
		
	}
}
