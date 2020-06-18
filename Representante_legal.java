
/**
 * Write a description of class Representante_legal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Representante_legal extends Persona implements Serializable
{ 
    public Representante_legal(String nom){
        super(nom,"Repre"+nom.replace(' ','_'));
    }
    
    public String toString(){
        return "ID : "+id+"\n Nombre : "+nombre;
    }
}
