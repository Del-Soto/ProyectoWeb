package mx.upiicsa.persona.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.upiicsa.persona.bean.Persona;
import mx.upiicsa.persona.bs.PersonaBs;

@WebServlet("/PersonaServlet")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PersonaServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		HttpSession misesion = request.getSession();
		int codigo = 0;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String nombre = (String) request.getParameter("nombre");
		String primerApellido = (String) request.getParameter("primerApellido");
		String segundoApellido = (String) request.getParameter("segundoApellido");
		String curp = (String) request.getParameter("curp");
		// String folio = (String) request.getParameter("persona.folio");
		String genero = (String) request.getParameter("genero");
		String tipoSangre = (String) request.getParameter("tipoSangre");
		
		if (nombre == null || nombre.isEmpty()) {
			rd = request.getRequestDispatcher("RegistraPersona.jsp");
			codigo = -1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("--->codigo++++" + codigo);
		} else {
			Persona persona = new Persona();
			persona.setNombre(nombre);
			persona.setPrimerApellido(primerApellido);
			persona.setSegundoApellido(segundoApellido);
			persona.setCurp(curp);
			// persona.setFolio(folio);
			persona.setGenero(genero);
			persona.setTipoSangre(tipoSangre);
			PersonaBs personabs = new PersonaBs();
			int resultado = personabs.registraPersona(persona);
			System.out.println("--->resultado" + resultado);
			if (resultado == 1) {
				System.out.println("--->Dentro del if" + resultado);
				rd = request.getRequestDispatcher("exitoPersona.jsp");
				codigo = 1;
				misesion.setAttribute("codigo", codigo);
				rd.forward(request, response);
			}
		}

	}
}
