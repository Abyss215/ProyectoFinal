
/**
 * Write a description of class Ruta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Vector;
public class Ruta
{
    private Vector<Cliente> establecimientos=new Vector<Cliente>(1,1);
    private String nombre;
    private String id;
    private Vector<String> repartidoresAsig=new Vector<String>(1,1);
    
    public Ruta(String nombre){
        this.nombre=nombre;
        id="Rut"+nombre.replace(' ','_');
    }
    
    public Ruta(String nombre,String r){
        this.nombre=nombre;
        id="Rut"+nombre.replace(' ','_');
        repartidoresAsig.add(r);
    }
    
    public Vector<String> obtenerRepartidores(){return repartidoresAsig;}
    public void asignarRepartidor(String r){
        repartidoresAsig.add(r);
    }
    public void eliminarRepartidor(String r){
        repartidoresAsig.remove(repartidoresAsig.indexOf(r));
    } 
    
    public void setNombre(String nom){
        nombre=nom;
    }
    public void setId(String code){
        id=code;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getId(){
        return id;
    }
    
    public void agregarClientes(Vector<Cliente> listaCliente){
        establecimientos.addAll(listaCliente);
    }
    public void agregarCliente(Cliente c){
        establecimientos.add(c);
    }
    public void eliminarClienteRuta(Cliente clien){
        establecimientos.remove(clien);
    }
    
    public Vector<Cliente> getLocales(){return establecimientos;}
    
    public Cliente buscarCliente(String code){
        int x=0;
        while(x<establecimientos.size() && (establecimientos.get(x) instanceof Cliente)){
            if(establecimientos.get(x).getId().equals(code)) return establecimientos.get(x);
            x++;
        }
        return null;
    }
}
