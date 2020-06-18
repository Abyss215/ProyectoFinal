
/**
 * Write a description of class Pintura here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Pintura extends Insumo implements Serializable
{
    private String color;
    
    Pintura(int cant,String col,double preci){
        super(cant,"Pint-"+col,preci);
        color=col;
    }
    
    public String getColor(){return color;}
    public void setColor(String col){color=col;}
}
