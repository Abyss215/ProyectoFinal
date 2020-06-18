
/**
 * Write a description of class Esmaltada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Esmaltada extends Producto implements Serializable
{
    private String color;
    private boolean brillo;
    Esmaltada(String tipo,int cant,String col, boolean brill){///esmalte
        super(cant,"Esma"+tipo.replace(' ','_')+"-"+col+"."+(brill?01:00),tipo);
        color=col;
        brillo=brill;
    }
    Esmaltada(String tipo,int cant,String col){///pintura
        super(cant,"Pint"+tipo.replace(' ','_')+"-"+col,tipo);
        color=col;
    }
    
    public void setColor(String col){
        color=col;
    }
    public String getColor(){
        return color;
    }
    
    public void setBrillo(boolean brill){
        brillo=brill;
    }
    public boolean getBrillo(){
        return brillo;
    }
    
}
