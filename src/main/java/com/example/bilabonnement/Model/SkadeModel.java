package com.example.bilabonnement.Model;

public class SkadeModel {

  private int skadeId;
  private String registreringsNummer;
  private String skadeNavn;
  private int skadePris;

  public SkadeModel(int skadeId, String registreringsNummer, String skadeNavn, int skadePris) {
    this.skadeId = skadeId;
    this.registreringsNummer = registreringsNummer;
    this.skadeNavn = skadeNavn;
    this.skadePris = skadePris;
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
        ", registreringsNummer=" + registreringsNummer +
        ", skadeNavn='" + skadeNavn + '\'' +
        ", skadePris=" + skadePris +
        '}';
  }
}
