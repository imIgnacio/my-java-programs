/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;
import ucn.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Ignacio
 */
public class AppBikeRush {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(in);
        
        SistemaBikeRush system = new SistemaBikeRushImpl();
        menu(system, input);
    }
    
    
    
    private static void menu(SistemaBikeRush system, BufferedReader input) throws IOException{
        int min = 1;
        int max = 7;
        int numeroAccion = 0;
        boolean validacion = false;
        int accionador;
        
        system.leerMontania();
        system.leerRuta();
        system.leerUrbana();
        system.leerZonas();
        system.leerRepartidores();
        do{
            
            while(!validacion){
                
                StdOut.println("Ingrese el número de opción a realizar:");
                StdOut.println("1.- Contratar Repartidor");
                StdOut.println("2.- Despedir Repartidor");
                StdOut.println("3.- Modificar Repartidor");
                StdOut.println("4.- Realizar Envío");
                StdOut.println("5.- Recepción Repartidor");
                StdOut.println("6.- Cierre de Caja");
                StdOut.println("7.- Salir del sistema");
                String accion = StdIn.readString();

                try{
                    accionador = Integer.parseInt(accion);
                    if(accionador >= 1 && accionador <= 7){
                        numeroAccion = accionador;
                        validacion = true;
                    }else{
                        System.err.println("Numero fuera de rango");
                        validacion = false;
                    }
                }catch(Exception e){
                    System.err.println("Valor ingresado incorrecto");
                    StdOut.println("");
                }   
            }

            if(numeroAccion == 1){
                boolean a = opcion1(system, input);
                if(a){
                    StdOut.println("");
                    StdOut.println("Repatidor agregado al sistema");
                    StdOut.println("");
                }else{
                    StdOut.println("");
                    StdOut.println("Repartidor no se ha agregado al sistema");
                    StdOut.println("");
                }
            }else{
                if(numeroAccion == 2){
                    boolean b = opcion2(system);
                    if(b){
                        StdOut.println("");
                        StdOut.println("Repatidor eliminado del sistema");
                        StdOut.println("");
                    }else{
                        StdOut.println("");
                        StdOut.println("Repartidor no encontrado en el sistema");
                        StdOut.println("");
                    }
                }else{
                    if(numeroAccion == 3){
                        boolean c = opcion3(system, input);
                    }else{
                        if(numeroAccion == 4){
                            opcion4(system, input);
                        }else{
                            if(numeroAccion == 5){
                                opcion5(system, input);
                            }else{
                                if(numeroAccion == 6){
                                    boolean escrito = opcion6(system, input);
                                    if(escrito){
                                        StdOut.println("Caja cerrada correctamente");
                                    }else{
                                        StdOut.println("Caja no se pudo cerrar");
                                    }
                                }else{
                                    if(numeroAccion == 7){
                                        StdOut.println("Ha salido exitosamente del sistema");
                                        System.exit(0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            StdOut.println("");

            StdOut.println("Ingrese el número de opción a realizar:");
            StdOut.println("1.- Contratar Repartidor");
            StdOut.println("2.- Despedir Repartidor");
            StdOut.println("3.- Modificar Repartidor");
            StdOut.println("4.- Realizar Envío");
            StdOut.println("5.- Recepción Repartidor");
            StdOut.println("6.- Cierre de Caja");
            StdOut.println("7.- Salir del sistema");
            String accion = StdIn.readString();

            accionador = Integer.parseInt(accion);
            if(accionador >= 1 && accionador <= 7){
                numeroAccion = accionador;
                validacion = true;
            }else{
                validacion = false;
            }         
        }while(accionador !=7);
        System.out.println("Ha salido exitosamente del Sistema");
        System.exit(0);
    }
    
    private static boolean verificarRut(String rut){
        try{
            int a = Integer.parseInt(rut);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    private static boolean opcion1(SistemaBikeRush system, BufferedReader input) throws IOException{
        StdOut.println("Ingrese nombre de la persona");
        String nombre = input.readLine();
        StdOut.println("");

        StdOut.println("Ingrese RUT de la persona");
        String ID;
        try{
            ID = input.readLine().substring(0, 8);
            StdOut.println("");
        }catch(Exception e){
            System.err.println("No ha ingresado un RUT valido");
            return false;
        }
        
        boolean boo = verificarRut(ID);
        
        if(!boo){
            System.err.println("No ha ingresado un RUT valido");
            StdOut.println("");
            return false;
        }

        int edad = 0;
        
        StdOut.println("Ingrese edad de la persona");
        String age = input.readLine();

        try{
            edad = Integer.parseInt(age);
        }catch(Exception e){
                System.err.println("No ha ingresado una edad");
                return false;
        }
        

        StdOut.println("Ingrese el tipo de bicicleta (Puede ser Ruta, Urbana o Montaña)");
        String tipoBicicleta = StdIn.readString().substring(0, 3);
        if(tipoBicicleta.equalsIgnoreCase("rut")){
            
        }else{
            if(tipoBicicleta.equalsIgnoreCase("urb")){
                
            }else{
                if(tipoBicicleta.equalsIgnoreCase("mon")){
                    
                }else{
                    System.err.println("ERROR: El tipo de bicicleta no existe");
                    return false;
                }
            }
        }
        StdOut.println("");

        StdOut.println("Ingrese la patente de la Bicicleta");
        String patente = StdIn.readString().replace(" ", "").replace("-", "").toUpperCase();
        StdOut.println("");

        StdOut.println("Ingrese el costo de mantención de la bicicleta");
        String mant = input.readLine();
        int monto; 
        
        try{
            monto = Integer.parseInt(mant);
        }catch(Exception e){
            System.err.println("ERROR: Monto de mantencion no valido");
            StdOut.println("");
            return false;
        }

        StdOut.println("Ingrese dirección de la persona");
        String direccion = input.readLine();

        boolean creado = system.contratarRepartidor(nombre, edad, direccion, tipoBicicleta, patente, ID, monto);

        return creado;
    }

    private static boolean opcion2(SistemaBikeRush system) {
        StdOut.println("Ingrese ID del repartidor a eliminar");

            String ID = StdIn.readString();

            boolean b = system.despedirRepartidor(ID);
            return b;
    }

    private static boolean opcion3(SistemaBikeRush system, BufferedReader input) throws IOException {
        StdOut.println("");
        StdOut.println("Ingrese ID del repartidor a modificar ");
        String ID = input.readLine();
        NodoRepartidor repartidorModificar = system.buscarRepartidor(ID);
        if(repartidorModificar == null){
            StdOut.println("Repartidor no encontrado");
            return false;
        }
        
        StdOut.println("");
        StdOut.println("Seleccione opcion a realizar: ");
        StdOut.println("1.- Modificar Repartidor");
        StdOut.println("2.- Modificar Bicicleta");
        
        String opcion = input.readLine();
        boolean isNumero;
        boolean isEdad;
        int a;
        int nuevaEdad = -1;
        try{
            a = Integer.parseInt(opcion);
            if(a == 1 || a == 2){
                isNumero = true;
            }else{
                isNumero = false;
            }
        }catch(Exception e){
            isNumero = false;
        }
        
        if(!isNumero){
            return false;
        }else{
            if(opcion.equalsIgnoreCase("1")){
                
                StdOut.println("Seleccione dato a modificar: ");
                StdOut.println("A.- Nombre Repartidor");
                StdOut.println("B.- Edad");
                StdOut.println("C.- Direccion");
                StdOut.println("");
                String opcion2 = input.readLine();
                
                if(opcion2.equalsIgnoreCase("A")){
                    StdOut.println("Ingrese nuevo nombre");
                    String nombreNuevo = input.readLine();
                    system.modificarRepartidor(repartidorModificar, nombreNuevo, "nombre");
                    StdOut.println("Ha modificado el nombre");
                    return true;
                }else{
                    if(opcion2.equalsIgnoreCase("B")){
                        StdOut.println("");
                        StdOut.println("Ingrese nueva edad");
                        String edad = input.readLine();
                        
                        try{
                            nuevaEdad = Integer.parseInt(edad);
                            if(nuevaEdad >= 0){
                                isEdad = true;
                            }else{
                                isEdad = false;
                            }
                        }catch(Exception e){
                            isEdad = false;
                        }
                        
                        if(!isEdad){
                            return false;
                        }else{
                            system.modificarRepartidor(repartidorModificar, nuevaEdad);
                            StdOut.println("Ha modificado la edad");
                            return true;
                        }
                    }else{
                        if(opcion2.equalsIgnoreCase("C")){
                            StdOut.println("Ingrese nueva direccion ");
                            String nombreNuevo = input.readLine();
                            system.modificarRepartidor(repartidorModificar, nombreNuevo, "direccion");
                            StdOut.println("Ha modificado la direccion");
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }else{
                Bicicleta bicicleta = repartidorModificar.getRepartidor().getBicicleta();
                StdOut.println("Seleccionar accion a realizar de la bicicleta");
                StdOut.println("A.- Modificar Patente ");
                StdOut.println("B.- Cambiar de Bicicleta ");
                
                String opcionB = input.readLine();
                if(opcionB.equalsIgnoreCase("A")){
                    StdOut.println("Ingrese nueva patente");
                    String patente = input.readLine();
                    system.modificarRepartidor(repartidorModificar, bicicleta, patente);
                    StdOut.println("Patente modificada");
                    return true;
                }else{
                    if(opcionB.equalsIgnoreCase("B")){
                        Bicicleta nueva;
                        
                        StdOut.println("Ingrese el tipo de bicicleta (Puede ser Ruta, Urbana o Montaña)");
                        String tipoBicicleta = StdIn.readString().substring(0, 3);
                        StdOut.println("");

                        StdOut.println("Ingrese la patente de la Bicicleta");
                        String patente = StdIn.readString().replace(" ", "").replace("-", "").toUpperCase();
                        StdOut.println("");

                        StdOut.println("Ingrese el costo de mantención de la bicicleta");
                        int monto = StdIn.readInt();
                        StdOut.println("");
                        
                        if(tipoBicicleta.equalsIgnoreCase("rut")){
                            nueva = new Ruta(patente, 70, monto);
                        }else{
                            if(tipoBicicleta.equalsIgnoreCase("urb")){
                                nueva = new Urbana(patente, 30, monto);
                            }else{
                                if(tipoBicicleta.equalsIgnoreCase("mon")){
                                    nueva = new Montania(patente, 40, monto);
                                }else{
                                    StdOut.println("Tipo bicicleta no existente");
                                    return false;
                                }
                            }
                        }
                        
                        repartidorModificar.getRepartidor().setBicicleta(nueva);
                        system.modificarRepartidor(bicicleta, nueva);
                        StdOut.println("Bicicleta nueva añadida");
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }
    }
    
    private static boolean opcion4(SistemaBikeRush system, BufferedReader input) throws IOException{
        int numeroEnvio = 1;
        StdOut.println("Ingrese nombre del emisor ");
        String nombreEmisor = input.readLine();
        StdOut.println("");
        StdOut.println("Ingrese direccion del emisor");
        String direccionEmisor = input.readLine();
        StdOut.println("");
        StdOut.println("Ingrese nombre del receptor");
        String nombreReceptor = input.readLine();
        StdOut.println("");
        StdOut.println("Ingrese direccion del receptor");
        String direccionReceptor = input.readLine();
        StdOut.println("");
        StdOut.println("Ingrese el nombre de la zona del receptor ");
        String nombreZonaReceptor = input.readLine();
        
        boolean[] isPosible = system.realizarEnvio(nombreEmisor, nombreReceptor, direccionEmisor, direccionReceptor, nombreZonaReceptor);
        if(isPosible[0] == false){
            StdOut.println("");
            StdOut.println("No es posible realizar el envio, no tenemos Repartidores para su ubicacion");
            StdOut.println("");
            return false;
        }else{
            if(isPosible[1] == false){
                StdOut.println("");
                StdOut.println("El envio ha quedado en espera, dado que todos nuestros repartidores estan ocupados");
                StdOut.println("");
                return true;
            }else{
                StdOut.println("");
                StdOut.println("Se procedera a realizar el envio");
                StdOut.println("");
                return true;
            }
        }
    }
    
    private static void opcion5(SistemaBikeRush system, BufferedReader input) throws IOException{
        StdOut.println("Ingrese ID del Repartidor");
        String ID = input.readLine();
        boolean[] vector = system.recepcionRepartidor(ID);
        
        if(vector[0] == false){
            System.out.println("El repartidor no existe");
        }else{
            if(vector[1] == false){
                StdOut.println("El repartidor esta libre");
            }else{
                
            }
        }
    }

    private static boolean opcion6(SistemaBikeRush system, BufferedReader input) {
        boolean a = system.escribirArchivo();
        return a;
    }
}
