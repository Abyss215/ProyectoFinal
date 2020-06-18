
/**
 * Write a description of class Repartidor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
import java.util.Vector;
public class Repartidor extends Persona implements Serializable
{
    private int piezasVendidas;
    private String licencia;
    
    public Repartidor(String nom,String licen){
        super(nom,"Repa"+nom.replace(' ','_'));
        licencia=licen;
    }
    
    public Venta vender(Cliente c,Producto p,int cant,String fecha,String code) throws Exception{
        if(p.getCantidad()<cant){
            throw new MiException("Cantidad de Producto insuficiente....reasigne la cantidad");
        }else{
            p.setCantidad(p.getCantidad()-cant);
            piezasVendidas+=cant;
            
            return new Venta(fecha,c.getId(),p.getId(),id,cant,code);
        }
    }
    
    public Vector<Venta> diaVenta(Ruta r,Vehiculo v,String fecha,Vector[] ordenes) throws Exception{
        Vector<Venta> ventas=new Vector<Venta>(1,1);
        try{
            for(int x=0;x<ordenes[0].size();x++){
                (v.obtenerMaletera())[1].set(v.buscarIndex((String)ordenes[1].get(x)),(v.obtenerMaletera())[1].get(v.buscarIndex((String)ordenes[1].get(x))));
                ventas.add(new Venta(fecha,(r.buscarCliente((String)ordenes[0].get(x))).getId(),(v.buscarProducto((String)ordenes[1].get(x))).getId(),id,(Integer)ordenes[2].get(x),r.getId()));
            }
            
        }catch(Exception e){
            throw new MiException("problemas con la orden",e);
        }
        return ventas;
    }
    
    public int getPiezasV(){return piezasVendidas;}
    
    public void calcularSueldo(){
        setSueldo(getPiezasV()*4);
    }
    
    public int getPiezasVendidas(){return piezasVendidas;}
    public void setPiezasVendidas(int cant){piezasVendidas=cant;}
    
    public String toString(){
        return "ID : "+id+"\n Nombre : "+nombre+"\n Sueldo : "+sueldo+"\n Piezas vendidas : "+piezasVendidas+"\n Licencia "+licencia;
    }
}
