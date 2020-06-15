
/**
 * Write a description of class MiExcepcion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiException extends Exception
{
    public MiException(String mess){
        super(mess);
    }
    
    public MiException(String mess,Exception e){
        super(mess,e);
    }
}
