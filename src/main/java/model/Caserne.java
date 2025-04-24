/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author zakina
 */
public class Caserne {
    
    private int id;
    private String ville ;
    private String cpos ;
    private String adresse;
    private ArrayList<Pompier> lesPompiers ;

    public Caserne() {
    }

    public Caserne(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public String getCpos() {
        return cpos;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCpos(String cpos) {
        this.cpos = cpos;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



    public ArrayList<Pompier> getLesPompiers() {
        return lesPompiers;
    }

    public void setLesPompiers(ArrayList<Pompier> lesPompiers) {
        this.lesPompiers = lesPompiers;
    }
    
    public void addPompier(Pompier p){
        if (lesPompiers == null){
            lesPompiers = new ArrayList<Pompier>();
        }
        lesPompiers.add(p);
    }
    
}
