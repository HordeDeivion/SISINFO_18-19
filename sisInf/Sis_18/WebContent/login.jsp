<!DOCTYPE html>

<html lang="es">

<%@ page import = "java.util.Map" %>
<%
	String loginError = ""; String claveError = "";
	String loginValor = ""; String claveValor = "";
	String m_error="";
	Map <String, String> e=(Map <String, String>) request.getAttribute("errores");
	if (e != null){
	String cabecera = "<span style=\"color:red\">"; String finalE = "</span>";
	if (e.containsKey("insertar")){
		loginError = cabecera + e.get("insertar")+ finalE;
		m_error= cabecera+"Email y/o contraseña incorrecta"+ finalE;	
	}
	else{
		loginError = "Email:";
	}
	
	
	if (e.containsKey("pass")){
		claveError = cabecera + e.get("pass")+ finalE;
		
	}
	else{
		claveError = "Contraseña:";
	}
	loginValor = request.getParameter("email");
	claveValor = request.getParameter("pass");
}%>
<head>

    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">



    <!-- Optional theme -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-    rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">



    <link href="estilo.css"

      rel="stylesheet" type="text/css">



    <!-- Latest compiled and minified JavaScript -->

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</head>
<body>

<form class ="container" id="formulario" name="formulario" enctype="text/plain" align="center" action="logIn.do">
	<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
	<div class ="panel panel-primary" align="center">
		<div class = "panel-heading text-center">
			<h2>LOGIN</h2>
		</div>
		
		<h3><%= m_error %></h3>
		<div class = "panel-body">
			<h4><%= loginError %> </h4>
			
		<form name="f2" method="post" action = "logIn.do">
  			<input id="choose" type="email" name = "email" required placeholder= "email" >	
			<h4><%= claveError %></h4>
			<input type="password" id="choose" name="pass" pattern="[a-zA-Z0-9]+" required placeholder= "contraseña"> 

			<div class="m_option js_ok_ko_class_placement">
             	*<input class="m_option_input js_quizz_radio" data-msg-required="Elige una opcion" required="required" type="radio" value="36428" name="participacion" id="holaquetal" aria-required="true">
              	<label class="m_option_label" for="holaquetal">Soy alumno</label>
            </div>
          			
          	 <div class="m_option js_ok_ko_class_placement">
              	*<input class="m_option_input js_quizz_radio" data-msg-required="Elige una opcion" required="required" type="radio" value="36429" name="participacion" id="holaquetal1" aria-required="true">
              	<label class="m_option_label" for="holaquetal1">Soy profesor</label>
            </div>
           					 

			<div class = "panel-footer" align="center">
				<button class= "btn btn-primary" action = "logIn.do">Inicia Sesion</button>
			 	<button class= "btn btn-warning" onclick="location.href='dardeAlta.jsp'">Registrarse</button>
			 	<button class= "btn btn-danger" onclick="location.href='menuPrincipal.jsp'">Atrás</button>
			 	<div class="m_option js_ok_ko_class_placement"></div>
			</div>
		 </form>
     						 
		</div>
	</div>
	</div>
</form>
</body>
</html>
