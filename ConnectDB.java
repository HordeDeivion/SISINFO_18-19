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
      
        int HaPodido= insert_profe("paco","palotes","perez","1234","paco@gm","uno@unizar.es");
        if (HaPodido==1){
            System.out.println("Inserccion de paco correcta");
        }
        HaPodido= insert_alumno("paaco","paloates","pearez","1234","palotes@gm","uno@unizar.es");
        if (HaPodido==1){
            System.out.println("Inserccion de paco correcta");
        }
   
    
    }
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
                    PreparedStatement al = conection.prepareStatement("NSERT INTO cartel(id,emailA,ganador,agno,tema,link) VALUES("
                                               +"'"+id+"',"+   "'"+mail+"'," +   "'"+ganar+"',"+  
                                              "'"+agno+"',"+   "'"+tema+"',"  +   "'"+link+"');");
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
