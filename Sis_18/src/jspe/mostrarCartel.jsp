<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "Funciones_usuario.*" %>
    <%@ page import= "ConnectDB.*" %>
    <%@ page import= "java.io.IOException" %>
    <%@ page import= "java.util.*" %>
    
    <% 
    String email="alum@unizar.es";
    int idCartel=567;
    Funciones_usuario user = new Funciones_usuario();
    Pregunta preg=user.pregunta_asociada_cartel_func(idCartel);
    Reto ret = user.retos_asociados_cartel_func(idCartel);
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
        <h2>RETO</h2>
          <div class="panel panel-primary" >
            <div class="panel-heading">RETO</div>
              <div class="panel-body"><% ret.dameDescripcion(); %></div>
          </div>
        <br>
      </div>

</body>
</html>