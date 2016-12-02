
<%@page import="java.util.List"%>
<%@page import="com.inmobiliaria.model.Cliente"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : lista-clientes
    Created on : 21-oct-2016, 10:51:08
    Author     : alumno
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListarClientes</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>
                        Identificador
                    </th>
                    <th>
                        Nombre
                    </th>
                    <th>
                        Numero de telefono
                    </th>
                    <th>
                        email
                    </th>               
                </tr>
            </thead>
            <tbody> 
             <%
                    List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");
                    for (Cliente c : listaClientes) {
                        String nombre = c.getNombreCompleto();
                        Integer id = c.getIdentificador();
                        Integer numero = c.getTelefono();
                        String email = c.getEmail();
                %>
                <tr>
                    <td>
                        <%=id%>
                    </td>
                    <td>
                        <%=nombre%>
                    </td>
                    <td>
                        <%=numero%>
                    </td>
                    <td>
                        <%=email%>
                    </td>
                    <td>
                        <button><a href="ClienteController?accion=editar&id=<%=id%>"><i class="fa fa-pencil" aria-hidden="true"></i></a></button>
                    </td>
                    
                </tr>
                <%}
                %>  
               
            </tbody>
        </table>
    </body>
</html>
