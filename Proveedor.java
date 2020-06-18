
/**
 * Write a description of class Proveedor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public abstract class Proveedor implements Serializable
{
    protected String id;
    protected String nombre;
    
    Proveedor(String code,String nom){
        id="Prov"+code;
        nombre=nom;
    }
    
    public void setId(String code){id="Prov"+code;}
    public String getId(){return id;}
    
    public void setNombre(String nom){nombre=nom;}
    public String getNombre(){return nombre;}
    
    public abstract String toString(); 
}
