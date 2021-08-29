package taller4;

/**
 *
 * @author luisr
 */
public class NodoRepartidor {
    
    private Repartidor repartidor;
    private NodoRepartidor next;
    
    public NodoRepartidor(Repartidor repartidor){
        this.repartidor = repartidor;
        next = null;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public NodoRepartidor getNext() {
        return next;
    }

    public void setNext(NodoRepartidor next) {
        this.next = next;
    }   
}
