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
           d.insert_alumno(Nombre,apellido1,apellido2,contrasena,email,asociado);
    
    }
   public void insert_cartel(int id, String mail, String ganar, int agno, String tema,String link )
}
