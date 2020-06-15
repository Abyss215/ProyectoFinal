
/**
 * Write a description of class Cocinero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cocinero extends Persona
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
    
    public void cocinar(Natural n,Inventario i,int cant)  {
        n.setCantidad(n.getCantidad()-cant);
        i.agregarProducto(new Cocida(n.getTipo(),cant));
    }
    
    public void cocinar(Esmaltada e,Inventario i,int cant)  {
        e.setCantidad(e.getCantidad()-cant);
        if(e.getId().contains("Esma"))
        i.agregarProducto(new Terminado(e.getTipo(),cant,e.getColor(),e.getBrillo()));
        else
        i.agregarProducto(new Terminado(e.getTipo(),cant,e.getColor()));
    }
}
