package com.example.bilabonnement.Model;

public class LejeAftaleModel {

  private int aftaleId;
  private String navn;
  private String adresse;
  private int postnummer;
  private String kommune;
  private int telefonNr;
  private String cpr;
  private String Email;
  private String LejeperiodeFra;
  private String LejeperiodeTil;
  private String AntalMaaneder;
  private String afhentningssted;
  private String afleveringssted;
  private int kmVedAfhentning;
  private int aftaleKM;
  private int kmVedIndlevering;
  private String registreringsNummer;

  public LejeAftaleModel(int aftaleId, String navn, String adresse, int postnummer, String kommune, int telefonNr, String cpr, String Email, String lejeperiodeFra, String lejeperiodeTil, String AntalMaaneder, String afhentningssted, String afleveringssted, int kmVedAfhentning, int aftaleKM, int kmVedIndlevering, String registreringsNummer) {
    this.aftaleId = aftaleId;
    this.navn = navn;
    this.adresse = adresse;
    this.postnummer = postnummer;
    this.kommune = kommune;
    this.telefonNr = telefonNr;
    this.cpr = cpr;
    this.Email = Email;
    this.LejeperiodeFra = lejeperiodeFra;
    this.LejeperiodeTil = lejeperiodeTil;
    this.AntalMaaneder = AntalMaaneder;
    this.afhentningssted = afhentningssted;
    this.afleveringssted = afleveringssted;
    this.kmVedAfhentning = kmVedAfhentning;
    this.aftaleKM = aftaleKM;
    this.kmVedIndlevering = kmVedIndlevering;
    this.registreringsNummer = registreringsNummer;
  }

  public LejeAftaleModel(String navn, String adresse, int postnummer, String kommune, int telefonNr, String cpr, String Email, String lejeperiodeFra, String lejeperiodeTil, String AntalMaaneder, String afhentningssted, String afleveringssted, int kmVedAfhentning, int aftaleKM, int kmVedIndlevering, String registreringsNummer) {
    this.navn = navn;
    this.adresse = adresse;
    this.postnummer = postnummer;
    this.kommune = kommune;
    this.telefonNr = telefonNr;
    this.cpr = cpr;
    this.Email = Email;
    this.LejeperiodeFra = lejeperiodeFra;
    this.LejeperiodeTil = lejeperiodeTil;
    this.AntalMaaneder = AntalMaaneder;
    this.afhentningssted = afhentningssted;
    this.afleveringssted = afleveringssted;
    this.kmVedAfhentning = kmVedAfhentning;
    this.aftaleKM = aftaleKM;
    this.kmVedIndlevering = kmVedIndlevering;
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

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    this.Email = email;
  }


  public String getLejeperiodeFra() {
    return LejeperiodeFra;
  }

  public void setLejeperiodeFra(String lejeperiodeFra) {
    this.LejeperiodeFra = lejeperiodeFra;
  }

  public String getLejeperiodeTil() {
    return LejeperiodeTil;
  }

  public void setLejeperiodeTil(String lejeperiodeTil) {
    this.LejeperiodeTil = lejeperiodeTil;
  }

  public String getAntalMaaneder() {
    return AntalMaaneder;
  }

  public void setAntalMaaneder(String antalMaaneder) {
    this.AntalMaaneder = antalMaaneder;
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

  public int getAftaleKM() {
    return aftaleKM;
  }

  public void setAftaleKM(int aftaleKM) {
    this.aftaleKM = aftaleKM;
  }

  public int getKmVedIndlevering() {
    return kmVedIndlevering;
  }

  public void setKmVedIndlevering(int kmVedIndlevering) {
    this.kmVedIndlevering = kmVedIndlevering;
  }

  public String getRegistreringsNummer() {
    return registreringsNummer;
  }

  public void setRegistreringsNummer(String registreringsNummer) {
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
        ", eMail='" + Email + '\'' +
        ", lejeperiodeFra=" + LejeperiodeFra +
        ", lejeperiodeTil=" + LejeperiodeTil +
        ", antalMåneder=" + AntalMaaneder +
        ", afhentningssted='" + afhentningssted + '\'' +
        ", afleveringssted='" + afleveringssted + '\'' +
        ", kmVedAfhentning=" + kmVedAfhentning +
        ", aftaleId=" + aftaleId +
        ", maxKilometer=" + aftaleKM +
        ", aktueltKørteKilometer=" + kmVedIndlevering +
        ", registreringsNummer=" + registreringsNummer +
        '}';
  }
}
