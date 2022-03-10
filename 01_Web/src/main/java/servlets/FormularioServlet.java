package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Persona;


@WebServlet("/FormularioServlet")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Hay que tener muy claro que los valores de los parámetros llegan siempre en formato cadena (String).
		String nombre = request.getParameter("nombre"); // igual que el name del formulario
		String apellido = request.getParameter("apellido");
		String sPeso = request.getParameter("peso"); // Siempre son Strings
		
		int iPeso = 0;
		if(sPeso != null) {
			iPeso = Integer.parseInt(sPeso); // Parseamos para que sea un int.
		}
		
		Persona p = new Persona();
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setPeso(iPeso);
		
		response.getWriter().append("Served at: " + p.toString()).append("<h1>" + p.toString() + "</h1>");
		response.setContentType("text/html");
		
		// Si queremos trabajar con HTML, esta no es la manera.
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
