package com.Model;

import java.util.Date;

public class LejeAftaleModel {

private String navn;
private String adresse;
private int postnummer;
private String kommune;
private int telefonNr;
private String cpr;
private String eMail;
private Date lejeperiodeFra;
private Date lejeperiodeTil;
private int antalMåneder;
private String afhentningssted;
private String afleveringssted;
private int kmVedAfhentning;
private int aftaleId;
private int maxKilometer;
private int aktueltKørteKilometer;
private int registreringsNummer;

  public LejeAftaleModel(String navn, String adresse, int postnummer,
                         String kommune, int telefonNr, String cpr, String eMail,
                         Date lejeperiodeFra, Date lejeperiodeTil, int antalMåneder,
                         String afhentningssted, String afleveringssted, int kmVedAfhentning,
                         int aftaleId, int maxKilometer, int aktueltKørteKilometer,
                         int registreringsNummer) {
    this.navn = navn;
    this.adresse = adresse;
    this.postnummer = postnummer;
    this.kommune = kommune;
    this.telefonNr = telefonNr;
    this.cpr = cpr;
    this.eMail = eMail;
    this.lejeperiodeFra = lejeperiodeFra;
    this.lejeperiodeTil = lejeperiodeTil;
    this.antalMåneder = antalMåneder;
    this.afhentningssted = afhentningssted;
    this.afleveringssted = afleveringssted;
    this.kmVedAfhentning = kmVedAfhentning;
    this.aftaleId = aftaleId;
    this.maxKilometer = maxKilometer;
    this.aktueltKørteKilometer = aktueltKørteKilometer;
    this.registreringsNummer = registreringsNummer;
  }

  public LejeAftaleModel() {

  }

  public String getNavn() {
    return navn;
  }

  public void setNavn(String navn) {
    this.navn = navn;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public int getPostnummer() {
    return postnummer;
  }

  public void setPostnummer(int postnummer) {
    this.postnummer = postnummer;
  }

  public String getKommune() {
    return kommune;
  }

  public void setKommune(String kommune) {
    this.kommune = kommune;
  }

  public int getTelefonNr() {
    return telefonNr;
  }

  public void setTelefonNr(int telefonNr) {
    this.telefonNr = telefonNr;
  }

  public String getCpr() {
    return cpr;
  }

  public void setCpr(String cpr) {
    this.cpr = cpr;
  }

  public String geteMail() {
    return eMail;
  }

  public void seteMail(String eMail) {
    this.eMail = eMail;
  }

  public Date getLejeperiodeFra() {
    return lejeperiodeFra;
  }

  public void setLejeperiodeFra(Date lejeperiodeFra) {
    this.lejeperiodeFra = lejeperiodeFra;
  }

  public Date getLejeperiodeTil() {
    return lejeperiodeTil;
  }

  public void setLejeperiodeTil(Date lejeperiodeTil) {
    this.lejeperiodeTil = lejeperiodeTil;
  }

  public int getAntalMåneder() {
    return antalMåneder;
  }

  public void setAntalMåneder(int antalMåneder) {
    this.antalMåneder = antalMåneder;
  }

  public String getAfhentningssted() {
    return afhentningssted;
  }

  public void setAfhentningssted(String afhentningssted) {
    this.afhentningssted = afhentningssted;
  }

  public String getAfleveringssted() {
    return afleveringssted;
  }

  public void setAfleveringssted(String afleveringssted) {
    this.afleveringssted = afleveringssted;
  }

  public int getKmVedAfhentning() {
    return kmVedAfhentning;
  }

  public void setKmVedAfhentning(int kmVedAfhentning) {
    this.kmVedAfhentning = kmVedAfhentning;
  }

  public int getAftaleId() {
    return aftaleId;
  }

  public void setAftaleId(int aftaleId) {
    this.aftaleId = aftaleId;
  }

  public int getMaxKilometer() {
    return maxKilometer;
  }

  public void setMaxKilometer(int maxKilometer) {
    this.maxKilometer = maxKilometer;
  }

  public int getAktueltKørteKilometer() {
    return aktueltKørteKilometer;
  }

  public void setAktueltKørteKilometer(int aktueltKørteKilometer) {
    this.aktueltKørteKilometer = aktueltKørteKilometer;
  }

  public int getRegistreringsNummer() {
    return registreringsNummer;
  }

  public void setRegistreringsNummer(int registreringsNummer) {
    this.registreringsNummer = registreringsNummer;
  }

  @Override
  public String toString() {
    return "LejeAftaleModel{" +
        "navn='" + navn + '\'' +
        ", adresse='" + adresse + '\'' +
        ", postnummer=" + postnummer +
        ", kommune='" + kommune + '\'' +
        ", telefonNr=" + telefonNr +
        ", cpr='" + cpr + '\'' +
        ", eMail='" + eMail + '\'' +
        ", lejeperiodeFra=" + lejeperiodeFra +
        ", lejeperiodeTil=" + lejeperiodeTil +
        ", antalMåneder=" + antalMåneder +
        ", afhentningssted='" + afhentningssted + '\'' +
        ", afleveringssted='" + afleveringssted + '\'' +
        ", kmVedAfhentning=" + kmVedAfhentning +
        ", aftaleId=" + aftaleId +
        ", maxKilometer=" + maxKilometer +
        ", aktueltKørteKilometer=" + aktueltKørteKilometer +
        ", registreringsNummer=" + registreringsNummer +
        '}';
  }
}
