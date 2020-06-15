
/**
 * Write a description of class ListaVehiculos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Vector;
public class ListaVehiculos
{
    private Vector<Vehiculo> lista=new Vector<Vehiculo>(1,1);
    
    public ListaVehiculos(){}
    
    public void agregarVehiculo(Vehiculo v){lista.add(v);}
    
    public void removerVehiculo(Vehiculo v){lista.remove(v);}
    
    public Vector<Vehiculo> getLista(){return lista;}
}
