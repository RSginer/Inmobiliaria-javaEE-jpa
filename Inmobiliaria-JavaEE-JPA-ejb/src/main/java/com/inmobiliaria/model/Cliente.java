/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.model;

/**
 *
 * @author alumno
 */
public class Cliente {
    private Integer identificador;
    private String nombreCompleto;
    private Integer telefono;
    private String email;
    private enum tipoCliente{
        VENDEDOR,COMPRADOR,ALQUILADO
    }

    public Cliente(Integer identificador, String nombreCompleto, Integer telefono, String email) {
        this.identificador = identificador;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
    }

    public Cliente(Integer identificador, String nombreCompleto) {
        this.identificador = identificador;
        this.nombreCompleto = nombreCompleto;
    }
    
    
    
    /**
     * @return the identificador
     */
    public Integer getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the telefono
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "identificador=" + identificador + 
                ", nombreCompleto=" +nombreCompleto + 
                ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    
}
