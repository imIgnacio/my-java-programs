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
public abstract class Bicicleta {
    
    protected String patente;
    protected double velocidad;
    protected double costoMantencion;

    public Bicicleta(String patente, double velocidad, double costoMantencion) {
        this.patente = patente;
        this.velocidad = 0;
        this.costoMantencion = 0;
    }
    
    public abstract double costoMantencionAplicada(double costoMantencion);

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getCostoMantencion() {
        return costoMantencion;
    }

    public void setCostoMantencion(double costoMantencion) {
        this.costoMantencion = costoMantencion;
    }
}
