package com.example.bilabonnement.Model;

public class LejeAftaleModel {

  private int aftaleId;
  private String Navn;
  private String Adresse;
  private String Postnummer;
  private String Kommune;
  private String TelefonNr;
  private String CPR;
  private String Email;
  private String LejeperiodeFra;
  private String LejeperiodeTil;
  private String AntalMaaneder;
  private String Afhentningssted;
  private String Afleveringssted;
  private String KmVedAfhentning;
  private String AftaleKM;
  private String KmVedIndlevering;
  private String RegistreringsNummer;

  public LejeAftaleModel(int AftaleId, String Navn, String Adresse, String Postnummer, String Kommune, String TelefonNr, String CPR, String Email, String LejeperiodeFra, String LejeperiodeTil, String AntalMaaneder, String Afhentningssted, String Afleveringssted, String KmVedAfhentning, String AftaleKM, String KmVedIndlevering, String RegistreringsNummer) {
    this.aftaleId = AftaleId;
    this.Navn = Navn;
    this.Adresse = Adresse;
    this.Postnummer = Postnummer;
    this.Kommune = Kommune;
    this.TelefonNr = TelefonNr;
    this.CPR = CPR;
    this.Email = Email;
    this.LejeperiodeFra = LejeperiodeFra;
    this.LejeperiodeTil = LejeperiodeTil;
    this.AntalMaaneder = AntalMaaneder;
    this.Afhentningssted = Afhentningssted;
    this.Afleveringssted = Afleveringssted;
    this.KmVedAfhentning = KmVedAfhentning;
    this.AftaleKM = AftaleKM;
    this.KmVedIndlevering = KmVedIndlevering;
    this.RegistreringsNummer = RegistreringsNummer;
  }

  public LejeAftaleModel(String navn, String adresse, String postnummer, String kommune, String telefonNr, String CPR, String Email, String lejeperiodeFra, String lejeperiodeTil, String AntalMaaneder, String afhentningssted, String afleveringssted, String kmVedAfhentning, String aftaleKM, String kmVedIndlevering, String registreringsNummer) {
    this.Navn = navn;
    this.Adresse = adresse;
    this.Postnummer = postnummer;
    this.Kommune = kommune;
    this.TelefonNr = telefonNr;
    this.CPR = CPR;
    this.Email = Email;
    this.LejeperiodeFra = lejeperiodeFra;
    this.LejeperiodeTil = lejeperiodeTil;
    this.AntalMaaneder = AntalMaaneder;
    this.Afhentningssted = afhentningssted;
    this.Afleveringssted = afleveringssted;
    this.KmVedAfhentning = kmVedAfhentning;
    this.AftaleKM = aftaleKM;
    this.KmVedIndlevering = kmVedIndlevering;
    this.RegistreringsNummer = registreringsNummer;
  }

  public LejeAftaleModel() {

  }

    public LejeAftaleModel(String kmVedIndlevering) {
    this.KmVedIndlevering = kmVedIndlevering;
    }

  public LejeAftaleModel(String KmVedIndlevering, String RegistreringsNummer) {
    this.KmVedIndlevering = KmVedIndlevering;
    this.RegistreringsNummer = RegistreringsNummer;
  }

  public String getNavn() {
    return Navn;
  }

  public void setNavn(String navn) {
    this.Navn = navn;
  }

  public String getAdresse() {
    return Adresse;
  }

  public void setAdresse(String adresse) {
    this.Adresse = adresse;
  }

  public String getPostnummer() {
    return Postnummer;
  }

  public void setPostnummer(String postnummer) {
    this.Postnummer = postnummer;
  }

  public String getKommune() {
    return Kommune;
  }

  public void setKommune(String kommune) {
    this.Kommune = kommune;
  }

  public String getTelefonNr() {
    return TelefonNr;
  }

  public void setTelefonNr(String telefonNr) {
    this.TelefonNr = telefonNr;
  }

  public String getCPR() {
    return CPR;
  }

  public void setCPR(String CPR) {
    this.CPR = CPR;
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
    return Afhentningssted;
  }

  public void setAfhentningssted(String afhentningssted) {
    this.Afhentningssted = afhentningssted;
  }

  public String getAfleveringssted() {
    return Afleveringssted;
  }

  public void setAfleveringssted(String afleveringssted) {
    this.Afleveringssted = afleveringssted;
  }

  public String getKmVedAfhentning() {
    return KmVedAfhentning;
  }

  public void setKmVedAfhentning(String kmVedAfhentning) {
    this.KmVedAfhentning = kmVedAfhentning;
  }

  public int getAftaleId() {
    return aftaleId;
  }

  public void setAftaleId(int aftaleId) {
    this.aftaleId = aftaleId;
  }

  public String getAftaleKM() {
    return AftaleKM;
  }

  public void setAftaleKM(String aftaleKM) {
    this.AftaleKM = aftaleKM;
  }

  public String getKmVedIndlevering() {
    return KmVedIndlevering;
  }

  public void setKmVedIndlevering(String kmVedIndlevering) {
    this.KmVedIndlevering = kmVedIndlevering;
  }

  public String getRegistreringsNummer() {
    return RegistreringsNummer;
  }

  public void setRegistreringsNummer(String registreringsNummer) {
    this.RegistreringsNummer = registreringsNummer;
  }

  @Override
  public String toString() {
    return "LejeAftaleModel{" +
        "navn='" + Navn + '\'' +
        ", adresse='" + Adresse + '\'' +
        ", postnummer=" + Postnummer +
        ", kommune='" + Kommune + '\'' +
        ", telefonNr=" + TelefonNr +
        ", cpr='" + CPR + '\'' +
        ", eMail='" + Email + '\'' +
        ", lejeperiodeFra=" + LejeperiodeFra +
        ", lejeperiodeTil=" + LejeperiodeTil +
        ", antalMåneder=" + AntalMaaneder +
        ", afhentningssted='" + Afhentningssted + '\'' +
        ", afleveringssted='" + Afleveringssted + '\'' +
        ", kmVedAfhentning=" + KmVedAfhentning +
        ", aftaleId=" + aftaleId +
        ", maxKilometer=" + AftaleKM +
        ", aktueltKørteKilometer=" + KmVedIndlevering +
        ", registreringsNummer=" + RegistreringsNummer +
        '}';
  }
}
