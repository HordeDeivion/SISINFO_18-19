<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "Funciones_usuario.*" %>
    <%@ page import= "ConnectDB.*" %>
    <%@ page import= "java.io.IOException" %>
    <%@ page import= "java.util.*" %>
    
    <% String nombre = "Logeado como "+(String)request.getAttribute("nombre");%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Alumno Subir Cartel</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="estilo.css"

      rel="stylesheet" type="text/css">

<script>
function abrir() {
open('Confirmacion.html','','top=300,left=300,width=300,height=300') ;
}
</script>


</head>
<body>

<div class="jumbotron text-center">
  <p class="navbar-text"><div align="left"><c:set> ${nombre} </c:set></div></p>
  <h1>¡Sube tu cartel!</h1>
</div>
<br><br>
  <div class="container">
      <div class ="panel panel-primary">
      <div class="panel-heading" align="center">INTRODUCE LOS DATOS DE TU CARTEL</div>
        <div class = "panel-body" align="center">
  <form id="SubirCartel" action ="upload.php" method="post" enctype="multipart/form-data">
    <input name="userfile" type="file">
    <br>
    <iframe src="http://docs.google.com/gview?url=http://www.midominio.com/pdfs/elpdfquesea.pdf&embedded=true" style="width:800px; height:600px;" frameborder="0"></iframe>
    </form>
        </div>

            <br>
            <input type="submit" class="btn btn-primary" align="center" value="Confirmar Cartel"></input>
      </div>
      </div>






 <div class="container">
      <div class ="panel">
        <div class="panel-heading text-center"><h2>SUBE PREGUNTA</h2></div>
  <form id="SubirPregunta" action ="upload.php" method="post" enctype="multipart/form-data">
    <div class="input-group input-group-lg">
      <span class="input-group-addon" id="sizing-addon1">
      <input type="text" class="form-control" placeholder="Pregunta" aria-describedby="sizing-addon1">
    </div>
    <br>
    <input name="userfile" type="text">
    <label for="opcion1">Opcion1</label>
    <br>
    <input name="userfile" type="text" id="opcion2">
    <label for="opcion2">Opcion2</label>
    <br>
    <input name="userfile" type="text" id="opcion3">
    <label for="opcion3">Opcion3</label>
    <br>
    <input name="userfile" type="text" id="opcion4">
    <label for="opcion4">Opcion4</label>
    </span>
    <br><br>
     <input type="submit" class="btn btn-primary" align="center" value="Enviar Cartel"></input>
  </div>

  </form>
</div>

</div>


















   
  <div class="container">
 
      <div class ="panel">
      <div class = "panel-heading text-center">
      <h2>INTRODUCE TU NOTICIA</h2>
    </div>

  <form class ="container" id="subeNoticia" name="subeNoticia" enctype="text/plain" align="center" >
  <textarea align="center" class="form-control" rows="10" cols="8">Escriba aquí su noticia</textarea>
  
  </form>
  <button class="btn btn-primary" type="submit" value="Enviar" align="right">Enviar </button>
  </div>
  </div>
  
















<div class="container">
      <div class ="panel">
      <div class="panel-heading" align="center"><h2>INTRODUCE TU RETO</h2></div>
        <div class = "panel-body" align="center">
   <form id="SubirCartel" action ="upload.php" method="post" enctype="multipart/form-data">
    <div class="input-group input-group-lg">
      <span class="input-group-addon" id="sizing-addon1">
      <input type="text" class="form-control" placeholder="Reto" aria-describedby="sizing-addon1">
    </div>
    <br>
    <input type="submit" class="btn btn-primary" align="center" value="Confirmar Reto"></input>
    </form>
        </div>
      </div>
    </div>













<br><br>
<div class="container">
      <div class ="panel">
      <div class="panel-heading" align="center"><h2>ESCOJA LA TANDA A LA QUE PERTENCERÁ EL CARTEL</h2></div>
        <div class = "panel-body" align="center">
            <div class="m_option js_ok_ko_class_placement" align="center">
                  <input class="m_option_input js_quizz_radio" data-msg-required="Elige una opcion" required="required" type="radio" value="36428" name="participacion" id="holaquetal" aria-required="true">
                  <label class="m_option_label" for="holaquetal">Agua</label>
            </div>
                
                  
            <div class="m_option js_ok_ko_class_placement" align="center">
                  <input class="m_option_input js_quizz_radio" data-msg-required="Elige uno opcion" required="required" type="radio" value="36429" name="participacion" id="holaquetal1" aria-required="true">
                  <label class="m_option_label" for="holaquetal1">Reciclaje</label>
            </div>

            <div class="m_option js_ok_ko_class_placement" align="center">
                  <input class="m_option_input js_quizz_radio" data-msg-required="Elige uno opcion" required="required" type="radio" value="36429" name="participacion" id="holaquetal1" aria-required="true">
                  <label class="m_option_label" for="holaquetal1">Contaminación</label>
            </div>
        </div>
        </div>
  </div>




    <div class="row">
     <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" align="center">
       <div class="panel panel-info">  
            <div class="panel-heading"> CONFIRMAR Y ENVIAR CARTEL </div>
            <br>
           <button type="button" class=" btn-primary btn-lg" data-toggle="modal" data-target="#exampleModal" align="center">
  Enviar Cartel
</button>
           <br><br>
      </div>
    </div>
    </div>
  











            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Cartel Entregado</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="glyphicon glyphicon-ok"> <h4> Tu cartel ha sido entregado correctamente</h4> </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <input type="submit" name="guardar"  class="btn btn-primary" value="Confirmar" onclick="location.href='seleccionarCartel.html'"></input>
      </div>
    </div>
  </div>
</div>











            <br>
            <br>
      </div>
    </div>
    </body>
  </html>