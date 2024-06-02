package com.example.akei;

import org.w3c.dom.Text;

public class Rayon {

    private long idRayon;
    private String nomRayon;
    private String descriptionRayon;

    public Rayon(long idRayon,String nomRayon, String descriptionRayon) {
        this.idRayon = idRayon;
        this.nomRayon = nomRayon;
        this.descriptionRayon = descriptionRayon;
    }

    public long getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(long idRayon) {this.idRayon = idRayon;}

    public String getNomRayon() {
        return nomRayon;
    }

    public void setNomRayon(String nomRayon) {
        this.nomRayon = nomRayon;
    }

    public String getDescriptionRayon() {
        return descriptionRayon;
    }

    public void setDescriptionRayon(String descriptionRayon) {this.descriptionRayon = descriptionRayon;}


    public String toString() {
        return "Rayon{" +
                "id='" + idRayon + '\'' +
                ", nom='" + nomRayon + '\'' +
                ", description=" + descriptionRayon +
                '}';
    }



}
