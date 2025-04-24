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
import model.Fonction;
import model.Grade;

/**
 *
 * @author zakina
 */
public class DaoPompier {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Pompier> getLesPompiers(Connection cnx){
        
        ArrayList<Pompier> lesPompiers = new ArrayList<Pompier>();
        try{
            requeteSql = cnx.prepareStatement("select pompier.id as p_id, pompier.nom as p_nom, pompier.prenom as p_prenom, pompier.dateNaissance as p_dateNaissance, pompier.typePompier as p_typePompier, pompier.pro_dernierIndice as p_pro_dernierIndice, pompier.pro_dateObtentionIndice as p_pro_dateObtentionIndice, pompier.vol_professionLibelle as p_vol_professionLibelle, pompier.vol_professionVille as p_vol_professionVille, f.id as f_id, f.code as f_code, f.libelle as f_libelle, g.id as g_id, g.libelle as g_libelle, c.id as c_id, c.nom as c_nom " +
                         " from pompier inner join caserne c on pompier.caserne_id = c.id " + 
                         " inner join fonction f on pompier.fonction_id = f.id " +
                         " inner join grade g on pompier.grade_id = g.id");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Pompier p = new Pompier();
                    p.setId(resultatRequete.getInt("p_id"));
                    p.setNom(resultatRequete.getString("p_nom"));
                    p.setPrenom(resultatRequete.getString("p_prenom"));
                    p.setDateNaissance(resultatRequete.getDate("p_dateNaissance"));
                    p.setTypePompier(resultatRequete.getString("p_typePompier"));
                    p.setPro_dernierIndice(resultatRequete.getString("p_pro_dernierIndice"));
                    p.setPro_dateObtentionIndice(resultatRequete.getDate("p_pro_dateObtentionIndice"));
                    p.setVol_professionLibelle(resultatRequete.getString("p_vol_professionLibelle"));
                Caserne c = new Caserne();
                    c.setId(resultatRequete.getInt("c_id"));
                    c.setNom(resultatRequete.getString("c_nom"));
                p.setUneCaserne(c);
                Fonction f = new Fonction();
                    f.setId(resultatRequete.getInt("f_id"));
                    f.setCode(resultatRequete.getString("f_code"));
                    f.setLibelle(resultatRequete.getString("f_libelle"));
                p.setUneFonction(f);
                Grade g = new Grade();
                    g.setId(resultatRequete.getInt("g_id"));
                    g.setLibelle(resultatRequete.getString("g_libelle"));
                p.setUnGrade(g);
                
                lesPompiers.add(p);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return lesPompiers;
    }
    
    public static Pompier getPompierById(Connection cnx, int idPompier){
        
        Pompier p = null ;
        try{
            requeteSql = cnx.prepareStatement("select pompier.id as p_id, pompier.nom as p_nom, pompier.prenom as p_prenom, pompier.dateNaissance as p_dateNaissance, pompier.typePompier as p_typePompier, pompier.pro_dernierIndice as p_pro_dernierIndice, pompier.pro_dateObtentionIndice as p_pro_dateObtentionIndice, pompier.vol_professionLibelle as p_vol_professionLibelle, pompier.vol_professionVille as p_vol_professionVille, f.id as f_id, f.code as f_code, f.libelle as f_libelle, g.id as g_id, g.libelle as g_libelle, c.id as c_id, c.nom as c_nom " +
                         " from pompier inner join caserne c on pompier.caserne_id = c.id " + 
                         " inner join fonction f on pompier.fonction_id = f.id " +
                         " inner join grade g on pompier.grade_id = g.id "+
                         " where pompier.id= ? ");
            requeteSql.setInt(1, idPompier);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                    p = new Pompier();
                    p.setId(resultatRequete.getInt("p_id"));
                    p.setNom(resultatRequete.getString("p_nom"));
                    p.setPrenom(resultatRequete.getString("p_prenom"));
                    p.setDateNaissance(resultatRequete.getDate("p_dateNaissance"));
                    p.setTypePompier(resultatRequete.getString("p_typePompier"));
                    p.setPro_dernierIndice(resultatRequete.getString("p_pro_dernierIndice"));
                    p.setPro_dateObtentionIndice(resultatRequete.getDate("p_pro_dateObtentionIndice"));
                    p.setVol_professionLibelle(resultatRequete.getString("p_vol_professionLibelle"));
                Caserne c = new Caserne();
                    c.setId(resultatRequete.getInt("c_id"));
                    c.setNom(resultatRequete.getString("c_nom"));
                p.setUneCaserne(c);
                Fonction f = new Fonction();
                    f.setId(resultatRequete.getInt("f_id"));
                    f.setCode(resultatRequete.getString("f_code"));
                    f.setLibelle(resultatRequete.getString("f_libelle"));
                p.setUneFonction(f);
                Grade g = new Grade();
                    g.setId(resultatRequete.getInt("g_id"));
                    g.setLibelle(resultatRequete.getString("g_libelle"));
                p.setUnGrade(g);
                
                
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getPompierById  a généré une erreur");
        }
        return p ;
    }
    
    
    public static Pompier addPompier(Connection connection, Pompier p){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requeteSql=connection.prepareStatement("INSERT INTO pompier ( nom, prenom, caserne_id)\n" +
                    "VALUES (?,?,?)", requeteSql.RETURN_GENERATED_KEYS );
            requeteSql.setString(1, p.getNom());
            requeteSql.setString(2, p.getPrenom());
            requeteSql.setInt(3, p.getUneCaserne().getId());

           /* Exécution de la requête */
            requeteSql.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            resultatRequete = requeteSql.getGeneratedKeys();
            while ( resultatRequete.next() ) {
                idGenere = resultatRequete.getInt( 1 );
                p.setId(idGenere);
                
                p = DaoPompier.getPompierById(connection, p.getId());
            }
            
         
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return p ;    
    }
    
}
