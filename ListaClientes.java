
/**
 * Write a description of class ListaClientes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
import java.util.Vector;
public class ListaClientes implements Serializable
{
    private Vector<Cliente> lista=new Vector<Cliente>(1,1);
    
    public ListaClientes(){}
    
    public void anadirCliente(Cliente clien){lista.add(clien);}
    
    public void eliminarCliente(Cliente clien,ListaRutas lr){
        lista.remove(clien);
        for(int x=0;x<lr.getLista().size();x++){
            lr.getLista().get(x).eliminarClienteRuta(clien);
        }
    }
    
    public Vector<Cliente> getLista(){return lista;}
    
    //Cliente
    public Vector<String> obtenerClientesNombres(){
        Vector<String> v=new Vector<String>(1,1);
        for(int i=0;i<lista.size();i++){
            v.add((lista.get(i)).getNombre());
        }
        return v;
    }
    
    public Cliente buscarCliente(String nom)throws Exception{
        Cliente c=null;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getNombre().equals(nom)) c= lista.get(i);
        }
        if(c==null){
            throw new MiException("no se a encontrado nada");
        }else
        return c;
    }
    
    public Cliente buscarClienteID(String id)throws Exception{
        Cliente c=null;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getId().equals(id)) c= lista.get(i);
        }
        if(c==null){
            throw new MiException("no se a encontrado nada");
        }else
        return c;
    }
}
