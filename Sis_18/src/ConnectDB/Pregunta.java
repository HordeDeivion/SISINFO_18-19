/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDB;

/**
 *
 * @author nacho
 */
public class Pregunta {
    int id;
    String titulo;
    int idCartel;
    
    public Pregunta(int id, String titulo, int idCartel){
        this.id=id;
        this.titulo=titulo;
        this.idCartel=idCartel; 
    }
    
    public int dameID(){
        return id;
    }
    
    public int dameIDCartel(){
        return idCartel;
    }
    
    public String dameTitulo(){
        return titulo;
    }      
}
