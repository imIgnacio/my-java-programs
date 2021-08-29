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

import ucn.*;
import java.io.*;
import java.util.*;

public class Persona {
    
    private String nombre;
    private String rut;
    private String fechaNacimiento;
    private String domicilio;
    private String ciudad;
    private String comuna;
    private ListaPersona[] listaPersona;
    private ListaNegocio[] listaNegocio;

    public Persona(String nombre, String rut, String fechaNacimiento, String domicilio, String ciudad, String comuna) {
        this.nombre = nombre;
        this.rut = rut;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.comuna = comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public ListaNegocio[] getListaNegocio() {
        return listaNegocio;
    }

    public ListaPersona[] getListaPersona() {
        return listaPersona;
    }
    
    
    

    @Override
    public String toString() {
        return "Persona{" + "nombre = " + nombre + ", rut = " + rut + ", fechaNacimiento = " + fechaNacimiento + ", domicilio = " + domicilio + ", ciudad = " + ciudad + ", comuna = " + comuna + '}';
    }
}
