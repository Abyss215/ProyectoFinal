
/**
 * Write a description of class Natural here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Natural extends Producto implements Serializable
{
    Natural(String tipo,int cant){
        super(cant,"Natu"+tipo.replace(' ','_'),tipo);
    }
}
