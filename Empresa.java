
/**
 * Write a description of class Empresa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empresa extends Proveedor 
{
    private Representante_legal repre;
     
    Empresa(String id,String nom,Representante_legal rep){
        super("Empa"+id,nom);
        repre=rep;
    }
    
    public void setRepresentante(Representante_legal rep){
        repre=rep;
    }
    
    public Representante_legal getRepresentante(){
        return repre;
    }
}
