
/**
 * Write a description of class Estudiantes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Estudiante extends Alfarero  implements Serializable
{
    private int horas,productosHechos;
    
    public Estudiante (int horas,String nom){
        super(nom,"Matr"+nom.replace(' ','_'));
        this.horas=horas;
    }
    
    public void hacerPieza(Arcilla a,Natural p,int cant)throws Exception{
        int matPrim;
        if(p.getTipo().contains("plato")){
            matPrim=400;
        }else{
            matPrim=350;
        }
        if(a.getCantidad()<cant*matPrim){
            throw new Exception("ya no hay Arcilla suficiente...produccion detenida");
        }else{
            a.setCantidad(a.getCantidad()-cant*matPrim);
            p.setCantidad(p.getCantidad()+cant);
            productosHechos+=cant;
        }
    }
    
    public Natural hacerPieza(Arcilla a,String tipo,int cant)throws Exception{
        int matPrim;
        if(tipo.contains("plato")){
            matPrim=400;
        }else{
            matPrim=350;
        }
        if(a.getCantidad()<cant*matPrim){
            throw new Exception("ya no hay Arcilla suficiente...produccion detenida");
        }else{
            a.setCantidad(a.getCantidad()-cant*matPrim);
            
            productosHechos+=cant;
            return new Natural(tipo,cant);
        }
    }
    
    public int getProductosHechos(){return productosHechos;}
    
    public void calcularSueldo(){
        setSueldo(productosHechos*3);
    }
    
    public String toString(){
        return "ID : "+id+"\n Nombre : "+nombre+"\n Sueldo : "+sueldo+"\n Productos hechos : "+productosHechos;
    }
}
