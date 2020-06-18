
/**
 * Write a description of class Esmaltador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Esmaltador extends Persona implements Serializable
{
    private int piezasH;
    public Esmaltador(String nom){
        super(nom,"Esma"+nom.replace(' ','_'));
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
    
    public void pintar(Cocida c,Pintura p,Esmaltada pe,int cant) throws Exception{
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
    
    public Esmaltada esmaltar(Cocida c,Esmalte e,int cant) throws Exception{
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
            return new Esmaltada(c.getTipo(),cant,e.getColor(),e.getBrillo());
        }
    }
    
    public Esmaltada pintar(Cocida c,Pintura p,int cant) throws Exception{
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
            return new Esmaltada(c.getTipo(),cant,p.getColor());
        }
    }
    
    public int getPiezasH(){return piezasH;}
    
    public void calcularSueldo(){
        setSueldo(getPiezasH()*8);
    }
    
    public String toString(){
        return " ID : "+id+"\n Nombre : "+nombre+"\n Sueldo : "+sueldo+"\n Piezas hechas : "+piezasH;
    }
}
