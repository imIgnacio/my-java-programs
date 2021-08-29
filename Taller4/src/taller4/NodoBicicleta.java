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
public class NodoBicicleta {
    
    private Bicicleta bicicleta;
    private NodoBicicleta next;

    public NodoBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
        this.next = null;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }
    
    public NodoBicicleta getNext() {
        return next;
    }

    public void setNext(NodoBicicleta next) {
        this.next = next;
    }
}
