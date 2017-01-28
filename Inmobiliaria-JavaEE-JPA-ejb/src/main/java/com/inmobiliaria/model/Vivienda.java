/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian Begines
 */
@Entity
@Table(name="viviendas")
@NamedQueries({
@NamedQuery(name="vivienda.findAll", query ="SELECT v "
        + " FROM Vivienda v ORDER BY v.id")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vivienda implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_vivienda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name="clientes_vivienda",
    joinColumns=@JoinColumn(name="id_vivienda"),inverseJoinColumns=@JoinColumn(name="id_cliente"))                                                 
    private Cliente idInteresado;
    
    @Column(name="direccion",nullable=false,length=50)
    private String direccion;
    @Column(name="precio",nullable=false)
    private Double precio; 
    
    @Enumerated(EnumType.STRING)
    private tipoVivienda tipoVivienda;
    
    @OneToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "clientes")
    private Cliente propietario;
    private Double superficie;

    public Vivienda(Integer idVivienda, Cliente idInteresado, String direccion, Double precio, Double superficie) {
        this.id = idVivienda;
        this.idInteresado = idInteresado;
        this.direccion = direccion;
        this.precio = precio;
        this.superficie = superficie;
    }
    public Vivienda(){
        
    }
    public Vivienda(Integer idVivienda, String direccion) {
        this.id = idVivienda;
        this.direccion = direccion;
    }
    
    
    /**
     * @return the idVivienda
     */
    public Integer getId() {
        return id;
    }

    public tipoVivienda getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(tipoVivienda tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    /**
     * @param idVivienda the idVivienda to set
     */
    public void setId(Integer idVivienda) {
        this.id = idVivienda;
    }

    /**
     * @return the idInteresado
     */
    public Cliente getIdInteresado() {
        return idInteresado;
    }

    /**
     * @param idInteresado the idInteresado to set
     */
    public void setIdInteresado(Cliente idInteresado) {
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
    public Cliente   getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(Cliente propietario) {
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
        return "Vivienda{" + "idVivienda=" + id + ", idInteresado=" + idInteresado +
                ", direccion=" + direccion + ", precio=" + precio +
                ", propietario=" + propietario + ", superficie=" + superficie + '}';
    }
    
    

   
    
    
}
