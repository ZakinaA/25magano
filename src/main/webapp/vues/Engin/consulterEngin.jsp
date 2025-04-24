<%-- 
    Document   : consulterEngin
    Created on : 27 mars 2025, 09:39:50
    Author     : TS1SIO
--%>
<%@ page import="model.Engin" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <%
            Engin e = (Engin) request.getAttribute("pUnEngin");
        %>
        <h1>Voici l'Engin numéro <% e.getId(); %> :</h1>
        <table>
            <tr>
                <td>ID : </td><td><%= e.getId() %></td>
            </tr>
            <tr>
                <td>Type : </td><td><%= e.getType() %></td>
            </tr>
            <tr>
                <td>Numéro Ordre : </td><td><%= e.getNumOrdre() %></td>
            </tr>
            <tr>
                <td>Caserne Id : </td><td><%= e.getCaserne() %></td>
            </tr>
            
        </table>
    </body>
</html>

