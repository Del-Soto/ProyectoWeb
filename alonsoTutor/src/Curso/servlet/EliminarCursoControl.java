package Curso.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Curso.bean.Curso;
import Curso.bs.EliminarCursoBs;

@WebServlet("/EliminarCursoControl")
public class EliminarCursoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminarCursoControl() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		HttpSession misesion = request.getSession();
		int codigo = 0;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String nombre = (String) request.getParameter("curso.nombre");
		String fechaInicio = request.getParameter("curso.fechaInicio");
		String fechaFin = request.getParameter("curso.fechaFin");
		
		if (nombre == null || nombre.isEmpty() || fechaInicio == null || fechaInicio.isEmpty() || fechaFin == null || fechaFin.isEmpty()
				)  {
			rd = request.getRequestDispatcher("EliminarCurso.jsp");
			codigo = -1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("--->codigo++++" + codigo);
		} else {
			Curso curso = new Curso();
			curso.setNombre(nombre);
			curso.setFechaInicio(fechaInicio);
			curso.setFechaFin(fechaFin);
			EliminarCursoBs eliminarCursobs = new EliminarCursoBs();
			int resultado = eliminarCursobs.eliminarCurso(curso);
			
			if (resultado == 1) {
				System.out.println("--->Dentro del if" + resultado);
				rd = request.getRequestDispatcher("EliminarCurso.jsp");
				codigo = 1;
				misesion.setAttribute("codigo", codigo);
				rd.forward(request, response);
			}else if(resultado == -1){
				System.out.println("--->resultado" + resultado);
				rd = request.getRequestDispatcher("EliminarCurso.jsp");
				codigo = -1;
				misesion.setAttribute("codigo", codigo);
				rd.forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}