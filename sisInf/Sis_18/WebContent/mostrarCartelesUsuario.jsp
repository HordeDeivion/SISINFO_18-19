<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "Funciones_usuario.*" %>
    <%@ page import= "ConnectDB.*" %>
    <%@ page import= "java.io.IOException" %>
    <%@ page import= "java.util.*" %>
    
    <% 
    Funciones_usuario user = new Funciones_usuario();
    //Alumno alum=(Alumno)session.getAttribute("usuario");
    //String Usuario=request.getParameter("email");
    String nombre = (String)request.getAttribute("nombre");
    ArrayList<Cartel> carteles = (ArrayList<Cartel>)request.getAttribute("carteles");
    int numCarteles = (int)request.getAttribute("numCarteles");
    
    Iterator<Cartel> it = carteles.iterator();
    Cartel cart;
    String link;   
    int anyo;
    String titulo;
    String temita;

    %>
    
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
		<title>Carteles listado</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-	rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<link rel = "stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>
	<div class="jumbotron text-center">
	<p class="navbar-text"><div align="left"><c:out value="nombre"/></div></p>
   	 <h1>LISTADO CARTELES</h1>
	<div align="left">
	  <form class="navbar-form navbar-left" role="search">
	    <div class="form-group">
  	      <input type="text" class="form-control" placeholder="Busca cartel">
 	    </div>
 	    <button type="submit" class="btn btn-default">Buscar por tema</button>
      <button type="submit" class="btn btn-default">Buscar por año</button>
	  </form>
	</div>
	</div>

<!--SECCION 1-->
  	<div class="container-fluid">
  	  <div class="row flex-items-xs-center slider-1 flex-items-xs-middle" id="sec-1">
  		<div class="row">
  		  <c:forEach var="i" begin="1" end="<%=numCarteles %>">
  			  <%cart=it.next();	 
           		if(cart==null){
        	    	link="No_se_ha_podido_encontrar";
           		}
           		else{
        	   		link=cart.dameLink();
           		}
          	  %>
           <div align="center"><h1><c:out value="<%= cart.dameID() %>"/> </h1>
            <div align="center"><h3><strong>Tema:</strong><c:out value="<%= cart.dameTema() %>"/> <strong>Año:</strong><c:out value="<%=cart.dameAgno()%>"/></h3></div>
  			 <img class="center-block" alt=" Imagen" src=<% request.setAttribute("cartel",link);%>  width="90%" height="90%" onclick="location.href='mostrarCartel?idCartel=<%= cart.dameID() %>'" />
          <button align="center" class= "btn btn-primary" onclick="location.href='mostrarCartel.jsp?idCartel=<%= cart.dameID() %>'">Ver Cartel</button> 
  		   </div>
  		 </c:forEach>
  	  </div>
    </div>
 </div>
  	
</body>
</html>