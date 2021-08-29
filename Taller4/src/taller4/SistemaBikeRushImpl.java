/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdOut;
/**
 *
 * @author Ignacio
 */
public class SistemaBikeRushImpl implements SistemaBikeRush{
    
    LinkedList<Envio> listaEnvios;
    ArrayList<Zona> listaZonas;
    ListaRepartidores listaRepartidores;
    ListaBicicletas listaBicicletas;
    
    public SistemaBikeRushImpl(){
        this.listaEnvios = new LinkedList<>();
        this.listaZonas = new ArrayList();
        this.listaRepartidores = new ListaRepartidores();
        this.listaBicicletas = new ListaBicicletas();
    }
    
    /**
     *  Ingresa un Repartidor al Sistema
     * @param nombre
     * @param edad
     * @param direccion
     * @param tipoBicicleta
     * @param patente
     * @param ID
     * @param monto
     * @return boolean
     */
    @Override
    public boolean contratarRepartidor(String nombre, int edad, String direccion, String tipoBicicleta, String patente, String ID, int monto) {
        
        Bicicleta bicicleta;
        if(tipoBicicleta.equalsIgnoreCase("rut")){
            bicicleta = new Ruta(patente, 70, monto);
        }else{
            if(tipoBicicleta.equalsIgnoreCase("urb")){
                bicicleta = new Urbana(patente, 30, monto);
            }else{
                if(tipoBicicleta.equalsIgnoreCase("mon")){
                    bicicleta = new Montania(patente, 40, monto);
                }else{
                    System.err.println("ERROR: Tipo de Bicicleta no existente");
                    return false;
                }
            }
        }
        Repartidor repartidor = new Repartidor(ID, nombre, edad, direccion, bicicleta);
        boolean a = this.listaBicicletas.insertarUltimo(bicicleta);
        boolean b = this.listaRepartidores.insertarUltimo(repartidor);
        
        if(b){
            StdOut.println("Repartidor correctamente creado");
        }
        if(a){
            StdOut.println("Bicicleta correctamente creada");
        }
        if(a && b){
            return true;
        }else{
            return false;
        }
    }

    /**
     *Busca el Repartidor asociado al ID para eliminarlo del sistema
     * @param ID
     * @return boolean
     */
    @Override
    public boolean despedirRepartidor(String ID) {
        //Buscaremos si esta el Repartidor
        
        NodoRepartidor actual = this.listaRepartidores.getFirst();
        //Verificamos si la lista esta vacia
        if(actual == null){
            return false;
        }
        //Recorremos la lista buscando el repartidor para saber si existe o no
        while(!actual.getRepartidor().getID().equalsIgnoreCase(ID) && actual.getNext() != null){
            actual = actual.getNext();
        } 
        Bicicleta bicicleta;
        //Revisamos si equivale al ultimo
        if(actual.getNext() == null){
            if(!actual.getRepartidor().getID().equalsIgnoreCase(ID)){ //VERIFICAR SI NO ESTA
                return false;
            }else{
                bicicleta = actual.getRepartidor().getBicicleta();
                this.listaRepartidores.eliminarDespues(ID);
                this.listaBicicletas.eliminarDespues(bicicleta);
                return true;
            }
        }else{ //Caso de que no sea el ultimo
            bicicleta = actual.getRepartidor().getBicicleta();
            this.listaRepartidores.eliminarDespues(ID);
            this.listaBicicletas.eliminarDespues(bicicleta);
            return true;
        }
    }
    
    /**
     * Busca si existe el repartidor con su ID
     * @param ID
     * @return NodoRepartidor
     */
    @Override
    public NodoRepartidor buscarRepartidor(String ID){
        NodoRepartidor actual = this.listaRepartidores.getFirst();
        //Verificamos si la lista esta vacia
        if(actual == null){
            return null;
        }
        //Recorremos la lista buscando el repartidor para saber si existe o no
        while(!actual.getRepartidor().getID().equalsIgnoreCase(ID) && actual.getNext() != null){
            actual = actual.getNext();
        } 
        //Revisamos si equivale al ultimo
        if(actual.getNext() == null){
            if(actual.getRepartidor().getID().equalsIgnoreCase(ID)){
                return actual;
            }else{
                return null;
            }
        }
        //Caso de que no sea el ultimo
        return actual;
        
    }

    /**
     * Modifica el nombre o la direccion de un repartidor
     * @param nodo
     * @param dato
     * @param accion
     */
    @Override
    public void modificarRepartidor(NodoRepartidor nodo,String dato, String accion) {
        if(accion.equalsIgnoreCase("nombre")){
            nodo.getRepartidor().setNombre(dato);
        }else{
            nodo.getRepartidor().setDireccion(dato);
        }
    }

    /**
     * Modifica la edad de un repartidor
     * @param nodo
     * @param edad
     */
    @Override
    public void modificarRepartidor(NodoRepartidor nodo, int edad) {
        nodo.getRepartidor().setEdad(edad);
    }

    /**
     * Crea una nueva bicicleta y destruye la antigua
     * @param bicicleta
     * @param nueva
     */
    @Override
    public void modificarRepartidor(Bicicleta bicicleta, Bicicleta nueva) {
        this.listaBicicletas.eliminarDespues(bicicleta);
        this.listaBicicletas.insertarUltimo(nueva);
    }
    
    /**
     * Modifica la patente de la bicicleta
     * @param nodo
     * @param bicicleta
     * @param patente
     */
    @Override
    public void modificarRepartidor(NodoRepartidor nodo, Bicicleta bicicleta, String patente) {
        nodo.getRepartidor().getBicicleta().setPatente(patente);
    }

    /**
     * Verifica si es posible o no el envio. La primera posicion del vector verifica si es posible realizar el envio.
     * La segunda posicion si el envio esta en espera o en proceso
     * @param nombreEmisor
     * @param nombreReceptor
     * @param direccionEmisor
     * @param direccionReceptor
     * @param nombreZonaReceptor
     * @return boolean[]
     */
    @Override
    public boolean[] realizarEnvio(String nombreEmisor, String nombreReceptor, String direccionEmisor, String direccionReceptor, String nombreZonaReceptor) {
        
        boolean[] vector = new boolean[2];
        int i;
        int numeroEnvio = 1;
        Iterator auxIterator = this.listaEnvios.iterator();
        
        //GENERADOR DE ID DE ENVIO
        while(auxIterator.hasNext()){
            auxIterator.next();
            numeroEnvio+=1;
        }
        
        //BUSCAMOS SI LA ZONA EXISTE
        for(i=0; i<this.listaZonas.size();i++){
            if(this.listaZonas.get(i).getNombreZona().equalsIgnoreCase(nombreZonaReceptor)){
                break;
            }
        }
        if(i == this.listaZonas.size()){
            vector[0] = false;
            vector[1] = false;
            return vector;
        }
        
        String colorZona = this.listaZonas.get(i).getColorZona();
        NodoRepartidor aux = this.listaRepartidores.getFirst();
        NodoRepartidor pivote = this.listaRepartidores.getFirst();
        Zona zona = this.listaZonas.get(i);
        
        //CASO DE QUE EL COLOR SEA ROJO
        if(colorZona.equalsIgnoreCase("rojo")){
            
            //BUSCAMOS SI EXISTE ALGUN REPARTIDOR CAPAZ DE LLEGAR A LA ZONA ROJA
            while(aux.getNext() != null && aux.getRepartidor().getBicicleta().getVelocidad() != 40){
                aux = aux.getNext();
            }
            if(aux.getNext() == null){
                if(aux.getRepartidor().getBicicleta().getVelocidad() == 40){
                    
                }else{
                    vector[0] = false;
                    vector[1] = false;
                    return vector;
                }
            }  
            vector[0] = true;
                //EXISTE AL MENOS UN REOARTIDOR ROJO
                boolean disponibilidad = isRepartidorDisponible(aux, 40);
                if(!disponibilidad){
                    //EL ENVIO QUEDA EN ESPERA
                    vector[1] = false;
                    while(pivote.getRepartidor().getBicicleta().getVelocidad() != 40){
                        pivote = pivote.getNext();
                    }
                    Envio envio = new Envio(nombreEmisor, nombreReceptor, direccionEmisor, direccionReceptor, zona, pivote.getRepartidor(), numeroEnvio);
                    this.listaEnvios.add(envio);
                    return vector;
                }else{
                    //HAY DISPONIBILIADAD PARA EL ENVIO
                    vector[1] = true;
                    Repartidor maquina = getRepartidorDisponible(this.listaRepartidores, 40);
                    maquina.setDisponibilidad(false);
                    Envio envio = new Envio(nombreEmisor, nombreReceptor, direccionEmisor, direccionReceptor, zona, maquina, numeroEnvio);
                    envio.setEstadoEnvio(true);
                    this.listaEnvios.add(envio);
                    String nombre = envio.getRepartidor().getNombre();
                    String direccion = envio.getDireccionReceptor();
                    String nombreZona = envio.getZona().getNombreZona();
                    StdOut.println("Se ha enviado a "+ nombre + " a la direccion "+ direccion + ", ubicada en la zona "+ nombreZona);
                    return vector;
                }
        }else{
        //CASO DE QUE EL COLOR SEA AMARILLO
            if(colorZona.equalsIgnoreCase("amarillo")){
                //BUSCAMOS SI EXISTE ALGUN REPARTIDOR PARA LLEGAR A LA ZONA AMARILLA
                while(aux.getNext() != null && aux.getRepartidor().getBicicleta().getVelocidad() != 70){
                    aux = aux.getNext();
                }
                if(aux.getNext() == null){
                    if(aux.getRepartidor().getBicicleta().getVelocidad() == 70){

                    }else{
                        vector[0] = false;
                        vector[1] = false;
                        return vector;
                    }
                }
                vector[0] = true;
                //EXISTE UN REPARTIDOR AMARILLO
                boolean disponibilidad = isRepartidorDisponible(aux, 70);
                if(!disponibilidad){
                    //EL ENVIO QUEDA EN ESPERA
                    vector[1] = false;
                    while(pivote.getRepartidor().getBicicleta().getVelocidad() != 70){
                        pivote = pivote.getNext();
                    }
                    Envio envio = new Envio(nombreEmisor, nombreReceptor, direccionEmisor, direccionReceptor, zona, pivote.getRepartidor(), numeroEnvio);
                    this.listaEnvios.add(envio);
                    return vector;
                }else{
                    //SE PROCEDE CON EL ENVIO
                    vector[1] = true;
                    Repartidor maquina = getRepartidorDisponible(this.listaRepartidores,70);
                    maquina.setDisponibilidad(false);
                    Envio envio = new Envio(nombreEmisor, nombreReceptor, direccionEmisor, direccionReceptor, zona, maquina, numeroEnvio);
                    envio.setEstadoEnvio(true);
                    this.listaEnvios.add(envio);
                    String nombre = envio.getRepartidor().getNombre();
                    String direccion = envio.getDireccionReceptor();
                    String nombreZona = envio.getZona().getNombreZona();
                    StdOut.println("Se ha enviado a "+ nombre + " a la direccion "+ direccion + ", ubicada en la zona "+ nombreZona);
                    return vector;
                }
            }else{
            //CASO DE QUE EL COLOR SEA VERDE
            //BUSCAMOS SI EXISTE ALGUN REPARTIDOR VERDE
                while(aux.getNext() != null && aux.getRepartidor().getBicicleta().getVelocidad() != 30){
                    aux = aux.getNext();
                }
                if(aux.getNext() == null){
                    if(aux.getRepartidor().getBicicleta().getVelocidad() == 30){

                    }else{
                        vector[0] = false;
                        vector[1] = false;
                        return vector;
                    }
                }
                vector[0] = true;
                //EXISTE AL MENOS UN REPARTIDOR VERDE
                boolean disponibilidad = isRepartidorDisponible(aux, 30);
                if(!disponibilidad){
                    //EL ENVIO QUEDA EN ESPERA
                    vector[1] = false;
                    while(pivote.getRepartidor().getBicicleta().getVelocidad() != 30){
                        pivote = pivote.getNext();
                    }
                    Envio envio = new Envio(nombreEmisor, nombreReceptor, direccionEmisor, direccionReceptor, zona, pivote.getRepartidor(), numeroEnvio);
                    this.listaEnvios.add(envio);
                    return vector;
                }else{
                    //SE PROCEDE CON EL ENVIO
                    vector[1] = true;
                    Repartidor maquina = getRepartidorDisponible(this.listaRepartidores, 30);
                    maquina.setDisponibilidad(false);
                    Envio envio = new Envio(nombreEmisor, nombreReceptor, direccionEmisor, direccionReceptor, zona, maquina, numeroEnvio);
                    envio.setEstadoEnvio(true);
                    this.listaEnvios.add(envio);
                    String nombre = envio.getRepartidor().getNombre();
                    String direccion = envio.getDireccionReceptor();
                    String nombreZona = envio.getZona().getNombreZona();
                    StdOut.println("Se ha enviado a "+ nombre + " a la direccion "+ direccion + ", ubicada en la zona "+ nombreZona);
                    return vector;
                }   
            }
        }
    }
    
    /**
     * Verifica si existe algun Repartidor libre para realizar el envio, si no hay deja el Envio pendiente
     * @param nodo
     * @param velocidad
     * @return boolean
     */
    public boolean isRepartidorDisponible(NodoRepartidor nodo, int velocidad){
        while(nodo.getNext() != null){
            if(nodo.getRepartidor().getBicicleta().getVelocidad() == velocidad){
                if(nodo.getRepartidor().isDisponibilidad() == true){
                    return true;
                }else{
                    nodo = nodo.getNext();
                }
            }else{
                nodo = nodo.getNext();
            }
        }
        if(nodo.getRepartidor().getBicicleta().getVelocidad() == velocidad){
            if(nodo.getRepartidor().isDisponibilidad() == true){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    /**
     *Busca el Repartidor que esta libre para realizar el envio
     * @param first
     * @param velocidad
     * @return Repartidor
     */
    public Repartidor getRepartidorDisponible(ListaRepartidores first, int velocidad){
        NodoRepartidor nodo = first.getFirst();
        while(nodo.getNext() != null){
            if(nodo.getRepartidor().getBicicleta().getVelocidad() == velocidad){
                if(nodo.getRepartidor().isDisponibilidad() == true){
                    return nodo.getRepartidor();
                }else{
                    nodo = nodo.getNext();
                }
            }else{
                nodo = nodo.getNext();
            }
        }
        if(nodo.getRepartidor().getBicicleta().getVelocidad() == velocidad){
            if(nodo.getRepartidor().isDisponibilidad() == true){
                return nodo.getRepartidor();
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    /**
     *Deja a disposicion al Repartidor, retorna un arreglo de dos posiciones, si la primera es false, el repartidor no esxiste. Para el caso de la segunda posicion; si es false
     * el repartidor queda libre, si es true ha tomado otro pedido
     * @param ID
     * @return boolean[]
     */
    @Override
    public boolean[] recepcionRepartidor(String ID) {
        boolean[] vector = new boolean[2];
        int i = 0;
        
        NodoRepartidor nodo = buscarRepartidor(ID);
        if(nodo == null){
            vector[0] = false;
            vector[1] = false;
            return vector;
        }
        
        Repartidor repartidor = nodo.getRepartidor();
        double velocidad = repartidor.getBicicleta().getVelocidad();
        repartidor.setDisponibilidad(true);
        vector[0] = true;
        
        //CASO DE QUE SEA MONTAÑA
        if(velocidad == 40){
            //VERIFICAMOS SI EL REPARTIDOR PUEDE ENTREGAR OTRO PEDIDO
            Iterator envioIterator = this.listaEnvios.iterator();
            
            while(envioIterator.hasNext()){
                envioIterator.next();
                
                if(this.listaEnvios.get(i).isEstadoEnvio() == false && this.listaEnvios.get(i).getZona().getColorZona().equalsIgnoreCase("rojo")){
                    break;
                }else{
                    if(envioIterator.hasNext()){
                        i++;
                    }else{
                        
                    }
                }
            }
            if(this.listaEnvios.getLast() == this.listaEnvios.get(i)){
                if(this.listaEnvios.getLast().isEstadoEnvio() == false && this.listaEnvios.get(i).getZona().getColorZona().equalsIgnoreCase("rojo")){
                    
                }else{
                    vector[1] = false;
                    return vector;
                }
            }
            repartidor.setDisponibilidad(false);
            this.listaEnvios.get(i).setRepartidor(repartidor);
            this.listaEnvios.get(i).setEstadoEnvio(true);
            vector[1] = true;
            StdOut.println("Se envio al repartidor "+ repartidor.getNombre() + " a la direccion "+ this.listaEnvios.get(i).getDireccionReceptor() + " ubicada en la zona "+ this.listaEnvios.get(i).getZona().getNombreZona());
            return vector;
        }else{
            //CASO DE QUE SEA RUTA
            if(velocidad == 70){
                //VERIFICAMOS SI EL REPARTIDOR PUEDE ENTREGAR OTRO PEDIDO
                Iterator envioIterator = this.listaEnvios.iterator();
                if(!envioIterator.hasNext()){
                    vector[1] = false;
                    return vector;
                }
                
                while(envioIterator.hasNext()){
                    envioIterator.next();
                    
                    if(this.listaEnvios.get(i).isEstadoEnvio() == false && this.listaEnvios.get(i).getZona().getColorZona().equalsIgnoreCase("amarillo")){
                        break;
                    }else{
                        if(envioIterator.hasNext()){
                            i++;
                        }else{
                            
                        }
                    }
                }
                if(this.listaEnvios.getLast() == this.listaEnvios.get(i)){
                    if(this.listaEnvios.getLast().isEstadoEnvio() == false && this.listaEnvios.get(i).getZona().getColorZona().equalsIgnoreCase("amarillo")){

                    }else{
                        vector[1] = false;
                        return vector;
                    }
                }
                repartidor.setDisponibilidad(false);
                this.listaEnvios.get(i).setRepartidor(repartidor);
                this.listaEnvios.get(i).setEstadoEnvio(true);
                vector[1] = true;
                StdOut.println("Se envio al repartidor "+ repartidor.getNombre() + " a la direccion "+ this.listaEnvios.get(i).getDireccionReceptor() + " ubicada en la zona "+ this.listaEnvios.get(i).getZona().getNombreZona());
                return vector;
            }else{
                //CASO DE QUE SEA URBANA
                //VERIFICAMOS SI EL REPARTIDOR PUEDE ENTREGAR OTRO PEDIDO
                Iterator envioIterator = this.listaEnvios.iterator();
                if(!envioIterator.hasNext()){
                    vector[1] = false;
                    return vector;
                }
                while(envioIterator.hasNext()){
                    envioIterator.next();
                    if(this.listaEnvios.get(i).isEstadoEnvio() == false && this.listaEnvios.get(i).getZona().getColorZona().equalsIgnoreCase("verde")){
                        break;
                    }else{
                        if(envioIterator.hasNext()){
                            i++;
                        }else{

                        }
                    }
                }
                if(this.listaEnvios.getLast() == this.listaEnvios.get(i)){
                    if(this.listaEnvios.getLast().isEstadoEnvio() == false && this.listaEnvios.get(i).getZona().getColorZona().equalsIgnoreCase("verde")){

                    }else{
                        vector[1] = false;
                        return vector;
                    }
                }
                repartidor.setDisponibilidad(false);
                this.listaEnvios.get(i).setRepartidor(repartidor);
                this.listaEnvios.get(i).setEstadoEnvio(true);
                vector[1] = true;
                StdOut.println("Se envio al repartidor "+ repartidor.getNombre() + " a la direccion "+ this.listaEnvios.get(i).getDireccionReceptor() + " ubicada en la zona "+ this.listaEnvios.get(i).getZona().getNombreZona());
                return vector;
            }
        }
    }  

    /**
     *Si existen envios, genera un archivo con detalles, caso contrario genera archivo vacio
     * @return boolean
     */
    @Override
    public boolean escribirArchivo() { //REVISAR LA GANANCIA DE UN REPARTIDOR
        Date date = new Date();  
        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");  
        String lolazo = formatter.format(date);
        String currentDate = lolazo.concat(".txt");
        
        File file = new File(currentDate);
        BufferedWriter writer;
        
        double gananciaTotal = 0;
        int j = 0;
        Iterator i = this.listaEnvios.iterator();
        Iterator i2 = this.listaEnvios.iterator();
        ArrayList<String> nombres = new ArrayList<>();
        try {
            writer = new BufferedWriter(new FileWriter(file));
            if(!i.hasNext()){
                writer.close();
                return false;
            }
            while(i.hasNext()){
                i.next();
                if(this.listaEnvios.get(j).isEstadoEnvio() == true){
                    String ID = Integer.toString(this.listaEnvios.get(j).getNumeroEnvio());
                    String nombreEmisor = this.listaEnvios.get(j).getNombreEmisor();
                    String nombreReceptor = this.listaEnvios.get(j).getNombreReceptor();
                    String direccionEmisor = this.listaEnvios.get(j).getDireccionEmisor();
                    String direccionReceptor = this.listaEnvios.get(j).getDireccionReceptor();
                    String nombreZona = this.listaEnvios.get(j).getZona().getNombreZona();
                    String montoFlete = Double.toString(this.listaEnvios.get(j).getValorEnvio());
                    
                    writer.write(ID+", "+nombreEmisor+", "+nombreReceptor+", "+direccionEmisor+", "+direccionReceptor+", "+nombreZona+", "+montoFlete);
                    writer.newLine();
                    gananciaTotal += this.listaEnvios.get(j).getValorEnvio();
                    
                    if(!nombres.contains(this.listaEnvios.get(j).getRepartidor().getNombre())){
                        nombres.add(this.listaEnvios.get(j).getRepartidor().getNombre());
                    }
                    j++;
                }else{
                    j++;
                }   
            }
            writer.newLine();
            int k = 0;
            double gananciaRepartidor = 0;
            for(int a=0;a<nombres.size();a++){
                if(this.listaEnvios.size() == 1){
                    if(this.listaEnvios.getLast().isEstadoEnvio() == true && this.listaEnvios.getLast().getRepartidor().getNombre().equalsIgnoreCase(nombres.get(a))){
                        gananciaRepartidor+= this.listaEnvios.getLast().getValorEnvio();
                    }
                }else{
                
                    while(i2.hasNext()){
                        i2.next();
                        if(this.listaEnvios.get(k).isEstadoEnvio() == true && this.listaEnvios.get(k).getRepartidor().getNombre().equalsIgnoreCase(nombres.get(a))){
                            gananciaRepartidor += this.listaEnvios.get(k).getValorEnvio();
                            k++;
                        }else{
                            k++;
                        }
                    }
                }  
                writer.write(nombres.get(a)+", "+Double.toString(gananciaRepartidor));
                writer.newLine();
                k = 0;
                gananciaRepartidor = 0;
                i2 = this.listaEnvios.iterator();
    
            }
            writer.newLine();
            writer.write("Ganancia Total: "+Double.toString(gananciaTotal));
            writer.close();
            
            return true;
        } catch (IOException ex) {
            Logger.getLogger(SistemaBikeRushImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     *Lee el archivo Repartidores
     * @throws IOException
     */
    @Override
    public void leerRepartidores() throws IOException{
        ArchivoEntrada archivoRepartidores = new ArchivoEntrada("Repartidores.txt");
        
        while(!archivoRepartidores.isEndFile()){
            Registro reg = archivoRepartidores.getRegistro();
            String ID = reg.getString();
            String nombre = reg.getString();
            int edad = reg.getInt();
            String direccion = reg.getString();
            String patente = reg.getString();
            
            Bicicleta bicicleta = null;
            NodoBicicleta aux = this.listaBicicletas.getFirst();
            while(aux.getNext() != null){
                if(aux.getBicicleta().getPatente().equalsIgnoreCase(patente)){
                    bicicleta = aux.getBicicleta();
                    Repartidor repartidor = new Repartidor(ID, nombre, edad, direccion, bicicleta);
                    this.listaRepartidores.insertarUltimo(repartidor);
                    break;
                }else{
                    aux = aux.getNext();
                }
            }
            if(aux.getNext() == null){
                if(aux.getBicicleta().getPatente().equalsIgnoreCase(patente)){
                    bicicleta = aux.getBicicleta();
                    Repartidor repartidor = new Repartidor(ID, nombre, edad, direccion, bicicleta);
                    this.listaRepartidores.insertarUltimo(repartidor);
                }else{
                    
                }
            }
        }
        archivoRepartidores.close();
        
    }

    /**
     *Lee el archivo bicicletas Ruta
     * @throws IOException
     */
    @Override
    public void leerRuta() throws IOException {
        ArchivoEntrada archRuta = new ArchivoEntrada("Bicicletas_Ruta.txt");
        
        while(!archRuta.isEndFile()){
            Registro reg = archRuta.getRegistro();
            String patente = reg.getString();
            String a = reg.getString().replace("$", "");
            int monto = Integer.parseInt(a);
            Bicicleta bici = new Ruta(patente, 70, monto);
            this.listaBicicletas.insertarUltimo(bici);
        }
        archRuta.close();
    }

    /**
     *Lee el archivo bicicletas Urbana
     * @throws IOException
     */
    @Override
    public void leerUrbana() throws IOException {
        ArchivoEntrada archUrbana = new ArchivoEntrada("Bicicletas_Urbana.txt");
        
        while(!archUrbana.isEndFile()){
            Registro reg = archUrbana.getRegistro();
            String patente = reg.getString();
            String a = reg.getString().replace("$", "");
            int monto = Integer.parseInt(a);
            Bicicleta bici = new Urbana(patente, 30, monto);
            this.listaBicicletas.insertarUltimo(bici);
        }
        archUrbana.close();
    }

    /**
     *Lee el archivo bicicletas MTB
     * @throws IOException
     */
    @Override
    public void leerMontania() throws IOException {
        ArchivoEntrada archMTB = new ArchivoEntrada("Bicicletas_MTB.txt");
        
        while(!archMTB.isEndFile()){
            Registro reg = archMTB.getRegistro();
            String patente = reg.getString();
            String a = reg.getString().replace("$", "");
            int monto = Integer.parseInt(a);
            Bicicleta bici = new Montania(patente, 40, monto);
            this.listaBicicletas.insertarUltimo(bici);
        }
        archMTB.close();
    }

    /**
     *Lee el archivo zonas
     * @throws IOException
     */
    @Override
    public void leerZonas() throws IOException {
        ArchivoEntrada archZonas = new ArchivoEntrada("Zonas.txt");
        
        while(!archZonas.isEndFile()){
            Registro reg = archZonas.getRegistro();
            String nombre = reg.getString();
            String color = reg.getString();
            double monto = reg.getDouble();
            Zona zona = new Zona(nombre, color, monto);
            this.listaZonas.add(zona);
        }
        archZonas.close();
    }
    
    
}
