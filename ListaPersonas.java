
/**
 * Write a description of class ListaTrabajadores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
import java.util.Vector;
public class ListaPersonas implements Serializable
{
    private Vector[] lista=new Vector[6];
    
    public ListaPersonas(){
        lista[0]=new Vector<Alfarero>(1,1);
        lista[1]=new Vector<Cocinero>(1,1);
        lista[2]=new Vector<Esmaltador>(1,1);
        lista[3]=new Vector<Repartidor>(1,1);
        lista[4]=new Vector<Gerente>(1,1);
        lista[5]=new Vector<Representante_legal>(1,1);        
    }
    
    public void agregarPersona(Alfarero a){
        lista[0].add(a);
    }
    public void agregarPersona(Cocinero c ){
        lista[1].add(c);
    }
    public void agregarPersona(Esmaltador e){
        lista[2].add(e);
    }
    public void agregarPersona(Repartidor r){
        lista[3].add(r);
    }
    public void agregarPersona(Gerente g){
        lista[4].add(g);
    }
    public void agregarPersona(Representante_legal rl){
        lista[5].add(rl);
    }
    
    public Vector<Alfarero> getListaAlfareros(){return lista[0];}
    public Vector<Cocinero> getListaCocineros(){return lista[1];}
    public Vector<Esmaltador> getListaEsmaltadores(){return lista[2];}
    public Vector<Repartidor> getListaRepartidores(){return lista[3];}
    public Vector<Gerente> getListaGerentes(){return lista[4];}
    public Vector<Representante_legal> getListaRepresentantes(){return lista[5];}
    
    //vector completo con todo junto
    public Vector<Persona> getPersonas(){
        Vector<Persona> p=new Vector(1,1);
        p.addAll(getListaGerentes());
        p.addAll(getListaAlfareros());
        p.addAll(getListaCocineros());
        p.addAll(getListaEsmaltadores());
        p.addAll(getListaRepartidores());
        p.addAll(getListaRepresentantes());
        return p;
    }
    
    //eliminar
    public void eliminarPersonas(Alfarero a){
        lista[0].remove(a);
    }
    public void eliminarPersonas(Cocinero c ){
        lista[1].remove(c);
    }
    public void eliminarPersonas(Esmaltador e){
        lista[2].remove(e);
    }
    public void eliminarPersonas(Repartidor r){
        lista[3].remove(r);
    }
    public void eliminarPersonas(Gerente g){
        lista[4].remove(g);
    }
    public void eliminarPersonas(Representante_legal rl){
        lista[5].remove(rl);
    }
    
    ///obtener
    public Vector<Maestro> obtenerAlfareroMaestro(){
        Vector<Maestro> v=new Vector<Maestro>(1,1);
        Vector<Alfarero> g=lista[0];
        for(int i=0;i<g.size();i++){
            if(g.get(i) instanceof Maestro) v.add((Maestro)g.get(i));
        }
        return v;
    }
    public Vector<Estudiante> obtenerAlfareroEstudiante(){
        Vector<Estudiante> v=new Vector<Estudiante>(1,1);
        Vector<Alfarero> g=lista[0];
        for(int i=0;i<g.size();i++){
            if(g.get(i) instanceof Estudiante) v.add((Estudiante)g.get(i));
        }
        return v;
    }
    
    /////busquedas y filtro
    //nombre
    public Persona buscarNombre(String nom)throws Exception{
        Persona p=null;
        for(int i=0;i<6||p!=null;i++){
            for(int j=0;i<lista[i].size();j++){
                if(((Persona)lista[i].get(j)).getNombre().equals(nom)) {p=(Persona)lista[i].get(j); break;}
            }
        }
        if(p==null){
            throw new MiException("no se a encontrado nada");
        }else
        return p;
    }
    
    ///id
    public Persona buscarId(String id)throws Exception{
        Persona p=null;
        for(int i=0;i<6||p!=null;i++){
            for(int j=0;i<lista[i].size();j++){
                if(((Persona)lista[i].get(j)).getId().equals(id)) {p=(Persona)lista[i].get(j); break;}
            }
        }
        if(p==null){
            throw new MiException("no se a encontrado nada");
        }else
        return p;
    }
    ///////
    //gerete
    public Vector<String> obtenerGerentesNombres(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Gerente> g=lista[4];
        for(int i=0;i<g.size();i++){
            v.add(g.get(i).getNombre());
        }
        return v;
    }
    
    public Gerente buscarGerente(String nom){
        Vector<Gerente> p=lista[4];
        for(int i=0;i<p.size();i++){
            if(p.get(i).getNombre().equals(nom)) return p.get(i);
        }
        return null;
    }
    
    //alfarero
    //Alfarero
    public Vector<String> obtenerAlfareroNombres(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Alfarero> g=getListaAlfareros();
        for(int i=0;i<g.size();i++){
            v.add(g.get(i).getNombre());
        }
        return v;
    }
    
    public Alfarero buscarAlfarero(String nom){
        Vector<Alfarero> p=getListaAlfareros();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getNombre().equals(nom)) return p.get(i);
        }
        return null;
    }
    //maestro
    public Vector<String> obtenerMaestrosNombres(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Maestro> p=obtenerAlfareroMaestro();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getNombre());
        }
        return v;
    }
    
    public Maestro buscarMaestro(String nom){
        Vector<Maestro> p=obtenerAlfareroMaestro();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getNombre().equals(nom)) return p.get(i);
        }
        return null;
    }
    //Estudiante
    public Vector<String> obtenerEstudiantesNombres(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Estudiante> p=obtenerAlfareroEstudiante();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getNombre());
        }
        return v;
    }
    
    public Estudiante buscarEstudiante(String nom){
        Vector<Estudiante> p=obtenerAlfareroEstudiante();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getNombre().equals(nom)) return p.get(i);
        }
        return null;
    }
    
    
    ///cocinero
    public Vector<String> obtenerCocinerosNombres(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Cocinero> p=getListaCocineros();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getNombre());
        }
        return v;
    }
    
    public Cocinero buscarCocinero(String nom){
        Vector<Cocinero> p=getListaCocineros();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getNombre().equals(nom)) return p.get(i);
        }
        return null;
    }
    
    ///Esmaltadores
    public Vector<String> obtenerEsmaltadoresNombres(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Esmaltador> p=getListaEsmaltadores();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getNombre());
        }
        return v;
    }
    
    public Esmaltador buscarEsmaltador(String nom){
        Vector<Esmaltador> p=getListaEsmaltadores();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getNombre().equals(nom)) return p.get(i);
        }
        return null;
    }
    
    //Repartidor
    public Vector<String> obtenerRepartidoresNombres(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Repartidor> p=getListaRepartidores();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getNombre());
        }
        return v;
    }
    
    public Repartidor buscarRepartidor(String nom){
        Vector<Repartidor> p=getListaRepartidores();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getNombre().equals(nom)) return p.get(i);
        }
        return null;
    }
    
    
    ////Representante
    public Vector<String> obtenerRepresentantesNombres(){
        Vector<String> v=new Vector<String>(1,1);
        Vector<Representante_legal> p=getListaRepresentantes();
        for(int i=0;i<p.size();i++){
            v.add((p.get(i)).getNombre());
        }
        return v;
    }
    
    public Representante_legal buscarRepresentante(String nom){
        Vector<Representante_legal> p=getListaRepresentantes();
        for(int i=0;i<p.size();i++){
            if(p.get(i).getNombre().equals(nom)) return p.get(i);
        }
        return null;
    }
    
    
    
    ////toString
    public String toString(){
        String p="";
        for(int i=0;i<6;i++){
            for(int j=0;i<lista[i].size();j++){
                p+=lista[i].get(j).toString()+"\n";
            }
            p+="\n";
        }
        return p;
    }
    public String toString(Vector v){
        String p="";
        for(int i=0;i<6;i++){
            for(int j=0;i<v.size();j++){
                p+=v.get(j).toString()+"\n";
            }
            p+="\n";
        }
        return p;
    }
}



