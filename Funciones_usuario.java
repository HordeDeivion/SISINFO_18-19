/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones_usuario;
import ConnectDB.*;

/**
 *
 * Autores: Jose Manuel Romero ,Ignacio Palacios, David Ubide
 */
public class Funciones_usuario {
    
    
        //  Inserta un Profesor a nuestra base de datos.
        public void insertar_profesor (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado){
               System.out.println("Insertando "+Nombre+" en nuestra base de datos");
               ConnectDB d = new ConnectDB();
               int puede= d.insert_profe(Nombre,apellido1,apellido2,contrasena,email,asociado);
               if(puede == 0){
                   System.out.println("No ha podido insertar profesor");
               }
        }

        // Inserta un alumno 
        public void insertar_alumno (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado){
               System.out.println("Insertando "+Nombre+" en nuestra base de datos");
               ConnectDB d = new ConnectDB();
               int puede= d.insert_alumno(Nombre,apellido1,apellido2,contrasena,email,asociado);
                if(puede == 0){
                   System.out.println("No ha podido insertar alumno");
               }
        }

       public void insertar_cartel(int id, String mail, String ganar, int agno, String tema,String link ){
           System.out.println("Insertando cartel asociado al mail: "+mail+" en nuestra base de datos");
               ConnectDB d = new ConnectDB();
               int puede= d.insert_cartel(id,mail,ganar,agno,tema,link);
                if(puede == 0){
                   System.out.println("No ha podido insertar cartel");
               }
       }
      public void insertar_pregunta(int id, int idC, String titulo ){
            System.out.println("Insertando pregunta: "+titulo+" en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            int puede= d.insert_pregunta(id,idC,titulo);
            if(puede == 0){
                System.out.println("No ha podido insertar pregunta");
            }
      }
    public void insertar_comentario(int id, int idC, String nombre, String cuerpo,String pend ){
            System.out.println("Insertando comentario del usuario: "+nombre+" en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            int puede= d.insert_comentario(id,idC,nombre,cuerpo,pend);
            if(puede == 0){
                System.out.println("No ha podido insertar comentario");
            }
     }
    public static void insertar_reto(int id, int idC, String descripcion ){
            System.out.println("Insertando reto : " +descripcion+ " en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            int puede= d.insert_reto(id,idC,descripcion);
            if(puede == 0){
                System.out.println("No ha podido insertar reto");
            }
    }
    
    /*
    -----------------------------------------------------------------------------------------------------------------------------------------------
    */
    public static void borrar_profesor(String email){
        System.out.println("Insertando al profesor asociado al email: " +email+ " de nuestra base de datos");
        ConnectDB d = new ConnectDB();
        int puede= d.delete_profesor(email);
        if(puede == 0){
            System.out.println("No ha podido borrar al profesor");
        }
    }
 
    public static void borrar_alumno(String email){
        System.out.println("Borrando al alumno asociado al email: " +email+ " de nuestra base de datos");
        ConnectDB d = new ConnectDB();
        int puede= d.delete_alumno(email);
        if(puede == 0){
            System.out.println("No ha podido borrar al alumno");
        }
    }
    public static void borrar_cartel(int idC)  {
        System.out.println("Borrando el cartel asociado al identificador: " +idC+ " de nuestra base de datos");
        ConnectDB d = new ConnectDB();
        int puede= d.delete_carteles(idC);
        if(puede == 0){
            System.out.println("No ha podido borrar el cartel");
        }
    }
    public static void borrar_comentario(int idC)  {
        System.out.println("Borrando el comentario asociado al identificador: " +idC+ " de nuestra base de datos");
        ConnectDB d = new ConnectDB();
        int puede= d.delete_comentario(idC);
        if(puede == 0){
            System.out.println("No ha podido borrar el comentario");
        }
    }
    public static void borrar_pregunta(int idP)  {
        System.out.println("Borrando la pregunta asociado al identificador: " +idP+ " de nuestra base de datos");
        ConnectDB d = new ConnectDB();
        int puede= d.delete_pregunta(idP);
        if(puede == 0){
            System.out.println("No ha podido borrar la pregunta");
        }
    }
    public static void borrar_respuesta(int idR)  {
        System.out.println("Borrando la respuesta asociada al identificador: " +idR+ " de nuestra base de datos");
        ConnectDB d = new ConnectDB();
        int puede= d.delete_respuesta(idR);
        if(puede == 0){
            System.out.println("No ha podido borrar la respuesta");
        }
    }
    
    public static void borrar_reto(int idR)  {
        System.out.println("Borrando la pregunta asociado al reto: " +idR+ "de nuestra base de datos");
        ConnectDB d = new ConnectDB();
        int puede= d.delete_reto(idR);
        if(puede == 0){
            System.out.println("No ha podido borrar el reto");
        }
    }
    /*
   ------------------------------------------------------------------------------------------------------------------
    
    */
    public void modificar_profesor (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado){
               System.out.println("Modificando:  "+Nombre+" en nuestra base de datos");
               ConnectDB d = new ConnectDB();
               int puede= d.update_profe(Nombre,apellido1,apellido2,contrasena,email,asociado);
                if(puede == 0){
                   System.out.println("No se ha podido modificar");
               }
        }
    public void modificar_alumno (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado){
               System.out.println("Modificando:  "+Nombre+" en nuestra base de datos");
               ConnectDB d = new ConnectDB();
               int puede= d.update_alumno(Nombre,apellido1,apellido2,contrasena,email,asociado);
                if(puede == 0){
                   System.out.println("No se ha podido modificar");
               }
        }

      public void modificar_pregunta(int id,String titulo ){
            System.out.println("Modificando pregunta: "+titulo+" en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            int puede= d.update_pregunta(id,titulo);
            if(puede == 0){
                System.out.println("No se ha podido modificar");
            }
      }

    public static void modificar_reto(int id, int idC, String descripcion ){
            System.out.println("Modificando reto : " +descripcion+ " en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            int puede= d.update_reto(id,descripcion);
            if(puede == 0){
                System.out.println("No se ha modificar");
            }
    }
    
}
