package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Persona;


@WebServlet("/FormularioJSPServlet")
public class FormularioJSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre"); // igual que el name del formulario
		String apellido = request.getParameter("apellido");
		String sPeso = request.getParameter("peso"); // Siempre son Strings
		
		int iPeso = 0;
		if(sPeso != null && !sPeso.equals("")) {
			iPeso = Integer.parseInt(sPeso); // Parseamos para que sea un int.
		}
		
		Persona p = new Persona();
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setPeso(iPeso);
		
		String mensaje = "Primer mensaje desde el Servlet";
		
		// Podemos decir al servlet donde queremos ir para mostrar la informaci�n
		RequestDispatcher rd = request.getRequestDispatcher("resultadoFormulario2.jsp");
		request.setAttribute("m1", mensaje);
		request.setAttribute("num", 5);
		request.setAttribute("p1", p);
		
		// Si se quiere guardar info para un usuario durante todo su trayecto por la aplicaci�n, se debe usar la session.
		request.getSession().setAttribute("nombre", nombre);

		// Ejecutamos acci�n de ir
		rd.forward(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
