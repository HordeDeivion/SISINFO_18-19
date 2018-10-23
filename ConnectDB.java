package ConnectDB;

import java.sql.*;
import java.io.*;


public class ConnectDB {
    static String Nombre_DB= "sis_18";
    static String username = "root";
    static String password = "1234";
    static String url = "jdbc:mysql://localhost:3306/"+Nombre_DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    /*
     * Main de prueba de las funciones de acceso y modificacion de la base de datos
     */
public ConnectDB(){}
    public static void main(String[] args) {
        //Prueba a insertar un profesor
        int HaPodido= insert_profe("paco","palotes","perez","1234","paco@gm","uno@unizar.es");
        if (HaPodido==1){
            System.out.println("Inserccion de paco correcta");
        }
        //Prueba a insertar un alumno
        HaPodido= insert_alumno("paaco","paloates","pearez","1234","palotes@gm","uno@unizar.es");
        if (HaPodido==1){
            System.out.println("Inserccion de paco  alumno correcta");
        }
        // Prueba a insertar un cartel
        HaPodido= insert_cartel(1,"palotes@gm","1",2018,"Agua","Link_cartel_1_agua");
        if (HaPodido==1){
            System.out.println("Inserccion de paco correcta");
        }
        //Prueba a Insertar una pregunta
        HaPodido= insert_pregunta(1,1,"¿Cual fue el coste del tratamiento de aguas en Zaragoza el agno pasado?");
        if (HaPodido==1){
            System.out.println("Inserccion pregunta correcta");
        }
        //Prueba a Insertar un comentario
        HaPodido= insert_comentario(1,1,"Paco","Me encanto la pregunta, muy informativa","0");
        if (HaPodido==1){
            System.out.println("Inserccion comentario correcta");
        }
        //Prueba a Insertar una respuesta
        HaPodido= insert_respuesta(1,1,1,"5,4 millones de euros",0,"T");
        if (HaPodido==1){
            System.out.println("Inserccion de respuesta correcta");
        }
        //Prueba a Insertar un reto
        HaPodido= insert_reto(2,1,"Animate a recoger 5 latas en 5 dias ");
        if (HaPodido==1){
            System.out.println("Inserccion de reto correcto");
        }
        //Prueba a borrar un profesor
        HaPodido= delete_profesor("paco@gm");
        if (HaPodido==1){
            System.out.println("borrado correcto");
        }
         //Prueba a borrar un alumno
        HaPodido= delete_alumno("1234");
        if (HaPodido==1){
            System.out.println("borrado correcto");
        }
        
          //Prueba a borrar un alumno
        HaPodido= delete_alumno("1234");
        if (HaPodido==1){
            System.out.println("borrado correcto");
        }
        
        HaPodido= insert_profe("paco","palotes","perez","1234","paco@gm","uno@unizar.es");
        if (HaPodido==1){
            System.out.println("Inserccion de paco correcta");
        }
        
        HaPodido= insert_cartel(200,"alum@unizar.es","F",2011,"Agua","link_cartel_2");
        if (HaPodido==1){
            System.out.println("Inserccion de cartel correcta");
        }
        
        HaPodido= update_profe("","due","per","1233","paco@gm","");
        if (HaPodido==1){
            System.out.println("Update de paco correcta");
        }
        
        HaPodido= update_profe("","due","per","1233","uno@unizar.es","");
        if (HaPodido==1){
            System.out.println("Update de paco correcta");
        }
        
        HaPodido= update_reto(2, "Recicla ya");
        if (HaPodido==1){
            System.out.println("Update de paco correcta");
        }
        
        HaPodido= update_pregunta(1, "Cambiada");
        if (HaPodido==1){
            System.out.println("Update de pregunta correcta");
        }
        
        HaPodido= update_respuesta(1, 1, 1, "Callese",123, "");
        if (HaPodido==1){
            System.out.println("Update de paco correcta");
        }
        
        HaPodido= update_respuesta(1, 1, 1, "",124, "");
        if (HaPodido==1){
            System.out.println("Update de paco correcta");
        }
        
        HaPodido= delete_profesor("paco@gm");
        if (HaPodido==1){
            System.out.println("borrado correcto");
        }
        HaPodido= pregunta_asociada_cartel(1);
        if (HaPodido==1){
            System.out.println("pregunta_asociada_cartel correcto");
        }
        HaPodido= carteles_asociados_tema("Agua");
        if (HaPodido==1){
            System.out.println("carteles_asociados_tema correcto");
        }  
        HaPodido=carteles_ganadores_anyo(2018);
        if (HaPodido==1){
            System.out.println("carteles_ganadores_anyo correcto");
        } 
        HaPodido=retos_asociados_cartel(1);
        if (HaPodido==1){
            System.out.println("retos_asociados_cartel correcto");
        }
    }
    
    /*
                    INSERCCIONES
    
    */
    
    
      /*
    nombre: Nombre profesor
    a1: Primer apellido
    a2: Segundo apellido
    contra: contrasena
    em: email del profesor
    asociado = email del profe asociado
    */
    public static int insert_profe(String nom, String a1, String a2, String contra, String em,String asociado ){
          
         
        
         int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
                //Class.forName("com.mysql.jdbc.Driver");
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
    public static int insert_alumno(String nom, String a1, String a2, String contra, String em,String asociado ){
          
         
        
         int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
                //Class.forName("com.mysql.jdbc.Driver");
                Connection conection = DriverManager.getConnection(url, username, password);
                if (nom.length() == 0){
                    System.out.println("Inserte un nombre valido");
                    Puede = -1;
                }
                else{
                    // Se intenta insertar un profesor
                    PreparedStatement al = conection.prepareStatement("INSERT INTO alumno(nombre,apellido1,apellido2,email,contrasena,emailprofe) VALUES("
                                               +"'"+nom+"',"+   "'"+a1+"'," +   "'"+a2+"',"+  
                                              "'"+em+"',"+   "'"+contra+"',"  +   "'"+asociado+"');");
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
    id: Identificador aleatorio a decidir previamente
    
    */
    public static int insert_cartel(int id, String mail, String ganar, int agno, String tema,String link ){
          
         
        
         int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
                //Class.forName("com.mysql.jdbc.Driver");
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
    public static int insert_pregunta(int id, int idC, String titulo ){
          
         
        
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
                //Class.forName("com.mysql.jdbc.Driver");
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
    public static int insert_comentario(int id, int idC, String nombre, String cuerpo,String pend ){
          
         
        
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
                //Class.forName("com.mysql.jdbc.Driver");
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se mira si es un link valido
                if (cuerpo.length() == 0){
                    System.out.println("Inserte un comentario valido");
                    Puede = -1;
                }
                else{
                    // Se intenta insertar un profesor
                    PreparedStatement al = conection.prepareStatement("INSERT INTO comentario(idC,idCartel,nombre,cuerpo,pendiente) VALUES("
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
    public static int insert_respuesta(int idR, int idC, int idP, String cuerpo,int veces, String ganador){
          
         
        
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
                //Class.forName("com.mysql.jdbc.Driver");
                Connection conection = DriverManager.getConnection(url, username, password);
                // Se mira si es un link valido
                if (cuerpo.length() == 0){
                    System.out.println("Inserte una respuesta");
                    Puede = -1;
                }
                else{
                    // Se intenta insertar un profesor
                    PreparedStatement al = conection.prepareStatement("INSERT INTO respuesta(idR,idC,idP,cuerpo,veces,ganador) VALUES("
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
    public static int insert_reto(int id, int idC, String descripcion ){
          
         
        
        int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
        try{
                //Class.forName("com.mysql.jdbc.Driver");
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
                //Class.forName("com.mysql.jdbc.Driver");
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
                //Class.forName("com.mysql.jdbc.Driver");
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
                //Class.forName("com.mysql.jdbc.Driver");
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
                //Class.forName("com.mysql.jdbc.Driver");
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
                //Class.forName("com.mysql.jdbc.Driver");
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
                //Class.forName("com.mysql.jdbc.Driver");
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
                //Class.forName("com.mysql.jdbc.Driver");
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
    public static int update_profe(String nom, String a1, String a2, String contra, String em,String asociado ){
          
         
        
         int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
         boolean cambiadas=false;
        try{
                String comando="UPDATE profesor SET";
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
                    comando=comando+ " contrasena = '"+contra+"',";
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
    public static int update_alumno(String nom, String a1, String a2, String contra, String em,String asociado ){
          
         
        
         int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
         boolean cambiadas=false;
        try{
                String comando="UPDATE alumno SET";
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
                    comando=comando+ " contrasena = '"+contra+"',";
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
    public static int update_pregunta(int id, String titulo ){
          
         
        
         int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
         boolean cambiadas=false;
        try{
                String comando="UPDATE pregunta SET";
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
    public static int update_respuesta(int idR, int idC, int idP, String cuerpo,int veces, String ganador){
          
         
        
         int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
         boolean cambiadas=false;
         boolean vecescam=false;
         boolean aCambiar=false;
        try{
                String comando="UPDATE respuesta SET";
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
                    comando = comando + " WHERE idR = " + idR + " AND idC = "+idC+" AND idP= "+idP+";";
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
    public static int update_reto(int id, String descripcion ){
          
         
        
         int Puede = 0;         // 1 si la inserccion ha sido un exito 0 en caso contrario
         boolean cambiadas=false;
        try{
                String comando="UPDATE reto SET";
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
    public ResultSet pregunta_asociada_cartel(int idCartel){
     
         ResultSet rs=null;
         try{
                String comando="SELECT p.id, p.titulo\n" +
                                "FROM cartel c left join pregunta p on c.id=p.idCartel\n" +
                                "WHERE c.id="+idCartel+";";
                Connection conection = DriverManager.getConnection(url, username, password);
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                return rs;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return rs;

        }
    }   
    
    //Carteles asociados a un tema
    public ResultSet carteles_asociados_tema(String tema){
  
         ResultSet rs=null;
         try{
                String comando="SELECT c.id, c.link\n" +
                               "FROM cartel c\n" +
                               "WHERE tema='" + tema + "';";
                Connection conection = DriverManager.getConnection(url, username, password);
                
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                return rs;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return rs;

        }
    } 
    
    //Carteles ganadores por año
    public ResultSet carteles_ganadores_anyo(int anyo){    
         ResultSet rs=null;
         try{
                String comando="SELECT c.id, c.link\n" +
                                "FROM cartel c\n" +
                                "WHERE c.agno=" + anyo + " AND c.ganador=1;";
                Connection conection = DriverManager.getConnection(url, username, password);
                
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                return rs;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return rs;

        }
    }
    
    //Retos asociados a un cartel
    public ResultSet retos_asociados_cartel(int idCartel){  
         ResultSet rs=null;
         try{
                String comando="SELECT r.id, r.descripcion\n" +
                                "FROM cartel c left join reto r on c.id=r.idCartel\n" +
                                "WHERE c.id=" + idCartel + ";";
                Connection conection = DriverManager.getConnection(url, username, password);
       
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                while (rs.next()){
                    int idReto = rs.getInt("id");
                    String descripcion = rs.getString("descripcion");
                    System.out.format("%s, %s\n", idReto, descripcion);
                }
                return rs;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return rs;

        }
    }
    
    //Comentarios pendientes dirigidos a los alumnos de un profesor
    public ResultSet comentarios_pendientes(String emailProf){    
         ResultSet rs=null;
         try{
                String comando="SELECT com.idC, com.nombre, com.cuerpo\n" +
"	FROM ((profesor prof left join alumno a on prof.email = a.emailprofe) left join cartel c on a.email=c.emailA) left join comentario com on c.id=com.idCartel\n" +
"	WHERE prof.email='" + emailProf + "' AND com.pendiente='T';";
                Connection conection = DriverManager.getConnection(url, username, password);
                
                System.out.println("Buscando comentarios pendientes del profesor: "+emailProf);
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                return rs;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return rs;

        }
    }
    
    //Carteles asociados a un alumno
    public ResultSet carteles_alum(String emailAlum){  
         ResultSet rs=null;
         try{
                String comando="SELECT c.id, c.link\n" +
                                "FROM alumno a left join cartel c on a.email=c.emailA\n" +
                                "WHERE c.emailA='"+ emailAlum+ "';";
                Connection conection = DriverManager.getConnection(url, username, password);
                
                System.out.println("Buscando carteles del alumno: "+emailAlum);
                PreparedStatement al = conection.prepareStatement(comando);
                rs =al.executeQuery();
                return rs;
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return rs;

        }
    }
    
    /*
        Devuelve el listado de alumnos asociados a un profesor y su email
    */
    public ResultSet alumnos(String email_profe){
         
         ResultSet rs=null;
    
        try{ 
                Connection conection = DriverManager.getConnection(url, username, password);
                Statement pet = conection.createStatement(); 
                String query=" select A1.nombre,A2.apellido1,A1.apellido2,A1.email from ( (select * from profesor  where profesor.email = "+email_profe +") AS A2 LEFT JOIN  alumno A1 ON A1.emailprofe = A2.email) ;";
                rs=pet.executeQuery (query);
                
                return rs;
                
              
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
             return rs;
        }
       
    }
    
     /*
        Devuelve el listado de carteles ganadores segun peticion:
            1 - Ordenados por agno
            2 - Ordenados por agno y tematica
    */
    public ResultSet carteles_gandores (int peticion){
         
         ResultSet rs=null;
         if ( peticion == 1 || peticion==2){
            try{

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

                    return rs;


            } catch(SQLException ex){
                 System.out.println(ex.getMessage());
                 return rs;
            }   
         }
         else{
            System.out.println("Peticion de cartel invalida");
            return rs;
         }
       
    }
    
      /*
        Devuelve el listado de todas las respuestas asociadas a un cartel
    */
    public ResultSet respuestas_cartel (int id_Cartel){
         
         ResultSet rs=null;
        
            try{

                    Connection conection = DriverManager.getConnection(url, username, password);
                    Statement pet = conection.createStatement(); 
                    String query = "select  A2.cuerpo from( (select * from cartel WHERE id = "+ id_Cartel +") AS A1 LEFT JOIN comentario A2 ON A1.id = A2.idC );" ;

                    rs=pet.executeQuery (query);

                    return rs;


            } catch(SQLException ex){
                 System.out.println(ex.getMessage());
                 return rs;
            }   
         
        
       
    }
    
        /*
        Comprueba si el id ya existe
    */
    public boolean comprobar_id(String tabla, double newID){
         
         ResultSet rs=null;
         boolean aver=false;
    
        try{ 
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
}


