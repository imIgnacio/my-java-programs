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
public class Zona {
    private String nombreZona;
    private String colorZona;
    private double monto;

    public Zona(String nombreZona, String colorZona, double monto) {
        this.nombreZona = nombreZona;
        this.colorZona = colorZona;
        this.monto = monto;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public String getColorZona() {
        return colorZona;
    }

    public double getMonto() {
        return monto;
    }
}
