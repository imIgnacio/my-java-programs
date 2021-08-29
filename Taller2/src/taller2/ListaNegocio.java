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
public class ListaNegocio {
    
    private int cantidadNegocio;
    private Negocio[] listaNegocio;
    private int maxNegocio;

    public ListaNegocio(int maxNegocio) {
        listaNegocio = new Negocio[maxNegocio];
        cantidadNegocio = 0;
        this.maxNegocio = maxNegocio;
    }

    public int getCantidadNegocio() {
        return cantidadNegocio;
    }

    public Negocio[] getListaNegocio() {
        return listaNegocio;
    }

    public int getMaxNegocio() {
        return maxNegocio;
    }
    
    public boolean ingresarNegocio(Negocio negocio){
        if(cantidadNegocio < maxNegocio){
            listaNegocio[cantidadNegocio] = negocio;
            cantidadNegocio++;
            return true;
        }else{
            return false;
        }
    }
    
    public Negocio buscarNegocio(ListaNegocio listaNegocio, String nombreNegocio){
        
        for(int i=0; i<cantidadNegocio; i++){
            if(listaNegocio.getListaNegocio()[i].getNombreNegocio().equals(nombreNegocio)){
                return listaNegocio.getListaNegocio()[i];
            }
        }
        return null;
    } 
    
    public boolean eliminarNegocio(int posicion){
        
        if(posicion < 0 || posicion > this.listaNegocio.length){
            return false;
        }
    
        if(posicion > this.cantidadNegocio){
            return false;
        }
        for(int i = posicion; i < this.cantidadNegocio; i++){
            this.listaNegocio[i] = this.listaNegocio[i+1];
        }
        cantidadNegocio--;
        return true;
    }
}
