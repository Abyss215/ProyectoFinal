
/**
 * Write a description of class Venta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Venta
{
    private String fecha;
    private String idCliente;
    private String idProducto;
    private String idVendedor;
    private int cantidad;
    private String codigo;
    
    Venta(String date,String cliente,String producto,String vendedor,int cant,String code){
        fecha=date;
        idCliente=cliente;
        idProducto=producto;
        idVendedor=vendedor;
        cantidad=cant;
        codigo=fecha.replace('/','.')+"Vent-"+code;
    }
    
    public String getFecha(){return fecha;}
    public void setFecha(String date){fecha=date;}
    
    public String getIdCliente(){return idCliente;}
    public void setIdCliente(String cliente){idCliente=cliente;}
    
    public String getIdProducto(){return idProducto;}
    public void setIdProducto(String producto){idProducto=producto;}
    
    public String getIdVendedor(){return idVendedor;}
    public void setIdVendedor(String vendedor){idVendedor=vendedor;}
    
    public int getCantidad(){return cantidad;}
    public void setCantidad(int cant){cantidad=cant;}
    
    public String getCodigo(){return codigo;}
}
