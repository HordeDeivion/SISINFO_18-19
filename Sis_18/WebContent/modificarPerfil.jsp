<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String nombre = "Logeado como "+(String)request.getAttribute("nombre");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
	<title>MODIFICAR DATOS</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-	rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<script type="text/javascript">
function comprobarClave(){
    clave2 = document.f1.clave2.value
    clave3 = document.f1.clave3.value

    if (clave2 != clave3)
       alert("Las claves no coinciden")
   else
   		f1.submit()
}
</script> 


	<link rel = "stylesheet" type="text/css" href="estilo.css">
</head>
<body>
<body style="text-align: center;">

<div class ="container">
<div class="row">
            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
	<div class ="panel panel-primary">
	<p class="navbar-text"><div align="left"><c:out value="<%= nombre %>"/></div></p>
		<div class = "panel-heading text-center">
			<h2>MODIFICAR PERFIL</h2>
		</div>
		<div class = "panel-body">
		<form name="f1" method="post" action="javascript:comprobarClave(this.form)">
			<h4>Introduzca su nuevo nombre real </h4>
			<input type="nombre" name="usuario" placeholder="nombre">
			<h4>Introduzca su primer apellido </h4>
			<input type="nombre" name="apellido1" placeholder="apellido1">
			<h4>Introduzca su segundo apellido </h4>
			<input type="nombre" name="apellido2" placeholder="apellido2">
				
			<h4>Introduce antigua contraseña</h4>
			<input id="choose" name="clave1" pattern="[a-zA-Z0-9]+" required placeholder= "antigua contraseña"><br>
			<h4>Introduce nueva contraseña</h4>
			<input id="clave2" name="clave2" pattern="[a-zA-Z0-9]*" required placeholder= "nueva contraseña"><br>
			<h4>Repite la nueva contraseña: </h4>
			<input id="clave3" name="clave3" pattern="[a-zA-Z0-9]*" required placeholder= "repite nueva contraseña"><br>
			</div>
		</form>
		</div>
				<div class = "panel-footer">
			<button class= "btn btn-primary" onclick="comprobarClave()">Confirmar cambios</button>
			<button class= "btn btn-warning" onclick="location.href='perfilUsuario'">Cancelar</button><br><br>
		</div>
		</div>
	</div>
	</div>
	</div>
</div>
</body>
</html>