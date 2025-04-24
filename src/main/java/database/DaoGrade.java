//nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 /* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import model.Grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Caserne;

/**
 *
 * @author zakina
 */
public class DaoGrade {

    public static Object getGradeById(Connection cnx, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Grade> getLesGrades(Connection cnx){
        
        ArrayList<Grade> lesGrades = new ArrayList<Grade>();
        try{
            requeteSql = cnx.prepareStatement("select grade.id as g_id, grade.libelle as g_libelle from grade; ");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Grade g = new Grade();
                    g.setId(resultatRequete.getInt("g_id"));
                    g.setLibelle(resultatRequete.getString("g_libelle"));
                
                lesGrades.add(g);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesGrades e généré une erreur");
        }
        return lesGrades;
    }
    
    public static Grade getGradById(Connection cnx, int idGrade){
        
        Grade g = null ;
        try{
            requeteSql = cnx.prepareStatement("select grade.id as g_id, grade.libelle as g_libelle from grade"+
                         " where grade.id= ? ;");
            requeteSql.setInt(1, idGrade);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                    g = new Grade();
                        g.setId(resultatRequete.getInt("g_id"));
                        g.setLibelle(resultatRequete.getString("g_libelle"));     
                
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getGradeById  a généré une erreur");
        }
        return g ;
    }
    
}
