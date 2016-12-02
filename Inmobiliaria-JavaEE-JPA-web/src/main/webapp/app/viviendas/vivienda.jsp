<%-- 
    Document   : vivienda
    Created on : 21-oct-2016, 13:24:01
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
        <h1>Modificar Vivienda</h1>
        <form action="ViviendaController?accion=modificar&id=${vivienda.getIdVivienda()}" method="post">
            <div>
                <label for="idVivienda">IdVivienda:</label>
                <input id="idVivienda" type="text" name="idVivienda" value="${vivienda.getIdVivienda()}">
            </div>
            <div>
                <label for="idInteresado">IdInteresado</label>
                <input id="idInteresado" type="text" name="idInteresado" value="${vivienda.getIdInteresado()}">
            </div>
            <div>
                <label for="direccion">Direccion:</label>
                <input id="direccion" type="text" name="direccion" value="${vivienda.getDireccion()}">
            </div>
            <div>
                <label for="precio">Precio:</label>
                <input id="precio" type="text" name="precio" value="${vivienda.getPrecio()}">
            </div>
            <div>
                <label for="propietario">Propietario:</label>
                <input id="propietario" type="text" name="propietario" value="${vivienda.getPropietario()}">
            </div>
            <div>
                <label for="superficie">Superficie</label>
                <input id="superficie" type="text" name="superficie" value="${vivienda.getSuperficie()}">
            </div>
            <input type="submit" name="guardar" value="guardar">
        </form>
    </body>
</html>
