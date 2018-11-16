package log_in;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ConnectDB.Alumno;
import Funciones_usuario.Funciones_usuario;

/**
 * Servlet implementation class ModificarPerfilAlumno
 */
@WebServlet("/ModificarPerfilAlumno")
public class ModificarPerfilAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPerfilAlumno() {
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
		Map<String,String> errors = new HashMap<String,String>();
		
		//String tipo = request.getParameter("tipo");
		String tipo = "entro";
		if(tipo.equals("entro")){
			String nombre = alum.dameNombre()+" "+alum.dameApellido1()+ " "+alum.dameApellido2();
			request.setAttribute("nombre", nombre);
			request.getRequestDispatcher("modificarPerfil.jsp").forward(request, response);
		}
		else{
			String nombre = request.getParameter("nombre");
			String apellido1 = request.getParameter("apellido1");
			String apellido2 = request.getParameter("apellido2");
			String passvieja = request.getParameter("clave1");
			String pass = request.getParameter("clave2");
			try{
			//if(user.login_alumno_func (alum.dameEmail(), passvieja)){
			if(true){
				user.modificar_alumno (nombre,apellido1, apellido2, pass , alum.dameEmail(), alum.dameEmailprofe());
				request.getRequestDispatcher("perfilUsuario").forward(request, response);
			}
			}catch(Exception e) {
				if (e.getMessage()=="Error usuario") {
					errors.put("email","Email erroneo");
				}else if(e.getMessage()=="Error contrasena"){
					errors.put("pass", "Contraseña incorrecta");
				}
			}
		}
	}

}
