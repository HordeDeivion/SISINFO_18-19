package log_in;

import Funciones_usuario.*;
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logIn
 */
@WebServlet("/logIn")
public class logIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 *  emailv = email vacio
	 *  emaile = email error
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("He llegado");
	//	List<String> errors = new ArrayList<String>(); 
		Map<String,String> errors = new HashMap<String,String>();
		String email = request.getParameter("email");
		System.out.println(email);
		String pass = request.getParameter("pass");
		String op = request.getParameter("participacion");
		if(errors.isEmpty()){
			if (op != "36428") {
				
				System.out.println("Soy alumno");
				try {
					Funciones_usuario n = new Funciones_usuario();
					boolean e = n.login_alumno_func(email,pass);
					HttpSession s = request.getSession();
					s.setAttribute("nombre", email);
					response.sendRedirect("perfilUsuario.jsp");
				}catch(Exception e) {
					if (e.getMessage()=="Error usuario") {
						System.out.println("He llegado al java");
						errors.put("email","Email erroneo");
						
					}else if(e.getMessage()=="Error contrasena"){
						errors.put("pass", "Contraseña incorrecta");
	
					}
					request.setAttribute("errores",errors);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
					dispatcher.forward(request,response);
				}
			}
			else {
				try {
					Funciones_usuario n = new Funciones_usuario();
					boolean e = n.login_profe_func(email,pass);
					HttpSession s = request.getSession();
					s.setAttribute("nombre", email);
					response.sendRedirect("Profesor.jsp");
				}catch(Exception e) {
					if (e.getMessage()=="Error usuario") {
						System.out.println("He llegado");
						errors.put("email","Email erroneo");
						
					}else if(e.getMessage()=="Error contrasena"){
						errors.put("pass", "Contraseña incorrecta");
	
					}
					request.setAttribute("errores",errors);
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request,response);
				}
			}
		}
		else {
			request.setAttribute("errores",errors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request,response);
		}
	
		
		
	}

}
