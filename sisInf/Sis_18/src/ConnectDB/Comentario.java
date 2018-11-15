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
public class Comentario {
    int id;
    int idCartel;
    String nombre;
    String cuerpo;
    String pendiente;
    
    public Comentario(int id, int idCartel, String nombre, String cuerpo,
                     String pendiente){
        this.id=id;
        this.idCartel=idCartel;
        this.nombre=nombre;
        this.cuerpo=cuerpo;
        this.pendiente=pendiente;
    }
    
    public int dameID(){
        return id;
    }
    
    public int dameIDCartel(){
        return idCartel;
    }
    
    public boolean dameSiPendiente(){
        return pendiente.equals("T");
    }
    
    public String dameNombre(){
        return nombre;
    }
    
    public String dameCuerpo(){
        return cuerpo;
    }
}
