
/**
 * Write a description of class Ejecutacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Ejecutacion
{
    
    public static void main(String [] args){
        try{
            Lectura l=new Lectura();
            Data d=new Data();
            ListaProveedores lPro=new ListaProveedores();
            RegistroTransacciones rt=new RegistroTransacciones();
            ListaPersonas lPer=new ListaPersonas();
            ListaClientes lCli=new ListaClientes();
            ListaVehiculos lVeh=new ListaVehiculos();
            ListaRutas lRut=new ListaRutas();
            Inventario inv=new Inventario();
            
            String[] op={"Clases","Ventas","Compras","Produccion","Reportes","Salir"};
            
            
            switch (l.opcion(op,"MEnu Principal")){
                case 0: String[] cl={"Trabajador","Cliente","Proveedor","Productos","Salir"};
                        String[] ac={"Agregar","Eliminar","Buscar","Ver","Salir"};
                        switch(l.opcion(cl,"Clases")){
                            case 0: //persona
                                    String[] t={"Gerente","Alfarero Maestro","Alfarero Estudiante","Cocinero","Esmaltador","Repartidor","Representante Legal"};
                                    switch(l.opcion(ac,"Acciones")){                                
                                        case 0: 
                                                switch(l.seleccionar(t,"Tipo")){//agregar
                                                    case "Gerente": lPer.agregarPersona(new Gerente(l.LString("Nombre")));
                                                    break;
                                                    case "Alfarero Maestro": lPer.agregarPersona(new Maestro(l.LString("Horario"),l.LString("Nombre"),l.LDouble("Sueldo Semanal")));
                                                    break;
                                                    case "Alfarero Estudiante": lPer.agregarPersona(new Estudiante(l.LInteger("Horas de Trabajo"),l.LString("Nombre")));
                                                    break;
                                                    case "Cocinero": lPer.agregarPersona(new Cocinero(l.LString("Nombre"),l.LDouble("Sueldo semanal")));
                                                    break;
                                                    case "Esmaltador": lPer.agregarPersona(new Esmaltador(l.LString("Nombre"),l.LDouble("Sueldo semanal")));
                                                    break;
                                                    case "Repartidor": lPer.agregarPersona(new Repartidor(l.LString("Nombre"),l.LString("codigo de licencias de concducir")));
                                                    break;
                                                    case "Representante Legal": lPer.agregarPersona(new Representante_legal(l.LString("Nombre")));;
                                                    break;
                                                }
                                        break;
                                        case 1: switch(l.seleccionar(t,"Tipo")){///eliminar
                                                    case "Gerente": lPer.eliminarPersonas(lPer.buscarGerente(l.seleccionar(l.obtenerArreglo(lPer.obtenerGerentesNombres()),"Seleccione Gerente a eliminar")));
                                                    break;
                                                    case "Alfarero Maestro": lPer.eliminarPersonas(lPer.buscarMaestro(l.seleccionar(l.obtenerArreglo(lPer.obtenerMaestrosNombres()),"Seleccione Maestro a eliminar")));
                                                    break;
                                                    case "Alfarero Estudiante": lPer.eliminarPersonas(lPer.buscarEstudiante(l.seleccionar(l.obtenerArreglo(lPer.obtenerEstudiantesNombres()),"Seleccione Estudiante a eliminar")));
                                                    break; 
                                                    case "Cocinero": lPer.eliminarPersonas(lPer.buscarCocinero(l.seleccionar(l.obtenerArreglo(lPer.obtenerCocinerosNombres()),"Seleccione Cocinero a eliminar")));
                                                    break;
                                                    case "Esmaltador": lPer.eliminarPersonas(lPer.buscarEsmaltador(l.seleccionar(l.obtenerArreglo(lPer.obtenerEsmaltadoresNombres()),"Seleccione Esmaltador a eliminar")));
                                                    break;
                                                    case "Repartidor": lPer.eliminarPersonas(lPer.buscarRepartidor(l.seleccionar(l.obtenerArreglo(lPer.obtenerRepartidoresNombres()),"Seleccione Repartidor a eliminar")));
                                                    break;
                                                    case "Representante Legal": lPer.eliminarPersonas(lPer.buscarRepresentante(l.seleccionar(l.obtenerArreglo(lPer.obtenerRepresentantesNombres()),"Seleccione Representante a eliminar")));
                                                    break;
                                                }
                                        break;
                                        case 2:///buscar
                                                String[] bus={"Nombre","tipo","clave"};
                                        break;
                                        case 3: //ver
                                                String tx;
                                                switch(l.seleccionar(t,"Tipo")){///ver
                                                    case "Gerente": tx=lPer.buscarGerente(l.seleccionar(l.obtenerArreglo(lPer.obtenerGerentesNombres()),"Seleccione Gerente a eliminar")).toString();
                                                    break;
                                                    case "Alfarero Maestro": tx=lPer.buscarMaestro(l.seleccionar(l.obtenerArreglo(lPer.obtenerMaestrosNombres()),"Seleccione Maestro a eliminar")).toString();
                                                    break;
                                                    case "Alfarero Estudiante": tx=lPer.buscarEstudiante(l.seleccionar(l.obtenerArreglo(lPer.obtenerEstudiantesNombres()),"Seleccione Estudiante a eliminar")).toString();
                                                    break; 
                                                    case "Cocinero": tx=lPer.buscarCocinero(l.seleccionar(l.obtenerArreglo(lPer.obtenerCocinerosNombres()),"Seleccione Cocinero a eliminar")).toString();
                                                    break;
                                                    case "Esmaltador": tx=lPer.buscarEsmaltador(l.seleccionar(l.obtenerArreglo(lPer.obtenerEsmaltadoresNombres()),"Seleccione Esmaltador a eliminar")).toString();
                                                    break;
                                                    case "Repartidor": tx=lPer.buscarRepartidor(l.seleccionar(l.obtenerArreglo(lPer.obtenerRepartidoresNombres()),"Seleccione Repartidor a eliminar")).toString();
                                                    break;
                                                    case "Representante Legal": tx=lPer.buscarRepresentante(l.seleccionar(l.obtenerArreglo(lPer.obtenerRepresentantesNombres()),"Seleccione Representante a eliminar")).toString();
                                                    break;
                                                    default: tx="No se encontro nada..intente denuevo";
                                                }
                                                JOptionPane.showMessageDialog(null,tx,"Info",JOptionPane.INFORMATION_MESSAGE,null);
                                        break;
                                    }
                            break;
                            case 1: ///cliente
                                        switch(l.opcion(ac,"Acciones")){
                                        case 0: //lCli.agregar;
                                        break;
                                        case 1: ;
                                        break;
                                        case 2: ;
                                        break;
                                        case 3: ;
                                        break;
                                    }
                            break;
                            case 2: //proveedor
                                    switch(l.opcion(ac,"Acciones")){
                                        case 0: ;
                                        break;
                                        case 1: ;
                                        break;
                                        case 2: ;
                                        break;
                                        case 3: ;
                                        break;
                                    }
                            break;
                            case 3: //producto
                                        switch(l.opcion(ac,"Acciones")){
                                        case 0: ;
                                        break;
                                        case 1: ;
                                        break;
                                        case 2: ;
                                        break;
                                        case 3: ;
                                        break;
                                    }
                            break;
                        }
                break;
                case 1: rt.agregarVenta(new Venta(l.LFecha(),lCli.buscarCliente(l.seleccionar(l.obtenerArreglo(lCli.obtenerClientesNombres()),"Seleccione Cliente")).getId(),l.seleccionar(l.obtenerArreglo(inv.obtenerProductosTNombres()),"Seleccione Produccto"),lPer.buscarRepartidor(l.seleccionar(l.obtenerArreglo(lPer.obtenerRepartidoresNombres()),"Seleccione vendedor")).getId(),l.LInteger(1,1000,"Cantidad A vender"),l.LString("Codigo de identificacion")));
                break;
                case 2: ;
                break;
                case 3: ;
                break;
                case 4: ;
                break;
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR:"+e.getMessage(),"ERROR",JOptionPane.DEFAULT_OPTION,null);
        }
    }
}
