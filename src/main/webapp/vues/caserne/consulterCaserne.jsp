<%-- 
    Document   : consulterCaserne
    Created on : 27 mars 2025, 10:42:11
    Author     : TS1SIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Caserne"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <%
            Caserne c = (Caserne)request.getAttribute("cCaserne");
        %>
        <h1>Bienvenue à la caserne de<%  out.println(c.getVille());%></h1>
        <table>
            <tr>
                <td>Lieux : </td><td><%  out.println(c.getVille()+' '+c.getAdresse()+' '+c.getCpos());%></td>
            </tr>
            <tr>
                <td>Caserne Id : </td><td><%  out.println(c.getId());%></td>
            </tr>
        </table>
    </body>
</html>

