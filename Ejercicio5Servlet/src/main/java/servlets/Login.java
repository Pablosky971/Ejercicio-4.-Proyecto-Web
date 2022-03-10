package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Usuario;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setPassword(password);
		
		// Los tres primeros usuarios predefinidos.
		
		Usuario u1 = new Usuario();
		Usuario u2 = new Usuario();
		Usuario u3 = new Usuario();
		
		u1.setNombre("Pablosky");
		u1.setPassword("XOXOSlytherin");
		
		u2.setNombre("Meri");
		u2.setPassword("XOXOGriffindor");
		
		u3.setNombre("FdePablo");
		u3.setPassword("elmejorProfe");
		
		// Verificamos si los credenciales coinciden.
		
		if((u1.getNombre().equals(u.getNombre()) && u1.getPassword().equals(u.getPassword()))
				|| (u2.getNombre().equals(u.getNombre()) && u2.getPassword().equals(u.getPassword())) ||
				(u3.getNombre().equals(u.getNombre()) && u3.getPassword().equals(u.getPassword()))) {
			
			request.getSession().setAttribute("nombre", nombre);
			RequestDispatcher rd = request.getRequestDispatcher("exito.jsp");
			rd.forward(request, response);
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}