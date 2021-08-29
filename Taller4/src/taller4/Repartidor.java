package taller4;

/**
 *
 * @author luisr
 */
public class Repartidor {
    
    private String ID;
    private String nombre;
    private int edad;
    private String direccion;
    private Bicicleta bicicleta;
    private boolean disponibilidad;

    public Repartidor(String ID, String nombre, int edad, String direccion, Bicicleta bicicleta) {
        this.ID = ID;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.bicicleta = bicicleta;
        this.disponibilidad = true;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }   

    @Override
    public String toString() {
        return "Repartidor{" + "ID=" + ID + ", nombre=" + nombre + ", edad=" + edad + ", direccion=" + direccion + ", bicicleta=" + bicicleta + ", disponibilidad=" + disponibilidad + '}';
    }
}
