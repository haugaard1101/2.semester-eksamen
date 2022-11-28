package com.Model;

public class SkadeOgUdbedringsModel {

  private int skadeId;
  private String skadeNavn;
  private int skadePris;
  private int registreringsNummer;

  public SkadeOgUdbedringsModel(int skadeId, String skadeNavn, int skadePris,
                                int registreringsNummer) {
    this.skadeId = skadeId;
    this.skadeNavn = skadeNavn;
    this.skadePris = skadePris;
    this.registreringsNummer = registreringsNummer;
  }

  public SkadeOgUdbedringsModel() {

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

  public int getRegistreringsNummer() {
    return registreringsNummer;
  }

  public void setRegistreringsNummer(int registreringsNummer) {
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
