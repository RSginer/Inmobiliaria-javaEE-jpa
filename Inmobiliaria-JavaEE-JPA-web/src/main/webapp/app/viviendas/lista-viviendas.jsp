<%-- 
    Document   : lista-viviendas
    Created on : 21-oct-2016, 10:50:57
    Author     : alumno
--%>

<%@page import="com.inmobiliaria.model.Vivienda"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        
    </head>
    <body>
      <table>
            <thead>
                <tr>
                    <th>
                        Id vivienda
                    </th>
                    <th>
                        Id Interesado
                    </th>
                    <th>
                        Direccion
                    </th>
                    <th>
                        precio
                    </th>               
                    <th>
                        Superficie
                    </th>               
                    <th>
                        Propietario
                    </th>               
                </tr>
            </thead>
            <tbody> 
             <%
                    List<Vivienda> listaVivienda = (List<Vivienda>) request.getAttribute("listaViviendas");
                    for (Vivienda v : listaVivienda) {
                      Integer idVivienda=v.getIdVivienda();
                      Integer idInteresado = v.getIdInteresado();
                      String direccion = v. getDireccion();
                      Double precio= v.getPrecio();
                      Double superficie=v.getSuperficie();
                      String propietario=v.getPropietario();
                %>      
                <tr>
                    <td>
                        <%=idVivienda%>
                    </td>
                    <td>
                        <%=idInteresado%>
                    </td>
                    <td>
                        <%=direccion%>
                    </td>
                    <td>
                        <%=precio%>
                    </td>
                    <td>
                        <%=superficie%>
                    </td>
                    <td>
                        <%=propietario%>
                    </td>
                    <td>
                        <button><a href="ViviendaController?accion=editar&id=<%=idVivienda%>"><i class="fa fa-pencil" aria-hidden="true"></i></a></button>
                    </td>
                    
                </tr>
                <%}
                %>  
               
            </tbody>
        </table> 
                <button><a href="LoginController">volver al inicio</a></button>
    </body>
</html>
