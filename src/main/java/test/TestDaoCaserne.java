/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import database.ConnexionBdd;
import database.DaoCaserne;
import java.sql.Connection;
import model.Caserne;
import model.Pompier;

/**
 *
 * @author zakina
 */
public class TestDaoCaserne {
    
    public static void main (String args[]){
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        System.out.println ("nombre de caserne=" + DaoCaserne.getLesCasernes(cnx).size());
       
        System.out.println ("La caserne 1 s'appelle =" + DaoCaserne.getCasernById(cnx,1).getVille() +' '+ DaoCaserne.getCasernById(cnx,1).getAdresse() +' '+ DaoCaserne.getCasernById(cnx,1).getCpos());
        
        Caserne c = new Caserne();
        c.setVille("CHAUVEL");
        
    }
    
}

