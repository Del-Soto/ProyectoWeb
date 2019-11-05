package Curso.bs;

import Curso.bean.Curso;
import Curso.dao.EliminarCursoDao;

public class EliminarCursoBs {
	public int eliminarCurso(Curso curso) {
		
		EliminarCursoDao eliminarCursoDao = new EliminarCursoDao();
		int codigo = (Integer) eliminarCursoDao.eliminarCurso(curso);
		return codigo;
	}
	

	public static void main(String[] args) {
		EliminarCursoDao eliminarCursoDao = new EliminarCursoDao();
		Curso curso;
		curso = eliminarCursoDao.findById(1);
		if (curso != null) {
			System.out.println("nombre: " + curso.getNombre());
		} else {
			System.out.println("Se genero algun error");
		}

	}
}
