
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
        return JOptionPane.showInputDialog(null,d,"Lectura",JOptionPane.QUESTION_MESSAGE);
    }
    
    public Double LDouble(String d) throws Exception{
        try{
            return Double.parseDouble(JOptionPane.showInputDialog(null,d,"Lectura",JOptionPane.QUESTION_MESSAGE));
        }catch(Exception e){
            if(e.getMessage().contains("null"))throw new Cancelar("cancelar");
            else{
                JOptionPane.showMessageDialog(null,"Ingrese caracteres VALIDOS","ERROR",JOptionPane.ERROR_MESSAGE,null);
                return LDouble(d);
            }
        }
    }
    
    public int LInteger(int i,int f,String d)throws Exception{
        try{
            int x= Integer.parseInt(JOptionPane.showInputDialog(null,d,"Lectura",JOptionPane.QUESTION_MESSAGE));
            if(x>f||x<i) throw new MiException("ingrese valor dentro del rango("+i+","+f+")");
            else return x;
        }catch(MiException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
            return LInteger(i,f,d);
        }catch(NumberFormatException e){
            if(e.getMessage().contains("null"))throw new Cancelar("cancelar");
            else{
                JOptionPane.showMessageDialog(null,"hubo un problema intentelo denuevo,Revise q sean caracteres admitidos como numeros","ERROR",JOptionPane.ERROR_MESSAGE,null);
                return LInteger(i,f,d);
            }
        }
    }
    // public int LInteger(int c,String d){
        // try{
            // int x= Integer.parseInt(JOptionPane.showInputDialog(null,d,"Lectura",JOptionPane.QUESTION_MESSAGE));
            // if(x>c) throw new MiException("");
            // else return x;
        // }catch(MiException e){
            // JOptionPane.showMessageDialog(null,"hubo un problema intentelo denuevo","ERROR",JOptionPane.ERROR_MESSAGE,null);
            // return LInteger(c,d);
        // }
    // }
    public int LInteger(String d)throws Exception{
        try{
                int i=Integer.parseInt(JOptionPane.showInputDialog(null,d,"Lectura",JOptionPane.QUESTION_MESSAGE));
        }catch(NumberFormatException e){
            if(e.getMessage().contains("null"))throw new Cancelar("cancelar");
            else{
                JOptionPane.showMessageDialog(null,"hubo un problema intentelo denuevo,Revise q sean caracteres admitidos como numeros"+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                return LInteger(d);
            }
        }
        return 0;
    }
    
    public boolean LBoolean(String s){
        int resp = JOptionPane.showConfirmDialog(null, s,"Lectura",JOptionPane.YES_NO_OPTION);
        if(resp==0)return true;
        else return false;
    }
    
    public String[] obtenerArreglo(Vector<String> v) throws Exception{
        if(v.size()==0){
            throw new MiException("no hay nada para elegir, intente agregar datos antes");
        }else{
            String[] s=new String[v.size()];
            for(int i=0;i<v.size();i++){
                s[i]=v.get(i);
            }
            return s;
        }
    }
    
    public String seleccionar(String[] s,String d){
        return (String)JOptionPane.showInputDialog(null, d, "Lectura", JOptionPane.YES_NO_OPTION,null,s, s[0]);
    }
    
    public int opcion(String[] s,String d){
        return JOptionPane.showOptionDialog(null, d, "MENU", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, s, s[0]);
    }
    
    public String LFecha()throws Exception{
        return LInteger(1,30,"Ingrese dia")+"/"+LInteger(1,12,"Ingrese mes")+"/"+LInteger(00,99,"Ingrese año(formato 00)");
    }
    public String LFecha(String s)throws Exception{
        return LInteger(1,30,"Ingrese dia "+s)+"/"+LInteger(1,12,"Ingrese mes "+s)+"/"+LInteger(00,99,"Ingrese año(formato 00) "+s);
    }
}
