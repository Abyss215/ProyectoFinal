
/**
 * Write a description of class Cocinero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Cocinero extends Persona implements Serializable
{
    private String horario;
    
    public Cocinero(String nom,double suel){
        super(nom,suel,"Coci"+nom.replace(' ','_'));
    }
    
    
    public void cocinar(Natural n,Cocida c,int cant)  {
        n.setCantidad(n.getCantidad()-cant);
        c.setCantidad(c.getCantidad()+cant);
    }
    
    public void cocinar(Esmaltada e,Terminado t,int cant)  {
        e.setCantidad(e.getCantidad()-cant);
        t.setCantidad(t.getCantidad()+cant);
    }
    
    public Cocida cocinar(Natural n,int cant)  {
        n.setCantidad(n.getCantidad()-cant);
        return new Cocida(n.getTipo(),cant);
    }
    
    public Terminado cocinar(Esmaltada e,int cant)  {
        e.setCantidad(e.getCantidad()-cant);
        if(e.getId().contains("Esma"))
        return new Terminado(e.getTipo(),cant,e.getColor(),e.getBrillo());
        else
        return new Terminado(e.getTipo(),cant,e.getColor());
    }
    
    public String toString(){
        return " ID : "+id+"\n Nombre : "+nombre+"\n Sueldo : "+sueldo;
    }
}
