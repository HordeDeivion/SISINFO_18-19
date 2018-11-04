<!DOCTYPE html>

<html>

<head>

    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
​

    <!-- Latest compiled and minified CSS -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

​

    <!-- Optional theme -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-    rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

​

    <link href="estilo.css"

      rel="stylesheet" type="text/css">

​

    <!-- Latest compiled and minified JavaScript -->

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>

<div class ="container" id="formulario" align="center">
	<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
	<div class ="panel panel-primary" align="center">
		<div class = "panel-heading text-center">
			<h2>LOGIN</h2>
		</div>
		<div class = "panel-body">
			<h4>Email: </h4>
<form action= logIn.do>
  		<input id="choose" name="email" type="text" required placeholder= "email">
			<h4>Contrasena: </h4>
  		<input id="choose" type= "password" name="contra" pattern="[a-zA-Z0-9]+" required placeholder= "contraseña">

		</div>
		<div class = "panel-footer" align="center">
			<button class= "btn btn-primary" action= logIn.do">Inicia Sesion</button>
		 	<button class= "btn btn-warning" onclick="location.href='dardeAlta.html'">Registrarse</button>
		 	<button class= "btn btn-danger" onclick="location.href='menuPrincipal.html'">Atrás</button>
		</div>
	</div>
	</div>
</form>
</div>
</body>
</html>
