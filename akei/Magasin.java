package com.example.akei;
/*

CRÉE PAR RAFAEL DA SILVA

*/

public class Magasin {
    private long idMagasin;
    private String nomMagasin;
    private String rueMagasin;
    private String villeMagasin;
    private String cpMagasin;
    private String paysMagasin;

    //---------------------CONSTRUCTOR--------------------

    public Magasin(long idMagasin, String nomMagasin, String rueMagasin, String villeMagasin, String cpMagasin, String paysMagasin) {
        this.idMagasin = idMagasin;
        this.nomMagasin = nomMagasin;
        this.rueMagasin = rueMagasin;
        this.villeMagasin = villeMagasin;
        this.cpMagasin = cpMagasin;
        this.paysMagasin = paysMagasin;
    }
    //--------------------GETTERS SETTERS--------------------


    public long getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(long idMagasin) {
        this.idMagasin = idMagasin;
    }

    public String getNomMagasin() {
        return nomMagasin;
    }

    public void setNomMagasin(String nomMagasin) {
        this.nomMagasin = nomMagasin;
    }

    public String getRueMagasin() {
        return rueMagasin;
    }

    public void setRueMagasin(String rueMagasin) {
        this.rueMagasin = rueMagasin;
    }

    public String getVilleMagasin() {
        return villeMagasin;
    }

    public void setVilleMagasin(String villeMagasin) {
        this.villeMagasin = villeMagasin;
    }

    public String getCpMagasin() {
        return cpMagasin;
    }

    public void setCpMagasin(String cpMagasin) {
        this.cpMagasin = cpMagasin;
    }

    public String getPaysMagasin() {
        return paysMagasin;
    }

    public void setPaysMagasin(String paysMagasin) {
        this.paysMagasin = paysMagasin;
    }

    //----------toString----------


    @Override
    public String toString() {
        return "Magasin{" +
                "idMagasin=" + idMagasin +
                ", nomMagasin='" + nomMagasin + '\'' +
                ", rueMagasin='" + rueMagasin + '\'' +
                ", villeMagasin='" + villeMagasin + '\'' +
                ", cpMagasin='" + cpMagasin + '\'' +
                ", paysMagasin='" + paysMagasin + '\'' +
                '}';
    }
}
