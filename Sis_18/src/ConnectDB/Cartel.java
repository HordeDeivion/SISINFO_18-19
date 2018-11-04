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
public class Cartel {
    int id;
    String emailAlumno;
    String ganador;
    int agno;
    String tema;
    String link;
    
    public Cartel(int id, String emailAlumno, String ganador,
                     int agno, String tema, String link){
        this.id=id;
        this.emailAlumno=emailAlumno;
        this.ganador=ganador;
        this.agno=agno;
        this.tema=tema;
        this.link=link;
    }
    
    public int dameID(){
        return id;
    }
    
    public String dameEmailAlumno(){
        return emailAlumno;
    }
    
    public boolean dameSiGanador(){
        return ganador.equals("T");
    }
    
    public int dameAgno(){
        return agno;
    }
    
    public String dameTema(){
        return tema;
    }
    
    public String dameLink(){
        return link;
    }
}
