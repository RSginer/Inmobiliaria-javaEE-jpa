<%-- 
    Document   : panelDeControl
    Created on : 21-oct-2016, 10:50:17
    Author     : alumno
--%>
<jsp:useBean id="user" scope="request"  class="com.inmobiliaria.model.Usuario" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../assets/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Bienvenido <jsp:getProperty name="user" property="userName"></jsp:getProperty></h1>
        <a href="ListaViviendasController" class="btn">Listado de viviendas</a>
        <a href="ListaClientesController" class="btn">Listado de clientes</a>
        <a href="#" class="btn">Alquilar vivienda</a>
        <a href="#" class="btn">Vender vivienda</a>
        <a href="#" class="btn">Alta cliente</a>
        <a href="#" class="btn">Baja cliente</a>
    </body>
</html>
