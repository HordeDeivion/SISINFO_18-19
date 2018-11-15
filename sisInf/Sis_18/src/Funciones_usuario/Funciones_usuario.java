/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Funciones_usuario;
import ConnectDB.*;

import java.sql.*;
import java.util.*;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * Autores: Jose Manuel Romero ,Ignacio Palacios, David Ubide
 */
public class Funciones_usuario {


	public Funciones_usuario() {}
	/*
    public static void main(String[] args) { 
        insertar_profesor("ejemplo", "de", "prueba", "contra", "ejemplo@unizar.es", "uno@unizar.es");
        modificar_profesor ("ejempl", "d", "prueb", "contra", "ejemplo@unizar.es", "uno@unizar.es");
        modificar_profesor ("", "", "", "eee", "ejemplo@unizar.es", "uno@unizar.es");
        insertar_alumno("ejemploalum", "de", "prueba", "contra", "ejemploalum@unizar.es", "uno@unizar.es");
        modificar_alumno("ejemalum", "d", "pruea", "", "ejemploalum@unizar.es", "uno@unizar.es");
        modificar_alumno("", "", "", "eeee", "ejemploalum@unizar.es", "uno@unizar.es");
        //carteles_asociados_tema_func("Contaminacion");
        //listado_respuestas_func (10);
        //retos_alum_func ("alum@unizar.es");
        //temas_anyoactual_func ();
        //ganadorestema_anyoactual_func ();
    }    
    */
    
    
    //  Inserta un Profesor a nuestra base de datos.
        public static void insertar_profesor (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado) throws Exception {
               System.out.println("Insertando "+Nombre+" en nuestra base de datos");
       
	               try{
	                    MessageDigest md= MessageDigest.getInstance("SHA-512");
	                    md.update(contrasena.getBytes());
	                    byte[] mb = md.digest();
	                    Profesor profe=new Profesor(Nombre, apellido1, apellido2, email, asociado);
	                    ConnectDB d = new ConnectDB();
	                    int puede= d.insert_profe(profe,mb);
	                    if(puede == 0){
	                        System.out.println("No ha podido insertar profesor");
	                    }
	               } catch (Exception e) {
	                    //Error
	            	   throw new Exception ("Error profesor");
	                }
        }

        // Inserta un alumno 
        public static void insertar_alumno (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado) throws Exception {
               System.out.println("Insertando "+Nombre+" en nuestra base de datos");
               try{
                    MessageDigest md= MessageDigest.getInstance("SHA-512");
                    md.update(contrasena.getBytes());
                    byte[] mb = md.digest();
                    Alumno alum=new Alumno(Nombre, apellido1, apellido2, email, asociado);
                    ConnectDB d = new ConnectDB();
                    int puede= d.insert_alumno(alum,mb);
                    if(puede == 0){
                        System.out.println("No ha podido insertar alumno");
                    }
               } catch (NoSuchAlgorithmException e) {
            	   throw new Exception ("Error alumno");
                }
        }

        public static void insertar_cartel(String mail, String ganar, int agno, String tema,String link ){
            System.out.println("Insertando cartel asociado al mail: "+mail+" en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            int id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
            boolean salir=d.comprobar_id("cartel",id);
            while(!salir){
                id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
                salir=d.comprobar_id("cartel",id);
            }
            Cartel cart=new Cartel(id,mail,ganar,agno,tema,link);
            int puede= d.insert_cartel(cart);
            if(puede == 0){
                System.out.println("No ha podido insertar cartel");
            }
        }
        
      public void insertar_pregunta(int idC, String titulo ){
            System.out.println("Insertando pregunta: "+titulo+" en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            int id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
            boolean salir=d.comprobar_id("pregunta",id);
            while(!salir){
                id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
                salir=d.comprobar_id("pregunta",id);
            }
            Pregunta pregun=new Pregunta(id,titulo,idC);
            int puede= d.insert_pregunta(pregun);
            if(puede == 0){
                System.out.println("No ha podido insertar pregunta");
            }
      }
      
    public void insertar_comentario(int idC, String nombre, String cuerpo,String pend ){
            System.out.println("Insertando comentario del usuario: "+nombre+" en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            int id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
            boolean salir=d.comprobar_id("comentario",id);
            while(!salir){
                id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
                salir=d.comprobar_id("comentario",id);
            }
            Comentario comment=new Comentario(id,idC,nombre,cuerpo,pend);
            int puede= d.insert_comentario(comment);
            if(puede == 0){
                System.out.println("No ha podido insertar comentario");
            }
     }
    
    
    public void insertar_reto(int idC, String descripcion ){
            System.out.println("Insertando reto : " +descripcion+ " en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            int id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
            boolean salir=d.comprobar_id("reto",id);
            while(!salir){
                id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
                salir=d.comprobar_id("reto",id);
            }
            Reto ret=new Reto(id,descripcion,idC);
            int puede= d.insert_reto(ret);
            if(puede == 0){
                System.out.println("No ha podido insertar reto");
            }
    }
    
    
    public static void insertar_respuesta(int idC, int idP, String cuerpo, String ganador ){
            System.out.println("Insertando respuesta : " +cuerpo+ " en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            int id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
            boolean salir=d.comprobar_id("respuesta",id);
            while(!salir){
                id=(int)(Math.random() * ((1500 - 1) + 1)) + 1;
                salir=d.comprobar_id("respuesta",id);
            }
            Respuesta resp=new Respuesta(id,idC,idP, cuerpo, 0, ganador);
            int puede= d.insert_respuesta(resp);
            if(puede == 0){
                System.out.println("No ha podido insertar respuesta");
            }
    }
    
    /*
    -----------------------------------------------------------------------------------------------------------------------------------------------
    */
    public static void borrar_profesor(String email){
        System.out.println("Borrando al profesor asociado al email: " +email+ " de nuestra base de datos");
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
    public static void modificar_profesor (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado){
               System.out.println("Modificando:  "+Nombre+" en nuestra base de datos");
               Profesor profe=new Profesor(Nombre, apellido1, apellido2, email, asociado);
               ConnectDB d = new ConnectDB();
               int puede= d.update_profe(profe,contrasena);
               if(puede == 0){
                   System.out.println("No se ha podido modificar");
               }
        }
    public static void modificar_alumno (String Nombre, String apellido1,String apellido2,String contrasena,String email,String asociado){
               System.out.println("Modificando:  "+Nombre+" en nuestra base de datos");
               Alumno alum=new Alumno(Nombre, apellido1, apellido2, email, asociado);
               ConnectDB d = new ConnectDB();
               int puede= d.update_alumno(alum,contrasena);
               if(puede == 0){
                   System.out.println("No se ha podido modificar");
               }
        }

      public void modificar_pregunta(int id,String titulo ){
            System.out.println("Modificando pregunta: "+titulo+" en nuestra base de datos");
            Pregunta preg=new Pregunta(id, titulo, 0);
            ConnectDB d = new ConnectDB();
            int puede= d.update_pregunta(preg);
            if(puede == 0){
                System.out.println("No se ha podido modificar");
            }
      }
      
      public static void modificar_respuesta(int id, int idC, int idP, String cuerpo, int veces, String ganador ){
            System.out.println("Modificando respuesta: "+id+" en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            Respuesta res=new Respuesta(id,idC,idP,cuerpo,veces+1,ganador);
            int puede= d.update_respuesta(res);
            if(puede == 0){
                System.out.println("No se ha podido modificar");
            }
      }  

    public static void modificar_reto(int id, int idC, String descripcion ){
            System.out.println("Modificando reto : " +descripcion+ " en nuestra base de datos");
            ConnectDB d = new ConnectDB();
            Reto ret=new Reto(id,descripcion,idC);
            int puede= d.update_reto(ret);
            if(puede == 0){
                System.out.println("No se ha modificar");
            }
    }
   
   
   /*
    --------------------------------------------    CONSULTAS           --------------------------------------------------
    ----------------------------------------------------------------------------------------------------------------------
    */
   
    //Preguntas asociadas a un cartel
    public Pregunta pregunta_asociada_cartel_func(int idCartel){
        System.out.println("Buscando pregunta asociada al cartel: "+idCartel);
        ConnectDB d = new ConnectDB();  
        Pregunta preg= d.pregunta_asociada_cartel(idCartel);
        String titu=preg.dameTitulo();
        System.out.println("Pregunta: "+titu);
        return preg;
    }
    
    //Carteles asociados a un tema
    public static void carteles_asociados_tema_func(String tema){
        System.out.println("Buscando carteles del tema: "+tema);
        ArrayList<Cartel> lista;
        Cartel cart=null;
        ConnectDB d = new ConnectDB();  
        lista= d.carteles_asociados_tema(tema);
        Iterator<Cartel> it = lista.iterator();
        while (it.hasNext()){
            cart=it.next();
            int idCartel = cart.dameID();
            String link = cart.dameLink();
            System.out.format("%s, %s\n", idCartel, link);
        }
    }    
    
    
    //Carteles ganadores por año
    public void carteles_ganadores_anyo_func(int anyo){
        System.out.println("Buscando carteles ganadores del año: "+anyo);
        ArrayList<Cartel> lista;
        Cartel cart=null;
        ConnectDB d = new ConnectDB();  
        lista= d.carteles_ganadores_anyo(anyo);
        Iterator<Cartel> it = lista.iterator();
        while (it.hasNext()){
            cart=it.next();
            int idCartel = cart.dameID();
            String link = cart.dameLink();
            System.out.format("%s, %s\n", idCartel, link);
        }
    }
    
    
    //Retos asociados a un cartel
    public Reto retos_asociados_cartel_func(int idCartel){
        System.out.println("Buscando retos asociados al cartel: "+idCartel);
        ArrayList<Reto> lista;
        Reto ret=null;
        ConnectDB d = new ConnectDB();  
        lista= d.retos_asociados_cartel(idCartel);
        Iterator<Reto> it = lista.iterator();
        //while (it.hasNext()){
        if(it.hasNext()){
            ret=it.next();
            int idReto = ret.dameID();
            String descripcion = ret.dameDescripcion();
            System.out.format("%s, %s\n", idReto, descripcion);
        }
        return ret;
    }
    
    //Comentarios pendientes dirigidos a los alumnos de un profesor
    public void comentarios_pendientes_func(String emailProf){
        System.out.println("Buscando comentario pendientes para profesor: "+emailProf);
        ArrayList<Comentario> lista;
        Comentario com=null;
        ConnectDB d = new ConnectDB();  
        lista= d.comentarios_pendientes(emailProf);
        Iterator<Comentario> it = lista.iterator();
        while (it.hasNext()){
            com=it.next();
            int idCom = com.dameID();
            String nombre = com.dameNombre();
            String cuerpo = com.dameCuerpo();
            System.out.format("%s, %s, %s\n", idCom, nombre, cuerpo);
        }
    }
    
    //Carteles asociados a un alumno
    public ArrayList<Cartel> carteles_alum_func(String emailAlum){
        System.out.println("Buscando carteles del alumno: "+emailAlum);
        ArrayList<Cartel> lista;
        Cartel cart=null;
        ConnectDB d = new ConnectDB();  
        lista= d.carteles_alum(emailAlum);
        return lista;
        /*Iterator<Cartel> it = lista.iterator();
        while (it.hasNext()){
            cart=it.next();
            int idCartel = cart.dameID();
            String link = cart.dameLink();
            System.out.format("%s, %s\n", idCartel, link);
        }     */
    }
    
    //Devuelve el listado de alumnos asociados a un profesor y su email
    public ArrayList<Alumno> alumnos_func(String email_profe){
        System.out.println("Buscando alumnos del profesor: "+email_profe);
        ArrayList<Alumno> lista;
        Alumno alum=null;
        ConnectDB d = new ConnectDB();  
        lista= d.alumnos(email_profe);
        return lista;
        /*Iterator<Alumno> it = lista.iterator();
        while (it.hasNext()){
            alum=it.next();
            String nombre=alum.dameNombre();
            String ape1=alum.dameApellido1();
            String ape2=alum.dameApellido2();
            String email=alum.dameEmail();
            System.out.format("%s, %s, %s, %s\n", nombre, ape1, ape2, email);
        }*/  
    }
    
    /*
        Devuelve el listado de carteles ganadores segun peticion:
            1 - Ordenados por agno
            2 - Ordenados por agno y tematica
    */
    public void carteles_ganadores_func (int peticion){
        System.out.println("Buscando carteles ganadores segun peticion: "+peticion);
        ArrayList<Cartel> lista;
        Cartel cart=null;
        ConnectDB d = new ConnectDB();  
        lista= d.carteles_gandores(peticion);
        Iterator<Cartel> it = lista.iterator();
        while (it.hasNext()){
            cart=it.next();
            int idCartel = cart.dameID();
            String link = cart.dameLink();
            System.out.format("%s, %s\n", idCartel, link);
        } 
    }
    
    //Devuelve el listado de todos los comentarios asociados a un cartel
    public ArrayList<Comentario> respuestas_cartel_func (int id_Cartel){
        System.out.println("Buscando comentarios asociados a un cartel: "+id_Cartel);
        ArrayList<Comentario> lista;
        Comentario com=null;
        ConnectDB d = new ConnectDB();  
        lista= d.respuestas_cartel(id_Cartel);
        return lista;
        /*Iterator<Comentario> it = lista.iterator();
        while (it.hasNext()){
            com=it.next();
            int id = com.dameID();
            String nombre = com.dameNombre();
            String cuerpo = com.dameCuerpo();
            String pendiente;
            if(com.dameSiPendiente()){
                pendiente="T";
            }
            else{
                pendiente="F";
            }
            System.out.format("%s, %s, %s, %s\n", id, nombre, cuerpo, pendiente);
        }*/ 
    }
    
    // Listado de respuestas a una pregunta
    public static ArrayList<Respuesta> listado_respuestas_func (int id_Pregunta){
        System.out.println("Buscando respuestas asociadas a una pregunta: "+id_Pregunta);
        ArrayList<Respuesta> lista;
        Respuesta res=null;
        ConnectDB d = new ConnectDB();  
        lista= d.listado_respuestas(id_Pregunta);
        return lista;
        /*Iterator<Respuesta> it = lista.iterator();
        while (it.hasNext()){
            res=it.next();
            int idRes=res.dameID();
            String cuerpo=res.dameCuerpo();
            String ganador;
            if(res.dameSiGanador()){
                ganador="T";
            }
            else{
                ganador="F";
            }
            //System.out.format("%s, %s, %s\n", idRes, cuerpo, ganador);
            
        }*/ 
    }
    
    
    // comprobar email y contraseña de prof (para login)
    public static boolean login_profe_func (String email_profe, String contrasena)throws Exception{
    	 System.out.println("Buscando cuenta del profesor");
         ConnectDB d = new ConnectDB(); 
         try {
             boolean conectado= d.comprobar_login_prof(email_profe, contrasena);
             if(conectado){
                 System.out.println("Profesor encontrado");
             }
             else{
                 System.out.println("Profesor NO encontrado");
             }
             return conectado;
         }catch(Exception e) {
         	
         	if(e.getMessage()== "Error contrasena") {
         		
         		throw new Exception("Error contrasena");
         	}
         	if(e.getMessage()== "Error nombre") {
         		throw new Exception("Error usuario");
         	}
         }
         return false;
    }
    
    
        // comprobar email y contraseña de alumno (para login)
    public static boolean login_alumno_func (String email_alum, String contrasena) throws Exception{
        System.out.println("Buscando cuenta del alumno");
        ConnectDB d = new ConnectDB(); 
        try {
            boolean conectado= d.comprobar_login_alumno(email_alum, contrasena);
            if(conectado){
                System.out.println("Alumno encontrado");
            }
            else{
                System.out.println("Alumno NO encontrado");
            }
            return conectado;
        }catch(Exception e) {
        	System.out.println("Pescada");
        	if(e.getMessage()== "Error contrasena") {
        		
        		throw new Exception("Error contrasena");
        	}
        	if(e.getMessage()== "Error nombre") {
        		throw new Exception("Error usuario");
        	}
        }
        return false;
       
    }
    
    //Preguntas asociadas a un alumno
    public static ArrayList<Pregunta> preguntas_alum_func (String emailAlum){
        System.out.println("Buscando preguntas asociadas al alumno: "+emailAlum);
        ArrayList<Pregunta> lista;
        Pregunta preg=null;
        ConnectDB d = new ConnectDB();  
        lista= d.preguntas_alum(emailAlum);
        return lista;
        /*Iterator<Pregunta> it = lista.iterator();
        while (it.hasNext()){
            preg=it.next();
            int id=preg.dameID();
            int idCartel = preg.dameIDCartel();
            String titulo=preg.dameTitulo();
            System.out.format("%s, %s, %s\n", id, idCartel, titulo);
        } */
    }
    
    
    //Retos asociados a un alumno
    public static ArrayList<Reto> retos_alum_func (String emailAlum){
        System.out.println("Buscando retos asociados al alumno: "+emailAlum);
        ArrayList<Reto> lista;
        Reto ret=null;
        ConnectDB d = new ConnectDB();  
        lista= d.retos_alum(emailAlum);
        return lista;
        /*Iterator<Reto> it = lista.iterator();
        while (it.hasNext()){
            ret=it.next();
            int idReto = ret.dameID();
            int idCartel=ret.dameIDCartel();
            String descripcion = ret.dameDescripcion();
            System.out.format("%s, %s, %s\n", idReto, idCartel, descripcion);
        }*/
    }
    
    
    public static int cuenta_notificaciones_func (String emailProf){
        System.out.println("Contando notificaciones del profesor: "+emailProf);
        ConnectDB d = new ConnectDB();  
        int notif= d.cuenta_notificaciones(emailProf);
        System.out.format("Tiene %d notificaciones\n", notif);
        return notif;
    }
    
    //Listado de carteles de este año
    public static void carteles_anyoactual_func (){
        System.out.println("Buscando carteles de este año");
        ArrayList<Cartel> lista;
        Cartel cart=null;
        ConnectDB d = new ConnectDB();  
        lista= d.listado_carteles_anyoactual();
        Iterator<Cartel> it = lista.iterator();
        while (it.hasNext()){
            cart=it.next();
            int idCartel=cart.dameID();
            String link=cart.dameLink();
            System.out.format("%s, %s\n",idCartel, link);
        }
    }
    
    
    //Temas de este año
    public static ArrayList<String> temas_anyoactual_func (){
        System.out.println("Buscando temas de este año");
        ArrayList<String> temas = new ArrayList<>();;
        ConnectDB d = new ConnectDB();  
        try{
            ResultSet rs= d.temas_anyoactual();
            while (rs.next()){
                    String tema = rs.getString("tema");
                    System.out.format("%s\n", tema);
                    temas.add(tema);
            }
        } catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
        return temas;
    }
    
    //Listado de carteles de este año
    public static ArrayList<Cartel> ganadorestema_anyoactual_func (){
        System.out.println("Buscando carteles ganadores por tema de este año");
        ArrayList<Cartel> lista;
        Cartel cart=null;
        ConnectDB d = new ConnectDB();  
        lista= d.ganadorestema_anyoactual();
        return lista;
        /*Iterator<Cartel> it = lista.iterator();
        while (it.hasNext()){
            cart=it.next();
            int idCartel=cart.dameID();
            String link=cart.dameLink();
            String tema=cart.dameTema();
            System.out.format("%s, %s, %s\n",idCartel, tema, link);
        }*/
    }
    
    //Cartel ganador por tema de este año
    public static Cartel ganadortema_anyoactual_func (String tema){
        Cartel cart=null;
        ConnectDB d = new ConnectDB();  
        cart= d.ganadortema_anyoactual(tema);
        return cart;
    }
    
  //Cartel segun el id
    public static Cartel cartel_id_func (int idCartel){
        Cartel cart=null;
        ConnectDB d = new ConnectDB();  
        cart= d.cartel_id(idCartel);
        return cart;
    }
    
    //Alumno segun el email
    public static Alumno alumno_id_func (String email){
        Alumno alum=null;
        ConnectDB d = new ConnectDB();  
        alum= d.alumno_id(email);
        return alum;
    }
    
  //Profesor segun el email
    public static Profesor profesor_id_func (String email){
    	Profesor profe=null;
        ConnectDB d = new ConnectDB();  
        profe= d.profe_id(email);
        return profe;
    }
    
    /*
     * 
     * FUNCION NUEVA
     */
    
    public static boolean Buscar_profe (String email_profe)throws Exception{
   	 System.out.println("Buscando cuenta del profesor");
        ConnectDB d = new ConnectDB(); 
        try {
            boolean conectado= d.comprobar_prof(email_profe);
        }catch(Exception e) {
        	
        	if(e.getMessage()== "Error nombre profesor") {
        		throw new Exception("Error nombre profesor");
        	}
        }
        return false;
   }
    
    /*
     * 
     * FUNCION NUEVA
     */
    
    public static boolean Buscar_alum (String email_alum)throws Exception{
   	 System.out.println("Buscando cuenta del profesor");
        ConnectDB d = new ConnectDB(); 
        try {
            boolean conectado= d.comprobar_alum(email_alum);
        }catch(Exception e) {
        	
        	if(e.getMessage() == "Error nombre alumno") {
        		throw new Exception("Error nombre alumno");
        	}
        }
        return false;
   }
    
}