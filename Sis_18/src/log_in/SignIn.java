package log_in;
import Funciones_usuario.*;
import ConnectDB.*;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ConnectDB.Alumno;

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
		String pass2 = request.getParameter("pass2");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String emailP = request.getParameter("emailP");

		String op = request.getParameter("participacion");
		Funciones_usuario user = new Funciones_usuario();
		if(pass.equals(pass2)) {
			
		
				try {
					user.Buscar_profe(emailP);
				}catch(Exception e){
					if(e.getMessage()== "Error nombre profesor") {
						errors.put("email asociado","Email profesor asociado erroneo");
		        	}
				}
			
				if (op.equals("36428") ) {
					// Insertamos alumno.
					//insertar_profesor (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado)
					try{
						user.Buscar_alum(email);
						
					}catch(Exception e) {
						errors.put("nombre","Email en uso");
						request.setAttribute("errores",errors);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/dardeAlta.jsp");
						dispatcher.forward(request,response);
					}	
					try {
						user.insertar_alumno(nombre,apellido1,apellido2,pass,email,emailP);
						Alumno alum = user.alumno_id_func(email);
						HttpSession s = request.getSession();
						s.setAttribute("usuario", alum);
						response.sendRedirect("perfilUsuario.jsp");
					}catch(Exception e) {
						errors.put("insertar","insertar usuario");
						request.setAttribute("errores",errors);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/dardeAlta.jsp");
						dispatcher.forward(request,response);
					}
				}
				else {
					// Profesor.
					try {
						user.Buscar_profe(email);
					}catch(Exception e){
						if(e.getMessage()== "Error nombre profesor") {
							errors.put("nombre","Email en uso");
							request.setAttribute("errores",errors);
							RequestDispatcher dispatcher = request.getRequestDispatcher("/dardeAlta.jsp");
							dispatcher.forward(request,response);
			        	}
					}
					try {
						user.insertar_profesor(nombre,apellido1,apellido2,pass,email,emailP);
						Profesor profe = user.profesor_id_func(email);
						HttpSession s = request.getSession();
						s.setAttribute("usuario", profe);
						response.sendRedirect("Profesor.html");
					}
					catch(Exception e){
						errors.put("insertar","insertar profesor");
						request.setAttribute("errores",errors);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/dardeAlta.jsp");
						dispatcher.forward(request,response);
					}
				}
	
	
			//ConnectDB uno = new ConnectDB();
			
			//int HaPodido= uno.insert_profe(nombre, apellidos, apellidos, pass, email,"uno@unizar.es" );
			
		}else {
			// Codigo contraseñas incorrectas
			errors.put("pass","password incorrecta usuario");
			request.setAttribute("errores",errors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/dardeAlta.jsp");
			dispatcher.forward(request,response);
			
		}
	}

}
