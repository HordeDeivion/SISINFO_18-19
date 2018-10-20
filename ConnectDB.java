/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectdb;
import java.sql.*;
import java.io.*;

/**
 *
 * @author David
 */
public class ConnectDB {

    /**
     * @param args the command line arguments
     */
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
        HaPodido= insert_cartel(1,"palotes@gm","1",2018,"La Paloteada","doblementePalote");
        if (HaPodido==1){
            System.out.println("Inserccion de paco correcta");
        }
        //Prueba a Insertar una pregunta
        HaPodido= insert_pregunta(1,1,"Paloteando al palote,palote");
        if (HaPodido==1){
            System.out.println("Inserccion pregunta correcta");
        }
        //Prueba a Insertar un comentario
        HaPodido= insert_comentario(1,1,"Paco","El paloteador maximo","0");
        if (HaPodido==1){
            System.out.println("Inserccion comentario correcta");
        }
        //Prueba a Insertar una respuesta
        HaPodido= insert_respuesta(1,1,1,"Paloteando ando",0,"1");
        if (HaPodido==1){
            System.out.println("Inserccion de respuesta correcta");
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
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
                    System.out.println("Insertando Profesor: "+nom+ " "+ a1+ " "+ a2+ " " +contra +" "+ asociado);
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
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
                    System.out.println("Insertando Alumno: "+nom+ " "+ a1+ " "+ a2+ " " +contra +" "+ asociado);
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
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
                    System.out.println("Insertando Cartel: "+link);
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
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
                    System.out.println("Insertando Comentario: "+cuerpo);
                    PreparedStatement al = conection.prepareStatement("INSERT INTO comentario(idC,idCartel,nombre,cuerpo,pendiente) VALUES("
                                               +id+     ","+    idC+","+  "'"+nombre+"'," + "'"+cuerpo+"',"+ "'"+pend+"'"+
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
        idR: Identificador de la respuesta
        idC: Identificador del cartel
        idP: Identificador de la pregunta
        cuerp: Texto asociado a la respuesta
        veces: Numero de veces que ha sido seleccionada esa respuesta
        ganador: 0 si no es ganadora, 1 si lo es
    */
    public static int insert_respuesta(int idR, int idC, int idP, String cuerpo,int veces, String ganador){
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
                    System.out.println("Insertando respuesta: "+cuerpo);
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
            BORRADOS
    */
    public static int delete_profesor(String email){
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
                    System.out.println("Borrando profesor asociado al email: "+email);
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
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
                    System.out.println("Borrando alumno asociado al email: "+email);
                    PreparedStatement al = conection.prepareStatement("DELETE FROM alumno WHERE email = "+
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
    // Destruye todos los carteles asociados a un email
    public static int delete_carteles(String email){
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
                    System.out.println("Borrando alumno asociado al email: "+email);
                    PreparedStatement al = conection.prepareStatement("DELETE FROM cartel WHERE emailA = "+
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
    /*
        Todos los ids de un comentario deben ser >= 0
    
    */
    public static int delete_comentario(int idC){
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
                    System.out.println("Borrando alumno asociado al id: "+idC);
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
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
                    System.out.println("Borrando alumno asociado al id: "+idP);
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
         String url = "jdbc:mysql://localhost:3306/sis_18?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         String username = "root";
         String password = "1234";
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
                    System.out.println("Borrando alumno asociado al id: "+idR);
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
    
}
