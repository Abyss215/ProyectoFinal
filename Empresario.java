
/**
 * Write a description of class Empresarios here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Empresario extends Proveedor  implements Serializable
{
    private String curp;
    
    Empresario(String nom,String cup){
        super("Empo"+nom.replace(' ','.'),nom);
        curp=cup;
    }
    
    public void setCurp(String cup){curp=cup;}
    public String getCurp(){return curp;}
    
    public String toString(){
        return " ID : "+id+"\n Nombre : "+nombre+"\n Curp : "+curp;
    }
}
