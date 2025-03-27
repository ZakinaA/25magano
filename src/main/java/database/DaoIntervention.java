/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.Date;
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
public class DaoIntervention {
    Connection cnx = null;
    static PreparedStatement requete =null;
    static ResultSet rs = null;
    
    public static ArrayList<Intervention> getLesInterventions( Connection cnx){
        ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>();
        try{
            requete=cnx.prepareStatement("select i.id as i_id, i.lieu as i_lieu, i.dateInter as i_dateInter\n"+
                                           "from intervention i\n"+
                                            "inner join situation s\n"+
                                            "on i.id_situation = s.id\n");
            
            
            rs=requete.executeQuery();
            
            while ( rs.next() ) {
                Intervention uneIntervention = new Intervention();
                uneIntervention.setId(rs.getInt("i_id"));
                uneIntervention.setLieu(rs.getString("i_lieu"));
                uneIntervention.setDateInter(rs.getString("i_dateInter"));
               
                
                
                
                
                
              
                
                lesInterventions.add(uneIntervention);  
            }
        }
        catch (SQLException e)
        {
        e.printStackTrace();
        }
        return lesInterventions;
   }
   
    public static Intervention getInterventionById(Connection cnx, int idIntervention){
        Intervention uneIntervention = new Intervention();
        try{
            requete=cnx.prepareStatement("select i.id as i_id, i.lieu as i_lieu, i.heureAppel as i_heureAppel, i.heureArrive as i_heureArrive, i.duree as i_duree, i.dateInter as i_dateInter, s.type as s_type\n"+
                                           "from intervention i\n"+
                                            "inner join situation s\n"+
                                            "on i.id_situation = s.id\n"+
                                            "where i.id=?");
            requete.setInt(1, idIntervention);
            
            rs=requete.executeQuery();
            
            if ( rs.next()){
                
                uneIntervention.setId(rs.getInt("i_id"));
                uneIntervention.setLieu(rs.getString("i_lieu"));
                uneIntervention.setHeureAppel(rs.getString("i_heureAppel"));
                uneIntervention.setHeureArrive(rs.getString("i_heureArrive"));
                uneIntervention.setDuree(rs.getString("i_duree"));
                uneIntervention.setDateInter(rs.getString("i_dateInter"));
                
             
                
                Situation s = new Situation();
                s.setId(rs.getInt("s_id"));
                s.setType(rs.getString("s_type"));
              
                
                uneIntervention.setSituation(s);
                
                
                
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return uneIntervention;
    }
}