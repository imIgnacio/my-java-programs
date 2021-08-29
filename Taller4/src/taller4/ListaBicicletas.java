/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;

/**
 *
 * @author Ignacio
 */
public class ListaBicicletas {
    
    private NodoBicicleta first;

    public ListaBicicletas() {
        this.first = null;
    }

    public NodoBicicleta getFirst() {
        return first;
    }

    public void setFirst(NodoBicicleta first) {
        this.first = first;
    }
    
    public boolean isEmpty(){
        if(first == null)
            return true;
        return false;
    }
    
    /**
     *  Si la lista está vacía, inserta una Bicicleta al comienzo
     * @param bicicleta
     * @return boolean
     */
    public boolean insertarDespues(Bicicleta bicicleta){
        NodoBicicleta nodo = new NodoBicicleta(bicicleta);
        if(this.first == null){
            this.first = nodo;
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Busca la bicicleta para eliminarla
     * @param bicicleta
     * @return boolean
     */
    public boolean eliminarDespues(Bicicleta bicicleta){
        //Si esta la lista vacia
        if(isEmpty())
            return false;
        
        NodoBicicleta actual = this.first;
        //Si hay un elemento en la lista
        if(actual.getNext() == null){
            if(actual.getBicicleta() == bicicleta){
                this.first = null;
                return true;
            }else{
                return false;
            }
        }
        //Si hay mas de un elemento
        while(actual.getNext().getNext() != null && actual.getNext().getBicicleta() != bicicleta){
            actual = actual.getNext();
        }
        if(actual.getNext().getNext() == null){
            if(actual.getNext().getBicicleta() == bicicleta){
                actual.setNext(null);
                return true;
            }else{
                return false;
            }
        }
        NodoBicicleta aEliminar = actual.getNext();
        actual.setNext(aEliminar.getNext());
        return true;
    }
    
    /**
     *  Inserta al final de la lista una Bicicleta
     * @param bicicleta
     * @return boolean
     */
    public boolean insertarUltimo(Bicicleta bicicleta){
        NodoBicicleta nuevoNodo = new NodoBicicleta(bicicleta);
        
        if(isEmpty()){
            this.first = nuevoNodo;
            return true;
        }
        
        NodoBicicleta actual = first;
        
        while(actual.getNext() != null){
            actual = actual.getNext();
        }
        
        actual.setNext(nuevoNodo);
        return true;
    }
    
    /**
     *  Busca la ultimo Bicicleta para eliminarlo
     * @param bicicleta
     * @return boolean
     */
    public boolean eliminarUltimo(Bicicleta bicicleta){
        NodoBicicleta actual = first;
        
        while(actual.getNext().getNext() != null){
            actual = actual.getNext();
        }
        actual.setNext(null);
        return true;
    }
}
