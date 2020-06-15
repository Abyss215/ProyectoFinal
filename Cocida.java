
/**
 * Write a description of class Cocida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cocida extends Producto
{
    Cocida(String tipo,int cant){
        super(cant,"Coci"+tipo.replace(' ','_'),tipo);
    }
}
