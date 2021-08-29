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
public class Envio {
    
    private String nombreEmisor;
    private String nombreReceptor;
    private String direccionEmisor;
    private String direccionReceptor;
    private Zona zona;
    private Repartidor repartidor;
    private double valorEnvio;
    private boolean estadoEnvio;
    private int numeroEnvio;

    public Envio(String nombreEmisor, String nombreReceptor, String direccionEmisor, String direccionReceptor, Zona zona, Repartidor repartidor, int numeroEnvio) {
        this.nombreEmisor = nombreEmisor;
        this.nombreReceptor = nombreReceptor;
        this.direccionEmisor = direccionEmisor;
        this.direccionReceptor = direccionReceptor;
        this.zona = zona;
        this.repartidor = repartidor;
        this.valorEnvio = this.calcularEnvio(zona.getMonto(), repartidor.getBicicleta().getCostoMantencion());
        this.estadoEnvio = false;
        this.numeroEnvio = numeroEnvio;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getDireccionEmisor() {
        return direccionEmisor;
    }

    public void setDireccionEmisor(String direccionEmisor) {
        this.direccionEmisor = direccionEmisor;
    }

    public String getDireccionReceptor() {
        return direccionReceptor;
    }

    public void setDireccionReceptor(String direccionReceptor) {
        this.direccionReceptor = direccionReceptor;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public boolean isEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(boolean estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public double getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(double valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public int getNumeroEnvio() {
        return numeroEnvio;
    }

    public void setNumeroEnvio(int numeroEnvio) {
        this.numeroEnvio = numeroEnvio;
    }
    
    private double calcularEnvio(double monto, double mantencion){
        double valor = (monto*mantencion)*0.8; 
        return valor;
    }   

    @Override
    public String toString() {
        return "Envio{" + "nombreEmisor=" + nombreEmisor + ", nombreReceptor=" + nombreReceptor + ", direccionEmisor=" + direccionEmisor + ", direccionReceptor=" + direccionReceptor + ", zona=" + zona + ", repartidor=" + repartidor + ", valorEnvio=" + valorEnvio + ", estadoEnvio=" + estadoEnvio + ", numeroEnvio=" + numeroEnvio + '}';
    }
    
    
}
