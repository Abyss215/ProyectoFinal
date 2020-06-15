
/**
 * Write a description of class Inventario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Vector;
public class Inventario
{
    private Vector[] inveInsumo=new Vector[3];
    private Vector[] inveProductos=new Vector[4];
    
    Inventario(){
        inveProductos[0]=new Vector<Natural>(1,1);
        inveProductos[1]=new Vector<Cocida>(1,1);
        inveProductos[2]=new Vector<Esmaltada>(1,1);
        inveProductos[3]=new Vector<Terminado>(1,1);
        inveInsumo[0]=new Vector<Arcilla>(1,1);
        inveInsumo[1]=new Vector<Pintura>(1,1);
        inveInsumo[2]=new Vector<Esmalte>(1,1);
    }
    
    ///agreagar al inventario
    public void agregarProducto(Natural n){
        inveProductos[0].add(n);
    }
    public void agregarProducto(Cocida c){
        inveProductos[1].add(c);
    }
    public void agregarProducto(Esmaltada e){
        inveProductos[2].add(e);
    }
    public void agregarProducto(Terminado t){
        inveProductos[3].add(t);
    }
    
    public void agregarInsumo(Arcilla a){
        inveInsumo[0].add(a);
    }
    public void agregarInsumo(Pintura p){
        inveInsumo[1].add(p);
    }
    public void agregarInsumo(Esmalte e){
        inveInsumo[2].add(e);
    }
    
    ///quitar a l inventnario
    public void quitarProducto(Natural n){
        inveProductos[0].remove(n);
    }
    public void quitarProducto(Cocida c){
        inveProductos[1].remove(c);
    }
    public void quitarProducto(Esmaltada e){
        inveProductos[2].remove(e);
    }
    public void quitarProducto(Terminado t){
        inveProductos[3].remove(t);
    }
    
    public void quitarInsumo(Arcilla a){
        inveInsumo[0].remove(a);
    }
    public void quitarInsumo(Pintura p){
        inveInsumo[1].remove(p);
    }
    public void quitarInsumo(Esmalte e){
        inveInsumo[2].remove(e);
    }
    
    //obtener todo el inventario de 
    public Vector[] getInsumos(){return inveInsumo;}
    public Vector[] getProductos(){return inveProductos;}
    
    //obtener de la categoria
    public Vector<Natural> getNaturales(){return inveProductos[0];}
    public Vector<Cocida> getCocidos(){return inveProductos[1];}
    public Vector<Esmaltada> getEsmaltados(){return inveProductos[2];}
    public Vector<Terminado> getTerminados(){return inveProductos[3];}
    
    public Vector<Arcilla> getArcilla(){return inveInsumo[0];}
    public Vector<Pintura> getPinturas(){return inveInsumo[1];}
    public Vector<Esmalte> getEsmaltes(){return inveInsumo[2];}
    
    
    ///productosVenta
    
    public Vector<String> obtenerProductosTNombres(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Terminado> p=getTerminados();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getId());
        }
        return v;
    }
    
    public Terminado buscarProductoT(String id){
        Vector<Terminado> p=getTerminados();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().equals(id)) return p.get(i);
        }
        return null;
    }
}
