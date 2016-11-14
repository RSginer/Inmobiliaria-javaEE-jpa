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
        Cliente c1 = new Cliente(1, "pepe");
        Cliente c2 = new Cliente(2, "juan");
        Cliente c3 = new Cliente(3, "jose");
        listaClientes.add(c3);
        listaClientes.add(c2);
        listaClientes.add(c1);
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
    
}
