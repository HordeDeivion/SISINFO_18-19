<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "Funciones_usuario.*" %>
    <%@ page import= "ConnectDB.*" %>
    <%@ page import= "java.io.IOException" %>
    <%@ page import= "java.util.*" %>
    
    <% 
    Funciones_usuario user = new Funciones_usuario();
    //Alumno alum=(Alumno)session.getAttribute("usuario");
    
    String nombre = (String)request.getAttribute("nombre");
    Cartel cart= (Cartel)request.getAttribute("cartel");
    String link=cart.dameLink();
    String tema=cart.dameTema();
    int anyo=cart.dameAgno();
    int titulo=cart.dameID();  //temporal
    String autor = (String)request.getAttribute("autor");
    String log = "Logeado como "+autor;
    
    Pregunta preg= (Pregunta)request.getAttribute("pregunta");
    
    ArrayList<Respuesta> resp = (ArrayList<Respuesta>)request.getAttribute("respuestas");
    ArrayList<Comentario> coms= (ArrayList<Comentario>)request.getAttribute("comentarios");
    Reto ret = (Reto)request.getAttribute("reto");
    String descReto = ret.dameDescripcion();

    
    int cantidad_respuestas=resp.size();
    Iterator<Respuesta> itResp = resp.iterator();
    
    int cantidad_comentarios=coms.size();
    Iterator<Comentario> itCom = coms.iterator();
    
    Respuesta res;
    Comentario com;
    String respuesta;
    String comentario;
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
		<title>Cartel</title>
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
	<div class ="panel panel-primary">
		<div class="jumbotron text-center">
   	 		<h1>Cartel</h1>
   		</div>

	 	<div class="container-fluid">
  			<div class="row flex-items-xs-center slider-2 flex-items-xs-middle" id="sec-2">
  				<div class="row">
  					<div align="center"><h1><strong>Titulo: <c:out value="<%= titulo %>" default="No username"/> </strong> </h1></div>
  					<div align="center"><h3><strong>Autor: </strong> <c:out value="<%= autor %>"/> <strong>Tema: </strong><c:out value="<%= tema %>"/> <strong>Año: </strong> <c:out value="<%= anyo %>"/></h3></div>
  			 			<img class="center-block" alt=" Imagen" src=<c:out value="<%= link %>"/> alt="CARTEL" width="90%" height="90%"/> 
              <h2>¿Sabías que?</h2>
              <h3>Las verduras puden mejorar la resistencia del hormigón</h3>
              <p>Cuántas veces nos dijeron, cuando éramos pequeños, que debíamos comer verduras para crecer más fuertes. Incluso teníamos a Popeye el marino demostrando los beneficios de los vegetales.

Sin embargo, los ingenieros de la época no podían imaginar que uno de los materiales estrella de la construcción −el hormigón− también iba a salir beneficiado de la adición de componentes de origen vegetal, en este caso la zanahoria y la remolacha. Pero esa es la propuesta del departamento de ingeniería de la Universidad de Lancaster (Reino Unido).

En la actualidad, la vida útil del hormigón armado se estima en cien años, momento a partir del cual los costes de mantenimiento se disparan debido a la aparición de grietas y el deterioro de las varillas de refuerzo.

Debido a ello, hay numerosos grupos de investigación dedicados al desarrollo de nuevas tecnologías que mejoren su durabilidad. Algunas de las propuestas se basan en la adición de nanoplaquetas de grafeno, tal como anunció recientemente la Universidad de Exeter (Reino Unido). Dicho esto, la producción industrial de grafeno sigue siendo un proceso relativamente complejo y caro

  				</div>
  			</div>
  	 	</div>
  	 </div>
     </p>
<div class="row">
  <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" align="left">
    <h2>PREGUNTA</h2>
    <div class="panel panel-primary">
      <div class="panel-heading"><h1 class="js_error_placement quizz_question required_field"><%= preg.dameTitulo() %></h1></div>
        <div class="panel-body">
         <c:forEach var="i" begin="1" end="<%= cantidad_respuestas %>">
          <div class="checkbox">
            <% res=itResp.next();
            respuesta=res.dameCuerpo();
            %>
            <label><input type="checkbox" value="verde"><c:out value="<%= respuesta %>"/></label>
          </div>
         </c:forEach>
        </div>
      <div class = "panel-footer" >
        <h5>Usuario: <c:out value="<%= nombre %>"/></h5>
            <button class= "btn btn-primary" onclick="location.href='seleccionarPregunta.html'">Enviar respuesta</button>
            <button class= "btn btn-danger" onclick="location.href='seleccionarPregunta.html'">Atrás</button>
      </div>
    </div>
  </div>



<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
        <h2>RETO</h2>
          <div class="panel panel-primary" >
            <div class="panel-heading">RETO</div>
              <div class="panel-body"><c:out value="<%= descReto %>" /></div>
          </div>
        <br>
      </div>








  <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" align="center">
       <h2>COMENTARIOS</h2>
      <form>
        <div class="input-group input-group-lg">
          <span class="input-group-addon" id="sizing-addon1">
          <label for="sizing-addon1">Escribe tu comentario</label>
          <input type="text" class="form-control" placeholder="Pregunta" aria-describedby="sizing-addon1">
        </div>

          <input name="userfile" type="text" id="usuario">
          <label for="usuario">Usuario</label>
          <input type="submit" name="subir_btn" Value="Comentar">
          </span>
        <br><br>

    <span class="input-group-addon" id="sizing-addon1">    
      <div class="well">
       <c:forEach var="i" begin="1" end="<%= cantidad_comentarios %>">
        <% com=itCom.next();%>
        <li><h8>Usuario: <c:out value="<%= com.dameNombre() %>" /></h8>
            <p><c:out value="<%= com.dameCuerpo() %>" /></p>
        </li>
          <br>
       </c:forEach>
      </div>
    </span>
           <br><br>
        </div>
        </form>
        </div>

  </div>
</body>
</html>