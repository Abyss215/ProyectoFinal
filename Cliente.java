
/**
 * Write a description of class Clientes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Cliente implements Serializable
{
    private String id;
    private String nombre;
    
    Cliente(String nom){
        id="Clien"+nom.replace(' ','_');
        nombre=nom;
    }
    
    public String getId(){return id;}
    public String getNombre(){return nombre;}
 
    public void setId(String code){id=code;}
    public void setNombre(String nom){nombre=nom;}
    
    public String toString(){
        return " Id : "+id+"\n Nombre : "+nombre;
    }
}
