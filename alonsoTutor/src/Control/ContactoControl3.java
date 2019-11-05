package Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Contacto;
import bs.ContactoBs;

/**
 * Servlet implementation class ContactoControl3
 */
@WebServlet("/ContactoControl3")
public class ContactoControl3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactoControl3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		HttpSession misesion = request.getSession();
		
		int codigo = 0;
		
		response.setContentType("text/html");
		response.setContentType("UTF-8");
	
		String id=(String)request.getParameter("id2");
		
		if(id.isEmpty())
		{
			rd = request.getRequestDispatcher("mediodecontacto.jsp");
			codigo = -1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
			System.err.println("--->codigo++++" + codigo);
		}
		else
		{
			Contacto contacto = new Contacto();
			contacto.setId(Integer.parseInt(id));
		
		ContactoBs contactobs = new ContactoBs();
		int resultado = contactobs.borrar(contacto);
		System.out.println("--->resultado" + resultado);
		
		if(resultado == 1)
		{
			System.out.println("--->Dentro del if" + resultado);
			rd = request.getRequestDispatcher("exito.jsp");
			codigo = 1;
			misesion.setAttribute("codigo", codigo);
			rd.forward(request, response);
		}
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
