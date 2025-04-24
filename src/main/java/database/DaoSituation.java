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
import model.Intervention;
import model.Situation;

/**
 *
 * @author TS1SIO
 */
public class DaoSituation {
    Connection cnx = null;
    static PreparedStatement requete =null;
    static ResultSet rs = null;
    
    public static ArrayList<Situation> getLesSituations( Connection cnx){
        ArrayList<Situation> lesSituations = new ArrayList<Situation>();
        try{
            requete=cnx.prepareStatement(" select s.id as s_id, s.type as s_type\n"+
                                           "from situation s\n");
            
            
            rs=requete.executeQuery();
            
            while ( rs.next() ) {
                Situation uneSituation = new Situation();
                uneSituation.setId(rs.getInt("s_id"));
                uneSituation.setType(rs.getString("s_type"));
                  
                lesSituations.add(uneSituation);  
            }
        }
        catch (SQLException e)
        {
        e.printStackTrace();
        }
        return lesSituations;
   }
    
    
}
