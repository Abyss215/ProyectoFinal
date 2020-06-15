
/**
 * Write a description of class Representante_legal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Representante_legal extends Persona
{ 
    public Representante_legal(String nom){
        super(nom,"Repre"+nom.replace(' ','_'));
    }
    
}
