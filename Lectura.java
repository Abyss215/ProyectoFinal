
/**
 * Write a description of class Lectura here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Vector;
import javax.swing.JOptionPane;
public class Lectura
{
    public Lectura(){}
    
    public String LString(String d){
        return JOptionPane.showInputDialog(null,d,"Lectura",JOptionPane.YES_NO_OPTION);
    }
    
    public Double LDouble(String d){
        try{
            return Double.parseDouble(JOptionPane.showInputDialog(null,d,"Lectura",JOptionPane.YES_NO_OPTION));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ingrese caracteres VALIDOS","ERROR",JOptionPane.ERROR_MESSAGE,null);
            return LDouble(d);
        }
    }
    
    public int LInteger(int i,int f,String d){
        try{
            int x= Integer.parseInt(JOptionPane.showInputDialog(null,d,"Lectura",JOptionPane.YES_NO_OPTION));
            if(x>f||x<i) throw new Exception();
            else return x;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"hubo un problema intentelo denuevo","ERROR",JOptionPane.ERROR_MESSAGE,null);
            return LInteger(i,f,d);
        }
    }
    public int LInteger(int c,String d){
        try{
            int x= Integer.parseInt(JOptionPane.showInputDialog(null,d,"Lectura",JOptionPane.YES_NO_OPTION));
            if(x>c) throw new Exception();
            else return x;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"hubo un problema intentelo denuevo","ERROR",JOptionPane.ERROR_MESSAGE,null);
            return LInteger(c,d);
        }
    }
    public int LInteger(String d){
        try{
            return Integer.parseInt(JOptionPane.showInputDialog(null,d,"Lectura",JOptionPane.YES_NO_OPTION));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"hubo un problema intentelo denuevo"+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
            return LInteger(d);
        }
    }
    
    public String[] obtenerArreglo(Vector<String> v){
        String[] s=new String[v.size()];
        for(int i=0;i<v.size();i++){
            s[i]=v.get(i);
        }
        return s;
    }
    
    public String seleccionar(String[] s,String d){
        return (String)JOptionPane.showInputDialog(null, d, "Lectura", JOptionPane.YES_NO_OPTION,null,s, s[0]);
    }
    
    public int opcion(String[] s,String d){
        return JOptionPane.showOptionDialog(null, d, "MENU", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, s, s[0]);
    }
    
    public String LFecha(){
        return LInteger(1,30,"Ingrese dia")+"/"+LInteger(1,12,"Ingrese mes")+"/"+LInteger(00,99,"Ingrese año(formato 00)");
    }
}
