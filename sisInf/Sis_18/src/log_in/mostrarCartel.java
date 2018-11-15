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
 * Servlet implementation class mostrarCartel
 */
@WebServlet("/mostrarCartel")
public class mostrarCartel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mostrarCartel() {
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
	    
	    String id = request.getParameter("idCartel");
	    int idCartel=Integer.parseInt(id);
	    Cartel cart= user.cartel_id_func(idCartel);
	    request.setAttribute("cartel", cart);
	    
	    Alumno autor = user.alumno_id_func(cart.dameEmailAlumno());
	    String nombreAutor=autor.dameNombre()+" "+autor.dameApellido1()+ " "+autor.dameApellido2();
	    request.setAttribute("autor", nombreAutor);
	    
	    Pregunta preg=user.pregunta_asociada_cartel_func(idCartel);
	    ArrayList<Respuesta> resp =user.listado_respuestas_func(preg.dameID());
	    request.setAttribute("pregunta", preg);
	    request.setAttribute("respuestas", resp);
	    
	    ArrayList<Comentario> coms= user.respuestas_cartel_func(idCartel);
	    request.setAttribute("comentarios", coms);
	    Reto ret = user.retos_asociados_cartel_func(idCartel);
	    request.setAttribute("reto", ret);
	    
		request.getRequestDispatcher("mostrarCartel.jsp").forward(request, response);
	}

}
