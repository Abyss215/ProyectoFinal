
/**
 * Write a description of class Empresa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public class Empresa extends Proveedor  implements Serializable
{
    private String repreID;
     
    Empresa(String nom,String rep){
        super("Empa"+nom.replace(' ','.'),nom);
        repreID=rep;
    }
    
    public void setRepresentante(String rep){
        repreID=rep;
    }
    
    public String  getRepresentante(){
        return repreID;
    }
    public String toString(){
        return " ID : "+id+"\n Nombre : "+nombre+"\n Representante : "+repreID;
    }
}
