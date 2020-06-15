
/**
 * Write a description of class Terminado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Terminado extends Producto
{
    private String color;
    private boolean brillo;
    Terminado(String tipo,int cant,String col, boolean brill){
        super(cant,"TermEsmal"+tipo.replace(' ','_')+"-"+col+"."+(brill?01:00),tipo);
        color=col;
        brillo=brill;
    }
    Terminado(String tipo,int cant,String col){
        super(cant,"TermPint"+tipo.replace(' ','_')+"-"+col,tipo);
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
