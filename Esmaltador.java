
/**
 * Write a description of class Esmaltador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Esmaltador extends Persona
{
    private double sueldo;
    public Esmaltador(String nom,double suel){
        super(nom,"Esma"+nom.replace(' ','_'));
        sueldo=suel;
    }
    
    public void esmaltar(Cocida c,Esmalte e,Esmaltada pe,int cant) throws Exception{
        int matPrim;
        if(c.getTipo().contains("plato")){
            matPrim=100;
        }else{
            matPrim=85;
        }
        if(e.getCantidad()<cant*matPrim){
            throw new Exception("ya no hay Esmalte suficiente...produccion detenida");
        }else{
            e.setCantidad(e.getCantidad()-cant*matPrim);
            c.setCantidad(c.getCantidad()-cant);
            pe.setCantidad(pe.getCantidad()+cant);
        }
    }
    
    public void decorar(Cocida c,Pintura p,Esmaltada pe,int cant) throws Exception{
        int matPrim;
        if(c.getTipo().contains("plato")){
            matPrim=60;
        }else{
            matPrim=90;
        }
        if(p.getCantidad()<cant*matPrim){
            throw new Exception("ya no hay Pintura suficiente...produccion detenida");
        }else{
            p.setCantidad(p.getCantidad()-cant*matPrim);
            c.setCantidad(c.getCantidad()-cant);
            pe.setCantidad(pe.getCantidad()+cant);
        }
    }
    
    public void esmaltar(Cocida c,Esmalte e,Inventario i,int cant) throws Exception{
        int matPrim;
        if(c.getTipo().contains("plato")){
            matPrim=100;
        }else{
            matPrim=85;
        }
        if(e.getCantidad()<cant*matPrim){
            throw new Exception("ya no hay Esmalte suficiente...produccion detenida");
        }else{
            e.setCantidad(e.getCantidad()-cant*matPrim);
            c.setCantidad(c.getCantidad()-cant);
            i.agregarProducto(new Esmaltada(c.getTipo(),cant,e.getColor(),e.getBrillo()));
        }
    }
    
    public void decorar(Cocida c,Pintura p,Inventario i,int cant) throws Exception{
        int matPrim;
        if(c.getTipo().contains("plato")){
            matPrim=60;
        }else{
            matPrim=90;
        }
        if(p.getCantidad()<cant*matPrim){
            throw new Exception("ya no hay Pintura suficiente...produccion detenida");
        }else{
            p.setCantidad(p.getCantidad()-cant*matPrim);
            c.setCantidad(c.getCantidad()-cant);
            i.agregarProducto(new Esmaltada(c.getTipo(),cant,p.getColor()));
        }
    }
}
