
/**
 * Write a description of class Data here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Data
{
    
    public Data(){
    }
    
    public Object leerDato(String ruta)throws Exception{
        File data = new File(ruta); 
        Object o=null;
        if(!data.exists()){
            data.createNewFile();
            throw new Cancelar("no abrir");
        }
        try{
                FileInputStream leerAr= new FileInputStream(data);
                ObjectInputStream leer= new ObjectInputStream(leerAr);
                o = leer.readObject();
                leer.close();
        }catch(Exception e){
            e.printStackTrace();
            return o;
        }
        return o;
    }
    
    public void guardarDato(String ruta,Object dato){
        File data = new File(ruta); 
        try{
            if(!data.exists()){
                data.createNewFile();
            }
            FileOutputStream escriAr= new FileOutputStream(data);
            ObjectOutputStream escri= new ObjectOutputStream(escriAr);
            escri.writeObject(dato);
            escri.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
