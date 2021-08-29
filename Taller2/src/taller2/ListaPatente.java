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
public class ListaPatente {
    
    private Patente[] listaPatente;
    private int cantidadPatente;
    private int maxPatente;

    public ListaPatente(int maxPatente) {
        listaPatente = new Patente[maxPatente];
        cantidadPatente = 0;
        this.maxPatente = maxPatente;
    }

    public Patente[] getListaPatente() {
        return listaPatente;
    }

    public int getCantidadPatente() {
        return cantidadPatente;
    }

    public int getMaxPatente() {
        return maxPatente;
    }
    
    /**
     *
     * @param patente
     * @return
     */
    public boolean ingresarPatente(Patente patente){
        if(cantidadPatente < maxPatente){
            listaPatente[cantidadPatente] = patente;
            cantidadPatente++;
            return true;
        }else{
            return false;
        }
    }
    
    /**
     *
     * @param listaPatente
     * @param IDPatente
     * @return
     */
    public Patente buscarPatente(ListaPatente listaPatente, String IDPatente){
        
        for(int i=0; i<cantidadPatente; i++){
            if(listaPatente.getListaPatente()[i].getIDPatente().equals(IDPatente)){
                return listaPatente.getListaPatente()[i];
            }
        }
        return null;
    }
    
    public boolean eliminarPatente(int posicion){
        
        if(posicion < 0 || posicion > this.listaPatente.length){
            return false;
        }
    
        if(posicion > this.cantidadPatente){
            return false;
        }
        for(int i = posicion; i < this.cantidadPatente; i++){
            this.listaPatente[i] = this.listaPatente[i+1];
        }
        cantidadPatente--;
        return true;
    }
    
    
}
