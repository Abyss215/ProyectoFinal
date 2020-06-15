
/**
 * Write a description of class Gerente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gerente extends Persona
{
    public Gerente(String nom){
        super(nom,"Gere"+nom.replace(' ','_'));
    }
    
    
    public Compra comparInsumos(String fecha,Proveedor p,int cantidad,Insumo is){
        is.setCantidad(is.getCantidad()+cantidad);
        return new Compra(fecha,p.getId(),is.getId(),cantidad,is.getPrecio());
    }
}
