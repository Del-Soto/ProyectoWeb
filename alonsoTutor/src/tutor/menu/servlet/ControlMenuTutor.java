package tutor.menu.servlet;

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


@WebServlet("/MenuTutor")

public class ControlMenuTutor extends HttpServlet{
	
	
private static final long serialVersionUID = 1L;
	
	public ControlMenuTutor() {
		
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
				
				String respuesta = (String) request.getParameter("buscarTutor");
				String respuesta2 = (String) request.getParameter("eliminarTutor");
				String respuesta3 = (String) request.getParameter("registrarTutor");
				String respuesta4 = (String) request.getParameter("modificarTutor");
				
				
				if(respuesta != null) {
					
					rd = request.getRequestDispatcher("buscarTutor.jsp");
					codigo = -1;
					misession.setAttribute("codigo", codigo);
					rd.forward(request, response);
					
				}
				else if(respuesta2 != null)
				{
					rd = request.getRequestDispatcher("EliminarTutor.jsp");
					codigo = -1;
					misession.setAttribute("codigo", codigo);
					rd.forward(request, response);
				}
				else if(respuesta3 != null)
				{
					rd = request.getRequestDispatcher("RegistrarTutor.jsp");
					codigo = -1;
					misession.setAttribute("codigo", codigo);
					rd.forward(request, response);
				}
				else if(respuesta4 != null)
				{
					rd = request.getRequestDispatcher("modificarTutor.jsp");
					codigo = -1;
					misession.setAttribute("codigo", codigo);
					rd.forward(request, response);
				}
				
					
					
					
					
			}

}

