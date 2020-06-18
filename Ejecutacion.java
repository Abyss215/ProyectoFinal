

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
        
        Lectura l=new Lectura();
        Data d=new Data();
        ListaProveedores lPro=new ListaProveedores();
        RegistroTransacciones rt=new RegistroTransacciones();
        ListaPersonas lPer=new ListaPersonas();
        ListaClientes lCli=new ListaClientes();
        ListaVehiculos lVeh=new ListaVehiculos();///
        ListaRutas lRut=new ListaRutas();///
        Inventario inv=new Inventario();
        try{
            //recuperar informacion
            lPro=(ListaProveedores)d.leerDato("listaProdveedor.txt");
            rt=(RegistroTransacciones)d.leerDato("listaTransaccion.txt");
            lPer=(ListaPersonas)d.leerDato("listaPersonas.txt");
            lCli=(ListaClientes)d.leerDato("listaClientes.txt");
            lVeh=(ListaVehiculos)d.leerDato("listaVehiculos.txt");
            lRut=(ListaRutas)d.leerDato("listaRutas.txt");
            inv=(Inventario)d.leerDato("inventario.txt");
        }catch(Exception e){
        }
        play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
        
        //guardar todos los cambios
        d.guardarDato("listaProdveedor.txt",lPro);
        d.guardarDato("listaTransaccion.txt",rt);
        d.guardarDato("listaPersonas.txt",lPer);
        d.guardarDato("listaClientes.txt",lCli);
        d.guardarDato("listaVehiculos.txt",lVeh);
        d.guardarDato("listaRutas.txt",lRut);
        d.guardarDato("inventario.txt",inv);
        
        JOptionPane.showMessageDialog(null,"Guardando archivos...guardados correctamente");
    }
    
    public static void play(Lectura l,Data d,ListaProveedores lPro,RegistroTransacciones rt,ListaPersonas lPer,ListaClientes lCli,ListaVehiculos lVeh,ListaRutas lRut,Inventario inv){
        try{
            
            String[] op={"Clases","Ventas","Compras","Produccion","Reportes","Salir"};
            
            
            switch (l.opcion(op,"MEnu Principal")){
                case 0: String[] cl={"Trabajador","Cliente","Proveedor","Inventario","Salir"};
                        String[] ac={"Agregar","Eliminar","Buscar","Ver","MENU"};
                        switch(l.opcion(cl,"Clases")){
                            case 0: //persona
                                    String[] t={"Gerente","Alfarero Maestro","Alfarero Estudiante","Cocinero","Esmaltador","Repartidor","Representante Legal","MENU"};
                                    switch(l.opcion(ac,"Acciones")){                                
                                        case 0: try{
                                                switch(l.seleccionar(t,"Tipo")){//agregar
                                                    case "Gerente": lPer.agregarPersona(new Gerente(l.LString("Nombre")));
                                                    break;
                                                    case "Alfarero Maestro": lPer.agregarPersona(new Maestro(l.LString("Horario"),l.LString("Nombre"),l.LDouble("Sueldo Semanal")));
                                                    break;
                                                    case "Alfarero Estudiante": lPer.agregarPersona(new Estudiante(l.LInteger("Horas de Trabajo"),l.LString("Nombre")));
                                                    break;
                                                    case "Cocinero": lPer.agregarPersona(new Cocinero(l.LString("Nombre"),l.LDouble("Sueldo semanal")));
                                                    break;
                                                    case "Esmaltador": lPer.agregarPersona(new Esmaltador(l.LString("Nombre")));
                                                    break;
                                                    case "Repartidor": lPer.agregarPersona(new Repartidor(l.LString("Nombre"),l.LString("codigo de licencias de concducir")));
                                                    break;
                                                    case "Representante Legal": lPer.agregarPersona(new Representante_legal(l.LString("Nombre")));;
                                                    break;
                                                }
                                            }catch(Exception e){play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);}
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 1: try{
                                                switch(l.seleccionar(t,"Tipo")){///eliminar
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
                                                    default:System.exit(0);
                                                }
                                            }catch(MiException e){ JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 2:///buscar
                                                String[] bus={"Nombre","clace(ID)","tipos"};
                                                switch(l.opcion(bus,"tipo de busqueda")){
                                                    case 0:
                                                    try{
                                                        JOptionPane.showMessageDialog(null,lPer.buscarNombre(l.LString("Nombre a buscar")).toString());
                                                    }catch(MiException e){
                                                        JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                    }                                                    
                                                    break;
                                                    case 1:
                                                    try{
                                                        JOptionPane.showMessageDialog(null,lPer.buscarId(l.LString("ID a buscar")).toString());
                                                    }catch(MiException e){
                                                        JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                    }                                                    
                                                    break;
                                                    case 2:
                                                        switch(l.seleccionar(t,"tipo")){
                                                            case "Gerente": JOptionPane.showMessageDialog(null,lPer.toString(lPer.getListaGerentes()).toString());
                                                            break;
                                                            case "Alfarero Maestro": JOptionPane.showMessageDialog(null,lPer.toString(lPer.obtenerAlfareroMaestro()).toString());
                                                            break;
                                                            case "Alfarero Estudiante": JOptionPane.showMessageDialog(null,lPer.toString(lPer.obtenerAlfareroEstudiante()).toString());
                                                            break; 
                                                            case "Cocinero": JOptionPane.showMessageDialog(null,lPer.toString(lPer.getListaCocineros()).toString());
                                                            break;
                                                            case "Esmaltador": JOptionPane.showMessageDialog(null,lPer.toString(lPer.getListaEsmaltadores()).toString());
                                                            break;
                                                            case "Repartidor": JOptionPane.showMessageDialog(null,lPer.toString(lPer.getListaRepartidores()).toString());
                                                            break;
                                                            case "Representante Legal": JOptionPane.showMessageDialog(null,lPer.toString(lPer.getListaRepresentantes()).toString());
                                                            break;
                                                        }                                           
                                                    break;
                                                }play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 3: //ver
                                            try{
                                                String tx;
                                                switch(l.seleccionar(t,"Tipo")){///ver
                                                    case "Gerente": tx=lPer.buscarGerente(l.seleccionar(l.obtenerArreglo(lPer.obtenerGerentesNombres()),"Seleccione Gerente a ver")).toString();
                                                    break;
                                                    case "Alfarero Maestro": tx=lPer.buscarMaestro(l.seleccionar(l.obtenerArreglo(lPer.obtenerMaestrosNombres()),"Seleccione Maestro a ver")).toString();
                                                    break;
                                                    case "Alfarero Estudiante": tx=lPer.buscarEstudiante(l.seleccionar(l.obtenerArreglo(lPer.obtenerEstudiantesNombres()),"Seleccione Estudiante a ver")).toString();
                                                    break; 
                                                    case "Cocinero": tx=lPer.buscarCocinero(l.seleccionar(l.obtenerArreglo(lPer.obtenerCocinerosNombres()),"Seleccione Cocinero a ver")).toString();
                                                    break;
                                                    case "Esmaltador": tx=lPer.buscarEsmaltador(l.seleccionar(l.obtenerArreglo(lPer.obtenerEsmaltadoresNombres()),"Seleccione Esmaltador a ver")).toString();
                                                    break;
                                                    case "Repartidor": tx=lPer.buscarRepartidor(l.seleccionar(l.obtenerArreglo(lPer.obtenerRepartidoresNombres()),"Seleccione Repartidor a ver")).toString();
                                                    break;
                                                    case "Representante Legal": tx=lPer.buscarRepresentante(l.seleccionar(l.obtenerArreglo(lPer.obtenerRepresentantesNombres()),"Seleccione Representante a ver")).toString();
                                                    break;
                                                    default: tx="No se encontro nada..intente denuevo";
                                                }
                                                JOptionPane.showMessageDialog(null,tx,"Info",JOptionPane.INFORMATION_MESSAGE,null);
                                            }catch(MiException e){JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                    }
                            break;
                            case 1: ///cliente
                                    switch(l.opcion(ac,"Acciones")){                                
                                        case 0: 
                                                lCli.anadirCliente(new Cliente(l.LString("ingrese nombre del cliente")));
                                        break;
                                        case 1: try{//eliminar
                                                    lCli.eliminarCliente(lCli.buscarCliente(l.seleccionar(l.obtenerArreglo(lCli.obtenerClientesNombres()),"Seleccionar cliente a eliminar")),lRut);
                                            }catch(MiException e){ JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                
                                        break;
                                        case 2:///buscar
                                                String[] bus={"Nombre","clace(ID)"};
                                                switch(l.opcion(bus,"tipo de busqueda")){
                                                    case 0:
                                                    try{
                                                        JOptionPane.showMessageDialog(null,lCli.buscarCliente(l.LString("Nombre a buscar")).toString());
                                                    }catch(MiException e){
                                                        JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                    }                                                    
                                                    break;
                                                    case 1:
                                                    try{
                                                        JOptionPane.showMessageDialog(null,lCli.buscarClienteID(l.LString("ID a buscar")).toString());
                                                    }catch(MiException e){
                                                        JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                    }                                                    
                                                    break;
                                                }
                                        break;
                                        case 3: //ver
                                            try{
                                                String tx;
                                                tx=lCli.buscarCliente(l.seleccionar(l.obtenerArreglo(lCli.obtenerClientesNombres()),"Seleccionar cliente a ver")).toString(); 
                                                JOptionPane.showMessageDialog(null,tx,"Info",JOptionPane.INFORMATION_MESSAGE,null);
                                            }catch(MiException e){JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                
                                        break;
                                    }
                                    play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                            break;
                            case 2: //proveedor
                            String[] tip={"Esmpresa","Empresario"};
                                    switch(l.opcion(ac,"Acciones")){                                
                                        case 0: 
                                            switch(l.opcion(tip,"de q tipo: ??")){
                                                case 0:
                                                try{
                                                    lPro.agregarProveedor(new Empresa(l.LString("ingrese nombre del cliente"),lPer.buscarRepresentante(l.seleccionar(l.obtenerArreglo(lPer.obtenerRepresentantesNombres()),"Seleccione Representante legal")).getId()));
                                                }catch(MiException e){
                                                    JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                }
                                                break;
                                                case 1:
                                                    lPro.agregarProveedor(new Empresario(l.LString("ingrese nombre del cliente"),l.LString("ingrese curp del cliente")));
                                                break;
                                            }                                                
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 1: ///eliminar
                                            try{
                                                    lPro.removerProveedor(lPro.buscarProveedor(l.seleccionar(l.obtenerArreglo(lPro.obtenerProveedoresNombres()),"Seleccionar cliente a eliminar")));
                                            }catch(MiException e){ JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 2:///buscar
                                                String[] bus={"Nombre","clave(ID)","Curp","Representante"};
                                                switch(l.opcion(bus,"tipo de busqueda")){
                                                    case 0://nombre
                                                    try{
                                                        JOptionPane.showMessageDialog(null,lPro.buscarProveedor(l.LString("Nombre a buscar")).toString());
                                                    }catch(MiException e){
                                                        JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                    }                                                    
                                                    break;
                                                    case 1://id
                                                    try{
                                                        JOptionPane.showMessageDialog(null,lPro.buscarProveedorID(l.LString("ID a buscar")).toString());
                                                    }catch(MiException e){
                                                        JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                    }                                                    
                                                    break;
                                                    case 2://curp
                                                    try{
                                                        JOptionPane.showMessageDialog(null,lPro.buscarProveedorCurp(l.LString("curp a buscar")).toString());
                                                    }catch(MiException e){
                                                        JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                    }                                                    
                                                    break;
                                                    case 3://representante
                                                    try{
                                                        JOptionPane.showMessageDialog(null,lPro.buscarProveedorRepre(lPer.buscarRepresentante(l.seleccionar(l.obtenerArreglo(lPer.obtenerRepresentantesNombres()),"Seleccione Representante legal")).getId()).toString());
                                                    }catch(MiException e){
                                                        JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                    }                                                    
                                                    break;
                                                }
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 3: //ver
                                            try{
                                                String tx;
                                                tx=lPro.buscarProveedor(l.seleccionar(l.obtenerArreglo(lPro.obtenerProveedoresNombres()),"Seleccionar Proveedor a ver")).toString(); 
                                                JOptionPane.showMessageDialog(null,tx,"Info",JOptionPane.INFORMATION_MESSAGE,null);
                                            }catch(MiException e){JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                    }
                            break;
                            case 3: //producto
                            String[] tipP ={"Insumos","Productos"};
                            switch(l.opcion(tipP,"Tipo de inventario")){
                                case 0:
                                    String[] i={"Arcilla","Pintura","Esmalte","MENU"};
                                    switch(l.opcion(ac,"Acciones")){                                
                                        case 0: 
                                            try{
                                                switch(l.seleccionar(i,"Tipo")){//agregar
                                                    case "Arcilla": inv.agregarInsumo(new Arcilla(0,l.LDouble("Precio")));
                                                    break;
                                                    case "Pintura": inv.agregarInsumo(new Pintura(0,l.LString("Color de la pintura"),l.LDouble("Precio")));
                                                    break;
                                                    case "Esmalte": inv.agregarInsumo(new Esmalte(0,l.LString("Color de la pintura"),l.LBoolean("con brillo o sin brillo"),l.LDouble("Precio")));
                                                    break;
                                                }
                                            }catch(MiException e){ JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 1: try{
                                                switch(l.seleccionar(i,"Tipo")){//Eliminar
                                                    case "Arcilla": inv.agregarInsumo(inv.buscarInsumoA(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosAIds()),"Seleccione Insumo a eliminar")));
                                                    break;
                                                    case "Pintura": inv.agregarInsumo(inv.buscarInsumoP(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosPIds()),"Seleccione Insumo a eliminar")));
                                                    break;
                                                    case "Esmalte": inv.agregarInsumo(inv.buscarInsumoE(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosEIds()),"Seleccione Insumo a eliminar")));
                                                    break;
                                                }
                                            }catch(MiException e){ JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 2:///buscar
                                                String[] bus={"clave(ID)"};
                                                switch(l.opcion(bus,"tipo de busqueda")){
                                                    case 0:
                                                    try{
                                                        JOptionPane.showMessageDialog(null,inv.buscarGeneralInsID(l.LString("ID a buscar")).toString());
                                                    }catch(MiException e){
                                                        JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                    }                                                    
                                                    break;
                                                }play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 3: //ver
                                            try{
                                                String tx;
                                                switch(l.seleccionar(i,"Tipo")){//Eliminar
                                                    case "Arcilla": tx =inv.buscarInsumoA(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosAIds()),"Seleccione Insumo a ver")).toString();
                                                    break;
                                                    case "Pintura": tx =inv.buscarInsumoP(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosPIds()),"Seleccione Insumo a ver")).toString();
                                                    break;
                                                    case "Esmalte": tx =inv.buscarInsumoE(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosEIds()),"Seleccione Insumo a ver")).toString();
                                                    break;
                                                    default: tx="No se encontro nada..intente denuevo";
                                                }
                                                JOptionPane.showMessageDialog(null,tx,"Info",JOptionPane.INFORMATION_MESSAGE,null);
                                            }catch(MiException e){JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                    }
                                break;
                                case 1:
                                    String[] p={"Natural","Cocida","Decorada Pintada","Decorada Esmaltada","Terminado Pintado","Terminado Esmaltado","MENU"};
                                    switch(l.opcion(ac,"Acciones")){                                
                                        case 0: 
                                        String[] est={"Taza","Plato Hondo","Plato Tendido"};
                                        try{
                                                switch(l.seleccionar(p,"Estado")){//agregar
                                                    case "Natural": inv.agregarProducto(new Natural(l.seleccionar(est,"Tipo de producto"),0));
                                                    break;
                                                    case "Cocida": inv.agregarProducto(new Cocida(l.seleccionar(est,"Tipo de producto"),0));
                                                    break;
                                                    case "Decorada Pintada": inv.agregarProducto(new Esmaltada(l.seleccionar(est,"Tipo de producto"),0,inv.buscarInsumoP(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosPIds()),"Seleccione Pintura")).getColor()));
                                                    break;
                                                    case "Decorada Esmaltada": Esmalte esmal=inv.buscarInsumoE(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosEIds()),"Seleccione Esmalte"));
                                                                                inv.agregarProducto(new Esmaltada(l.seleccionar(est,"Tipo de producto"),0,esmal.getColor(),esmal.getBrillo()));
                                                    break;
                                                    case "Terminado Pintado": inv.agregarProducto(new Terminado(l.seleccionar(est,"Tipo de producto"),0,inv.buscarInsumoP(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosPIds()),"Seleccione Pintura")).getColor()));
                                                    break;
                                                    case "Terminado Esmaltado": Esmalte esml=inv.buscarInsumoE(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosEIds()),"Seleccione Esmalte"));
                                                                                inv.agregarProducto(new Terminado(l.seleccionar(est,"Tipo de producto"),0,esml.getColor(),esml.getBrillo()));
                                                    break;
                                                }
                                            }catch(MiException e){ JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 1: try{
                                                switch(l.seleccionar(p,"Tipo")){//eliminar
                                                    case "Natural": inv.quitarProducto(inv.buscarNatural(l.seleccionar(l.obtenerArreglo(inv.obtenerNaturalIds()),"Seleccione producto a eliminar")));
                                                    break;
                                                    case "Cocida": inv.quitarProducto(inv.buscarCocida(l.seleccionar(l.obtenerArreglo(inv.obtenerCocidasIds()),"Seleccione producto a eliminar")));
                                                    break;
                                                    case "Decorada Pintada": inv.quitarProducto(inv.buscarEsmaltado(l.seleccionar(l.obtenerArreglo(inv.obtenerEsmaltadosPIds()),"Seleccione producto a eliminar")));
                                                    break;
                                                    case "Decorada Esmaltada": inv.quitarProducto(inv.buscarEsmaltado(l.seleccionar(l.obtenerArreglo(inv.obtenerEsmaltadosEIds()),"Seleccione producto a eliminar")));
                                                    break;
                                                     case "Terminado Pintado": inv.quitarProducto(inv.buscarProductoT(l.seleccionar(l.obtenerArreglo(inv.obtenerTerminadosPIds()),"Seleccione producto a eliminar")));
                                                    break;
                                                    case "Terminado Esmaltado": inv.quitarProducto(inv.buscarProductoT(l.seleccionar(l.obtenerArreglo(inv.obtenerTerminadosEIds()),"Seleccione producto a eliminar")));
                                                    break;
                                                }
                                            }catch(MiException e){ JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 2:///buscar
                                                String[] bus={"clave(ID)"};
                                                switch(l.opcion(bus,"tipo de busqueda")){
                                                    case 0:
                                                    try{
                                                        JOptionPane.showMessageDialog(null,inv.buscarGeneralID(l.LString("ID a buscar")).toString());
                                                    }catch(MiException e){
                                                        JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                    }                                                    
                                                    break;
                                                    // case 1:
                                                    // try{
                                                        // JOptionPane.showMessageDialog(null,lPer.buscarId(l.LString("ID a buscar")).toString());
                                                    // }catch(MiException e){
                                                        // JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                                    // }                                                    
                                                    // break;
                                                }play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                        case 3: //ver
                                            try{
                                                String tx;
                                                switch(l.seleccionar(p,"Tipo")){//ver
                                                    case "Natural": tx=inv.buscarNatural(l.seleccionar(l.obtenerArreglo(inv.obtenerNaturalIds()),"Seleccione producto a ver")).toString();
                                                    break;
                                                    case "Cocida": tx=inv.buscarCocida(l.seleccionar(l.obtenerArreglo(inv.obtenerCocidasIds()),"Seleccione producto a ver")).toString();
                                                    break;
                                                    case "Decorada Pintada": tx=inv.buscarEsmaltado(l.seleccionar(l.obtenerArreglo(inv.obtenerEsmaltadosPIds()),"Seleccione producto a ver")).toString();
                                                    break;
                                                    case "Decorada Esmaltada": tx=inv.buscarEsmaltado(l.seleccionar(l.obtenerArreglo(inv.obtenerEsmaltadosEIds()),"Seleccione producto a ver")).toString();
                                                    break;
                                                     case "Terminado Pintado": tx=inv.buscarProductoT(l.seleccionar(l.obtenerArreglo(inv.obtenerTerminadosPIds()),"Seleccione producto a ver")).toString();
                                                    break;
                                                    case "Terminado Esmaltado": tx=inv.buscarProductoT(l.seleccionar(l.obtenerArreglo(inv.obtenerTerminadosEIds()),"Seleccione producto a ver")).toString();
                                                    break;
                                                    default: tx="No se encontro nada..intente denuevo";
                                                }
                                                JOptionPane.showMessageDialog(null,tx,"Info",JOptionPane.INFORMATION_MESSAGE,null);
                                            }catch(MiException e){JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                                        break;
                                    }
                                break;
                            }
                            break;
                        }
                break;
                case 1: //ventas
                        try{
                            rt.agregarVenta(new Venta(l.LFecha(),lCli.buscarCliente(l.seleccionar(l.obtenerArreglo(lCli.obtenerClientesNombres()),"Seleccione Cliente")).getId(),l.seleccionar(l.obtenerArreglo(inv.obtenerProductosTIds()),"Seleccione Produccto"),lPer.buscarRepartidor(l.seleccionar(l.obtenerArreglo(lPer.obtenerRepartidoresNombres()),"Seleccione vendedor")).getId(),l.LInteger(1,1000,"Cantidad A vender"),l.LString("Codigo de identificacion")));
                        }catch(MiException e){ JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                        play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                break;
                case 2: ///compras
                        String[] ins={"Arcilla","Pintura","Esmalte"};
                        try{
                            Gerente g=lPer.buscarGerente(l.seleccionar(l.obtenerArreglo(lPer.obtenerGerentesNombres()),"Seleccione Gerente"));
                        switch (l.seleccionar(ins,"insumo a comprar")){
                            case "Arcilla": 
                                    rt.agregarCompra(g.comprarInsumos(l.LFecha(),lPro.buscarProveedor(l.seleccionar(l.obtenerArreglo(lPro.obtenerProveedoresNombres()),"Selecciona Proveedor")),inv.buscarInsumoA(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosAIds()),"Seleccione Arcilla a comprar")),l.LInteger(1,1000,"cantidad a comprar")));
                                
                            break;
                            case "Pintura":
                                    rt.agregarCompra(g.comprarInsumos(l.LFecha(),lPro.buscarProveedor(l.seleccionar(l.obtenerArreglo(lPro.obtenerProveedoresNombres()),"Selecciona Proveedor")),inv.buscarInsumoP(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosPIds()),"Seleccione Pintura a comprar")),l.LInteger(1,1000,"cantidad a comprar")));
                                
                            break;
                            case "Esmalte":
                                    rt.agregarCompra(g.comprarInsumos(l.LFecha(),lPro.buscarProveedor(l.seleccionar(l.obtenerArreglo(lPro.obtenerProveedoresNombres()),"Selecciona Proveedor")),inv.buscarInsumoE(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosEIds()),"Seleccione Esmalte a comprar")),l.LInteger(1,1000,"cantidad a comprar")));
                                
                            break;
                        }
                    }catch(MiException e){ JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.INFORMATION_MESSAGE);}
                        play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                break;
                case 3: //produccion
                    String [] prod={"Natural","Cocer natural","Decorar","cocer Pintado/Esmaltado"};
                    switch(l.seleccionar(prod,"Producir: ??")){
                        case "Natural": 
                        
                                try{//ya agregado algo
                                    Natural n=inv.buscarNatural(l.seleccionar(l.obtenerArreglo(inv.obtenerNaturalIds()),"Seleccione tipo de producto a producir"));
                                    try{
                                        lPer.buscarAlfarero(l.seleccionar(l.obtenerArreglo(lPer.obtenerAlfareroNombres()),"Seleccione Alfarero")).hacerPieza(inv.buscarInsumoA(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosAIds()),"Seleccione Arcilla")),n,l.LInteger(1,100,"cantidad a hacer"));
                                    }catch(MiException e){
                                         JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                    }
                                }catch(MiException e){///nada agregdo
                                    String[] tipoN={"Taza","Plato Hondo","Plato Tendido"};
                                    try{
                                        inv.agregarProducto(lPer.buscarAlfarero(l.seleccionar(l.obtenerArreglo(lPer.obtenerAlfareroNombres()),"Seleccione Alfarero")).hacerPieza(inv.buscarInsumoA(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosAIds()),"Seleccione Arcilla")),l.seleccionar(tipoN,"Seleccione tipo de producto a producir"),l.LInteger(1,100,"cantidad a hacer")));
                                    }catch(MiException m){
                                         JOptionPane.showMessageDialog(null,m.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                    }
                                }
                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                        break;
                        case "Cocer natural": 
                                try{//agregado
                                    Cocinero cok=lPer.buscarCocinero(l.seleccionar(l.obtenerArreglo(lPer.obtenerCocinerosNombres()),"Seleccione Cocinero"));
                                    Natural n=inv.buscarNatural(l.seleccionar(l.obtenerArreglo(inv.obtenerNaturalIds()),"Seleccione producto acocinar"));
                                    try{
                                        Cocida c=inv.buscarCocida("ProdCoci"+n.getTipo().replace(' ','_'));
                                        cok.cocinar(n,c,l.LInteger(1,n.getCantidad(),"Cantidad a procesar"));
                                    }catch(MiException e){//sin agregar
                                         inv.agregarProducto(cok.cocinar(n,l.LInteger(1,n.getCantidad(),"Cantidad a procesar")));
                                    }
                                }catch(MiException e){
                                     JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                }
                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                        break;
                        case "Decorar": 
                            try{
                                Esmaltador esm=lPer.buscarEsmaltador(l.seleccionar(l.obtenerArreglo(lPer.obtenerEsmaltadoresNombres()),"Seleccione Esmaltador"));
                                Cocida c=inv.buscarCocida(l.seleccionar(l.obtenerArreglo(inv.obtenerCocidasIds()),"Seleccione producto Decorar"));
                                String[] deco={"Pintar","Esmaltar"};
                                switch (l.opcion(deco,"tipo de decoracion")){
                                    case 0:
                                        Pintura pint=inv.buscarInsumoP(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosPIds()),"Seleccione Pintura"));
                                        try{//agregado
                                            esm.pintar(c,pint,inv.buscarEsmaltado("ProdPint"+c.getTipo().replace(' ','.')+"-"+pint.getColor()),l.LInteger(0,c.getCantidad(),"cantidad a pintar"));
                                        }catch(MiException e){//sin agregar
                                             inv.agregarProducto(esm.pintar(c,pint,l.LInteger(0,c.getCantidad(),"cantidad a pintar")));
                                        }
                                    break;
                                    case 1:
                                        Esmalte esmal=inv.buscarInsumoE(l.seleccionar(l.obtenerArreglo(inv.obtenerInsumosEIds()),"Seleccione Esmalte"));
                                        try{//agregado
                                            esm.esmaltar(c,esmal,inv.buscarEsmaltado("ProdEsma"+c.getTipo().replace(' ','.')+"-"+esmal.getColor()+"."+(esmal.getBrillo()?01:00)),l.LInteger(0,c.getCantidad(),"cantidad a Esmaltar"));
                                        }catch(MiException e){//sin agregar
                                             inv.agregarProducto(esm.esmaltar(c,esmal,l.LInteger(0,c.getCantidad(),"cantidad a esmaltar")));
                                        }
                                    break;
                                }
                            }catch(MiException e){ JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);}
                            play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                        break;
                        case "cocer Pintado/Esmaltado": 
                                try{//agregado
                                    Cocinero cok=lPer.buscarCocinero(l.seleccionar(l.obtenerArreglo(lPer.obtenerCocinerosNombres()),"Seleccione Cocinero"));
                                    Esmaltada n=inv.buscarEsmaltado(l.seleccionar(l.obtenerArreglo(inv.obtenerEsmaltadosIds()),"Seleccione producto a cocinar"));
                                    try{
                                        Terminado t=inv.buscarProductoT("ProdTerm"+n.getId().substring(4));
                                        cok.cocinar(n,t,l.LInteger(1,n.getCantidad(),"Cantidad a procesar"));
                                    }catch(MiException e){//sin agregar
                                         inv.agregarProducto(cok.cocinar(n,l.LInteger(1,n.getCantidad(),"Cantidad a procesar")));
                                    }
                                }catch(MiException e){
                                    JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                                }
                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                        break;
                    }
                break;
                case 4: //reportes
                    String[] repo={"Ventas","Compras"/*,"Rutas","Produccion"*/};
                    
                    switch(l.opcion(repo,"Obtener reporte de:")){
                        case 0: String[] venRe={"dia","rango dias","cliente","vendedor","producto"};
                            try{
                                switch(l.opcion(venRe,"busqueda de reporte/s")){
                                    case 0: System.out.println("REPORTE VENTAS POR DIA\n\n"+rt.toString(rt.buscarFechaV(l.LFecha())));
                                    break;
                                    case 1: System.out.println("REPORTE VENTAS POR RANGO DIA\n\n"+rt.toString(rt.buscarFechaV(l.LFecha("inicial"),l.LFecha("final"))));
                                    break;
                                    case 2: System.out.println("REPORTE VENTAS POR CLIENTE\n\n"+rt.toString(rt.buscarClienteV(lCli.buscarCliente(l.seleccionar(l.obtenerArreglo(lCli.obtenerClientesNombres()),"Seleccionar cliente de parametro")).getId())));
                                    break;
                                    case 3: System.out.println("REPORTE VENTAS POR VENDEDOR\n\n"+rt.toString(rt.buscarVendedorV(lPer.buscarRepartidor(l.seleccionar(l.obtenerArreglo(lPer.obtenerRepartidoresNombres()),"Seleccione Repartidor de parametro")).getId())));
                                    break;
                                    case 4: System.out.println("REPORTE VENTAS POR PRODUCTO\n\n"+rt.toString(rt.buscarProductoV(l.seleccionar(l.obtenerArreglo(inv.obtenerGeneralPIds()),"Producto para parametro"))));
                                    break;
                                }
                            }catch(MiException e){
                                JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                            }
                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                        break;
                        case 1: 
                        String[] comRe={"dia","rango dias","proveedor","producto"};
                            try{
                                switch(l.opcion(comRe,"busqueda de reporte/s")){
                                    case 0: System.out.println("REPORTE COMPRAS POR DIA\n\n"+rt.toString(rt.buscarFechaC(l.LFecha())));
                                    break;
                                    case 1: System.out.println("REPORTE COMPRAS POR RANGO DIA\n\n"+rt.toString(rt.buscarFechaC(l.LFecha("inicial"),l.LFecha("final"))));
                                    break;
                                    case 2: System.out.println("REPORTE COMPRAS POR PROVEEDOR\n\n"+rt.toString(rt.buscarProveedorC(lPro.buscarProveedor(l.seleccionar(l.obtenerArreglo(lPro.obtenerProveedoresNombres()),"Seleccionar proveedor de parametro")).getId())));
                                    break;
                                    case 3: System.out.println("REPORTE COMPRAS POR PRODUCTO/INSUMO\n\n"+rt.toString(rt.buscarInsumoC(l.seleccionar(l.obtenerArreglo(inv.obtenerGeneralIIds()),"Insumo para parametro"))));
                                    break;
                                }
                            }catch(MiException e){
                                JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,null);
                            }
                                play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
                        break;
                        // case 2: ;
                        // break;
                        // case 3: ;
                        // break;
                    }
                break;
            }
        }catch(Cancelar c){
            play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"la ultima:"+e.getMessage(),"ERROR",JOptionPane.DEFAULT_OPTION,null);
            play(l,d,lPro,rt,lPer,lCli,lVeh,lRut,inv);
        }
    }
    
}
///if(!e.getMessage().equals("cancelar"))