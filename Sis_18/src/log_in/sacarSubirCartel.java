package log_in;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ConnectDB.Alumno;

/**
 * Servlet implementation class sacarSubirCartel
 */
@WebServlet("/sacarSubirCartel")
public class sacarSubirCartel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sacarSubirCartel() {
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
		String nombre = alum.dameNombre()+" "+alum.dameApellido1()+ " "+alum.dameApellido2();
		request.setAttribute("nombre", nombre);
		request.getRequestDispatcher("subirCartel.jsp").forward(request, response);
	}

}
