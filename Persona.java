
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public abstract class  Persona implements Serializable
{
    protected String nombre;
    protected double sueldo;
    protected String id;
    
    public Persona(String nom,double suel,String code){
        nombre=nom;
        id=code;
        sueldo=suel;
    }
    public Persona(String nom,String code){
        nombre=nom;
        id=code;
    }
    
    public void setNombre(String nom){nombre=nom;}
    public void setSueldo(double suel){sueldo=suel;}
    public void setId(String code){id=code;}
    
    public String getNombre(){return nombre;}
    public double getSueldo(){return sueldo;}
    public String getId(){return id;}
    
    public abstract String toString();
}
