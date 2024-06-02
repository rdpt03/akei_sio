package com.example.akei;
/*

CRÉE PAR RAFAEL DA SILVA

*/
public class Vehicule{
    private long idVehicule;
    private String nomVehicule;
    private String marqueVehicule;
    private double longueurVehicule;
    private double largeurVehicule;
    private double hauteurVehicule;
    private double volumeVehicule;
    private String immatriculationVehicule;
    private double carburantVehicule;
    private int kmActuelVehicule;
    private long idMagasin;

    public Vehicule(long idVehicule, String nomVehicule, String marqueVehicule, double longueurVehicule, double largeurVehicule, double hauteurVehicule, double volumeVehicule, String immatriculationVehicule, double carburantVehicule, int kmActuelVehicule, long idMagasin) {
        this.idVehicule = idVehicule;
        this.nomVehicule = nomVehicule;
        this.marqueVehicule = marqueVehicule;
        this.longueurVehicule = longueurVehicule;
        this.largeurVehicule = largeurVehicule;
        this.hauteurVehicule = hauteurVehicule;
        this.volumeVehicule = volumeVehicule;
        this.immatriculationVehicule = immatriculationVehicule;
        this.carburantVehicule = carburantVehicule;
        this.kmActuelVehicule = kmActuelVehicule;
        this.idMagasin = idMagasin;
    }
    //--------------------GETTERS SETTERS--------------------

    public long getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(long idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getNomVehicule() {
        return nomVehicule;
    }

    public void setNomVehicule(String nomVehicule) {
        this.nomVehicule = nomVehicule;
    }

    public String getMarqueVehicule() {
        return marqueVehicule;
    }

    public void setMarqueVehicule(String marqueVehicule) {
        this.marqueVehicule = marqueVehicule;
    }

    public double getLongueurVehicule() {
        return longueurVehicule;
    }

    public void setLongueurVehicule(double longueurVehicule) {
        this.longueurVehicule = longueurVehicule;
    }

    public double getLargeurVehicule() {
        return largeurVehicule;
    }

    public void setLargeurVehicule(double largeurVehicule) {
        this.largeurVehicule = largeurVehicule;
    }

    public double getHauteurVehicule() {
        return hauteurVehicule;
    }

    public void setHauteurVehicule(double hauteurVehicule) {
        this.hauteurVehicule = hauteurVehicule;
    }

    public double getVolumeVehicule() {
        return volumeVehicule;
    }

    public void setVolumeVehicule(double volumeVehicule) {
        this.volumeVehicule = volumeVehicule;
    }

    public String getImmatriculationVehicule() {
        return immatriculationVehicule;
    }

    public void setImmatriculationVehicule(String immatriculationVehicule) {
        this.immatriculationVehicule = immatriculationVehicule;
    }

    public double getCarburantVehicule() {
        return carburantVehicule;
    }

    public void setCarburantVehicule(double carburantVehicule) {
        this.carburantVehicule = carburantVehicule;
    }

    public int getKmActuelVehicule() {
        return kmActuelVehicule;
    }

    public void setKmActuelVehicule(int kmActuelVehicule) {
        this.kmActuelVehicule = kmActuelVehicule;
    }

    public long getMagasin() {
        return idMagasin;
    }

    public void setMagasin(long idMagasin) {
        this.idMagasin = idMagasin;
    }
    //----------toString----------


    @Override
    public String toString() {
        return "Vehicule{" +
                "idVehicule=" + idVehicule +
                ", nomVehicule='" + nomVehicule + '\'' +
                ", marqueVehicule='" + marqueVehicule + '\'' +
                ", longueurVehicule=" + longueurVehicule +
                ", largeurVehicule=" + largeurVehicule +
                ", hauteurVehicule=" + hauteurVehicule +
                ", volumeVehicule=" + volumeVehicule +
                ", immatriculationVehicule='" + immatriculationVehicule + '\'' +
                ", carburantVehicule=" + carburantVehicule +
                ", kmActuelVehicule=" + kmActuelVehicule +
                ", idMagasin=" + idMagasin +
                '}';
    }
}