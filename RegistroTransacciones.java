
/**
 * Write a description of class RegistroTransaccciones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
import java.util.Vector;
public class RegistroTransacciones implements Serializable
{
    private Vector<Venta> listaVentas=new Vector<Venta>(1,1);
    private Vector<Compra> listaCompras=new Vector<Compra>(1,1);
    
    public RegistroTransacciones(){}
    
    public void agregarVenta(Venta v){listaVentas.add(v);}
    public void agregarCompra(Compra c){listaCompras.add(c);}
    
    public void agregarVentas(Vector<Venta> v){listaVentas.addAll(v);}
    public void agregarCompras(Vector<Compra> c){listaCompras.addAll(c);}
    
    public void removerVenta(Venta v){listaVentas.remove(v);}
    public void removerCompra(Compra c){listaCompras.remove(c);}
    
    public Vector<Venta> getListaVentas(){return listaVentas;}
    public Vector<Compra> getListaCompras(){return listaCompras;}
    
    ///entas busquedas
    
    public Vector<Venta> buscarFechaV(String fecha){
        Vector<Venta> v=new Vector<Venta>(1,1);
        for(int i=0;i<listaVentas.size();i++){
            if(listaVentas.get(i).getCodigo().contains(fecha.replace('/','.'))){
                v.add(listaVentas.get(i));
            }
        }
        return v;
    }
    
    public Vector<Venta> buscarFechaV(String fecha,String fecha2){
        Vector<Venta> v=new Vector<Venta>(1,1);
        if(fecha.equals(fecha2)) v=buscarFechaV(fecha);
        else{
            int d1=Integer.parseInt(fecha.substring(0,1)),m1=Integer.parseInt(fecha.substring(3,4)),a1=Integer.parseInt(fecha.substring(6,7));
            int d2=Integer.parseInt(fecha2.substring(0,1)),m2=Integer.parseInt(fecha2.substring(3,4)),a2=Integer.parseInt(fecha2.substring(6,7));
            if(a1<a2||(a1==a2&&m1<m2)||(a1==a2&&m1==m2&&d1<d2))
            do{
                for(int i=0;i<listaVentas.size();i++){
                    if(listaVentas.get(i).getCodigo().contains(d1+"."+m1+"."+a1)){
                        v.add(listaVentas.get(i));
                    }
                }
                d1++;
                if(d1>31){d1=1; m1++;}
                if(m1>12){m1=1; a1++;}
            }while(d1!=d2&&m1!=m2&&a1!=a2);
        }
        return v;
    }
    
    public Vector<Venta> buscarClienteV(String code){
        Vector<Venta> v=new Vector<Venta>(1,1);
        for(int i=0;i<listaVentas.size();i++){
            if(listaVentas.get(i).getIdCliente().contains(code)){
                v.add(listaVentas.get(i));
            }
        }
        return v;
    }
    
    public Vector<Venta> buscarVendedorV(String code){
        Vector<Venta> v=new Vector<Venta>(1,1);
        for(int i=0;i<listaVentas.size();i++){
            if(listaVentas.get(i).getIdVendedor().contains(code)){
                v.add(listaVentas.get(i));
            }
        }
        return v;
    }
    
    public Vector<Venta> buscarProductoV(String code){
        Vector<Venta> v=new Vector<Venta>(1,1);
        for(int i=0;i<listaVentas.size();i++){
            if(listaVentas.get(i).getIdProducto().contains(code)){
                v.add(listaVentas.get(i));
            }
        }
        return v;
    }
    
    
    ///compras busqueda
    
    public Vector<Compra> buscarFechaC(String fecha){
        Vector<Compra> c=new Vector<Compra>(1,1);
        for(int i=0;i<listaCompras.size();i++){
            if(listaCompras.get(i).getCodigo().contains(fecha.replace('/','.'))){
                c.add(listaCompras.get(i));
            }
        }
        return c;
    }
    
    public Vector<Compra> buscarFechaC(String fecha,String fecha2){
        Vector<Compra> c=new Vector<Compra>(1,1);
        if(fecha.equals(fecha2)) c=buscarFechaC(fecha);
        else{
            int d1=Integer.parseInt(fecha.substring(0,1)),m1=Integer.parseInt(fecha.substring(3,4)),a1=Integer.parseInt(fecha.substring(6,7));
            int d2=Integer.parseInt(fecha2.substring(0,1)),m2=Integer.parseInt(fecha2.substring(3,4)),a2=Integer.parseInt(fecha2.substring(6,7));
            if(a1<a2||(a1==a2&&m1<m2)||(a1==a2&&m1==m2&&d1<d2))
            do{
                for(int i=0;i<listaCompras.size();i++){
                    if(listaCompras.get(i).getCodigo().contains(d1+"."+m1+"."+a1)){
                        c.add(listaCompras.get(i));
                    }
                }
                d1++;
                if(d1>31){d1=1; m1++;}
                if(m1>12){m1=1; a1++;}
            }while(d1!=d2&&m1!=m2&&a1!=a2);
        }
        return c;
    }
    
    public Vector<Compra> buscarInsumoC(String code){
        Vector<Compra> c=new Vector<Compra>(1,1);
        for(int i=0;i<listaCompras.size();i++){
            if(listaCompras.get(i).getIdInsumo().contains(code)){
                c.add(listaCompras.get(i));
            }
        }
        return c;
    }
    
    public Vector<Compra> buscarProveedorC(String code){
        Vector<Compra> c=new Vector<Compra>(1,1);
        for(int i=0;i<listaCompras.size();i++){
            if(listaCompras.get(i).getIdProveedor().contains(code)){
                c.add(listaCompras.get(i));
            }
        }
        return c;
    }
    
    public String toString(Vector v){
        String s="";
        for(int i=0;i<v.size();i++){
            s+=v.get(i).toString()+"\n\t----------\n";
        }
        return s;
    }
}
