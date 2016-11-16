<%@page import="com.inmobiliaria.model.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : login
    Created on : 21-oct-2016, 10:48:54
    Author     : alumno
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../assets/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="login">
            <form action="LoginController" method="POST">
                <h1 class="login__title">Inicia sesión para continuar</h1>
                <label class="login__label" for="userName">Usuario </label><input id="userName" type="text" name="userName">
                <label class="login__label" for="password">Contraseña </label><input type="password" id="password" name="password">
                <input class="btn btn--login" type="submit" value="Entrar">
                <c:if test="${ user != null}" var="test" scope="session">
                    <p class="login__error">Usuario o contraseña incorrectos</p>
                </c:if>
            </form>
        </div>
    </body>
</html>
