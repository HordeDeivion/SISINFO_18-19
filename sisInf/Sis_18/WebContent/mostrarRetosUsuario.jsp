<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "Funciones_usuario.*" %>
    <%@ page import= "ConnectDB.*" %>
    <%@ page import= "java.io.IOException" %>
    <%@ page import= "java.util.*" %>
    
    <% 
    //String Usuario="alum@unizar.es";
    Funciones_usuario user = new Funciones_usuario();
    Alumno alum=(Alumno)session.getAttribute("usuario");
    String Usuario=alum.dameEmail();
	Reto ret;
    
    ArrayList<Reto> retos = user.retos_alum_func(Usuario);

    int cantidad_ret= retos.size();
    Iterator<Reto> it = retos.iterator();

    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
    <title>Varios retos</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-  rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

  <link rel = "stylesheet" type="text/css" href="estilo.css">
</head>
<body>
<div class="jumbotron text-center">
<% String nombre = "Logeado como "+alum.dameNombre()+" "+alum.dameApellido1()+ " "+alum.dameApellido2(); %>
	<p class="navbar-text"><div align="left"><%= nombre %></div></p>
  <h1>Tus retos</h1>
  <p>Revisa y modifica tus retos</p> 
</div>

<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8" align="center">
<c:forEach var="i" begin="1" end="<%= cantidad_ret %>">
  <div class="panel panel-primary">
  	<% ret=it.next(); %>
     <div class="panel-heading">RETO</div>
     <div class="panel-body"><%= ret.dameDescripcion() %></div>
     <button class= "btn btn-primary" onclick="location.href='Reto.html'">Ver comentarios</button>
     <button class= "btn btn-primary" onclick="location.href='modificarReto.html'">Modificar reto</button>
  </div>
  <br><br>
</c:forEach>
</div>
</body>
</html>