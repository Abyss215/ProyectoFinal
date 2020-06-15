
/**
 * Write a description of class Estudiantes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estudiante extends Alfarero 
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
            productosHechos+=cant;
        }
    }
}
