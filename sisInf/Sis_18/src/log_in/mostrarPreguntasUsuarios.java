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
 * Servlet implementation class mostrarPreguntasUsuarios
 */
@WebServlet("/mostrarPreguntasUsuarios")
public class mostrarPreguntasUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mostrarPreguntasUsuarios() {
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
		
		ArrayList<Pregunta> preguntas =  user.preguntas_alum_func(alum.dameEmail());
		ArrayList<Respuesta> respuestas;
		int numPreguntas=preguntas.size();
		request.setAttribute("numPreguntas", numPreguntas);
		
		Pregunta[] listaPreguntas = new Pregunta[numPreguntas];
		Respuesta[][] respuestasMatriz = new Respuesta[numPreguntas][6];
		int indice=0;
		int iResp;
		
		Iterator<Pregunta> it = preguntas.iterator();
		Iterator<Respuesta> itRes;
		while (it.hasNext()){
			listaPreguntas[indice]=it.next();
			respuestas=user.listado_respuestas_func(listaPreguntas[indice].dameID());
			itRes=respuestas.iterator();
			iResp=0;
			while (itRes.hasNext()){
				respuestasMatriz[indice][iResp]=itRes.next();
				iResp=iResp+1;
			}
			respuestasMatriz[indice][iResp]=null;
		}
		
		request.setAttribute("preguntas", listaPreguntas);
		request.setAttribute("respuestas", respuestasMatriz);
		
		request.getRequestDispatcher("mostrarPreguntasUsuario.jsp").forward(request, response);
	}

}
