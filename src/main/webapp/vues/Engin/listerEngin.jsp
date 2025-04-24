<%-- 
    Document   : listerInterventions
    Created on : 27 mars 2025, 09:39:32
    Author     : TS1SIO
--%>
<%@page import="model.Engin"%>
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
        <h1>Liste des Engins</h1>
            <%
                ArrayList<Engin> lesEngins = (ArrayList)request.getAttribute("pLesEngins");
            %>
            <table>  
            <thead>
                <tr>             
                    <th>Id</th>
                    <th>Type</th>
                    
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Engin e : lesEngins)
                        {              
                            out.println("<tr><td><a href ='../ServletEngin/consulter?idEngin="+ e.getId()+ "'>");
                            out.println(e.getId());
                            out.println("</a></td>");

                            out.println("<td>");
                            out.println(e.getType());
                            out.println("</td>");
                            
                            
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
    </body>
</html>
