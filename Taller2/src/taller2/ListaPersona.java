/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

import java.io.*;
import ucn.*;

/**
 *
 * @author Ignacio
 */
public class ListaPersona {
    
    private Persona[] listaPersona;
    private int cantidadPersona;
    private int maxPersona;

    public ListaPersona(int maxPersona) {
        listaPersona = new Persona[maxPersona];
        cantidadPersona = 0;
        this.maxPersona = maxPersona;
    }

    public Persona[] getListaPersona() {
        return listaPersona;
    }

    public int getCantidadPersona() {
        return cantidadPersona;
    }

    public int getMaxPersona() {
        return maxPersona;
    }
    
    public boolean ingresarPersona(Persona persona){
        if(cantidadPersona < maxPersona){
            listaPersona[cantidadPersona] = persona;
            cantidadPersona++;
            return true;
        }else{
            return false;
        }
    }
    
    public Persona buscarPersona(ListaPersona listaPersona, String rut){
        
        for(int i=0; i<cantidadPersona; i++){
            if(listaPersona.getListaPersona()[i].getRut().equals(rut)){
                return listaPersona.getListaPersona()[i];
            }
        }
        return null;
    }
    
    public boolean eliminarPersona(int posicion){
        
        if(posicion < 0 || posicion > this.listaPersona.length){
            return false;
        }
    
        if(posicion > this.cantidadPersona){
            return false;
        }
        for(int i = posicion; i < this.cantidadPersona; i++){
            this.listaPersona[i] = this.listaPersona[i+1];
        }
        cantidadPersona--;
        return true;
    }
}    

    
    

