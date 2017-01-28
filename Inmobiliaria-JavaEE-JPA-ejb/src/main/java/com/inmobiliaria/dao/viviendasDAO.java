/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.dao;

import com.inmobiliaria.model.Vivienda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class viviendasDAO implements viviendasDAOLocal {
    
    public static List<Vivienda> listaViviendas= new ArrayList();
    
  
    @Override
    public List<Vivienda> getViviendas() {
        return listaViviendas;
    }

    @Override
    public Vivienda getViviendaById(int idVivienda) {
         boolean encontrado = false;
        Vivienda v = null;
        Iterator ir = listaViviendas.iterator();
        while (ir.hasNext() && encontrado == false) {
            v = (Vivienda) ir.next();
            if (v.getId() == idVivienda) {
                encontrado = true;
            }
        }
        return v;
    }

    @Override
    public boolean updateVivienda(Vivienda vivienda) {
        boolean encontrado = false;
        int i = 0;

        while ((i < listaViviendas.size()) && (encontrado == false)) {
            if (listaViviendas.get(i).getId() == vivienda.getId()) {
                encontrado = true;
            } else {
                i++;
            }
        }      
        if (encontrado == true) {
            listaViviendas.set(i, vivienda);
        }
        return encontrado;
    }
    
    
}
