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
public class Montania extends Bicicleta {

    public Montania(String patente, double velocidad, double costoMantencion) {
        super(patente, velocidad, costoMantencion);
        this.velocidad = 40;
        this.costoMantencion = costoMantencionAplicada(costoMantencion);
    }
 
    /**
     *
     * @param costoMantencion
     * @return costoMantencionAplicada
     */
    @Override
    public double costoMantencionAplicada(double costoMantencion){
        
        double CMA = 5000 + (costoMantencion*0.7);
        return CMA;
    }
}
