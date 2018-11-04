/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDB;

/**
 *
 * Autor: Nacho
 */
public class Profesor {
    String nombre;
    String apellido1;
    String apellido2;
    String email;
    String emailprofe;
    
    public Profesor(String nom, String ape1, String ape2,
                     String correo, String correoprofe){
        nombre=nom;
        apellido1=ape1;
        apellido2=ape2;
        email=correo;
        emailprofe=correoprofe;
    }
    
    public String dameNombre(){
        return nombre;
    }
    
    public String dameApellido1(){
        return apellido1;
    }
    
    public String dameApellido2(){
        return apellido2;
    }
    
    public String dameEmail(){
        return email;
    }
    
    public String dameEmailprofe(){
        return emailprofe;
    }
}


