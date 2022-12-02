package com.example.bilabonnement.Model;

public class SkadeModel {

  private int SkadeID;
  private String registreringsNummer;
  private String skadeNavn;
  private int skadePris;

  public SkadeModel(int SkadeID, String registreringsNummer, String skadeNavn, int skadePris) {
    this.SkadeID = SkadeID;
    this.registreringsNummer = registreringsNummer;
    this.skadeNavn = skadeNavn;
    this.skadePris = skadePris;
  }

  public SkadeModel(String registreringsNummer, String skadeNavn, int skadePris) {
    this.registreringsNummer = registreringsNummer;
    this.skadeNavn = skadeNavn;
    this.skadePris = skadePris;
  }

  public int getSkadeID() {
    return SkadeID;
  }

  public void setSkadeID(int skadeID) {
    this.SkadeID = skadeID;
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
        "skadeId=" + SkadeID +
        ", registreringsNummer=" + registreringsNummer +
        ", skadeNavn='" + skadeNavn + '\'' +
        ", skadePris=" + skadePris +
        '}';
  }
}
