/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

/**
 *
 * @author Ignacio
 */

import ucn.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Taller2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        
        int maxNegocio = 100;
        int maxPersona = 100;
        int maxPatente = 100;
        
        ListaPersona listaPersona = new ListaPersona(maxPersona);
        ListaNegocio listaNegocio = new ListaNegocio(maxNegocio);
        ListaPatente listaPatente = new ListaPatente(maxPatente);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();
        String currentDate = formatter.format(date);
 
        leerArchivoPersona(listaPersona);
        leerArchivoNegocio(listaNegocio);
        leerArchivoPatente(listaPatente);
       
        
        
        
    }
    private static int leerArchivoPersona(ListaPersona listaPersona) throws IOException{
        
        ArchivoEntrada archivoPersona = new ArchivoEntrada("D:\\Ignacio\\Documentos\\NetBeansProjects\\Taller2\\src\\taller2\\persona.txt");
           int i = 0;

           while(!archivoPersona.isEndFile()){
               Registro reg = archivoPersona.getRegistro();

               String nombre = reg.getString().toLowerCase().replace(" ", "");
               String rut = reg.getString().replace("-", "");
               String fechaNacimiento = reg.getString();
               String domicilio = reg.getString().toLowerCase().replace(" ", "");
               String ciudad = reg.getString().toLowerCase();
               String comuna = reg.getString().toLowerCase();

               listaPersona.ingresarPersona( new Persona(nombre,rut,fechaNacimiento,domicilio,ciudad,comuna));
               i++;
           }
        return i;
    }
    
    private static int leerArchivoNegocio(ListaNegocio listaNegocio) throws IOException{
        
        ArchivoEntrada archivoNegocio = new ArchivoEntrada("D:\\Ignacio\\Documentos\\NetBeansProjects\\Taller2\\src\\taller2\\negocios.txt");
        int i = 0;
        
        while(!archivoNegocio.isEndFile()){
            Registro reg = archivoNegocio.getRegistro();
            
            String nombreNegocio = reg.getString().toLowerCase().replace(" ", "");
            String rutDuenio = reg.getString().replace("-", "");
            String tipoNegocio = reg.getString().toLowerCase();
            String domicilio = reg.getString().toLowerCase().replace(" ", "");
            String estado = reg.getString().toLowerCase();
            String comuna = reg.getString().toLowerCase();
            String ciudad = reg.getString().toLowerCase();
            
            listaNegocio.ingresarNegocio(new Negocio(nombreNegocio,rutDuenio,tipoNegocio,domicilio,estado,comuna,ciudad));
            i++;
        }
        return i;
    }
    
    private static int leerArchivoPatente(ListaPatente listaPatente) throws IOException{
        
        ArchivoEntrada archivoPatente = new ArchivoEntrada("D:\\Ignacio\\Documentos\\NetBeansProjects\\Taller2\\src\\taller2\\patentes.txt");
        int i = 0;
        
        while(!archivoPatente.isEndFile()){
            Registro reg = archivoPatente.getRegistro();
            
            String IDPatente = reg.getString();
            String nombreNegocio = reg.getString().toLowerCase().replace(" ", "");
            String tipoPatente = reg.getString().toLowerCase();
            String domicilioEmpresa = reg.getString().toLowerCase().replace(" ", "");
            double valor = reg.getDouble();
            String estado = reg.getString().toLowerCase().replace(" ","");
            String fechaVencimiento = reg.getString();
            
            listaPatente.ingresarPatente(new Patente(IDPatente,nombreNegocio,tipoPatente,domicilioEmpresa,valor,estado,fechaVencimiento));
            i++;
        }
        return i;
    }
    
    private static boolean clausurarNegocio(ListaNegocio listaNegocio){
        
        for(int i=0; i<listaNegocio.getCantidadNegocio();i++){
            
        }
    }
    
    private static void registrarDuenio(ListaPersona listaPersona, Persona persona){
        
        StdOut.print("Ingrese nombre de la persona: ");
        String nombre = StdIn.readLine().toLowerCase();
        StdOut.print("Ingrese rut de la persona (-1 para cancelar): ");
        String rut = StdIn.readLine().replace("-", "");
        if(rut.equals("-1")){

        }else{
            StdOut.print("Ingrese fecha de nacimiento de la persona (Formato dd/mm/aaaa): ");
            String fechaNacimiento = StdIn.readLine();
            StdOut.print("Ingrese domicilio de la persona: ");
            String domicilio = StdIn.readLine().toLowerCase().replace(" ", "").replace("-", "").replace("/", "");
            StdOut.print("Ingrese ciudad de la persona: ");
            String ciudad = StdIn.readLine().toLowerCase().replace(" ", "");
            StdOut.print("Ingrese comuna de la persona: ");
            String comuna = StdIn.readLine().toLowerCase().replace(" ", "");

            persona = Persona(nombre,rut,fechaNacimiento,domicilio,ciudad,comuna);

            ingresarPersona(persona);
        }  
    }
}
