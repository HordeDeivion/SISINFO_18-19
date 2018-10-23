
package Funciones_usuario;
import ConnectDB.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * Autores: Jose Manuel Romero ,Ignacio Palacios, David Ubide
 */
public class Funciones_usuario {
    
        //  Inserta un Profesor a nuestra base de datos.
        public static void insertar_profesor (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado){
               System.out.println("Insertando "+Nombre+" en nuestra base de datos");
               try{
                    MessageDigest md= MessageDigest.getInstance("SHA-512");
                    md.update(contrasena.getBytes());
                    byte[] mb = md.digest();
                    DBConnect d = new DBConnect();
                    int puede= d.insert_profe(Nombre,apellido1,apellido2,mb,email,asociado);
                    if(puede == 0){
                        System.out.println("No ha podido insertar profesor");
                    }
               } catch (NoSuchAlgorithmException e) {
                    //Error
                }
        }

        // Inserta un alumno 
        public static void insertar_alumno (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado){
               System.out.println("Insertando "+Nombre+" en nuestra base de datos");
               try{
                    MessageDigest md= MessageDigest.getInstance("SHA-512");
                    md.update(contrasena.getBytes());
                    byte[] mb = md.digest();
                    DBConnect d = new DBConnect();
                    int puede= d.insert_alumno(Nombre,apellido1,apellido2,mb,email,asociado);
                    if(puede == 0){
                        System.out.println("No ha podido insertar profesor");
                    }
               } catch (NoSuchAlgorithmException e) {
                    //Error
                }
        }

       public void insertar_cartel(String mail, String ganar, int agno, String tema,String link ){
           System.out.println("Insertando cartel asociado al mail: "+mail+" en nuestra base de datos");
               DBConnect d = new DBConnect();
            int id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
            boolean salir=d.comprobar_id("cartel",id);
            while(!salir){
                id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
                salir=d.comprobar_id("cartel",id);
            }
               int puede= d.insert_cartel(id,mail,ganar,agno,tema,link);
                if(puede == 0){
                   System.out.println("No ha podido insertar cartel");
               }
       }
      public void insertar_pregunta(int idC, String titulo ){
            System.out.println("Insertando pregunta: "+titulo+" en nuestra base de datos");
            DBConnect d = new DBConnect();
            int id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
            boolean salir=d.comprobar_id("pregunta",id);
            while(!salir){
                id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
                salir=d.comprobar_id("pregunta",id);
            }
            int puede= d.insert_pregunta(id,idC,titulo);
            if(puede == 0){
                System.out.println("No ha podido insertar pregunta");
            }
      }
    public void insertar_comentario(int idC, String nombre, String cuerpo,String pend ){
            System.out.println("Insertando comentario del usuario: "+nombre+" en nuestra base de datos");
            DBConnect d = new DBConnect();
            int id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
            boolean salir=d.comprobar_id("comentario",id);
            while(!salir){
                id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
                salir=d.comprobar_id("comentario",id);
            }
            int puede= d.insert_comentario(id,idC,nombre,cuerpo,pend);
            if(puede == 0){
                System.out.println("No ha podido insertar comentario");
            }
     }
    public void insertar_reto(int idC, String descripcion ){
            System.out.println("Insertando reto : " +descripcion+ " en nuestra base de datos");
            DBConnect d = new DBConnect();
            int id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
            boolean salir=d.comprobar_id("reto",id);
            while(!salir){
                id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
                salir=d.comprobar_id("reto",id);
            }
            int puede= d.insert_reto(id,idC,descripcion);
            if(puede == 0){
                System.out.println("No ha podido insertar reto");
            }
    }
    
    
    public static void insertar_respuesta(int idC, int idP, String cuerpo, String ganador ){
            System.out.println("Insertando respuesta : " +cuerpo+ " en nuestra base de datos");
            DBConnect d = new DBConnect();
            int id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
            boolean salir=d.comprobar_id("respuesta",id);
            while(!salir){
                id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
                salir=d.comprobar_id("respuesta",id);
            }
            int puede= d.insert_respuesta(id,idC,idP, cuerpo, 0, ganador);
            if(puede == 0){
                System.out.println("No ha podido insertar respuesta");
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
    
    public static void modificar_respuesta(int id, int idC, int idP, String cuerpo, int veces, String ganador ){
            System.out.println("Modificando respuesta: "+id+" en nuestra base de datos");
            DBConnect d = new DBConnect();
            int puede= d.update_respuesta(id,idC,idP,cuerpo,veces+1,ganador);
            if(puede == 0){
                System.out.println("No se ha podido modificar");
            }
      } 
    
    /*
    --------------------------------------------    CONSULTAS           --------------------------------------------------
    ----------------------------------------------------------------------------------------------------------------------
    */
   
    //Preguntas asociadas a un cartel
    public void pregunta_asociada_cartel_func(int idCartel){
        System.out.println("Buscando pregunta asociada al cartel: "+idCartel);
        DBConnect d = new DBConnect();  
        try{
            ResultSet rs= d.pregunta_asociada_cartel(idCartel);
            while (rs.next()){
                    int idPregunta = rs.getInt("id");
                    String tituloPreg = rs.getString("titulo");
                    System.out.format("%s, %s\n", idPregunta, tituloPreg);
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
    }
    
    //Carteles asociados a un tema
    public void carteles_asociados_tema_func(String tema){
        System.out.println("Buscando carteles del tema: "+tema);
        DBConnect d = new DBConnect();  
        try{
            ResultSet rs= d.carteles_asociados_tema(tema);
            while (rs.next()){
                    int idCartel = rs.getInt("id");
                    String link = rs.getString("link");
                    System.out.format("%s, %s\n", idCartel, link);
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
    }    
    
    
    //Carteles ganadores por año
    public void carteles_ganadores_anyo_func(int anyo){
        System.out.println("Buscando carteles ganadores del año: "+anyo);
        DBConnect d = new DBConnect();  
        try{
            ResultSet rs= d.carteles_ganadores_anyo(anyo);
            while (rs.next()){
                    int idCartel = rs.getInt("id");
                    String link = rs.getString("link");
                    System.out.format("%s, %s\n", idCartel, link);
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
    }
    
    
    //Retos asociados a un cartel
    public void retos_asociados_cartel_func(int idCartel){
        System.out.println("Buscando retos asociados al cartel: "+idCartel);
        DBConnect d = new DBConnect();  
        try{
            ResultSet rs= d.carteles_ganadores_anyo(idCartel);
            while (rs.next()){
                    int idReto = rs.getInt("id");
                    String descripcion = rs.getString("descripcion");
                    System.out.format("%s, %s\n", idReto, descripcion);
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
    }
    
    //Comentarios pendientes dirigidos a los alumnos de un profesor
    public void comentarios_pendientes_func(String emailProf){
        System.out.println("Buscando comentario pendientes para profesor: "+emailProf);
        DBConnect d = new DBConnect();  
        try{
            ResultSet rs= d.comentarios_pendientes(emailProf);
            while (rs.next()){
                    int idCartel = rs.getInt("id");
                    String link = rs.getString("link");
                    System.out.format("%s, %s\n", idCartel, link);
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
    }
    
    //Carteles asociados a un alumno
    public void carteles_alum_func(String emailAlum){
        System.out.println("Buscando carteles del alumno: "+emailAlum);
        DBConnect d = new DBConnect();  
        try{
            ResultSet rs= d.carteles_alum(emailAlum);
            while (rs.next()){
                    int idComment = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String cuerpo = rs.getString("cuerpo");
                    System.out.format("%s, %s, %s\n", idComment, nombre, cuerpo);
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
    }
    
        //Devuelve el listado de alumnos asociados a un profesor y su email
    public void alumnos_func(String email_profe){
        System.out.println("Buscando alumnos del profesor: "+email_profe);
        DBConnect d = new DBConnect();  
        try{
            ResultSet rs= d.alumnos(email_profe);
            while (rs.next()){
                    String nombre = rs.getString("nombre");
                    String apellido1 = rs.getString("apellido1");
                    String apellido2 = rs.getString("apellido2");
                    String email = rs.getString("email");
                    System.out.format("%s, %s, %s, %s\n", nombre, apellido1, apellido2, email);
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
    }
    
    /*
        Devuelve el listado de carteles ganadores segun peticion:
            1 - Ordenados por agno
            2 - Ordenados por agno y tematica
    */
    public void carteles_ganadores_func (int peticion){
        System.out.println("Buscando carteles ganadores segun peticion: "+peticion);
        DBConnect d = new DBConnect();  
        try{
            ResultSet rs= d.carteles_gandores(peticion);
            while (rs.next()){
                    int idCartel = rs.getInt("id");
                    String link = rs.getString("link");
                    int agno = rs.getInt("agno");
                    String tema = rs.getString("tema");
                    System.out.format("%s, %s, %s, %s\n", idCartel, link, agno,tema);
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
    }
    
    //Devuelve el listado de todas las respuestas asociadas a un cartel
    public void respuestas_cartel_func (int id_Cartel){
        System.out.println("Buscando comentarios asociados a un cartel: "+id_Cartel);
        DBConnect d = new DBConnect();  
        try{
            ResultSet rs= d.respuestas_cartel(id_Cartel);
            while (rs.next()){
                    int idCom = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String cuerpo = rs.getString("cuerpo");
                    System.out.format("%s, %s, %s\n", idCom, nombre,cuerpo);
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
    }
    
        // Listado de respuestas a una pregunta
    public static void listado_respuestas_func (int id_Pregunta){
        System.out.println("Buscando respuestas asociadas a una pregunta: "+id_Pregunta);
        DBConnect d = new DBConnect();  
        try{
            ResultSet rs= d.listado_respuestas(id_Pregunta);
            while (rs.next()){
                    int idCom = rs.getInt("id");
                    String cuerpo = rs.getString("cuerpo");
                    int veces = rs.getInt("veces");
                    String ganador = rs.getString("ganador");
                    System.out.format("%s, %s, %s, %s\n", idCom,cuerpo,veces,ganador);
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
    }
    
}
