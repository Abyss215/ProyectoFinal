
/**
 * Write a description of class Insumo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Insumo implements Serializable
{
    protected int cantidad;
    protected String id;
    protected double precio;
    
    public Insumo(int cant,String code,double preci){
        cantidad=cant;
        id="Im"+code;
        precio=preci;
    }
    
    public int getCantidad(){return cantidad;}
    public void setCantidad(int cant){cantidad=cant;}
    
    public String getId(){return id;}
    public void setId(String code){id=code;}
    
    public double getPrecio(){return precio;}
    public void setPrecio(double preci){precio=preci;}
}
