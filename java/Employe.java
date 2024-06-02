package com.example.akei;
/*

CRÉE PAR RAFAEL DA SILVA

*/
public class Employe {
    private long idEmploye;
    private String nomEmploye;
    private String prenomEmploye;
    private long idRayon;
    private long idMagasin;
    //----------Constructeur----------


    public Employe(long idEmployee, String nomEmployee, String prenomEmployee, long idRayon, long idMagasin) {
        this.idEmploye = idEmployee;
        this.nomEmploye = nomEmployee;
        this.prenomEmploye = prenomEmployee;
        this.idRayon = idRayon;
        this.idMagasin = idMagasin;
    }
    //----------getters setters------------


    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmployee) {
        this.idEmploye = idEmployee;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmployee) {
        this.nomEmploye = nomEmployee;
    }

    public String getPrenomEmploye() {
        return prenomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }

    public long getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(long idRayon) {
        this.idRayon = idRayon;
    }

    public long getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(long idMagasin) {
        this.idMagasin = idMagasin;
    }

    //----------tostring----------

    @Override
    public String toString() {
        return "Employe{" +
                "idEmploye=" + idEmploye +
                ", nomEmploye='" + nomEmploye + '\'' +
                ", prenomEmploye='" + prenomEmploye + '\'' +
                ", idRayon=" + idRayon +
                ", idMagasin=" + idMagasin +
                '}';
    }
}
