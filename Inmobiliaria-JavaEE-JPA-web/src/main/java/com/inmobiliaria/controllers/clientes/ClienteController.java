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
            "/app/ListaClientesController",
            "/app/Cliente/editar",
            "/app/Cliente/modificar"
        })
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
        String userPath = request.getServletPath();
        if (userPath.equals("/app/ListaClientesController")) {
            listarClientes(request, response);

        } else if(userPath.contains("/app/Cliente/editar")){
                editarCliente(request, response);
        }else if(userPath.contains("/app/Cliente/modificar")){
                this.updateCliente(request, response);
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

    private void listarClientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Cliente> listaClientes = clientesDAO.getClientes();
            request.setAttribute("listaClientes", listaClientes);
            RequestDispatcher rd = request.getRequestDispatcher("/app/clientes/lista-clientes.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void updateCliente(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("identificador");
        String nombreCompleto = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");

        Cliente cliente = new Cliente();
        cliente.setIdentificador(Integer.parseInt(id));
        cliente.setNombreCompleto(nombreCompleto);
        cliente.setTelefono(Integer.parseInt(telefono));
        cliente.setEmail(email);
        try {
            clientesDAO.updateCliente(cliente);
            List<Cliente> listaClientes = new ArrayList();
            listaClientes = clientesDAO.getClientes();
            request.setAttribute("listaClientes", listaClientes);
            RequestDispatcher rd = request.getRequestDispatcher("/app/clientes/lista-clientes.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) {
        String idCliente = request.getParameter("id");
        if (idCliente != null) {
            Integer id = Integer.parseInt(idCliente);
            Cliente cliente = new Cliente();
            try {
                cliente = clientesDAO.getClienteById(id);
                request.setAttribute("cliente", cliente);
                RequestDispatcher rd = request.getRequestDispatcher("/app/clientes/cliente.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
           
        }
    }
 }
