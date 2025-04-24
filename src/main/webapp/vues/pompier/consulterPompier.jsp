<%-- 
    Document   : consulterPompier
    Created on : 18 mars 2024, 12:03:07
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pompier"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <%
            Pompier p = (Pompier)request.getAttribute("pPompier");
        %>
        <h1>Bienvenue <%  out.println(p.getPrenom());%>  <%  out.println(p.getNom());%></h1>
        <table>
            <tr>
                <td>Date de naissance : </td><td><%  out.println(p.getDateNaissance());%></td>
            </tr>
            <tr>
                <td>Numero Bip : </td><td>bip bip</td>
            </tr>
            <tr>
                <td>Type de Pompier : </td><td><%  out.println(p.getTypePompier());%></td>
            </tr>
            <tr>
                <td>Dernier Indice : </td><td><%  out.println(p.getPro_dernierIndice());%></td>
            </tr>
            <tr>
                <td>Date d'Obtention du Dernier Indice : </td><td><%  out.println(p.getPro_dateObtentionIndice());%></td>
            </tr>
            <tr>
                <td>Nom de Profession : </td><td><%  out.println(p.getVol_professionLibelle());%></td>
            </tr>
            <tr>
                <td>Ville de la Profession : </td><td><%  out.println(p.getVol_professionVille());%></td>
            </tr>
            <tr>
                <td>Fonction : </td><td><%  out.println(p.getUneFonction().getLibelle());%></td>
            </tr>
            <tr>
                <td>Grade : </td><td><%  out.println(p.getUnGrade().getLibelle());%></td>
            </tr>
            <tr>
                <td>Caserne : </td><td><%  out.println(p.getUneCaserne().getNom());%></td>
            </tr>
        </table>
    </body>
</html>
