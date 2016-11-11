/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria;

import com.inmobiliaria.exceptions.BussinessException;
import com.inmobiliaria.model.Vivienda;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class viviendasDAOImplList implements viviendasDAO {

    @Override
    public List<Vivienda> getClientes() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vivienda getViviendaById() {
        return null;
    }

}
