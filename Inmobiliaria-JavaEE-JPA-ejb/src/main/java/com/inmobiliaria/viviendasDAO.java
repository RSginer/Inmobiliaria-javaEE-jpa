/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria;

import com.inmobiliaria.model.Vivienda;
import java.util.ArrayList;
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
       Vivienda v1=new Vivienda(1,"calle Germanias"); 
       Vivienda v2=new Vivienda(2,"calle de la reina"); 
       Vivienda v3=new Vivienda(3,"calle vicente ferrer"); 
       Vivienda v4=new Vivienda(4,"calle del rey"); 
       listaViviendas.add(v1);
       listaViviendas.add(v2);
       listaViviendas.add(v3);
       listaViviendas.add(v4);
    }
    
    @Override
    public List<Vivienda> getViviendas() {
        return listaViviendas;
    }

    
}
