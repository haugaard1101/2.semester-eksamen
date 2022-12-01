package com.example.bilabonnement.Model;

public class SkadeModel {

    private int skadeId;
    private String skadeNavn;
    private int skadePris;
    private int IDNumber;

    public SkadeModel(int skadeId, String skadeNavn, int skadePris,
                      int IDNumber) {
        this.skadeId = skadeId;
        this.skadeNavn = skadeNavn;
        this.skadePris = skadePris;
        this.IDNumber = IDNumber;
    }

    public int getSkadeId() {
        return skadeId;
    }

    public void setSkadeId(int skadeId) {
        this.skadeId = skadeId;
    }

    public String getSkadeNavn() {
        return skadeNavn;
    }

    public void setSkadeNavn(String skadeNavn) {
        this.skadeNavn = skadeNavn;
    }

    public int getSkadePris() {
        return skadePris;
    }

    public void setSkadePris(int skadePris) {
        this.skadePris = skadePris;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    @Override
    public String toString() {
        return "SkadeOgUdbedringsModel{" +
                "skadeId=" + skadeId +
                ", skadeNavn='" + skadeNavn + '\'' +
                ", skadePris=" + skadePris +
                ", registreringsNummer=" + IDNumber +
                '}';
    }
}
