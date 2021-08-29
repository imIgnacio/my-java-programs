package taller4;

import java.io.IOException;

/**
 *
 * @author Ignacio
 */
public interface SistemaBikeRush {
    public boolean contratarRepartidor(String nombre,int edad,String direccion,String tipoBicicleta,String patente,String ID, int monto);
    public boolean despedirRepartidor(String ID);
    public void modificarRepartidor(NodoRepartidor nodo, String dato, String accion);
    public void modificarRepartidor(NodoRepartidor nodo, int edad);
    public void modificarRepartidor(Bicicleta bicicleta, Bicicleta nueva);
    public void modificarRepartidor(NodoRepartidor nodo, Bicicleta bicicleta, String patente);
    public boolean[] realizarEnvio(String nombreEmisor, String nombreReceptor, String direccionEmisor, String direccionReceptor, String nombreZonaReceptor);
    public boolean[] recepcionRepartidor(String ID);
    public NodoRepartidor buscarRepartidor(String ID);
    public boolean escribirArchivo();
    public void leerRepartidores() throws IOException;
    public void leerRuta() throws IOException;
    public void leerUrbana() throws IOException;
    public void leerMontania() throws IOException;
    public void leerZonas() throws IOException;
}
