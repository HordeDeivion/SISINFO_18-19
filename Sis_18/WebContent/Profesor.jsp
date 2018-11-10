<!DOCTYPE html>
<html lang="en">
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
<p class="navbar-text"><div align="left">Logeado como Profesor</div></p>
<div align="left">
	<button class="btn btn-primary" type="button">
  		Preguntas <span class="badge">4</span>
	</button>
</div>
 
  <div align="right">
      <button class= "btn btn-warning" onclick="location.href='menuPrincipal.html'" >Desloguear</button>
      <button class= "btn btn-danger" onclick="location.href='dardebaja.html'" >Darse de baja</button>
      <button class= "btn btn-primary" onclick="location.href='modificarPerfil.html'" >Modificar Perfil</button>
  </div>

  <div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    Lista de alumnos
    <span class="caret"></span>
  </button>

  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" align="left">
    <li><a href="#">David Ubide:  kcsnjks@unizar.s</a></li>
    <li><a href="#">Jose Miguel Romero:    dkwjkj@unizar.es</a></li>
    <li><a href="#">Ignacio Palacios:   jnjkdnewdjk@unizar.es</a></li>
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




