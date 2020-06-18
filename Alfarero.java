
/**
 * Write a description of class Alfarero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public abstract class Alfarero extends Persona implements Serializable
{
    public Alfarero(String nom,double suel,String code){
        super(nom,suel,"Alfa"+code);
    }
    public Alfarero(String nom,String code){
        super(nom,"Alfa"+code);
    }
    
    public abstract void hacerPieza(Arcilla a,Natural p,int cant) throws Exception;
    public abstract Natural hacerPieza(Arcilla a,String tipo,int cant) throws Exception;
}
