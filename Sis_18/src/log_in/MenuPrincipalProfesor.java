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
 * Servlet implementation class MenuPrincipalProfesor
 */
@WebServlet("/MenuPrincipalProfesor")
public class MenuPrincipalProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuPrincipalProfesor() {
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
		//Alumno alum=(Alumno)session.getAttribute("usuario");
		Profesor prof=user.profesor_id_func("uno@unizar.es");  	//PRUEBAS
	    session.setAttribute("usuario",prof);					//PRUEBAS
		
		String nombre = prof.dameNombre()+" "+prof.dameApellido1()+ " "+prof.dameApellido2();
		request.setAttribute("nombre", nombre);
		
		ArrayList<String> temas =user.temas_anyoactual_func();
		int cantidad_temas= temas.size();
		String[] temaso = new String[cantidad_temas];
		Cartel[] carteles = new Cartel[cantidad_temas];
		Iterator<String> it = temas.iterator();
		int i=0;
	    while (it.hasNext()){
	        temaso[i]=it.next();
	        carteles[i]=user.ganadortema_anyoactual_func(temaso[i]);
	        i=i+1;
	    }
	    
	    request.setAttribute("temas", temaso);
	    request.setAttribute("carteles", carteles);
	    request.setAttribute("numTemas", cantidad_temas);
	    request.setAttribute("tipoUser", "Profesor");
	    request.getRequestDispatcher("menuPrincipal(Usuario).jsp").forward(request, response);
		
	}

}
