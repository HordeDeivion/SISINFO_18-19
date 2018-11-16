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

import ConnectDB.Alumno;
import Funciones_usuario.Funciones_usuario;

/**
 * Servlet implementation class mostrarRetoUsuario
 */
@WebServlet("/mostrarRetoUsuario")
public class mostrarRetoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mostrarRetoUsuario() {
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
		Funciones_usuario user = new Funciones_usuario();
		HttpSession session= request.getSession();
		Alumno alum=(Alumno)session.getAttribute("usuario");
		String nombre = alum.dameNombre()+" "+alum.dameApellido1()+ " "+alum.dameApellido2();
		request.setAttribute("nombre", nombre);
		
		ArrayList<Reto> retos = user.retos_alum_func(alum.dameEmail());
		int cantidad_ret= retos.size();
		
		request.setAttribute("retos", retos);
		request.setAttribute("numRetos", cantidad_ret);
		request.getRequestDispatcher("mostrarRetosUsuario.jsp").forward(request, response);
	}

}
