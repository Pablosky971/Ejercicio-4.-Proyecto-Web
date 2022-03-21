package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
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
		
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		
		// Verificamos si los credenciales coinciden.
		
		int i = 0;
		for(i=0;i<usuarios.size();i++) {
			
	
		
		if(usuarios.get(i).getNombre().equals(nombre) && usuarios.get(i).getPassword().equals(password)) {
			
			request.getSession().setAttribute("nombre", nombre);
			RequestDispatcher rd = request.getRequestDispatcher("exito.jsp");
			rd.forward(request, response);
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}
		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
