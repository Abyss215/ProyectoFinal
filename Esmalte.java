
/**
 * Write a description of class Esmalte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Esmalte extends Insumo implements Serializable
{
    private String color;
    private boolean brillo;
    
    Esmalte(int cant,String col,boolean brill,double precio){
        super(cant,"Esma-"+col+((brill)?01:00),precio);
        color=col;
        brillo=brill;
    }

    public String getColor(){return color;}
    public void setColor(String col){color=col;}
    
    public boolean getBrillo(){return brillo;}
    public void setBrillo(boolean brill){
        brillo=brill;
        setId("Esm-"+color+((brill)?01:00));
    }
}
