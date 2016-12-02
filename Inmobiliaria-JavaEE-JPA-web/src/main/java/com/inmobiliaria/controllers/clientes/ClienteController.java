/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controllers.clientes;

import com.inmobiliaria.clientesDAOLocal;
import com.inmobiliaria.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
public class ClienteController extends HttpServlet {

    @EJB
    private clientesDAOLocal clientesDAO;

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
        
        String accion=request.getParameter("accion");
        if(accion!=null && accion.equalsIgnoreCase("editar")){
            String idCliente= request.getParameter("id");
            if(idCliente!=null){
                Integer id= Integer.parseInt(idCliente);
                Cliente cliente= new Cliente();
                try{
                   cliente= clientesDAO.getClienteById(id);
                }catch(Exception e){
                    e.printStackTrace();
                }
                request.setAttribute("cliente", cliente);
                RequestDispatcher rd = request.getRequestDispatcher("/app/clientes/cliente.jsp");
                rd.forward(request, response);
            }
        }else if(accion!=null && accion.equalsIgnoreCase("modificar")){
            String id = request.getParameter("identificador");
            String nombreCompleto= request.getParameter("nombre");
            String telefono= request.getParameter("telefono");
            String email = request.getParameter("email");
            
            Cliente cliente= new Cliente();
            cliente.setIdentificador(Integer.parseInt(id));
            cliente.setNombreCompleto(nombreCompleto);
            cliente.setTelefono(Integer.parseInt(telefono));
            cliente.setEmail(email);
             try{
                 clientesDAO.updateCliente(cliente);
             }catch(Exception e){
                 e.printStackTrace();
             }
             List<Cliente>listaClientes= new ArrayList();
             listaClientes=clientesDAO.getClientes();
             request.setAttribute("listaClientes", listaClientes);
             RequestDispatcher rd = request.getRequestDispatcher("/app/clientes/lista-clientes.jsp");
             rd.forward(request, response);
            
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

}
