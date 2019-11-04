package tutor.modificar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modificar.tutor.beans.Tutor;
import modificar.tutor.bs.TutorBs;
import modificar.tutor.dao.BDConnection;
import modificar.tutor.dao.TutorDao;


@WebServlet("/modificarTutor")

public class ControlTutorModificar extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	
	
	public ControlTutorModificar()
	{
		super();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	
			throws ServletException, IOException
			{
				PrintWriter out = response.getWriter();
				RequestDispatcher rd;
				HttpSession misession = request.getSession();
				
				int codigo = 0;
				
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				
				String nombreTutor = (String) request.getParameter("tutor.nombre");
				String primerApellido = (String) request.getParameter("tutor.primerApellido");
				String segundoApellido = (String) request.getParameter("tutor.segundoApellido");
				
				if(nombreTutor == null || nombreTutor.isEmpty())
				{
					rd = request.getRequestDispatcher("error.jsp");
					codigo = -1;
					misession.setAttribute("codigo", codigo);
					rd.forward(request, response);
					System.err.println("----> Resultado:"+codigo);
					
					
					
				}
				else
				{
					Tutor tutor1 = new Tutor();
					tutor1.setNombre(nombreTutor);
					tutor1.setPrimerapellido(primerApellido);
					tutor1.setSegundoapellido(segundoApellido);
					tutor1.setCodigo(1);
					
					TutorBs tutorbs1 = new TutorBs();
					String resultado = tutorbs1.buscarTutor(tutor1);

					
					if (resultado == "existe") {
						rd = request.getRequestDispatcher("modificarTutor2.jsp");
						codigo = 1;
						misession.setAttribute("codigo", codigo);
						rd.forward(request, response);
					}
					
				}
			}
				

}
