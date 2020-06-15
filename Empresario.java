
/**
 * Write a description of class Empresarios here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empresario extends Proveedor 
{
    private String curp;
    
    Empresario(String nom,String id,String cup){
        super("Empo"+id,nom);
        curp=cup;
    }
    
    public void setCurp(String cup){curp=cup;}
    public String getCurp(){return curp;}
}
