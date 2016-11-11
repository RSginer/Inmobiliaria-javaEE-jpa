/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.dao;

import com.inmobiliaria.exceptions.BussinessException;
import com.inmobiliaria.model.Cliente;
import com.inmobiliaria.model.Usuario;
import com.inmobiliaria.model.Vivienda;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface InmobiliariaDAO {
    public List<Vivienda> getViviendas() throws BussinessException;
    public Vivienda getViviendaById(Integer id) throws BussinessException;
    public boolean updateVivienda(Integer id) throws BussinessException;
    public boolean removeVivienda(Integer id) throws BussinessException;
    public List<Cliente> getClientes() throws BussinessException;
    public Cliente getClienteById(int Integer) throws BussinessException;
    public boolean updateCliente(int Integer) throws BussinessException;
    public boolean removeCliente(int Integer) throws BussinessException;
    public boolean compruebaUsuario(Usuario user) throws BussinessException;
}
