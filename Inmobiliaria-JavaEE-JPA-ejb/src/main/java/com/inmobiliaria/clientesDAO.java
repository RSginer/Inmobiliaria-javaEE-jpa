/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria;


import com.inmobiliaria.model.Cliente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class clientesDAO implements clientesDAOLocal {
    public static  List<Cliente> listaClientes=new ArrayList();

    static{
        Cliente c1 = new Cliente(1, "pepe",657849604,"pepe@gmail.com");
        Cliente c2 = new Cliente(2, "juan",564343733,"juan@gmail.com");
        Cliente c3 = new Cliente(3, "jose",654869708,"jose@gmail.com");
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
    }

    
    @Override
    public List<Cliente> getClientes() {
        return listaClientes;
    }
    
    
    @Override
    public Cliente getClienteById(int id) {
        boolean encontrado = false;
        Cliente c = null;
        Iterator ir = listaClientes.iterator();
        while (ir.hasNext() && encontrado == false) {
            c = (Cliente) ir.next();
            if (c.getIdentificador() == id) {
                encontrado = true;
            }
        }
        return c;
    }

    @Override
    public boolean updateCliente(Cliente cliente) {
        
        boolean encontrado = false;
        int i = 0;

        while ((i < listaClientes.size()) && (encontrado == false)) {
            if (listaClientes.get(i).getIdentificador() == cliente.getIdentificador()) {
                encontrado = true;
            } else {
                i++;
            }
        }      
        if (encontrado == true) {
            listaClientes.set(i, cliente);
        }
        return encontrado;
    }
    
    
}
