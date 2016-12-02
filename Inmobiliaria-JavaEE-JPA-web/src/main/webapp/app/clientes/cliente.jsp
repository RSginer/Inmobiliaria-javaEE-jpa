<%-- 
    Document   : cliente
    Created on : 21-oct-2016, 13:25:59
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar Cliente</h1>
        <form action="ClienteController?accion=modificar&id=${cliente.getIdentificador()}" method="POST">
            <div>
                  <label for="identificador">Identificador:</label>
            <input id="identificador" type="text" name="identificador" value="${cliente.getIdentificador()}">
            </div>
            <div>
                 <label for="nombre">Nombre Completo</label>
            <input id="nombre" type="text" name="nombre" value="${cliente.getNombreCompleto()}">
            </div>
            <div>
                <label for="identificador">telefono</label>
            <input id="telefono" type="text" name="telefono" value="${cliente.getTelefono()}">
            </div>
            <div>
                 <label for="email">email</label>
            <input id="email" type="text" name="email" value="${cliente.getEmail()}">
            </div>
            <input type="submit" name="guardar" value="guardar">
        </form>
    </body>
</html>
