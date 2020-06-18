
/**
 * Write a description of class Vehiculo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
import java.util.Vector;
public class Vehiculo  implements Serializable{
    private String placas;
    private String color;
    private int ocupado=0;
    private Vector[] maletera=new Vector[2];
    private int capacidad;

    public Vehiculo(String plac,String col,int cant){
        placas=plac;
        color=col;
        capacidad=cant;
        maletera[0]=new Vector<Producto>(1,1);
        maletera[1]=new Vector<Integer>(1,1);
    }

    public void agregarMaletero(Producto p,int cant) throws Exception{
        if((capacidad-ocupado)<cant){
            throw new MiException("capacidad limitada solo caben"+(capacidad-ocupado));
        }else{
            ocupado+=cant;
            p.setCantidad(p.getCantidad()-cant);
            if(maletera[0].contains(p)){
                maletera[1].set(maletera[0].indexOf(p),(Integer)maletera[1].get(maletera[0].indexOf(p))+cant);
            }
            else{
                maletera[0].add(p);
                maletera[1].add(cant);
            }
        }
        
    }
    
    public Producto buscarProducto(String code){
        int x=0;
        while(x<maletera[0].size()){
            if(((Producto)maletera[0].get(x)).equals(code)){ 
                break;
            }
            x++;
        }
        return (Producto)maletera[0].get(x);
    }
    
    public int buscarIndex(String code){
        return (Integer)maletera[0].indexOf(buscarProducto(code));        
    }
    
    public void cargarMaletero(Vector<Producto> p,Vector<Integer> i) throws Exception{
        int x=0;
        while(x<p.size() && (p.get(x) instanceof Producto)){
            agregarMaletero(p.get(x),i.get(x));
            x++;
        }
    }
    
    public void descargarMaletera(){
        int i=0;
        while(i<maletera[0].size() && (maletera[0].get(i) instanceof Producto)){
            ((Producto)maletera[0].get(i)).setCantidad(((Producto)maletera[0].get(i)).getCantidad()+(Integer)maletera[1].get(i));
            i++;
        }
        maletera[0].removeAllElements();
        maletera[1].removeAllElements();
    }
    
    public Vector[] obtenerMaletera(){return maletera;}

    public String getPlaca(){return placas;}
    public String getColor(){return color;}
    public int getCapacidad(){return capacidad;}
    public int getOcupado(){return ocupado;}
    
    public void setPlaca(String plac){placas=plac;}
    public void setColor(String col){color=col;}
    public void setCapacidad(int cant){capacidad=cant;}
    public void setOcupado(int ocu){ocupado=ocu;}
}