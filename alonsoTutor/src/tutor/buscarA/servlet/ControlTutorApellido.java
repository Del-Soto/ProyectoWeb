package tutor.buscarA.servlet;

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
@WebServlet("/buscaTutorApellido")


public class ControlTutorApellido extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	public ControlTutorApellido() {
		
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
		
		String apellidoTutor = (String) request.getParameter("tutor.Apellido");
		String respuesta = (String) request.getParameter("cancelar");
		
		
		
		
		
		
		if(apellidoTutor == null || apellidoTutor.isEmpty())
		{
			if(respuesta == "cancelar")
			{
				rd = request.getRequestDispatcher("MenuTutor.jsp");
				codigo = -1;
				misession.setAttribute("codigo", codigo);
				rd.forward(request, response);
			}
			
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
			tutor1.setPrimerapellido(apellidoTutor);
			
			String resp=b1.buscarTutorApellido(tutor1);
			
			if (resp != null)
			{
				//System.out.println("respuesta chida: "+resp);
				misession.setAttribute("Respuesta", resp);
				rd = request.getRequestDispatcher("buscarTutor.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("error");
			}
			
			
			
			


			
			
		}
		
	}
	

}


