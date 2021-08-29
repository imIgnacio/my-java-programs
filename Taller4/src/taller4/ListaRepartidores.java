package taller4;

/**
 *
 * @author luisr
 */
public class ListaRepartidores {
    
    private NodoRepartidor first;
    
    public ListaRepartidores(){
        first = null;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    /**
     *  Inserta al final de la lista un Repartidor
     * @param repartidor
     * @return boolean
     */
    public boolean insertarUltimo(Repartidor repartidor){
        NodoRepartidor nuevoRepartidor = new NodoRepartidor(repartidor);
        if(this.first == null){
            this.first = nuevoRepartidor;
            return true;
        }
        NodoRepartidor actual = first;
        while(actual.getNext() != null){
            actual = actual.getNext();
        }
        if(actual.getNext() == null){
            actual.setNext(nuevoRepartidor);
            return true;
        }
        return false;
    }
    
    /**
     *  Busca el ultimo Repartidor para eliminarlo
     * @param repartidor
     * @return boolean
     */
    public boolean eliminarUltimo(Repartidor repartidor){
        NodoRepartidor actual = first;
        while(actual.getNext().getNext() != null){
            actual = actual.getNext();
        }
        if(actual.getNext().getNext() == null){
            actual.setNext(null);
            return true;
        }
        return false;
    }
    
    /**
     *  Si la lista está vacía, inserta un Repartidor al comienzo
     * @param repartidor
     * @return boolean
     */
    public boolean insertarDespues(Repartidor repartidor){
        NodoRepartidor nuevoRepartidor = new NodoRepartidor(repartidor);
        if(isEmpty()){
            this.first = nuevoRepartidor;
            return true;
        }
        return false;
    }
    
    /**
     *  Busca un Repartidor para eliminarlo
     * @param ID
     * @return boolean
     */
    public boolean eliminarDespues(String ID){
        //Si esta la lista vacia
        if(isEmpty())
            return false;
        
        NodoRepartidor actual = this.first;
        //Si hay un elemento en la lista
        if(actual.getNext() == null){
            if(actual.getRepartidor().getID().equalsIgnoreCase(ID)){
                Bicicleta bicicleta = actual.getRepartidor().getBicicleta();
                this.first = null;
                return true;
            }else{
                return false;
            }
        }
        //Si hay mas de un elemento
        while(actual.getNext().getNext() != null && !actual.getNext().getRepartidor().getID().equalsIgnoreCase(ID)){
            actual = actual.getNext();
        }
        if(actual.getNext().getNext() == null){
            if(actual.getNext().getRepartidor().getID().equalsIgnoreCase(ID)){
                actual.setNext(null);
                return true;
            }else{
                return false;
            }
        }
        NodoRepartidor aEliminar = actual.getNext();
        actual.setNext(aEliminar.getNext());
        return true;
    }

    public NodoRepartidor getFirst() {
        return first;
    }

    public void setFirst(NodoRepartidor first) {
        this.first = first;
    }
}
