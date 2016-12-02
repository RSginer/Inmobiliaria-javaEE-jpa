/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria;

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
    
    static{
       Vivienda v1=new Vivienda(1,1,"calle Germanias",80.000,"jose",200.00); 
       Vivienda v2=new Vivienda(2,3,"calle de la reina",80.000,"jose",200.00); 
       Vivienda v3=new Vivienda(3,2,"calle vicente ferrer",80.000,"jose",200.00); 
       Vivienda v4=new Vivienda(4,6,"calle del rey",80.000,"jose",200.00); 
       listaViviendas.add(v1);
       listaViviendas.add(v2);
       listaViviendas.add(v3);
       listaViviendas.add(v4);
    }
    
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
            if (v.getIdVivienda() == idVivienda) {
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
            if (listaViviendas.get(i).getIdVivienda() == vivienda.getIdVivienda()) {
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
