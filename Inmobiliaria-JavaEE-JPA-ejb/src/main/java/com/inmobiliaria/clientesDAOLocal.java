/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria;

import com.inmobiliaria.model.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local

public interface clientesDAOLocal {

    List<Cliente> getClientes();

    Cliente getClienteById(int id);

    boolean updateCliente(Cliente cliente);
    
}