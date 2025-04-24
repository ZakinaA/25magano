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
public class ServletEngin extends HttpServlet {

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
            out.println("<title>Servlet ServletEngin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEngin at " + request.getContextPath() + "</h1>");
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
        
          
        if (url.equals("/sdisweb/ServletEngin/lister")){
            
            ArrayList<Engin> lesEngins = DaoEngin.getLesEngins(cnx);
            request.setAttribute("pLesEngins", lesEngins);
            
            getServletContext().getRequestDispatcher("/vues/Engin/listerEngin.jsp").forward(request, response);
            
            
        }
        if (url.equals("/sdisweb/ServletEngin/consulter")){
            int idEngin= Integer.parseInt((String)request.getParameter("idEngin"));
            Engin unEngin = DaoEngin.getEnginById(cnx, idEngin);
            Engin e = DaoEngin.getEnginById(cnx, idEngin);
            request.setAttribute("pUnEngin", unEngin);
            
            getServletContext().getRequestDispatcher("/vues/Engin/consulterEngin.jsp").forward(request, response);
        }
        
        
    }
    
        
}        
        
        
    