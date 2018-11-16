<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "java.util.*" %>
    <%@ page import= "ConnectDB.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
<title>Carteles anteriores </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-	rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<link rel = "stylesheet" type="text/css" href="estilossssssssssssssssss.css">

	<script src="/home/josman/Documentos/sisInfo/smooth-scroll.min.js"></script>
	<script>
		smoothScroll.init({
			selector:'[data-scroll]',
			selectorHeader:null,
			speed:2000,
			easing:'easeInOutCubic',
			offset:0,
			callback:function(anchor,toggle){}
		});
		</script>
	</head>

<body>
<div class="jumbotron text-center">

    <h1>CARTELES GANADORES</h1>
    <p>Carteles ganadores de ediciones anteriores</p>
    <div align="left">
	  <form class="navbar-form navbar-left" role="search">
	    <div class="form-group">
  	      <input type="text" class="form-control" placeholder="Busca cartel">
 	    </div>
 	    <button type="submit" class="btn btn-default">Buscar</button>
	  </form>
	</div>
</div>


  	<div class="container-fluid">
  		<div class="row flex-items-xs-center slider-1 flex-items-xs-middle" id="sec-1">
  			<div class="row">
  			  <div align="center"><h1><strong>AGÜITA BUENA</strong> </h1></div>
              <div align="center"><h3><strong>Autor:</strong>Jose Manuel Romero <strong>Tema:</strong>Agua <strong>Año:</strong>2018</h3></div>
  			    <img class="center-block" alt=" Imagen Agua" src="https://sisalto.es/minimize/U3U4J5/macro-naturaleza-soltar-agua-art.jpg" width="90%" height="90%" onclick="location.href='cartel.html'"/>   
  		    </div>
  	    </div>
  	    <br><br><br>
  	</div>
  	
		
</body>
</html> 