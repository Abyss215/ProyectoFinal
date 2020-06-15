
/**
 * Write a description of class Producto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Producto
{
    protected int cantidad;
    protected String tipo;
    protected String id;
    
    
    Producto(int cant,String code,String tip){
      cantidad=cant;
      id="Prod"+code;
      tipo=tip;
    }
    
    
    public void setCantidad(int cant){
        cantidad=cant;
    }
    public int getCantidad(){
        return cantidad;
    }
    
    public void setTipo(String tip){
        tipo=tip;
    }
    public String getTipo(){
        return tipo;
    }
    
    public void setId(String code){
        id=code;
    }
    public String getId(){
        return id;
    }
}
