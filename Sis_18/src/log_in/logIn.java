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
		List<String> errors = new ArrayList<String>(); 

		String email = request.getParameter("email");
		System.out.println(email);
		String pass = request.getParameter("contra");
		if (email == null || email.equals("")) {
			errors.add("emailv");
		}
		if (pass == null || pass.equals("")) {
			errors.add("passv");
		}
		if(errors.isEmpty()){
			try {
				Funciones_usuario n = new Funciones_usuario();
				boolean e = n.login_alumno_func(email,pass);
				HttpSession s = request.getSession();
				s.setAttribute("nombre", email);
				response.sendRedirect("menuPrincipal(usuario).jsp");
			}catch(Exception e) {
				if (e.getMessage()=="Error usuario") {
					System.out.println("He llegado");
					errors.add("emaile");
					
				}else if(e.getMessage()=="Error contrasena"){
					errors.add("passe");

				}
				request.setAttribute("errores",errors);
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request,response);
			}
		}
		else {
			request.setAttribute("errores",errors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request,response);
		}
	
		
		
	}

}
