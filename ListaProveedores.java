
/**
 * Write a description of class ListaProveedores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Vector;
public class ListaProveedores
{
    private Vector<Proveedor> lista=new Vector<Proveedor>(1,1);
    
    public ListaProveedores(){
        
    }
    
    public void agregarProveedor(Proveedor p){lista.add(p);}
    
    public void removerProveedor(Proveedor p){lista.remove(p);}
    
    public Vector<Proveedor> getLista(){return lista;}
}
