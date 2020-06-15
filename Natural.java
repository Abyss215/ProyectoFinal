
/**
 * Write a description of class Natural here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Natural extends Producto
{
    Natural(String tipo,int cant){
        super(cant,"Natu"+tipo.replace(' ','_'),tipo);
    }
}
