<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "Funciones_usuario.*" %>
    <%@ page import= "ConnectDB.*" %>
    <%@ page import= "java.io.IOException" %>
    <%@ page import= "java.util.*" %>
    
    <%
    Funciones_usuario user = new Funciones_usuario();

    String nombre = "Logeado como "+(String)request.getAttribute("nombre");
    int cantidad_temas= (int)request.getAttribute("numTemas");
    String[] temaso = (String[])request.getAttribute("temas");
    Cartel[] carteles = (Cartel[])request.getAttribute("carteles");
    String tipoUser = (String)request.getAttribute("tipoUser");
    int indice=0;
    System.out.format("EEE %s", tipoUser);
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
	<p class="navbar-text"><div align="left"><c:out value="<%= nombre %>"/></div></p>
    <h1>Reto ecológico</h1>
    <p>Atrévete a participar</p>
</div>
<br><br>
<div class="container">
  <div class="row">
      <div class="col-xs-12 col-sm-12W col-md-12 col-lg-12" align="center">
         <div class="panel panel-danger">
           <br>
           <button class= "btn btn-danger" onclick="location.href='<%= tipoUser %>'"> Tu cuenta</button>
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
    
  <c:forEach var="i" begin="1" end="3">
      <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" align="center">
        <div class="panel panel-primary">
          <div class="panel-heading"><c:out value="<%= temaso[indice] %>"/></div>
          <br> 
          <img alt=<c:out value="<%= carteles[indice].dameLink() %>"/> src=<c:out value="<%= carteles[indice].dameLink() %>"/> width="200px" height="200px" />
          <div class="panel-body">El agua es uno de los recursos más preciados de nuestro planeta</div>
           <button align="center" class= "btn btn-primary" onclick="location.href='mostrarCartel?idCartel=<c:out value="<%= carteles[indice].dameID() %>"/>'">Ver Ganador</button>
           <br><br>
           <% indice=indice+1; %>
        </div>
       </div>
  </c:forEach>
  </div>
  </div>
</body>
</html>