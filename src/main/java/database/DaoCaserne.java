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
            requeteSql = cnx.prepareStatement("select caserne.id as c_id, caserne.nom as c_nom from caserne; ");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Caserne c = new Caserne();
                    c.setId(resultatRequete.getInt("c_id"));
                    c.setNom(resultatRequete.getString("c_nom"));
                
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
            requeteSql = cnx.prepareStatement("select caserne.id as c_id, caserne.nom as c_nom from caserne"+
                         " where caserne.id= ? ;");
            requeteSql.setInt(1, idCaserne);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                    c = new Caserne();
                    c.setId(resultatRequete.getInt("c_id"));
                    c.setNom(resultatRequete.getString("c_nom"));
                
                
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getCaserneById  a généré une erreur");
        }
        return c ;
    }
    
    
    public static Caserne addCaserne(Connection connection, Caserne c){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requeteSql=connection.prepareStatement("INSERT INTO Caserne ( nom )\n" +
                    "VALUES (?)", requeteSql.RETURN_GENERATED_KEYS );
            requeteSql.setString(1, c.getNom());

           /* Exécution de la requête */
            requeteSql.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            resultatRequete = requeteSql.getGeneratedKeys();
            while ( resultatRequete.next() ) {
                idGenere = resultatRequete.getInt( 1 );
                c.setId(idGenere);
                
                c = DaoCaserne.getCasernById(connection, c.getId());
            }
            
         
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return c ;    
    }
    
}
