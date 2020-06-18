
/**
 * Write a description of class Inventario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
import java.util.Vector;
public class Inventario implements Serializable
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
    public Vector<Cocida> getCocidas(){return inveProductos[1];}
    public Vector<Esmaltada> getEsmaltados(){return inveProductos[2];}
    public Vector<Terminado> getTerminados(){return inveProductos[3];}
    
    public Vector<Arcilla> getArcilla(){return inveInsumo[0];}
    public Vector<Pintura> getPinturas(){return inveInsumo[1];}
    public Vector<Esmalte> getEsmaltes(){return inveInsumo[2];}
    
    ///obtener todos los productos
    public Vector<Producto> obtenerProtuctosGeneral(){
        Vector<Producto> p=new Vector<Producto>(1,1);
        p.addAll(inveProductos[0]);
        p.addAll(inveProductos[1]);
        p.addAll(inveProductos[2]);
        p.addAll(inveProductos[3]);
        return p;
    }
    
    public Producto buscarGeneralID(String id) throws Exception{
        Vector<Producto> p=obtenerProtuctosGeneral();
        Producto n=null;
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().equals(id)){ n= p.get(i);break;}
        }
        if(n==null){
            throw new MiException("no encontrado");
        }else
        return n;
    }
    public Vector<String> obtenerGeneralPIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Producto> p=obtenerProtuctosGeneral();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getId());
        }
        return v;
    }
    // optener todos los insums
     public Vector<Insumo> obtenerInsumosGeneral(){
        Vector<Insumo> p=new Vector<Insumo>(1,1);
        p.addAll(inveInsumo[0]);
        p.addAll(inveInsumo[1]);
        p.addAll(inveInsumo[2]);
        return p;
    }
    
    public Insumo buscarGeneralInsID(String id) throws Exception{
        Vector<Insumo> p=obtenerInsumosGeneral();
        Insumo n=null;
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().equals(id)){ n= p.get(i);break;}
        }
        if(n==null){
            throw new MiException("no encontrado");
        }else
        return n;
    }
    public Vector<String> obtenerGeneralIIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Insumo> p=obtenerInsumosGeneral();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getId());
        }
        return v;
    }
    //produstos natural
    public Vector<String> obtenerNaturalIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Natural> p=getNaturales();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getId());
        }
        return v;
    }
    
    public Natural buscarNatural(String id) throws Exception{
        Vector<Natural> p=getNaturales();
        Natural n=null;
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().contains(id.replace(' ','_'))){ n= p.get(i);break;}
        }
        if(n==null){
            throw new MiException("no encontrado");
        }else
        return n;
    }
    
    //produstos Cocida
    public Vector<String> obtenerCocidasIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Cocida> p=getCocidas();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getId());
        }
        return v;
    }
    
    public Cocida buscarCocida(String id)throws Exception{
        Vector<Cocida> p=getCocidas();
        Cocida c=null;
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().contains(id.replace(' ','_'))){ c=p.get(i);break;}
        }
        if(c==null){
            throw new MiException("no encontrado");
        }else
        return c;
    }
    
    //produstos Esmaltada
    public Vector<String> obtenerEsmaltadosIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Esmaltada> p=getEsmaltados();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getId());
        }
        return v;
    }
    ///solo pintura
    public Vector<String> obtenerEsmaltadosPIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Esmaltada> p=getEsmaltados();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().contains("Pint")) v.add((p.get(i)).getId());
        }
        return v;
    }
    ///solo esmalte
    public Vector<String> obtenerEsmaltadosEIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Esmaltada> p=getEsmaltados();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().contains("Esma")) v.add((p.get(i)).getId());
        }
        return v;
    }
    
    public Esmaltada buscarEsmaltado(String id)throws Exception{
        Vector<Esmaltada> p=getEsmaltados();
        Esmaltada e=null;
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().contains(id.replace(' ','_'))){ e=p.get(i);break;}
        }
        if(e==null){
            throw new MiException("no encontrado");
        }else
        return e;
    }
    
    
    ///productos terminados o para venta
    
    public Vector<String> obtenerProductosTIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Terminado> p=getTerminados();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getId());
        }
        return v;
    }
    ///solo pintura
    public Vector<String> obtenerTerminadosPIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Terminado> p=getTerminados();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().contains("Pint")) v.add((p.get(i)).getId());
        }
        return v;
    }
    ///solo esmalte
    public Vector<String> obtenerTerminadosEIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Terminado> p=getTerminados();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().contains("Esma")) v.add((p.get(i)).getId());
        }
        return v;
    }
    public Terminado buscarProductoT(String id) throws Exception{
        Vector<Terminado> p=getTerminados();
        Terminado t=null;
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().equals(id)){ t= p.get(i);break;}
        }
        if(t==null){
            throw new MiException("no encontrado");
        }else
        return t;
    }
    /**insumo*/
    //arcilla
    public Vector<String> obtenerInsumosAIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Arcilla> p=getArcilla();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getId());
        }
        return v;
    }
    
    public Arcilla buscarInsumoA(String id) throws Exception{
        Vector<Arcilla> p=getArcilla();
        Arcilla a=null;
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().equals(id)){ a= p.get(i);break;}
        }
        if(a==null){
            throw new MiException("no encontrado");
        }else
        return a;
    }
    
    //pintura
    public Vector<String> obtenerInsumosPIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Pintura> p=getPinturas();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getId());
        }
        return v;
    }
    
    public Pintura buscarInsumoP(String id) throws Exception{
        Vector<Pintura> p=getPinturas();
        Pintura d=null;
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().equals(id)){ d= p.get(i);break;}
        }
        if(d==null){
            throw new MiException("no encontrado");
        }else
        return d;
    }
    
    //esmalte
    public Vector<String> obtenerInsumosEIds(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Esmalte> p=getEsmaltes();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getId());
        }
        return v;
    }
    
    public Esmalte buscarInsumoE(String id) throws Exception{
        Vector<Esmalte> p=getEsmaltes();
        Esmalte e=null;
        for(int i=0;i<p.size();i++){
            if(p.get(i).getId().equals(id)){ e= p.get(i);break;}
        }
        if(e==null){
            throw new MiException("no encontrado");
        }else
        return e;
    }
}
