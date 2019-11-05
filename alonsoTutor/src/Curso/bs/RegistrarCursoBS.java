package Curso.bs;

	import Curso.bean.Curso;
	import Curso.dao.RegistrarCursoDao;

	public class RegistrarCursoBS {
	public int registraCurso(Curso curso) {
			
		    RegistrarCursoDao regcursoDao = new RegistrarCursoDao();
			int codigo=(Integer)regcursoDao.registrarCurso(curso);
			return codigo;
		}

		public static void main(String[] args) {

		}

	}

