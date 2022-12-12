package com.example.bilabonnement.Model;

// Benjamin, Mathias, Marcus, Kasper
public class SkadeModel {
  private int SkadeID;
  private String registreringsNummer;
  private String skadeNavn;
  private String skadePris;

  // Mathias, Marcus, Kasper
  public SkadeModel(int SkadeID, String registreringsNummer, String skadeNavn, String skadePris) {
    this.SkadeID = SkadeID;
    this.registreringsNummer = registreringsNummer;
    this.skadeNavn = skadeNavn;
    this.skadePris = skadePris;
  }

  // Marcus
  public SkadeModel(String registreringsNummer) {
    this.registreringsNummer = registreringsNummer;
  }

  // Marcus, Kasper
  public SkadeModel(String registreringsNummer, String skadeNavn, String skadePris) {
    this.registreringsNummer = registreringsNummer;
    this.skadeNavn = skadeNavn;
    this.skadePris = skadePris;
  }

  // Marcus, Kasper
  public int getSkadeID() {
    return SkadeID;
  }

  // Kasper, Mathias
  public void setSkadeID(int skadeID) {
    this.SkadeID = skadeID;
  }

  // Kasper
  public String getSkadeNavn() {
    return skadeNavn;
  }

  // Kasper
  public void setSkadeNavn(String skadeNavn) {
    this.skadeNavn = skadeNavn;
  }

  // Marcus, Kasper
  public String getSkadePris() {
    return skadePris;
  }

  // Marcus, Kasper
  public void setSkadePris(String skadePris) {
    this.skadePris = skadePris;
  }

  //Kasper
  public String getRegistreringsNummer() {
    return registreringsNummer;
  }

  // Kasper
  public void setRegistreringsNummer(String registreringsNummer) {
    this.registreringsNummer = registreringsNummer;
  }

  // Marcus, Kasper
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
