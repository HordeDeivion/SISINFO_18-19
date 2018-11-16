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

/**
 * Servlet implementation class VerCarteles
 */
@WebServlet("/VerCarteles")
public class VerCarteles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerCarteles() {
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
		
		String pet = request.getParameter("participacion");
		int peticion=Integer.parseInt(pet);
		
		ArrayList<Cartel> carteles=user.carteles_ganadores_func(peticion);
		int numCarteles=carteles.size();
		
		request.setAttribute("carteles", carteles);
		request.setAttribute("numCarteles", numCarteles);
		request.getRequestDispatcher("verCarteles.jsp").forward(request, response);
	}

}
