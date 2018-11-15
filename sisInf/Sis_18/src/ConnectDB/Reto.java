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
public class Reto {
    int id;
    String descripcion;
    int idCartel;
    
    public Reto(int id, String descripcion, int idCartel){
        this.id=id;
        this.descripcion=descripcion;
        this.idCartel=idCartel; 
    }
    
    public int dameID(){
        return id;
    }
    
    public int dameIDCartel(){
        return idCartel;
    }
    
    public String dameDescripcion(){
        return descripcion;
    }  
}
