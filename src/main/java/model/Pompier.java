/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
/**
 *
 * @author zakina
 */
public class Pompier {
    
    private int id;
    private String bip ;
    private String nom;
    private String prenom ;
    private Date dateNaissance;
    private String typePompier;
    private String pro_dernierIndice;
    private Date pro_dateObtentionIndice;
    private String vol_professionLibelle;
    private String vol_professionVille;
    private Fonction uneFonction;
    private Grade unGrade;
    private Caserne uneCaserne ;

    public Pompier() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBip() {
        return bip;
    }

    public void setBip(String bip) {
        this.bip = bip;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Caserne getUneCaserne() {
        return uneCaserne;
    }

    public void setUneCaserne(Caserne uneCaserne) {
        this.uneCaserne = uneCaserne;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTypePompier() {
        return typePompier;
    }

    public void setTypePompier(String typePompier) {
        this.typePompier = typePompier;
    }

    public String getPro_dernierIndice() {
        return pro_dernierIndice;
    }

    public void setPro_dernierIndice(String pro_dernierIndice) {
        this.pro_dernierIndice = pro_dernierIndice;
    }

    public Date getPro_dateObtentionIndice() {
        return pro_dateObtentionIndice;
    }

    public void setPro_dateObtentionIndice(Date pro_dateObtentionIndice) {
        this.pro_dateObtentionIndice = pro_dateObtentionIndice;
    }

    public String getVol_professionLibelle() {
        return vol_professionLibelle;
    }

    public void setVol_professionLibelle(String vol_professionLibelle) {
        this.vol_professionLibelle = vol_professionLibelle;
    }

    public String getVol_professionVille() {
        return vol_professionVille;
    }

    public void setVol_professionVille(String vol_professionVille) {
        this.vol_professionVille = vol_professionVille;
    }

    public Fonction getUneFonction() {
        return uneFonction;
    }

    public void setUneFonction(Fonction uneFonction) {
        this.uneFonction = uneFonction;
    }

    public Grade getUnGrade() {
        return unGrade;
    }

    public void setUnGrade(Grade unGrade) {
        this.unGrade = unGrade;
    }
    
    
    
}
