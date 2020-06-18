
/**
 * Write a description of class Cocida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Cocida extends Producto implements Serializable
{
    Cocida(String tipo,int cant){
        super(cant,"Coci"+tipo.replace(' ','_'),tipo);
    }
}
