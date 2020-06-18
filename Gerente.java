
/**
 * Write a description of class Gerente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Gerente extends Persona implements Serializable
{
    public Gerente(String nom){
        super(nom,"Gere"+nom.replace(' ','_'));
    }
    
    
    public Compra comprarInsumos(String fecha,Proveedor p,Insumo is,int cantidad){
        is.setCantidad(is.getCantidad()+cantidad);
        return new Compra(fecha,p.getId(),is.getId(),cantidad,is.getPrecio());
    }
    
    
    public String toString(){
        return "ID : "+id+"\n Nombre : "+nombre;
    }
}
