
/**
 * Write a description of class Compra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Compra
{
    private String fecha;
    private String idProveedor;
    private String idInsumo;
    private int cantidad;
    private double monto;
    private String codigo;
    
    Compra(String fec,String codeProv,String codeInsum,int cant,double precio){
        fecha=fec;
        idProveedor=codeProv;
        idInsumo=codeInsum;
        cantidad=cant;
        monto=cant*precio;
        codigo=fecha.replace('/','.')+"Comp";
    }
    
    public String getFecha(){return fecha;}
    public void setFecha(String date){fecha=date;}
    
    public String getIdProveedor(){return idProveedor;}
    public void setIdProveedor(String proveedor){idProveedor=proveedor;}
    
    public String getIdInsumo(){return idInsumo;}
    public void setIdInsumo(String insumo){idInsumo=insumo;}
        
    public int getCantidad(){return cantidad;}
    public void setCantidad(int cant){cantidad=cant;}
    
    public double getMonto(){return monto;}
    public void setMonto(double mon){monto=mon;}
    
    public String getCodigo(){return codigo;}
}
