
/**
 * Write a description of class ListaProveedores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
import java.util.Vector;
public class ListaProveedores implements Serializable
{
    private Vector<Proveedor> lista=new Vector<Proveedor>(1,1);
    
    public ListaProveedores(){
        
    }
    
    public void agregarProveedor(Proveedor p){lista.add(p);}
    
    public void removerProveedor(Proveedor p){lista.remove(p);}
    
    public Vector<Proveedor> getLista(){return lista;}
    
    public Vector<String> obtenerProveedoresNombres(){
        Vector<String> v=new Vector<String>(1,1);
        for(int i=0;i<lista.size();i++){
            v.add((lista.get(i)).getNombre());
        }
        return v;
    }
    
    public Proveedor buscarProveedor(String nom)throws Exception{
        Proveedor p=null;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getNombre().equals(nom)) p= lista.get(i);
        }
        if(p==null){
            throw new MiException("no se a encontrado nada");
        }else
        return p;
    }
    
    public Proveedor buscarProveedorID(String id)throws Exception{
        Proveedor p=null;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getId().equals(id)) p= lista.get(i);
        }
        if(p==null){
            throw new MiException("no se a encontrado nada");
        }else
        return p;
    }
    
    public Proveedor buscarProveedorCurp(String cu)throws Exception{
        Proveedor p=null;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i) instanceof Empresario) if(((Empresario)lista.get(i)).getCurp().equals(cu)) p= lista.get(i);
        }
        if(p==null){
            throw new MiException("no se a encontrado nada");
        }else
        return p;
    }
    
    public Proveedor buscarProveedorRepre(String r)throws Exception{
        Proveedor p=null;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i) instanceof Empresa) if(((Empresa)lista.get(i)).getRepresentante().equals(r)) p= lista.get(i);
        }
        if(p==null){
            throw new MiException("no se a encontrado nada");
        }else
        return p;
    }
}
