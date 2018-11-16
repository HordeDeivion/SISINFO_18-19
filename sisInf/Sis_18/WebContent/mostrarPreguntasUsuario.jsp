<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "Funciones_usuario.*" %>
    <%@ page import= "ConnectDB.*" %>
    <%@ page import= "java.io.IOException" %>
    <%@ page import= "java.util.*" %>
    
    <% 
    //String Usuario="alum@unizar.es";
    Funciones_usuario user = new Funciones_usuario();
    String nombre = (String)request.getAttribute("nombre");
    Pregunta[] listaPreguntas =(Pregunta[])request.getAttribute("preguntas");
    Respuesta[][] respuestasMatriz = (Respuesta[][])request.getAttribute("respuestas");
    int numPreguntas = (int)request.getAttribute("numPreguntas");
    Pregunta preg;
    Respuesta resp;
    
    int iPreg=0;
    int iResp;
    int cuenta_respuestas;
    boolean parar;

    %>
    
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
		<title>Preguntas listado</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-	rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<link rel = "stylesheet" type="text/css" href="estilo.css">
</head>
<body>
	<div class="jumbotron text-center">
	<p class="navbar-text"><div align="left"><c:out value="<%= nombre %>"/></div></p>
   	 <h1>Listado preguntas</h1>
    	 <p>Revisa y/o modifica tus preguntas</p>
    <br><br>
	</div>

<c:forEach var="i" begin="1" end="<%= numPreguntas %>">
<% preg=listaPreguntas[iPreg]; 
   iResp=0;
   cuenta_respuestas=0;
   parar=false;
%>
<div class="row" align="left">
  <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" align="center">
    <div class="panel panel-primary">
      <div class="panel-heading"><h1 class="js_error_placement quizz_question required_field"><%= preg.dameTitulo() %></h1></div>
        <div class="panel-body">
		 <% 
		   while(!parar){
			   if(respuestasMatriz[iPreg][cuenta_respuestas] != null){
				   cuenta_respuestas=cuenta_respuestas+1;
			   }
			   else{
				   parar = true;
			   }
		   }
		 %>
         <div class="m_options js_quizz_question">
          <ul>
           <c:forEach var="i" begin="1" end="<%= cuenta_respuestas %>">
            <% resp=respuestasMatriz[iPreg][iResp]; %>
            <div align="left" class="m_option js_ok_ko_class_placement">
              <input class="m_option_input js_quizz_radio" data-msg-required="Elige una opcion" required="required" type="radio" value="36428" name="participacion" id="holaquetal" aria-required="true">
              <label class="m_option_label" for="holaquetal"><%= resp.dameCuerpo() %></label>
            </div>
            <% iResp=iResp+1; %>
           </c:forEach>
          
          </ul>
        </div>
          <div class = "panel-footer" >
            <button class= "btn btn-primary" onclick="location.href='modificarPregunta.html'">Modificar</button>
            <button class= "btn btn-danger">Cancelar</button>
            <button class= "btn btn-primary" onclick="location.href='pregunta.html'">Ver comentarios</button>
            

          </div>
      </div>
    </div>
  </div>
 </div>
 </c:forEach>
     

</body>
</html>