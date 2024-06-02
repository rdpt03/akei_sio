package com.example.akei;

import org.w3c.dom.Text;

public class Produit {

    private long idProduit;
    private String nomProduit;
    private String descriptionTechProduit;
    private double prixProduit;
    private double poidsProduit;
    private double longueurProduit;
    private double largeurProduit;
    private double hauteurProduit;
    private long idRayon;

    public Produit(long idProduit,String nomProduit, String descriptionTechProduit, double prixProduit,double poidsProduit,double longueurProduit,double largeurProduit,double hauteurProduit,long idRayon) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.descriptionTechProduit = descriptionTechProduit;
        this.prixProduit = prixProduit;
        this.poidsProduit = poidsProduit;
        this.longueurProduit = longueurProduit;
        this.largeurProduit = largeurProduit;
        this.hauteurProduit = hauteurProduit;
        this.idRayon = idRayon;
    }

    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {this.idProduit = idProduit;}

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescriptionTechProduit() {
        return descriptionTechProduit;
    }

    public void setDescriptionTechProduit(String descriptionTechProduit) {this.descriptionTechProduit = descriptionTechProduit;}

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {this.prixProduit = prixProduit;}

    public double getPoidsProduit() {
        return poidsProduit;
    }

    public void setPoidsProduit(double poidsProduit) {this.poidsProduit = poidsProduit;}

    public double getLongueurProduit() {
        return longueurProduit;
    }

    public void setLongueurProduit(double longueurProduit) {this.longueurProduit = longueurProduit;}

    public double getLargeurProduit() {
        return largeurProduit;
    }

    public void setLargeurProduit(double largeurProduit) {this.largeurProduit = largeurProduit;}

    public double getHauteurProduit() {
        return hauteurProduit;
    }

    public void setHauteurProduit(double hauteurProduit) {this.hauteurProduit = hauteurProduit;}

    public long getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(long idRayon) {this.idRayon = idRayon;}

    public String toString() {
        return "Produit{" +
                "id='" + idProduit + '\'' +
                ", nom='" + nomProduit + '\'' +
                ", description=" + descriptionTechProduit +
                ", prix=" + prixProduit +
                ", poids=" + poidsProduit +
                ", longueur=" + longueurProduit +
                ", largeur=" + largeurProduit +
                ", hauteur=" + hauteurProduit +
                ", idRayon=" + idRayon +
                '}';
    }

}
