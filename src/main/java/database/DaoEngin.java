/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;


/**
 *
 * @author TS1SIO
 */
public class DaoEngin {
    Connection cnx = null;
    static PreparedStatement requete =null;
    static ResultSet rs = null;
    
    public static ArrayList<Engin> getLesEngins( Connection cnx){
        ArrayList<Engin> lesEngins = new ArrayList<Engin>();
        try{
            requete=cnx.prepareStatement("Select e.id as e_id, e.type as e_type From engin e");
            
            
            rs=requete.executeQuery();
            
            while ( rs.next() ) {
                Engin unEngin = new Engin();
                unEngin.setId(rs.getInt("e_id"));
                unEngin.setType(rs.getString("e_type"));
                
               

                lesEngins.add(unEngin);  
            }
        }
        catch (SQLException e)
        {
        e.printStackTrace();
        }
        return lesEngins;
   }
   
    public static Engin getEnginById(Connection cnx, int idEngin){
        Engin unEngin = new Engin();
        try{
            requete=cnx.prepareStatement("select e.id as e_id, e.type as e_type, e.numOrdre as e_numOrdre, e.caserne_id as e_caserne_id From engin e, caserne c where e.caserne_id=c.id" 
                    + " and e.id=?");
            requete.setInt(1, idEngin);
            System.out.println("requete engin=" + requete);
            
            rs=requete.executeQuery();
            
            if ( rs.next()){
                
                unEngin.setId(rs.getInt("e_id"));
                unEngin.setType(rs.getString("e_type"));
                unEngin.setNumOrdre(rs.getString("e_numOrdre"));
                unEngin.setCaserne(rs.getInt("e_caserne_id"));
             
                
                
                
                
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return unEngin;
    }
}