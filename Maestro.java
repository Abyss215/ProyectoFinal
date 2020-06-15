
/**
 * Write a description of class Maestros here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maestro extends Alfarero
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
    
    public void hacerPieza(Arcilla a,String tipo,int cant,Inventario i)throws Exception{
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
            i.agregarProducto(new Natural(tipo,cant));
        }
    }
}
