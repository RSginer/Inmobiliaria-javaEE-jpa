
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : lista-clientes
    Created on : 21-oct-2016, 10:51:08
    Author     : alumno
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="cliente" scope="session" class="com.inmobiliaria.model.Cliente" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListarClientes</title>
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
                <c:forEach var="c" items="session.getAttribute('listaClientes')">
                        <jsp:setProperty name="cliente" property="email" value="${c.email}" />
                        <jsp:setProperty name="cliente" property="telefono" value="${c.telefono}" />
                        <jsp:setProperty name="cliente" property="nombre" value="${c.nombreCompleto}" />
                        <jsp:setProperty name="cliente" property="identificador" value="${c.identificador}" />
                          <tr>
                        <td>
                            <jsp:getProperty name="cliente" property="identificador" />
                        </td>
                        <td>
                            <jsp:getProperty name="cliente" property="nombreCompleto" />
                        </td>
                        <td>
                            <jsp:getProperty name="cliente" property="email" />
                        </td>
                        <td>
                            <jsp:getProperty name="cliente" property="telefono" />
                        </td>
                    </tr>
                </c:forEach>            
            </tbody>
        </table>
    </body>
</html>
