package servlet;

import database.*;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author TS1SIO
 */
public class ServletIntervention extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletIntervention</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletIntervention at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
     Connection cnx ;
            
    @Override
    public void init()
    {     
        System.out.println("Servlet init");
        ServletContext servletContext=getServletContext();
        cnx = (Connection)servletContext.getAttribute("connection");     
    }
    
    
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = request.getRequestURI();
        
          
        if (url.equals("/sdisweb/ServletIntervention/lister")){
            
            ArrayList<Intervention> lesInterventions = DaoIntervention.getLesInterventions(cnx);
            request.setAttribute("pLesInterventions", lesInterventions);
            
            getServletContext().getRequestDispatcher("/vues/intervention/listerInterventions.jsp").forward(request, response);
            
            
        }
        if (url.equals("/sdisweb/ServletIntervention/consulter")){
            int idIntervention= Integer.parseInt((String)request.getParameter("idIntervention"));
            Intervention uneIntervention = DaoIntervention.getInterventionById(cnx, idIntervention);
            Intervention i = DaoIntervention.getInterventionById(cnx, idIntervention);
            request.setAttribute("pUneIntervention", uneIntervention);
            
            getServletContext().getRequestDispatcher("/vues/intervention/consulterIntervention.jsp").forward(request, response);
        }
        
        
    }
    
        
}        
        
        
    