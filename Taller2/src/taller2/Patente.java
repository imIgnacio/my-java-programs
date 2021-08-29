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
public class Patente {
    
    private String tipoPatente;
    private String IDPatente;
    private String nombreNegocio;
    private String domicilioNegocio;
    private double valor;
    private String estadoPatente;
    private String fechaVencimiento;

    public Patente(String IDPatente, String nombreNegocio, String tipoPatente, String domicilioNegocio, double valor, String estadoPatente, String fechaVencimiento) {
        this.IDPatente = IDPatente;
        this.nombreNegocio = nombreNegocio;
        this.tipoPatente = tipoPatente;
        this.domicilioNegocio = domicilioNegocio;
        this.valor = valor;
        this.estadoPatente = estadoPatente;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipoPatente() {
        return tipoPatente;
    }

    public void setTipoPatente(String tipoPatente) {
        this.tipoPatente = tipoPatente;
    }

    public String getIDPatente() {
        return IDPatente;
    }

    public void setIDPatente(String IDPatente) {
        this.IDPatente = IDPatente;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getDomicilioNegocio() {
        return domicilioNegocio;
    }

    public void setDomicilioNegocio(String domicilioNegocio) {
        this.domicilioNegocio = domicilioNegocio;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEstadoPatente() {
        return estadoPatente;
    }

    public void setEstadoPatente(String estadoPatente) {
        this.estadoPatente = estadoPatente;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Patente{" + "tipoPatente = " + tipoPatente + ", IDPatente = " + IDPatente + ", nombreNegocio = " + nombreNegocio + ", domicilioNegocio = " + domicilioNegocio + ", valor = " + valor + ", estadoPatente = " + estadoPatente + ", fechaVencimiento = " + fechaVencimiento + '}';
    }
    
    
    
    
    
    
}
