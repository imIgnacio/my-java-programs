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
public class Negocio {
    
    private String nombreNegocio;
    private String rutDuenio;
    private String tipoNegocio;
    private String domicilio;
    private String estadoNegocio;
    private String comuna;
    private String ciudad;
    private ListaPatente[] listaPatente;

    public Negocio(String nombreNegocio, String rutDuenio, String tipo, String domicilio, String estado, String comuna, String ciudad) {
        this.nombreNegocio = nombreNegocio;
        this.rutDuenio = rutDuenio;
        this.tipoNegocio = tipoNegocio;
        this.domicilio = domicilio;
        this.estadoNegocio = estadoNegocio;
        this.comuna = comuna;
        this.ciudad = ciudad;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getRutDuenio() {
        return rutDuenio;
    }

    public void setRutDuenio(String rutDuenio) {
        this.rutDuenio = rutDuenio;
    }

    public String getTipoNegocio() {
        return tipoNegocio;
    }

    public void setTipoNegocio(String tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEstadoNegocio() {
        return estadoNegocio;
    }

    public void setEstadoNegocio(String estadoNegocio) {
        this.estadoNegocio = estadoNegocio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ListaPatente[] getListaPatente() {
        return listaPatente;
    }

    
    
    @Override
    public String toString() {
        return "Negocio{" + "nombreNegocio = " + nombreNegocio + ", rutDuenio = " + rutDuenio + ", tipoNegocio = " + tipoNegocio + ", domicilio = " + domicilio + ", estadoNegocio = " + estadoNegocio + ", comuna = " + comuna + ", ciudad = " + ciudad + '}';
    }
    
    
    
}
