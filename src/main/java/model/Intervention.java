/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TS1SIO
 */
public class Intervention {


    private int id;
    private String lieu ;
    private String prenom ;
    private String dateInter ;
    private String heureAppel;
    private String heureArrive;
    private String duree;
    private Situation situation ;

    public Intervention() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    public String getDateInter() {
        return dateInter;
    }

    public void setDateInter(String dateInter) {
        this.dateInter = dateInter;
    }
    
    public String getHeureAppel() {
        return heureAppel;
    }

    public void setHeureAppel(String heureAppel) {
        this.heureAppel = heureAppel;
    }
    
    public String getHeureArrive() {
        return heureArrive;
    }

    public void setHeureArrive(String heureArrive) {
        this.heureArrive = heureArrive;
    }
    
    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }
    

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }


    
    

}
