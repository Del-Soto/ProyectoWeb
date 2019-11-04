package tutor.buscar.servlet;

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
@WebServlet("/buscaTutor")


public class ControlTutor extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	public ControlTutor() {
		
		super();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		HttpSession misession = request.getSession();
		
		int codigo = 0;
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String nombreTutor = (String) request.getParameter("tutor.Nombre");
		/*String apellido1 = (String) request.getParameter("tutor.Apellido1");
		String apellido2 = (String) request.getParameter("tutor.Apellido2");*/
		
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
			TutorBs b1 = new TutorBs();
			tutor1.setNombre(nombreTutor);
			/*tutor1.setPrimerapellido(apellido1);
			tutor1.setSegundoapellido(apellido2);*/
			
			String resp=b1.buscarTutor(tutor1);
			
			if (resp=="existe")
			{
				System.out.println("respuesta chida: "+resp);
				
			}
			else
			{
				System.out.println("respuesta no tan chida");
			}
			
			
			
			


			
			
		}
		
	}
	

}

