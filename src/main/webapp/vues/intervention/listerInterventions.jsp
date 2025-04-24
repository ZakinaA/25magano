<%-- 
    Document   : listerInterventions
    Created on : 27 mars 2025, 09:39:32
    Author     : TS1SIO
--%>
<%@page import="model.Intervention"%>
<%@page import="model.Situation"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>APPLICATION DE GESTION SDIS CALVADOS</title>
    </head>
    <body>
        <h1>Liste des interventions du Calvados</h1>
            <%
                ArrayList<Intervention> lesInterventions = (ArrayList)request.getAttribute("pLesInterventions");
            %>
            <table>  
            <thead>
                <tr>             
                    <th>Id</th>
                    <th>Lieu</th>
                    <th>Date de l'intervention</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Intervention i : lesInterventions)
                        {              
                            out.println("<tr><td><a href ='../ServletIntervention/consulter?idIntervention="+ i.getId()+ "'>");
                            out.println(i.getId());
                            out.println("</a></td>");

                            out.println("<td>");
                            out.println(i.getLieu());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println(i.getDateInter());
                            out.println("</td>");

                            
                               
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
    </body>
</html>
