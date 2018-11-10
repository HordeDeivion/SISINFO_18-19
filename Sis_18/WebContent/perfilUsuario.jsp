<html lang="es">
<head>
<title> Perfil Usuario </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-	rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<link rel = "stylesheet" type="text/css" href="estilo.css">
</head>
<body>
<div class="jumbotron text-center">
  <div align="right">
      <button class= "btn btn-warning" onclick="location.href='menuPrincipal.html'" >Desloguear</button>
      <button class= "btn btn-warning" onclick="location.href='dardebaja.html'" >Darse de baja</button>
      <button class= "btn btn-warning" onclick="location.href='modificarPerfil.html'" >Modificar Perfil</button>
  </div>
  <h1>BIENVENIDO PARTICIPANTE</h1>
  <p>Â¿Que desea hacer?</p> 
</div>
<br>
<div class="row">
      <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" align="center">
        <div class="panel panel-primary">
          <div class="panel-heading">TUS CARTELES</div>
          <br> 
 			 <img alt=" Imagen Cartel" src="https://cdn.pixabay.com/photo/2017/10/15/14/14/poster-mockup-2853837_960_720.jpg" width="200px" height="200px" />
          <div class="panel-body">Revisa los carteles con los que has participado</div>
           <button align="center" class= "btn btn-primary" onclick="location.href='seleccionarCartel.html'">¡Revisar!</button>
           <br><br>
        </div>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" align="center" >
      <div class="panel panel-primary">
         <div class="panel-heading" >TUS PREGUNTAS </div>
          <br>
          <img alt=" Imagen Cartel" src="http://images4.fanpop.com/image/photos/19300000/Question-mark-quizzes-19322047-300-375.jpg" width="200px" height="200px" />
          <div class="panel-body">Revisa las preguntas que has planteado</div>
         <button class= "btn btn-primary" onclick="location.href='seleccionarPregunta.html'" >¡Revisar!</button>
           <br> <br>
      </div>
    </div>
      <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" align="center">
        <div class="panel panel-primary">
            <div class="panel-heading">TUS RETOS</div>        
             <br> 
             	<img alt=" Imagen Cartel" src="https://image.shutterstock.com/image-photo/hand-changing-word-impossible-possible-450w-540510409.jpg" width="200px" height="200px" />
                 <div class="panel-body">Revisa los retos que has propuesto a los participantes</div>
          			 <button class= "btn btn-primary" onclick="location.href='seleccionarReto.html'">¡Revisar!</button>
             <br><br>
        </div>
    </div>
  </div>
</body>
</html>