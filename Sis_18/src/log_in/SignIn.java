package log_in;
import Funciones_usuario.*;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class log_in
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignIn() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("He llegado");
		Map<String,String> errors = new HashMap<String,String>(); 

		String email = request.getParameter("usuario");
		String pass = request.getParameter("pass");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String op = request.getParameter("participacion");
		Funciones_usuario user = new Funciones_usuario();
		if (op == "36428") {
			// Insertamos alumno.
			//insertar_profesor (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado)
			try{
				user.insertar_alumno(nombre,apellidos,apellidos,pass,email,"uno@unizar.es");
				response.sendRedirect("menuPrincipal(usuario).html");
			}catch(Exception e) {
				response.sendRedirect("darAlta.html");
			}
		}
		else {
			// Profesor.
			try {
				user.insertar_profesor(nombre,apellidos,apellidos,pass,email,"uno@unizar.es");
				response.sendRedirect("menuPrincipal(Profesor).html");
			}
			catch(Exception e){
				response.sendRedirect("darAlta.html");
			}
		}


		//ConnectDB uno = new ConnectDB();
		
		//int HaPodido= uno.insert_profe(nombre, apellidos, apellidos, pass, email,"uno@unizar.es" );
		
	}

}
