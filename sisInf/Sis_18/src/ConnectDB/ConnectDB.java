package ConnectDB;
/*
Autores: José Manuel Romero, Ignacio Palacios, David Ubide

*/

import java.sql.*;
import java.util.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectDB {
    static String Nombre_DB= "sis_18";
    static String username = "root";
    static String password = "1234";
    static String url = "jdbc:mysql://localhost:8090/"+Nombre_DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true&integratedSecurity=true";
	static final String S_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * @param args the command line arguments
     */
    
    public ConnectDB(){} 
    /*
                    INSERCCIONES
    
    */
    
    /*public static void main(String[] args) {
    	String email = "buenos@unizar.es";
		String pass = "eae";
		String nombre = "hola";
		String apellidos = "bueno dias";
		String asociado = "uno@unizar.es";
		 try{
             MessageDigest md= MessageDigest.getInstance("SHA-512");
             md.update(pass.getBytes());
             byte[] mb = md.digest();
             Alumno alum=new Alumno(nombre, apellidos, apellidos, email, asociado);
             ConnectDB d = new ConnectDB();
             int puede= d.insert_alumno(alum,mb);
             if(puede == 0){
                 System.out.println("No ha podido insertar alumno");
             }
        } catch (Exception ex) {
     	   //throw new Exception ("Error alumno");
        	System.out.println("error");
         }
		
		
    }*/
    
      /*
    nombre: Nombre profesor
    a1: Primer apellido
    a2: Segundo apellido
    contra: contrasena
    em: email del profesor
    asociado = email del profe asociado
    */
    public int insert_profe(Profesor profe, byte[] contra) throws Exception {
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
            String nom=profe.dameNombre();
            String a1=profe.dameApellido1();
            String a2=profe.dameApellido2();
            String em=profe.dameEmail();
            String asociado=profe.dameEmailprofe();
            try {
            	 Class.forName(S_JDBC_DRIVER);
            }catch(Exception e) {}
          
            Connection conection = DriverManager.getConnection(url, username, password);
            if (nom.length() == 0){
                System.out.println("Inserte un nombre valido");
                Puede = -1;
            }
            else{
                // Se intenta insertar un profesor
                PreparedStatement prof = conection.prepareStatement("INSERT INTO profesor(nombre,apellido1,apellido2,email,contrasena,emailprofe) VALUES("
                                               +"'"+nom+"',"+   "'"+a1+"'," +   "'"+a2+"',"+  
                                              "'"+em+"',"+   "'"+contra+"',"  +   "'"+asociado+"');");
                // Ejecuta la instruccion en la BBDD
                // Puede == 1 si y solo si ha podido insertar
                Puede = prof.executeUpdate();;
            }
              
        } catch(Exception ex){
        	throw new Exception ("Error profesor");

        }
        return Puede;
    }
    
    
      /*
    nombre: Nombre profesor
    a1: Primer apellido
    a2: Segundo apellido
    contra: contrasena
    em: email del profesor
    asociado = email del profe asociado
    */
    //public static int insert_alumno(Alumno alum, byte[] contra)throws Exception{
    public static int insert_alumno(Alumno alum, byte[] contra)throws Exception{
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
            String nom=alum.dameNombre();
            String a1=alum.dameApellido1();
            String a2=alum.dameApellido2();
            String em=alum.dameEmail();
            String asociado=alum.dameEmailprofe();
            try {
           	 Class.forName(S_JDBC_DRIVER);
           }catch(Exception e) {}
            System.out.println("He llegado2");
            try{
            	Connection conection = DriverManager.getConnection(url, username, password);
            
            System.out.println("He llegado CONECTADO");
            if (nom.length() == 0){
                System.out.println("Inserte un nombre valido");
                Puede = -1;
            }
            else{
                // Se intenta insertar un profesor
            	System.out.println("He llegado3");
                PreparedStatement al = conection.prepareStatement("INSERT INTO alumno(nombre,apellido1,apellido2,email,contrasena,emailprofe) VALUES("
                                               +"'"+nom+"',"+   "'"+a1+"'," +   "'"+a2+"',"+  
                                              "'"+em+"',"+   "'"+contra+"',"  +   "'"+asociado+"');");
                // Ejecuta la instruccion en la BBDD
                // Puede == 1 si y solo si ha podido insertar
                Puede = al.executeUpdate();;
            }
            } catch(SQLException e){
            	System.out.println("NO CONECTA");
            	e.printStackTrace();
            }
            
        } catch(Exception ex){
        	throw new Exception ("Error alumno");
        }
        
        return Puede;
    }
       /*
    id: Identificador aleatorio a decidir previamente
    
    */
    public static int insert_cartel(Cartel cart){
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
                int id=cart.dameID();
                String mail=cart.dameEmailAlumno();
                String ganar;
                if(cart.dameSiGanador()){
                    ganar="T";
                }
                else{
                    ganar="F";
                }
                int agno=cart.dameAgno();
                String tema=cart.dameTema();
                String link=cart.dameLink();
                try {
               	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se mira si es un link valido
                if (link.length() == 0){
                    System.out.println("Inserte un nombre valido");
                    Puede = -1;
                }
                else{
                    // Se intenta insertar un profesor
                    PreparedStatement al = conection.prepareStatement("INSERT INTO cartel(id,emailA,ganador,agno,tema,link) VALUES("
                                               +id+   ",'"+mail+"'," +   "'"+ganar+"',"+  
                                              agno+   ",'"+tema+"',"  +   "'"+link+"');");
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();;
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    /*
        id: Identificador de la pregunta
        idc: Identificador del cartel
    */
    public static int insert_pregunta(Pregunta pregun){
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
            int id=pregun.dameID();
            int idC=pregun.dameIDCartel();
            String titulo=pregun.dameTitulo();
            try {
           	 Class.forName(S_JDBC_DRIVER);
           }catch(Exception e) {}
            Connection conection = DriverManager.getConnection(url, username, password);
            // Se mira si es un link valido
            if (titulo.length() == 0){
                System.out.println("Inserte un titulo valido");
                Puede = -1;
            }
            else{
                // Se intenta insertar un profesor
                System.out.println("Insertando pregunta: "+titulo);
                PreparedStatement al = conection.prepareStatement("INSERT INTO pregunta(id,titulo,idCartel) VALUES("
                                               +id+","+   "'"+titulo+"'," +idC+ 
                                             ");");
                // Ejecuta la instruccion en la BBDD
                // Puede == 1 si y solo si ha podido insertar
                Puede = al.executeUpdate();;
            }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
    
      /*
        id: Identificador de la pregunta
        idc: Identificador del cartel
        nombre: nombre del usuario que realiza el comentario
        cuerpo: cuerpo del comentario
        pend: Si la pregunta esta pendiente de confirmacion o no
    */
    public static int insert_comentario(Comentario comment){
        int id=comment.dameID();
        int idC=comment.dameIDCartel();
        String nombre=comment.dameNombre();
        String cuerpo=comment.dameCuerpo();
        String pend;
        if(comment.dameSiPendiente()){
            pend="T";
        }
        else{
            pend="F";
        }
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
        	try {
           	 Class.forName(S_JDBC_DRIVER);
           }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se mira si es un link valido
                if (cuerpo.length() == 0){
                    System.out.println("Inserte un comentario valido");
                    Puede = -1;
                }
                else{
                    // Se intenta insertar un profesor
                    PreparedStatement al = conection.prepareStatement("INSERT INTO comentario(id,idCartel,nombre,cuerpo,pendiente) VALUES("
                                               +id+     ","+    idC+","+  "'"+nombre+"'," + "'"+cuerpo+"',"+ "'"+pend+"'"+
                                             ");");
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
    
     /*
        idR: Identificador de la respuesta
        idC: Identificador del cartel
        idP: Identificador de la pregunta
        cuerp: Texto asociado a la respuesta
        veces: Numero de veces que ha sido seleccionada esa respuesta
        ganador: 0 si no es ganadora, 1 si lo es
    */
    public static int insert_respuesta(Respuesta resp){
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
            int idR=resp.dameID();
            int idC=resp.dameIDCartel();
            int idP=resp.dameIDPregunta();
            String cuerpo=resp.dameCuerpo();
            int veces=resp.dameVeces();
            String ganador;
            if(resp.dameSiGanador()){
                ganador="T";
            }
            else{
                ganador="F";
            }
            try {
           	 Class.forName(S_JDBC_DRIVER);
            }catch(Exception e) {}
            Connection conection = DriverManager.getConnection(url, username, password);
            // Se mira si es un link valido
            if (cuerpo.length() == 0){
                System.out.println("Inserte una respuesta");
                Puede = -1;
            }
            else{
                // Se intenta insertar un profesor
                PreparedStatement al = conection.prepareStatement("INSERT INTO respuesta(id,idC,idP,cuerpo,veces,ganador) VALUES("
                                               +idR+     ","+    idC+","+   idP+","+  "'"+cuerpo+"'," + veces+","+ "'"+ganador+"'"+
                                             ");");
                // Ejecuta la instruccion en la BBDD
                // Puede == 1 si y solo si ha podido insertar
                Puede = al.executeUpdate();;
            }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
        /*
        id: Identificador de la pregunta
        idc: Identificador del cartel
    */
    public static int insert_reto(Reto ret){
        int id=ret.dameID();
        int idC=ret.dameIDCartel();
        String descripcion=ret.dameDescripcion();
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
        	   try {
              	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se mira si es un link valido
                if (descripcion.length() == 0){
                    System.out.println("Inserte una descripción valida");
                    Puede = -1;
                }
                else{
                    // Se intenta insertar un profesor
                    PreparedStatement al = conection.prepareStatement("INSERT INTO reto(id,descripcion,idCartel) VALUES("
                                               +id+","+   "'"+descripcion+"'," +idC+ 
                                             ");");
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();;
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
    /*
            BORRADOS
    */
    public static int delete_profesor(String email){
          
         
        
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
        	   try {
              	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se mira si es un link valido
                if (email.length() == 0){
                    System.out.println("Inserte un email valido");
                    Puede = -1;
                }
                else{
                    // Se intenta insertar un profesor
                    PreparedStatement al = conection.prepareStatement("DELETE FROM profesor WHERE email = "+
                                               "'"+email+"';");
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();;
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
    public static int delete_alumno(String email){
          
         
        
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
        	   try {
              	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se mira si es un link valido
                if (email.length() == 0){
                    System.out.println("Inserte un email valido");
                    Puede = -1;
                }
                else{
                    // Se intenta borrar un alumno
                    PreparedStatement al = conection.prepareStatement("DELETE FROM alumno WHERE email = "+
                                               "'"+email+"';");
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido borrar
                    Puede = al.executeUpdate();;
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    // Destruye todos los carteles asociados a un email
    public static int delete_carteles(int idC){
          
         
        
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
        	   try {
              	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se intenta eliminar el cartel
                PreparedStatement al = conection.prepareStatement("DELETE FROM cartel WHERE emailA = "+
                                               ""+idC+";");
                // Ejecuta la instruccion en la BBDD
                // Puede == 1 si y solo si ha podido insertar
                Puede = al.executeUpdate();;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    /*
        Todos los ids de un comentario deben ser >= 0
    
    */
    public static int delete_comentario(int idC){
          
         
        
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
        	   try {
              	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se mira si es un link valido
                if (idC <= 0){
                    System.out.println("Inserte un email valido");
                    Puede = -1;
                }
                else{
                    // Se intenta insertar un profesor
                    PreparedStatement al = conection.prepareStatement("DELETE FROM comentario WHERE idC = "+
                                               +idC+";");
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();;
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    /*
    Borra la pregunta asociada a un id > 0
    */
     public static int delete_pregunta(int idP){
          
         
        
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
        	   try {
              	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se mira si es un link valido
                if (idP <= 0){
                    System.out.println("Inserte un identificador valido");
                    Puede = -1;
                }
                else{
                    // Se intenta insertar un profesor
                    PreparedStatement al = conection.prepareStatement("DELETE FROM pregunta WHERE id = "+
                                               +idP+";");
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();;
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
     
    public static int delete_respuesta(int idR){
          
         
        
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
        	   try {
              	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se mira si es un link valido
                if (idR <= 0){
                    System.out.println("Inserte un identificador valido");
                    Puede = -1;
                }
                else{
                    // Se intenta insertar un profesor
                    PreparedStatement al = conection.prepareStatement("DELETE FROM respuesta WHERE idR = "+
                                               +idR+";");
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();;
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
        /*
    Borra el reto asociado a un id > 0
    */
     public static int delete_reto(int idR){
          
         
        
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
        	   try {
              	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se mira si es un link valido
                if (idR <= 0){
                    System.out.println("Inserte un identificador valido");
                    Puede = -1;
                }
                else{
                    // Se intenta borrar un reto
                    PreparedStatement al = conection.prepareStatement("DELETE FROM reto WHERE id = "+
                                               +idR+";");
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();;
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
    
    //UPDATES
    public static int update_profe(Profesor profe, String contra){
        String nom=profe.dameNombre();
        String a1=profe.dameApellido1();
        String a2=profe.dameApellido2();
        String em=profe.dameEmail();
        String asociado=profe.dameEmailprofe();
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        boolean cambiadas=false;
        try{
                String comando="UPDATE profesor SET";
                try {
                  	 Class.forName(S_JDBC_DRIVER);
                   }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                if (nom.length() > 0){
                    comando=comando+ " nombre = '"+nom+"',";
                    cambiadas=true;
                }
                if (a1.length() > 0){
                    comando=comando+ " apellido1 = '"+a1+"',";
                    cambiadas=true;
                }
                if (a2.length() > 0){
                    comando=comando+ " apellido2 = '"+a2+"',";
                    cambiadas=true;
                }
                if (contra.length() > 0){
                    try{
                    MessageDigest md= MessageDigest.getInstance("SHA-512");
                    md.update(contra.getBytes());
                    byte[] mb = md.digest();
                    //String con = new String(mb);
                    comando=comando+ " contrasena = '"+mb.toString()+"',";
                    } catch (NoSuchAlgorithmException e) {
                        //Error
                    }
                    cambiadas=true;
                }
                if (cambiadas){
                    comando = comando.substring(0, comando.length() - 1);  //quito la ultima coma
                    comando = comando + " WHERE email = '" + em + "';";
                    // Se intenta modificar un profesor
                    PreparedStatement prof = conection.prepareStatement(comando);
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = prof.executeUpdate();;
                }
                else{
                    System.out.println("No se cambia nada");
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
    
    
    
       /*
    nombre: Nombre profesor
    a1: Primer apellido
    a2: Segundo apellido
    contra: contrasena
    em: email del profesor
    asociado = email del profe asociado
    */
    public static int update_alumno(Alumno alum, String contra){
        String nom=alum.dameNombre();
        String a1=alum.dameApellido1();
        String a2=alum.dameApellido2();
        String em=alum.dameEmail();
        String asociado=alum.dameEmailprofe();  
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        boolean cambiadas=false;
        try{
                String comando="UPDATE alumno SET";
                try {
                  	 Class.forName(S_JDBC_DRIVER);
                }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                if (nom.length() > 0){
                    comando=comando+ " nombre = '"+nom+"',";
                    cambiadas=true;
                }
                if (a1.length() > 0){
                    comando=comando+ " apellido1 = '"+a1+"',";
                    cambiadas=true;
                }
                if (a2.length() > 0){
                    comando=comando+ " apellido2 = '"+a2+"',";
                    cambiadas=true;
                }
                if (contra.length() > 0){
                    try{
                    MessageDigest md= MessageDigest.getInstance("SHA-512");
                    md.update(contra.getBytes());
                    byte[] mb = md.digest();
                    comando=comando+ " contrasena = '"+mb.toString()+"',";
                    } catch (NoSuchAlgorithmException e) {
                        //Error
                    }
                    cambiadas=true;
                }
                
                
                if (cambiadas){
                    comando = comando.substring(0, comando.length() - 1);  //quito la ultima coma
                    comando = comando + " WHERE email = '" + em + "';";
                    // Se intenta modificar un profesor
                    PreparedStatement al = conection.prepareStatement(comando);
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();;
                }
                else{
                    System.out.println("No se cambia nada");
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
    
    /*
    id = id de la pregunta
    titulo = titulo de la pregunta
    */
    public static int update_pregunta(Pregunta preg){
        int id=preg.dameID();
        String titulo=preg.dameTitulo();
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        boolean cambiadas=false;
        try{
                String comando="UPDATE pregunta SET";
                try {
                 	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                if (titulo.length() > 0){
                    comando=comando+ " titulo = '"+titulo+"'";
                    cambiadas=true;
                }       
                
                if (cambiadas){
                    comando = comando + " WHERE id = '" + id + "';";
                    // Se intenta modificar un profesor
                    PreparedStatement al = conection.prepareStatement(comando);
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();;
                }
                else{
                    System.out.println("No se cambia nada");
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
    
    /*
    id = id de la pregunta
    titulo = titulo de la pregunta
    */
    public static int update_respuesta(Respuesta res){
        int idR=res.dameID();
        int idC=res.dameIDCartel();
        int idP=res.dameIDPregunta();
        String cuerpo=res.dameCuerpo();
        int veces=res.dameVeces();
        String ganador;
        if(res.dameSiGanador()){
            ganador="T";
        }
        else{
            ganador="F";
        }
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        boolean cambiadas=false;
        boolean vecescam=false;
        boolean aCambiar=false;
        try{
                String comando="UPDATE respuesta SET";
                try {
                 	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                
                if (veces > 0){
                    cambiadas=true;
                    vecescam=true;
                }
                
                if (cuerpo.length() > 0){
                    comando=comando+ " cuerpo = '"+cuerpo+"',";
                    cambiadas=true;
                    aCambiar=true;
                }
                
                if (ganador.length() > 0){
                    comando=comando+ " ganador = '"+ganador+"',";
                    cambiadas=true;
                    aCambiar=true;
                }
                
                if (cambiadas){
                    if(vecescam){
                        if(aCambiar){
                            veces=0;
                        }
                        comando=comando+ " veces = "+veces;
                    }
                    else{
                        comando = comando.substring(0, comando.length() - 1);  //quito la ultima coma
                    }
                    comando = comando + " WHERE id = " + idR + " AND idC = "+idC+" AND idP= "+idP+";";
                    // Se intenta modificar una respuesta
                    PreparedStatement al = conection.prepareStatement(comando);
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();;
                }
                else{
                    System.out.println("No se cambia nada");
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
    
    /*
    id = id de la pregunta
    descripcion = descripcion del reto
    */
    public static int update_reto(Reto ret){
        int id=ret.dameID();
        String descripcion=ret.dameDescripcion();
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        boolean cambiadas=false;
        try{
                String comando="UPDATE reto SET";
                try {
                 	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                if (descripcion.length() > 0){
                    comando=comando+ " descripcion = '"+descripcion+"'";
                    cambiadas=true;
                }       
                
                if (cambiadas){
                    comando = comando + " WHERE id = '" + id + "';";
                    // Se intenta modificar un reto
                    System.out.println("Modificando reto: "+descripcion);
                    PreparedStatement al = conection.prepareStatement(comando);
                    // Ejecuta la instruccion en la BBDD
                    // Puede == 1 si y solo si ha podido insertar
                    Puede = al.executeUpdate();;
                }
                else{
                    System.out.println("No se cambia nada");
                }
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             Puede = -1;
             return Puede;

        }
        return Puede;
    }
    
    /*
    --------------------------------------------    CONSULTAS           --------------------------------------------------
    ----------------------------------------------------------------------------------------------------------------------
    */
    
    //Preguntas asociadas a un cartel
    public Pregunta pregunta_asociada_cartel(int idCartel){
         ResultSet rs=null;
         Pregunta pregun=null;
         try{
                String comando="SELECT p.id, p.titulo\n" +
                                "FROM cartel c left join pregunta p on c.id=p.idCartel\n" +
                                "WHERE c.id="+idCartel+";";
                
                try {
               	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                while (rs.next()){
                    int idPregunta = rs.getInt("id");
                    String tituloPreg = rs.getString("titulo");
                    System.out.format("%s, %s\n", idPregunta, tituloPreg);
                    pregun=new Pregunta(idPregunta, tituloPreg, idCartel);
                } 
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
        return pregun;
    }   
    
    //Carteles asociados a un tema
    public ArrayList<Cartel> carteles_asociados_tema(String tema){
         ArrayList<Cartel> lista=new ArrayList<>();
         Cartel cart=null;
         ResultSet rs=null;
         try{
                String comando="SELECT *\n" +
                               "FROM cartel c\n" +
                               "WHERE tema='" + tema + "';";
                try {
                 	 Class.forName(S_JDBC_DRIVER);
                }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                while (rs.next()){
                    int idCartel = rs.getInt("id");
                    String emailA = rs.getString("emailA");
                    String ganador = rs.getString("ganador");
                    int agno = rs.getInt("agno");
                    String link = rs.getString("link");
                    cart=new Cartel(idCartel,emailA,ganador,agno,tema,link);
                    lista.add(cart);
                }
                return lista;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return lista;

        }
    } 
    
    //Carteles ganadores por año
    public ArrayList<Cartel> carteles_ganadores_anyo(int anyo){    
         ResultSet rs=null;
         ArrayList<Cartel> lista=new ArrayList<>();
         Cartel cart=null;
         try{
                String comando="SELECT *\n" +
                                "FROM cartel c\n" +
                                "WHERE c.agno=" + anyo + " AND c.ganador=1;";
                try {
                	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                while (rs.next()){
                    int idCartel = rs.getInt("id");
                    String emailA = rs.getString("emailA");
                    String ganador = rs.getString("ganador");
                    String tema = rs.getString("tema");
                    String link = rs.getString("link");
                    cart=new Cartel(idCartel,emailA,ganador,anyo,tema,link);
                    lista.add(cart);
                }
                return lista;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return lista;

        }
    }
    
    //Retos asociados a un cartel
    public ArrayList<Reto> retos_asociados_cartel(int idCartel){  
         ResultSet rs=null;
         ArrayList<Reto> lista=new ArrayList<>();
         Reto ret=null;
         try{
                String comando="SELECT r.id, r.descripcion\n" +
                                "FROM cartel c left join reto r on c.id=r.idCartel\n" +
                                "WHERE c.id=" + idCartel + ";";
                
                try {
               	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
       
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                while (rs.next()){
                    int idReto = rs.getInt("id");
                    String descripcion = rs.getString("descripcion");
                    ret=new Reto(idReto, descripcion, idCartel);
                    lista.add(ret);
                }
                return lista;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return lista;

        }
    }
    
    //Comentarios pendientes dirigidos a los alumnos de un profesor
    public ArrayList<Comentario> comentarios_pendientes(String emailProf){    
         ResultSet rs=null;
         ArrayList<Comentario> lista=new ArrayList<>();
         Comentario com=null;
         try{
                String comando="SELECT com.id, com.nombre, com.cuerpo, com.idCartel\n" +
"	FROM ((profesor prof left join alumno a on prof.email = a.emailprofe) left join cartel c on a.email=c.emailA) left join comentario com on c.id=com.idCartel\n" +
"	WHERE prof.email='" + emailProf + "' AND com.pendiente='T';";
                try {
                	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                
                System.out.println("Buscando comentarios pendientes del profesor: "+emailProf);
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                while (rs.next()){
                    int idCom = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String cuerpo = rs.getString("cuerpo");
                    int idCartel = rs.getInt("idCartel");
                    com=new Comentario(idCom, idCartel, nombre, cuerpo, "T");
                    lista.add(com);
                }
                return lista;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return lista;

        }
    }
    
    //Carteles asociados a un alumno
    public ArrayList<Cartel> carteles_alum(String emailAlum){  
         ResultSet rs=null;
         ArrayList<Cartel> lista=new ArrayList<>();
         Cartel cart=null;
         try{
                String comando="SELECT c.id, c.link, c.ganador, c.agno, c.tema\n" +
                                "FROM alumno a left join cartel c on a.email=c.emailA\n" +
                                "WHERE c.emailA='"+ emailAlum+ "';";
                try {
                	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                
                System.out.println("Buscando carteles del alumno: "+emailAlum);
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                while (rs.next()){
                    int idCartel = rs.getInt("id");
                    String ganador = rs.getString("ganador");
                    int anyo = rs.getInt("agno");
                    String tema = rs.getString("tema");
                    String link = rs.getString("link");
                    cart=new Cartel(idCartel,emailAlum,ganador,anyo,tema,link);
                    lista.add(cart);
                }
                return lista;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return lista;

        }
    }
    
    /*
        Devuelve el listado de alumnos asociados a un profesor y su email
    */
    public ArrayList<Alumno> alumnos(String email_profe){
        ResultSet rs=null;
        ArrayList<Alumno> lista=new ArrayList<>();
        Alumno alum=null;
        try{ 
        	try {
            	 Class.forName(S_JDBC_DRIVER);
           }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                Statement pet = conection.createStatement(); 
                String query=" SELECT * \n" +
                				"FROM alumno a \n" +
                				"WHERE a.emailprofe='" + email_profe + "';";
                rs=pet.executeQuery (query);
                while (rs.next()){
                    String nombre = rs.getString("nombre");
                    String apellido1 = rs.getString("apellido1");
                    String apellido2 = rs.getString("apellido2");
                    String email = rs.getString("email");
                    alum=new Alumno(nombre,apellido1,apellido2,email,email_profe);
                    lista.add(alum);
                }
                return lista;    
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return lista;
        } 
    }
    
     /*
        Devuelve el listado de carteles ganadores segun peticion:
            1 - Ordenados por agno
            2 - Ordenados por agno y tematica
    */
    public ArrayList<Cartel> carteles_gandores (int peticion){
         
         ResultSet rs=null;
         ArrayList<Cartel> lista=new ArrayList<>();
         Cartel cart=null;
         if ( peticion == 1 || peticion==2){
            try{
            	   try {
                	 Class.forName(S_JDBC_DRIVER);
            	   }catch(Exception e) {}
                    Connection conection = DriverManager.getConnection(url, username, password);
                    Statement pet = conection.createStatement(); 
                    String query;
                    if (peticion == 1){
                         query=" select * from cartel WHERE ganador='T' ORDER BY agno;";
                    }
                    else{
                        query=" select * from cartel WHERE ganador='T' ORDER BY agno,tema;";
                    }
                    rs=pet.executeQuery (query);
                    while (rs.next()){
                        int idCartel = rs.getInt("id");
                        String emailAlum = rs.getString("emailA");
                        String ganador = rs.getString("ganador");
                        int anyo = rs.getInt("agno");
                        String tema = rs.getString("tema");
                        String link = rs.getString("link");
                        cart=new Cartel(idCartel,emailAlum,ganador,anyo,tema,link);
                        lista.add(cart);
                    }
                    return lista;


            } catch(SQLException ex){
                 System.out.println(ex.getMessage());
                 return lista;
            }   
         }
         else{
            System.out.println("Peticion de cartel invalida");
            return lista;
         }
       
    }
    
      /*
        Devuelve el listado de todos los comentarios asociados a un cartel
    */
    public ArrayList<Comentario> respuestas_cartel (int id_Cartel){
        ArrayList<Comentario> lista=new ArrayList<>();
        Comentario com=null;
        ResultSet rs=null;
        try{
        	try {
            	 Class.forName(S_JDBC_DRIVER);
           }catch(Exception e) {}
            Connection conection = DriverManager.getConnection(url, username, password);
            Statement pet = conection.createStatement(); 
            String query = "SELECT com.id, com.nombre, com.cuerpo, com.pendiente\n" +
                            "FROM comentario com\n" +
                            "WHERE com.idCartel="+id_Cartel+";" ;
            rs=pet.executeQuery (query);
            while (rs.next()){
                    int idCom = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String cuerpo = rs.getString("cuerpo");
                    String pendiente = rs.getString("pendiente");
                    com=new Comentario(idCom, id_Cartel, nombre, cuerpo, pendiente);
                    lista.add(com);
            }
            return lista;
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            return lista;
        }       
    }
    
    
    /*
        Listado de respuestas a una pregunta
    */
    public ArrayList<Respuesta> listado_respuestas (int id_Pregunta){
        ArrayList<Respuesta> lista=new ArrayList<>();
        Respuesta res=null;
        ResultSet rs=null;
        try{
        	try {
            	 Class.forName(S_JDBC_DRIVER);
           }catch(Exception e) {}
            Connection conection = DriverManager.getConnection(url, username, password);
            Statement pet = conection.createStatement(); 
            String query = "SELECT r.id, r.idC, r.cuerpo, r.veces, r.ganador\n" +
                                    "FROM pregunta p left join respuesta r on p.id=r.idP\n" +
                                    "WHERE p.id="+ id_Pregunta +";" ;
            rs=pet.executeQuery (query);
            while (rs.next()){
                    int idRes = rs.getInt("id");
                    int id_Cartel = rs.getInt("idC");
                    String cuerpo = rs.getString("cuerpo");
                    int veces = rs.getInt("veces");
                    String ganador = rs.getString("ganador");
                    res=new Respuesta(idRes, id_Cartel, id_Pregunta, cuerpo, veces, ganador);
                    lista.add(res);
            }
            return lista;

        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            return lista;
        }     
    }
    
    
    /*
    comprobar email y contraseña de prof (para login)
*/
public boolean comprobar_login_prof (String email_profe, String contrasena) throws Exception {
       ResultSet rs=null;
       boolean puede=true;
      
          try{
              try{
                  MessageDigest md= MessageDigest.getInstance("SHA-512");
                  md.update(contrasena.getBytes());
                  byte[] mb = md.digest();
                  try {
                     Class.forName(S_JDBC_DRIVER);
                 }catch(Exception e) {}
                  Connection conection = DriverManager.getConnection(url, username, password);
                  Statement pet = conection.createStatement(); 
                  String query = "SELECT *\n" +
                                  "FROM alumno a\n" +
                                  "WHERE a.profesor='"+ email_profe+"';" ; //+"' AND a.contrasena='" + md + "';" ;

                  rs=pet.executeQuery (query);
                  if(rs.next()){
                      puede=false;
                        query = "SELECT *\n" +
                              "FROM profesor a\n" +
                              "WHERE a.email='"+ email_profe+"' AND a.contrasena='" + md + "';" ;
                        rs = pet.executeQuery(query);
                         if(!rs.next()){
                            System.out.println("Ha habido un error en la contraseña del profesor");

                             throw new Exception ("Error contrasena");
                         }
                         else {
                             System.out.println("encontrado");
                             return true;
                         }
                        

                  }
                  else {
                    System.out.println("Ha habido un eror en el nombre");
                        throw new Exception ("Error nombre");
                        //throw new Exception ("Error contrasena");
                  }
              } catch(NoSuchAlgorithmException e){
                  System.out.println("No se ha podido cifrar la contraseña");
                  return false;
              }
          } catch(SQLException ex){
               System.out.println(ex.getMessage());
               return false;
          }     
}

    /*
    comprobar email y contraseña de alumno (para login)
*/
public boolean comprobar_login_alumno (String email_alumno, String contrasena) throws Exception{
     
     ResultSet rs=null;
     boolean puede=true;
    
        try{
            try{
                MessageDigest md= MessageDigest.getInstance("SHA-512");
                md.update(contrasena.getBytes());
                byte[] mb = md.digest();
                String str = new String(mb, "UTF-8");
                try {
                 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                Statement pet = conection.createStatement(); 
                String query = "SELECT *\n" +
                                "FROM alumno a\n" +
                                "WHERE a.email='"+ email_alumno+"';" ; //+"' AND a.contrasena='" + md + "';" ;
                System.out.format("%s------------------------\n",email_alumno);
                rs=pet.executeQuery (query);
                if(rs.next()){
                    puede=false;
                        query = "SELECT *\n" +
                            "FROM alumno a\n" +
                            "WHERE a.email='"+ email_alumno+"' AND a.contrasena='" + md + "';" ;
                        System.out.format("%s------------------------\n",str);
                        rs = pet.executeQuery(query);
                         if(!rs.next()){
                            System.out.println("Ha habido un error en la contra");

                             throw new Exception ("Error contrasena");
                         }
                         else {
                             System.out.println("encontrado");
                             return true;
                         }
                        

                }
                else {
                    System.out.println("Ha habido un error en el nombre");
                    throw new Exception ("Error nombre");
                }
            } catch(NoSuchAlgorithmException e){
                System.out.println("No se ha podido cifrar la contraseña");
                return false;
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return false;
        }     
}
    
    
    //Preguntas asociadas a un alumno
    public ArrayList<Pregunta> preguntas_alum(String emailAlum){ 
        ArrayList<Pregunta> lista=new ArrayList<>();
        Pregunta preg=null;
        ResultSet rs=null;
        try{
            String comando="SELECT p.id, p.titulo, p.idCartel\n" +
                                "FROM (alumno a left join cartel c on a.email=c.emailA) left join pregunta p on c.id=p.idCartel\n" +
                                "WHERE c.emailA='" + emailAlum + "';";
            try {
            	 Class.forName(S_JDBC_DRIVER);
           }catch(Exception e) {}
            Connection conection = DriverManager.getConnection(url, username, password);
            PreparedStatement al = conection.prepareStatement(comando);
            rs =al.executeQuery();
            while (rs.next()){
                    int idPreg = rs.getInt("id");
                    int id_Cartel = rs.getInt("idCartel");
                    String titulo = rs.getString("titulo");
                    preg=new Pregunta(idPreg, titulo, id_Cartel);
                    lista.add(preg);
            }
            return lista;      
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return lista;
        }
    }
    
    
    //Retos asociados a un alumno
    public ArrayList<Reto> retos_alum(String emailAlum){  
        ResultSet rs=null;
        ArrayList<Reto> lista=new ArrayList<>();
        Reto ret=null;
        try{
            String comando="SELECT r.id, r.descripcion, r.idCartel\n" +
                                "FROM (alumno a left join cartel c on a.email=c.emailA) left join reto r on c.id=r.idCartel\n" +
                                "WHERE c.emailA='"+emailAlum+"';";
            try {
            	 Class.forName(S_JDBC_DRIVER);
           }catch(Exception e) {}
            Connection conection = DriverManager.getConnection(url, username, password);
            PreparedStatement al = conection.prepareStatement(comando);
            rs =al.executeQuery();
            while (rs.next()){
                    int idReto = rs.getInt("id");
                    String descripcion = rs.getString("descripcion");
                    int idCartel = rs.getInt("idCartel");
                    ret=new Reto(idReto, descripcion, idCartel);
                    lista.add(ret);
            }
            return lista;   
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return lista;
        }
    }
    
    
    //Cuenta de notificaciones
    public int cuenta_notificaciones(String emailProf){  
         ResultSet rs=null;
         int veces=-1;
         try{
                String comando="SELECT DISTINCT count(*) as cuenta\n" +
                                "FROM ((profesor p left join alumno a on p.email=a.emailprofe) left join cartel c on a.email=c.emailA) left join comentario com on c.id=com.idCartel\n" +
                                "WHERE p.email='"+emailProf+"' AND com.pendiente='T';";
                try {
                	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                while (rs.next()){
                    veces = rs.getInt("cuenta");
                }
                return veces;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return veces;

        }
    }
    
    
    /*
        Listado de carteles de este año
    */
    public ArrayList<Cartel> listado_carteles_anyoactual (){
        ArrayList<Cartel> lista=new ArrayList<>();
        Cartel cart=null;
        ResultSet rs=null;
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        try{
        	try {
            	 Class.forName(S_JDBC_DRIVER);
           }catch(Exception e) {}
            Connection conection = DriverManager.getConnection(url, username, password);
            Statement pet = conection.createStatement(); 
            String query = "SELECT *\n" +
                                    "FROM cartel c\n" +
                                    "WHERE c.agno="+year+";";
            rs=pet.executeQuery (query);
            while (rs.next()){
                int idCartel = rs.getInt("id");
                String emailAlum = rs.getString("emailA");
                String ganador = rs.getString("ganador");
                String tema = rs.getString("tema");
                String link = rs.getString("link");
                cart=new Cartel(idCartel,emailAlum,ganador,year,tema,link);
                lista.add(cart);
            }
            return lista;
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            return lista;
        }     
    }
    
    
    /*
        Temas de este año
    */
    public ResultSet temas_anyoactual (){
        
         ResultSet rs=null;
         Calendar cal= Calendar.getInstance();
         int year= cal.get(Calendar.YEAR);
        
            try{
            	try {
                	 Class.forName(S_JDBC_DRIVER);
               }catch(Exception e) {}
                    Connection conection = DriverManager.getConnection(url, username, password);
                    Statement pet = conection.createStatement(); 
                    String query = "SELECT DISTINCT c.tema\n" +
                                    "FROM cartel c\n" +
                                    "WHERE c.agno="+year+";";
                    rs=pet.executeQuery (query);

                    return rs;


            } catch(SQLException ex){
                 System.out.println(ex.getMessage());
                 return rs;
            }     
    }
    
    
    /*
        Ganadores por temas de este año
    */
    public ArrayList<Cartel> ganadorestema_anyoactual (){
        ArrayList<Cartel> lista=new ArrayList<>();
        Cartel cart=null;
        ResultSet rs=null;
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        try{
        	try {
            	 Class.forName(S_JDBC_DRIVER);
           }catch(Exception e) {}
            Connection conection = DriverManager.getConnection(url, username, password);
            Statement pet = conection.createStatement(); 
            String query = "SELECT *\n" +
                                    "FROM cartel c\n" +
                                    "WHERE c.ganador='T' AND c.agno="+year+";";
            rs=pet.executeQuery (query);
            while (rs.next()){
                int idCartel = rs.getInt("id");
                String emailAlum = rs.getString("emailA");
                String tema = rs.getString("tema");
                String link = rs.getString("link");
                cart=new Cartel(idCartel,emailAlum,"T",year,tema,link);
                lista.add(cart);
            }
            return lista;
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            return lista;
        }     
    }
    
    
    /*
    Ganador por tema de este año
*/
public Cartel ganadortema_anyoactual (String tema){
    Cartel cart=null;
    ResultSet rs=null;
    Calendar cal= Calendar.getInstance();
    int year= cal.get(Calendar.YEAR);
    try{
    	try {
        	 Class.forName(S_JDBC_DRIVER);
       }catch(Exception e) {}
        Connection conection = DriverManager.getConnection(url, username, password);
        Statement pet = conection.createStatement(); 
        String query = "SELECT *\n" +
                                "FROM cartel c\n" +
                                "WHERE c.ganador='T' AND c.tema='"+tema+"' AND c.agno="+year+";";
        rs=pet.executeQuery (query);
        while (rs.next()){
            int idCartel = rs.getInt("id");
            String emailAlum = rs.getString("emailA");
            String link = rs.getString("link");
            cart=new Cartel(idCartel,emailAlum,"T",year,tema,link);
        }
        return cart;
    } catch(SQLException ex){
        System.out.println(ex.getMessage());
        return cart;
    }     
}
    
    
    /*
        Comprueba si el id ya existe
    */
    public boolean comprobar_id(String tabla, int newID){
         
         ResultSet rs=null;
         boolean aver=false;
    
        try{ 
        	try {
            	 Class.forName(S_JDBC_DRIVER);
           }catch(Exception e) {}
                Connection conection = DriverManager.getConnection(url, username, password);
                Statement pet = conection.createStatement(); 
                String query="select "+tabla+".id FROM "+tabla+" WHERE "+tabla+".id="+newID+";";
                rs=pet.executeQuery (query);
                
                if(!rs.next()){
                    aver=true;
                }
                /*while (rs.next()){
                    int idCartel = rs.getInt("id");
                    System.out.format("%s\n", idCartel);
                    if(idCartel!=){ aver=true; }
                }  */
                return aver;
                
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return false;
        }
       
    }
    
	    /*
	    Cartel segun id del cartel
	*/
	public Cartel cartel_id (int idCartel){
	    Cartel cart=null;
	    ResultSet rs=null;
	    try{
	    	try {
	        	 Class.forName(S_JDBC_DRIVER);
	       }catch(Exception e) {}
	        Connection conection = DriverManager.getConnection(url, username, password);
	        Statement pet = conection.createStatement(); 
	        String query = "SELECT *\n" +
	                                "FROM cartel c\n" +
	                                "WHERE c.id='"+idCartel+"';";
	        rs=pet.executeQuery (query);
	        while (rs.next()){
	        	String ganador = rs.getString("ganador");
	            String emailAlum = rs.getString("emailA");
	            String link = rs.getString("link");
	            String tema = rs.getString("tema");
	            int year = rs.getInt("agno");
	            cart=new Cartel(idCartel,emailAlum,ganador,year,tema,link);
	        }
	        return cart;
	    } catch(SQLException ex){
	        System.out.println(ex.getMessage());
	        return cart;
	    }     
	}
	
	    /*
	    Alumno segun el email
	*/
	public Alumno alumno_id (String email){
	    Alumno alum=null;
	    ResultSet rs=null;
	    try{
	    	try {
	        	 Class.forName(S_JDBC_DRIVER);
	       }catch(Exception e) {}
	        Connection conection = DriverManager.getConnection(url, username, password);
	        Statement pet = conection.createStatement(); 
	        String query = "SELECT *\n" +
	                                "FROM alumno a\n" +
	                                "WHERE a.email='"+email+"';";
	        rs=pet.executeQuery (query);
	        while (rs.next()){
	        	String nombre = rs.getString("nombre");
	            String apellido1 = rs.getString("apellido1");
	            String apellido2 = rs.getString("apellido2");
	            String emailprofe = rs.getString("emailprofe");
	            alum=new Alumno(nombre,apellido1,apellido2,email,emailprofe);
	        }
	        return alum;
	    } catch(SQLException ex){
	        System.out.println(ex.getMessage());
	        return alum;
	    }     
	}
	
	
	    /*
	    Profesor segun el email
	*/
	public Profesor profe_id (String email){
	    Profesor profe=null;
	    ResultSet rs=null;
	    try{
	    	try {
	        	 Class.forName(S_JDBC_DRIVER);
	       }catch(Exception e) {}
	        Connection conection = DriverManager.getConnection(url, username, password);
	        Statement pet = conection.createStatement(); 
	        String query = "SELECT *\n" +
	                                "FROM profesor p\n" +
	                                "WHERE p.email='"+email+"';";
	        rs=pet.executeQuery (query);
	        while (rs.next()){
	        	String nombre = rs.getString("nombre");
	            String apellido1 = rs.getString("apellido1");
	            String apellido2 = rs.getString("apellido2");
	            String emailprofe = rs.getString("emailprofe");
	            profe=new Profesor(nombre,apellido1,apellido2,email,emailprofe);
	        }
	        return profe;
	    } catch(SQLException ex){
	        System.out.println(ex.getMessage());
	        return profe;
	    }     
	}
	
	
	
	 /*
     * FUNCION NUEVA
     */
    public boolean comprobar_prof (String email_profe) throws Exception {
       ResultSet rs=null;
           try{
               try{
                  
                   try {
                     Class.forName(S_JDBC_DRIVER);
                  }catch(Exception e) {}
                   Connection conection = DriverManager.getConnection(url, username, password);
                   Statement pet = conection.createStatement(); 
                   String query = "SELECT *\n" +
                                   "FROM profesor a\n" +
                                   "WHERE a.profesor='"+ email_profe+"';";
                   rs=pet.executeQuery (query);
                   if(rs.next()){
                      return true;
                   }
                   else {
                    System.out.println("Ha habido un eror en el nombre");
                        throw new Exception ("Error nombre profesor");
                        //throw new Exception ("Error contrasena");
                   }
               } catch(NoSuchAlgorithmException e){
                   System.out.println("No se ha podido cifrar la contraseña");
                   return false;
               }
           } catch(SQLException ex){
                System.out.println(ex.getMessage());
                return false;
           }  
    }
   /*
    * FUNCION NUEVA
    */
   public boolean comprobar_alum (String email_alum) throws Exception {
       ResultSet rs=null;
          try{
              try{
                 
                  try {
                     Class.forName(S_JDBC_DRIVER);
                 }catch(Exception e) {}
                  Connection conection = DriverManager.getConnection(url, username, password);
                  Statement pet = conection.createStatement(); 
                  String query = "SELECT *\n" +
                                  "FROM alumno a\n" +
                                  "WHERE a.profesor='"+ email_alum+"';";
                  rs=pet.executeQuery (query);
                  if(rs.next()){
                     return true;
                  }
                  else {
                    System.out.println("Ha habido un error en el nombre del alumno");
                        throw new Exception ("Error nombre alumno");
                        //throw new Exception ("Error contrasena");
                  }
              } catch(NoSuchAlgorithmException e){
                  System.out.println("No se ha podido cifrar la contraseña");
                  return false;
              }
          } catch(SQLException ex){
               System.out.println(ex.getMessage());
               return false;
          } 
 }
    
}


