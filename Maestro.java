
/**
 * Write a description of class Maestros here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Maestro extends Alfarero implements Serializable
{
    private String horario;
    
    public Maestro(String horari,String nomb,double suel){
        super(nomb,suel,"Matr"+nomb.replace(' ','_'));
        horario=horari;        
    }
    
    public void hacerPieza(Arcilla a,Natural n,int cant)throws Exception{
        int matPrim;
        if(n.getTipo().contains("plato")){
            matPrim=400;
        }else{
            matPrim=350;
        }
        if(a.getCantidad()<cant*matPrim){
            throw new Exception("ya no hay Arcilla suficiente...produccion detenida");
        }else{
            a.setCantidad(a.getCantidad()-cant*matPrim);
            n.setCantidad(n.getCantidad()+cant);
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
            return new Natural(tipo,cant);
        }
    }
    
    public String toString(){
        return "ID : "+id+"\n Nombre : "+nombre+"\n Sueldo : "+sueldo+"\n Horario : "+horario;
    }
}
