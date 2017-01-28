/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.dao;

import com.inmobiliaria.model.Vivienda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface viviendasDAOLocal {

    List<Vivienda> getViviendas();

    Vivienda getViviendaById(int idVivienda);

    boolean updateVivienda(Vivienda vivienda);
    
}
