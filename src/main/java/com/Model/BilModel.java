package com.Model;

public class BilModel {
  private int registreringsNummer;
  private String stelnummer;
  private String mærke;
  private String udstyrNiveau;
  private UdlejningsStatusEnum udlejningsStatus;
  private GearEnum gear;
  private String brændstofType;
  private int kmL;
  private int co2Udledning;
  private int prisPrMåned;

  public BilModel(int registreringsNummer, String stelnummer, String mærke,
                  String udstyrNiveau, UdlejningsStatusEnum udlejningsStatus,
                  GearEnum gear, String brændstofType, int kmL, int co2Udledning,
                  int prisPrMåned) {
    this.registreringsNummer = registreringsNummer;
    this.stelnummer = stelnummer;
    this.mærke = mærke;
    this.udstyrNiveau = udstyrNiveau;
    this.udlejningsStatus = udlejningsStatus;
    this.gear = gear;
    this.brændstofType = brændstofType;
    this.kmL = kmL;
    this.co2Udledning = co2Udledning;
    this.prisPrMåned = prisPrMåned;
  }

  public BilModel() {
  }

  public int getRegistreringsNummer() {
    return registreringsNummer;
  }

  public void setRegistreringsNummer(int registreringsNummer) {
    this.registreringsNummer = registreringsNummer;
  }

  public String getStelnummer() {
    return stelnummer;
  }

  public void setStelnummer(String stelnummer) {
    this.stelnummer = stelnummer;
  }

  public String getMærke() {
    return mærke;
  }

  public void setMærke(String mærke) {
    this.mærke = mærke;
  }

  public String getUdstyrNiveau() {
    return udstyrNiveau;
  }

  public void setUdstyrNiveau(String udstyrNiveau) {
    this.udstyrNiveau = udstyrNiveau;
  }

  public UdlejningsStatusEnum getUdlejningsStatus() {
    return udlejningsStatus;
  }

  public void setUdlejningsStatus(UdlejningsStatusEnum udlejningsStatus) {
    this.udlejningsStatus = udlejningsStatus;
  }

  public GearEnum getGear() {
    return gear;
  }

  public void setGear(GearEnum gear) {
    this.gear = gear;
  }

  public String getBrændstofType() {
    return brændstofType;
  }

  public void setBrændstofType(String brændstofType) {
    this.brændstofType = brændstofType;
  }

  public int getKmL() {
    return kmL;
  }

  public void setKmL(int kmL) {
    this.kmL = kmL;
  }

  public int getCo2Udledning() {
    return co2Udledning;
  }

  public void setCo2Udledning(int co2Udledning) {
    this.co2Udledning = co2Udledning;
  }

  public int getPrisPrMåned() {
    return prisPrMåned;
  }

  public void setPrisPrMåned(int prisPrMåned) {
    this.prisPrMåned = prisPrMåned;
  }

  @Override
  public String toString() {
    return "BilModel{" +
        "registreringsNummer=" + registreringsNummer +
        ", stelnummer='" + stelnummer + '\'' +
        ", mærke='" + mærke + '\'' +
        ", udstyrNiveau='" + udstyrNiveau + '\'' +
        ", udlejningsStatus=" + udlejningsStatus +
        ", gear=" + gear +
        ", brændstofType='" + brændstofType + '\'' +
        ", kmL=" + kmL +
        ", co2Udledning=" + co2Udledning +
        ", prisPrMåned=" + prisPrMåned +
        '}';
  }
}
