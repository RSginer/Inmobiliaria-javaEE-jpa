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
 * @author alumno
 */
@Entity
@Table(name="clientes")
@NamedQueries({
@NamedQuery(name="cliente.findAll", query ="SELECT c "
        + " FROM Cliente c ORDER BY c.id")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="nombre_completo",nullable=false, length=50)
    private String nombreCompleto;
    
    @Column(name="telefon",nullable=false,length=9)
    private Integer telefono;
    
    @Column(name="email",nullable=false,length=50)
    private String email;
    
    @Enumerated(EnumType.STRING)
    private tipoCliente tipoCliente;
     
    

    public Cliente() {
    }
    
    public Cliente(Integer identificador, String nombreCompleto, Integer telefono, String email) {
        this.id = identificador;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
    }

    public Cliente(Integer identificador, String nombreCompleto) {
        this.id = identificador;
        this.nombreCompleto = nombreCompleto;
    }
    public Cliente(Integer id){
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public tipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(tipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
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
        return "Cliente{" + "identificador=" + id + 
                ", nombreCompleto=" +nombreCompleto + 
                ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    
}
