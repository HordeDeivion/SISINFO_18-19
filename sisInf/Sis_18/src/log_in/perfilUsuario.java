package log_in;

import java.io.IOException;
import java.util.*;
import Funciones_usuario.*;
import ConnectDB.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class perfilUsuario
 */
@WebServlet("/perfilUsuario")
public class perfilUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public perfilUsuario() {
        super();
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
		//doGet(request, response);
		HttpSession session= request.getSession();
		Alumno alum=(Alumno)session.getAttribute("usuario");
		String nombre = "Logeado como "+alum.dameNombre()+" "+alum.dameApellido1()+ " "+alum.dameApellido2();
		request.setAttribute("nombre", nombre);
		request.getRequestDispatcher("perfilUsuario.jsp").forward(request, response);
	}

}
