/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import static database.DaoPompier.requeteSql;
import static database.DaoPompier.resultatRequete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Caserne;
import model.Pompier;

/**
 *
 * @author zakina
 */
public class DaoCaserne {

    public static Object getCaserneById(Connection cnx, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Caserne> getLesCasernes(Connection cnx){
        
        ArrayList<Caserne> lesCasernes = new ArrayList<Caserne>();
        try{
            requeteSql = cnx.prepareStatement("select caserne.id as c_id, caserne.ville as c_ville, caserne.cpos as c_cpos, caserne.adresse as c_adresse from caserne; ");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Caserne c = new Caserne();
                    c.setId(resultatRequete.getInt("c_id"));
                    c.setVille(resultatRequete.getString("c_ville"));
                    c.setCpos(resultatRequete.getString("c_Cpos"));
                    c.setAdresse(resultatRequete.getString("c_Adresse"));
                
                lesCasernes.add(c);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesCaserne e généré une erreur");
        }
        return lesCasernes;
    }
    
    public static Caserne getCasernById(Connection cnx, int idCaserne){
        
        Caserne c = null ;
        try{
            requeteSql = cnx.prepareStatement("select caserne.id as c_id, caserne.ville as c_ville, caserne.cpos as c_cpos, caserne.adresse as c_adresse from caserne"+
                         " where caserne.id= ? ;");
            requeteSql.setInt(1, idCaserne);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                    c = new Caserne();
                        c.setId(resultatRequete.getInt("c_id"));
                        c.setVille(resultatRequete.getString("c_ville"));
                        c.setCpos(resultatRequete.getString("c_Cpos"));
                        c.setAdresse(resultatRequete.getString("c_Adresse"));
                
                
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getCaserneById  a généré une erreur");
        }
        return c ;
    }
    
}
