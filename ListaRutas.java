
/**
 * Write a description of class ListaRutas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Vector;
public class ListaRutas
{
    private Vector<Ruta> lista=new Vector<Ruta>(1,1);
    
    public ListaRutas(){}
    
    public Vector<Ruta> getLista(){return lista;}
    
    public void agregarRuta(Ruta r){lista.add(r);}
    public void eliminarRuta(Ruta r){lista.remove(r);}
    
    
}
