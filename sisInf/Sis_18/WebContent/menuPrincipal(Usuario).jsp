<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "Funciones_usuario.*" %>
    <%@ page import= "ConnectDB.*" %>
    <%@ page import= "java.io.IOException" %>
    <%@ page import= "java.util.*" %>
    
    <%
    //Alumno alum=(Alumno)session.getAttribute("usuario");
    Funciones_usuario user = new Funciones_usuario();
   
    Alumno alum=user.alumno_id_func ("alum@unizar.es");   	//PRUEBAS
    session.setAttribute("usuario",alum);					//PRUEBAS
   
    ArrayList<String> temas =user.temas_anyoactual_func();
    Cartel cart;
    String link;
    String tema;
    int cantidad_temas= temas.size();
    Iterator<String> it = temas.iterator();
    String[] temaso = new String[cantidad_temas];
    int i=0;
    while (it.hasNext()){
        temaso[i]=it.next();
        i=i+1;
    }
    int indice=0;
    
    //request.setAttribute("prueba","buenosdias");
    //session.setAttribute("sessname","alum@unizar.es"); 
    
    %>
    
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="es-es">
<head>
  <title>Menu_Principal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel = "stylesheet" type="text/css" href="estilo.css">
</head>
<div class="jumbotron text-center ">
	<% String nombre = "Logeado como "+alum.dameNombre()+" "+alum.dameApellido1()+ " "+alum.dameApellido2(); %>
	<p class="navbar-text"><div align="left"><%= nombre %></div></p>
    <h1>Reto ecológico</h1>
    <p>Atrévete a participar</p>
</div>
<br><br>
<div class="container">
  <div class="row">
      <div class="col-xs-12 col-sm-12W col-md-12 col-lg-12" align="center">
         <div class="panel panel-danger">
           <br>
           <button class= "btn btn-danger" onclick="location.href='perfilUsuario'">Tu cuenta</button>
           <button class= "btn btn-danger" onclick="location.href='verCarteles.html'">¡Mira a nuestros antiguos ganadores!</button>
           <button class= "btn btn-danger" onclick="location.href='http://iqtma.cps.unizar.es'">¡Sobre ingeniería del medio ambiente!</button>
          <br><br>
    </div>
      <div class="panel panel-danger">
           <br>
           <h3>NUESTROS GANADORES DE LA EDICIÓN ACTUAL</h3>
          <br><br>
    </div>
  </div>
    <br>
    <br>
    
  <c:forEach var="i" begin="0" end="<%= cantidad_temas-1 %>">

      <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" align="center">
        <div class="panel panel-primary">
        <% if(temaso[indice]!=null){ tema=temaso[indice]; } else{ tema=null; } %>
          <div class="panel-heading"><%= tema %></div>
          <br> 
          <% cart=user.ganadortema_anyoactual_func(temaso[indice]); %>
           <% 
           if(cart==null){
        	    link="No_se_ha_podido_encontrar";
           }
           else{
        	    link=cart.dameLink();
           }
           %>
          <img alt=<%= link %> src=<%= link %> width="200px" height="200px" />
          <div class="panel-body">El agua es uno de los recursos más preciados de nuestro planeta</div>
           <button align="center" class= "btn btn-primary" onclick="location.href='mostrarCartel?idCartel=<%= cart.dameID() %>'">Ver Ganador</button>
           <% session.setAttribute("cartel"+indice,cart);%>
           <br><br>
           <% indice=indice+1; %>
        </div>
    </div>

  </c:forEach>
  </div>
  </div>
</body>
</html>