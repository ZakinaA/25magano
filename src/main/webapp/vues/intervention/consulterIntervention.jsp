<%-- 
    Document   : consulterIntervention
    Created on : 27 mars 2025, 09:39:50
    Author     : TS1SIO
--%>
<%@ page import="model.Intervention" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <%
            Intervention i = (Intervention)request.getAttribute("pUneIntervention");
        %>
        <h1>Voici l'intervention numéro <% i.getId();%> :</h1>
        <table>
            <tr>
                <td>ID : </td><td><% i.getId();%></td>
            </tr>
            <tr>
                <td>Lieu : </td><td><% i.getLieu();%></td>
            </tr>
            <tr>
                <td>Date d'intervention : </td><td><% i.getDateInter();%></td>
            </tr>
            <tr>
                <td>Heure d'appel : </td><td><% i.getHeureAppel();%></td>
            </tr>
            <tr>
                <td>Heure d'arrivée : </td><td><% i.getHeureArrive();%></td>
            </tr>
            <tr>
                <td>Durée : </td><td><% i.getDuree();%></td>
            </tr>
            <tr>
                <td>Type de Situation : </td><td><% i.getSituation().getType();%></td>
            </tr>
        </table>
    </body>
</html>

