package com.example.bilabonnement.Model;

public class SkadeModel {

    private int skadeId;
    private String skadeNavn;
    private int skadePris;
    private String registreringsNummer;

    public SkadeModel(int skadeId, String skadeNavn, int skadePris,
                      String registreringsNummer) {
        this.skadeId = skadeId;
        this.skadeNavn = skadeNavn;
        this.skadePris = skadePris;
        this.registreringsNummer = registreringsNummer;
    }

    public SkadeModel(String registreringsNummer){

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

    public String getRegistreringsNummer() {
        return registreringsNummer;
    }

    public void setRegistreringsNummer(String registreringsNummer) {
        this.registreringsNummer = registreringsNummer;
    }

    @Override
    public String toString() {
        return "SkadeOgUdbedringsModel{" +
                "skadeId=" + skadeId +
                ", skadeNavn='" + skadeNavn + '\'' +
                ", skadePris=" + skadePris +
                ", registreringsNummer=" + registreringsNummer +
                '}';
    }
}
