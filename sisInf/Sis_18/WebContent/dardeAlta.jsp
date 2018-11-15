<!DOCTYPE html>

<html lang="es">

<%@ page import = "java.util.Map" %> 
<%
	String loginError = "Email:"; 		String claveError = "Introduzca una contraseña:"; 
	String errorInserccion= "";		String asociado= "Introduzca el correo del profesor asociado:";
	
	String m_error="";
	Map <String, String> e=(Map <String, String>) request.getAttribute("errores");


	if (e != null){
		String cabecera = "<span style=\"color:red\">"; String finalE = "</span>";

		if (e.containsKey("insertar")){
			errorInserccion = cabecera + "Error interno en el registro,inténtelo de nuevo"+ finalE;
		}
		else{
			errorInserccion = "";
		}
		
		
		if (e.containsKey("pass")){
			claveError = cabecera + "Contraseña inválida:"+ finalE;
			m_error= cabecera+"Contraseñas no identicas"+ finalE;	
		}
		else{
			claveError = "Introduzca una contraseña:";
		}

		if (e.containsKey("nombre")){
			loginError = cabecera + "Email:"+ finalE;
			m_error= cabecera+"Email en uso"+ finalE;	
		}
		else{
			loginError = "Email:";
		}


		if (e.containsKey("email asociado")){
			asociado = cabecera + "Email incorrecto"+ finalE;
			m_error= cabecera+"Email incorrecto"+ finalE;	
		}
		else{
			asociado = "Introduzca el correo del profesor asociado:";
		}

}%>
<head>
	
	<title>Dar de alta</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-	rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<script type="text/javascript">
		function comprobarClave(){
    	clave2 = document.f2.clave2.value
    	clave3 = document.f2.clave3.value

    if (clave2 != clave3)
       alert("las contraseÃ±as no coinciden")
   else
   		f2.submit()
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
		<div class = "panel-heading text-center">
			<h2>DARSE DE ALTA</h2>
			<h3><%= m_error %></h3>
			<h3><%=errorInserccion %></h3>
		</div>
		<div class = "panel-body">
		<form name="f2" method="post" action="InsertaUser.do">
			<h4><%= loginError %></h4>
			<input id="choose" name="usuario" type="email" required placeholder= "Email">
			<h4> <%= claveError	 %></h4>
			<input id="choose" type="password" name = "pass" pattern="[a-zA-Z0-9]+" name="clave1" required placeholder= "Contraseña"><br>
			<h4>* Repite la contraseña: </h4>
			<input type="password" name="pass2" pattern="[a-zA-Z0-9]+" name="clave1" required placeholder="Repite la contraseña">
			<h4>Introduzca su nombre real: </h4>
			<input type="nombre" name="nombre" required placeholder="Nombre">
			<h4>Introduzca sus apellidos: </h4>
			<input type="nombre" name="apellido1" required placeholder="Apellido 1">
			<input type="nombre" name="apellido2" placeholder="Apellido 2 (opcional)">
			<h4><%= asociado %></h4>
			<input type="nombre" name="emailP" placeholder="email profesor">
			<div class="m_options js_quizz_question" id="formulario">		
            					<div class="m_option js_ok_ko_class_placement">
             						 *<input class="m_option_input js_quizz_radio" data-msg-required="Elige una opcion" required="required" type="radio" value="36428" name="participacion" id="holaquetal" aria-required="true">
              						<label class="m_option_label" for="holaquetal">Soy alumno</label>
            					</div>
          			
          				
           					 <div class="m_option js_ok_ko_class_placement">
              						*<input class="m_option_input js_quizz_radio" data-msg-required="Elige una opcion" required="required" type="radio" value="36429" name="participacion" id="holaquetal1" aria-required="true">
              						<label class="m_option_label" for="holaquetal1">Soy profesor</label>
            					</div>
          			
				
			</div>
			
		
		<div class = "panel-footer">
			<button class= "btn btn-primary" action="InsertaUser.do" ">Registrarse</button>
			<button class= "btn btn-warning" onclick="location.href='menuPrincipal.jsp'">Cancelar</button><br><br>
			<h4>Una vez registrado, podra usar la cuenta una vez el docente encargado la apruebe </h4>
		</div>
		</form>
		</div>
		</div>
	</div>
	</div>
	</div>
</div>
</body>
</html>

