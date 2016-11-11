/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria;

import com.inmobiliaria.exceptions.BussinessException;
import com.inmobiliaria.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface clientesDAOImplList {
   
     List<Cliente> getClientes() throws BussinessException;

     Cliente getClienteById(int id) throws BussinessException;

     boolean addCliente(Cliente Cliente);

     boolean removeCliente(Cliente Cliente);

     boolean updateCliente(clientesDAO Cliente);

}
