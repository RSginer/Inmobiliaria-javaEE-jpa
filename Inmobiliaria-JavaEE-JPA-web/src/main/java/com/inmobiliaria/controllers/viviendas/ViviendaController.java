/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controllers.viviendas;

import com.inmobiliaria.model.Vivienda;
import com.inmobiliaria.dao.viviendasDAOLocal;
import com.inmobiliaria.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "ClienteController",
        loadOnStartup = 1,
        urlPatterns = {
            "/app/ListaViviendasController",
            "/app/Vivienda/editar",
            "/app/Vivienda/modificar"
        })
public class ViviendaController extends HttpServlet {

    @EJB
    private viviendasDAOLocal viviendasDAO;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String userPath = request.getServletPath();
        if (userPath.equals("/app/ListaViviendasController")) {
            this.listarViviendas(request, response);
        } else if(userPath.contains("/app/Vivienda/editar")){
                this.editarVivienda(request, response);
        }else if(userPath.contains("/app/Vivienda/modificar")){
            this.modificarVivienda(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listarViviendas(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Vivienda> listaViviendas = viviendasDAO.getViviendas();
            request.setAttribute("listaViviendas", listaViviendas);
            RequestDispatcher rd = request.getRequestDispatcher("/app/viviendas/lista-viviendas.jsp");
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ViviendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViviendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editarVivienda(HttpServletRequest request, HttpServletResponse response) {
        String idVivienda = request.getParameter("id");
        if (idVivienda != null) {
            Integer id = Integer.parseInt(idVivienda);
            Vivienda vivienda = new Vivienda();
            try {
                vivienda = viviendasDAO.getViviendaById(id);
                request.setAttribute("vivienda", vivienda);
                RequestDispatcher rd = request.getRequestDispatcher("/app/viviendas/vivienda.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void modificarVivienda(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idVivienda");
        String idInteresado = request.getParameter("idInteresado");
        String direccion = request.getParameter("direccion");
        String precio = request.getParameter("precio");
        String superficie = request.getParameter("superficie");
      

        Vivienda vivienda = new Vivienda();
        vivienda.setId(Integer.parseInt(id));
        //vivienda.setIdInteresado(Integer.parseInt(idInteresado));
        vivienda.setPrecio(Double.parseDouble(precio));
        vivienda.setDireccion(direccion);
        vivienda.setSuperficie(Double.parseDouble(superficie));   
        try {
            viviendasDAO.updateVivienda(vivienda);
            List<Vivienda> listaViviendas = new ArrayList();
            listaViviendas = viviendasDAO.getViviendas();
            request.setAttribute("listaViviendas", listaViviendas);
            RequestDispatcher rd = request.getRequestDispatcher("/app/viviendas/lista-viviendas.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
