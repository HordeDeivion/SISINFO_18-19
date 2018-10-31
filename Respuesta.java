/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_console;

/**
 *
 * @author nacho
 */
public class Respuesta {
    int id;
    int idCartel;
    int idPregunta;
    String cuerpo;
    int veces;
    String ganador;
    
    
    public Respuesta(int id, int idCartel, int idPregunta, String cuerpo,
                        int veces, String ganador){
        this.id=id;
        this.idCartel=idCartel;
        this.idPregunta=idPregunta;
        this.cuerpo=cuerpo;
        this.veces=veces;
        this.ganador=ganador;    
    }
    
    public int dameID(){
        return id;
    }
    
    public int dameIDCartel(){
        return idCartel;
    }
    
    public int dameIDPregunta(){
        return idPregunta;
    }
    
    public String dameCuerpo(){
        return cuerpo;
    } 
    
    public int dameVeces(){
        return veces;
    }
    
    public boolean dameSiGanador(){
        return ganador.equals("T");
    }
}
