<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "Funciones_usuario.*" %>
    <%@ page import= "ConnectDB.*" %>
    <%@ page import= "java.io.IOException" %>
    <%@ page import= "java.util.*" %>
    
    <% 
       Funciones_usuario user = new Funciones_usuario();
       //Profesor profe = (Profesor)session.getAttribute("usuario");
       
       Profesor profe = new Profesor("profe","de","prueba","uno@unizar.es",null); //PRUEBA
       ArrayList<Alumno> alumnos = user.alumnos_func(profe.dameEmail());
       Iterator<Alumno> it = alumnos.iterator();
       int cantidad_alumnos=alumnos.size();
       
       int notificaciones=user.cuenta_notificaciones_func (profe.dameEmail());
       
       Alumno alum;
       String nombreAlum;
    
    %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
  <title>perfil Profesor</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel = "stylesheet" type="text/css" href="estilo.css">
</head>
<body>

<div class="jumbotron text-center">
<% String nombre = "Logeado como "+profe.dameNombre()+" "+profe.dameApellido1()+ " "+profe.dameApellido2(); %>
<p class="navbar-text"><div align="left"><%= nombre %></div></p>
<div align="left">
	<button class="btn btn-primary" type="button">
  		Notificaciones <span class="badge"><%= notificaciones %></span>
	</button>
</div>
 
  <div align="right">
      <button class= "btn btn-warning" onclick="location.href='menuPrincipal.jsp'" >Desloguear</button>
      <button class= "btn btn-danger" onclick="location.href='dardebaja.html'" >Darse de baja</button>
      <button class= "btn btn-primary" onclick="location.href='modificarPerfil.html'" >Modificar Perfil</button>
  </div>

  <div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    Lista de alumnos
    <span class="caret"></span>
  </button>

  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" align="left">
   <c:forEach var="i" begin="1" end="<%= cantidad_alumnos %>">
    <% alum=it.next(); 
       nombreAlum= alum.dameNombre() + " " + alum.dameApellido1() + " " + alum.dameApellido2();
       nombreAlum=nombreAlum+" : "+alum.dameEmail();
    %>
    <li><a href="#"><%= nombreAlum %></a></li>
   </c:forEach>
  </ul>
  
</div>
  <h1>¡Bienvenido Profesor!</h1>
  <p>¿Qué desea hacer?</p> 
</div>
<br>


<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-4" align="center">
      <div class="panel panel-info">  
            <div class="panel-heading"> Confirmar preguntas o retos de los alumnos</div>
            <br>
           <button class= "btn btn-primary" onclick="location.href='Preguntaspendientes.html'">¡Confirmalas!</button>
           <br><br>
      </div>
    </div>
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-4" align="center">
       <div class="panel panel-info">  
            <div class="panel-heading"> Revisar los carteles de los participantes </div>
            <br>
           <button class= "btn btn-primary" onclick="location.href='actualescarteles.html'">¡Revísalos!</button>
           <br><br>
      </div>
    </div>
  
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-4" align="center">
       <div class="panel panel-info">  
            <div class="panel-heading"> Mirar carteles antiguos </div>
            <br>
           <button class= "btn btn-primary" onclick="location.href='verCarteles.html'">¡Míralos!</button>
           <br><br>
      </div>
    </div>
  </div>
  <div class="row">
     <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6" align="center">
       <div class="panel panel-info">  
            <div class="panel-heading"> Consultar preguntas en la base de datos </div>
            <br>
           <button class= "btn btn-primary" onclick="location.href='todaspreguntas.html'">¡Consúltalas!</button>
           <br><br>
      </div>
    </div>
     <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6" align="center">
       <div class="panel panel-info">  
            <div class="panel-heading"> Consultar retos en la base de datos </div>
            <br>
           <button class= "btn btn-primary" onclick="location.href='Retos.html'">¡Consúltalas!</button>
           <br><br>
      </div>
    </div>
    </div>
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" align="center" width=90%>
       <div class="panel panel-danger">  
            <div class="panel-heading">Borrar preguntas de este año</div>
            <br>
           <button align="center" class= "btn btn-danger" onclick="location.href='Retos.html'">Borrar todas las preguntas de este año</button>
           <br><br>
      </div>
      
    </div>



  </div>

</div>
</body>
</html>