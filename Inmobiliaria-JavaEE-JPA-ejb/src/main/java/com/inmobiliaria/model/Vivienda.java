/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.model;

/**
 *
 * @author Christian Begines
 */
public class Vivienda {
    
    private Integer idVivienda;
    private Integer idInteresado;    
    private String direccion;
    private Double precio; 
    private enum tipoVenta{
        ALQUILAR,VENDER,AMBOS
    }
    private String propietario;
    private Double superficie;

    /**
     * @return the idVivienda
     */
    public Integer getIdVivienda() {
        return idVivienda;
    }

    /**
     * @param idVivienda the idVivienda to set
     */
    public void setIdVivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    /**
     * @return the idInteresado
     */
    public Integer getIdInteresado() {
        return idInteresado;
    }

    /**
     * @param idInteresado the idInteresado to set
     */
    public void setIdInteresado(Integer idInteresado) {
        this.idInteresado = idInteresado;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the propietario
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    /**
     * @return the superficie
     */
    public Double getSuperficie() {
        return superficie;
    }

    /**
     * @param superficie the superficie to set
     */
    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    @Override
    public String toString() {
        return "Vivienda{" + "idVivienda=" + idVivienda + ", idInteresado=" + idInteresado +
                ", direccion=" + direccion + ", precio=" + precio +
                ", propietario=" + propietario + ", superficie=" + superficie + '}';
    }
    
    

   
    
    
}
