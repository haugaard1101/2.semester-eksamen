package com.example.bilabonnement.Model;

public class BilModel {
  private int idNumber;
  private String registreringsNummer;
  private String stelnummer;
  private String maerke;
  private String model;
  private String udstyrNiveau;
  private UdlejningsStatusEnum udlejningsStatus;
  private GearEnum gear;
  private String braendstofType;
  private int kmL;
  private int co2Udledning;
  private int prisPrMaaned;

  public BilModel(int idNumber, String registreringsNummer, String stelnummer, String maerke, String model, String udstyrNiveau, UdlejningsStatusEnum udlejningsStatus, GearEnum gear, String braendstofType, int kmL, int co2Udledning, int prisPrMaaned) {
    this.idNumber = idNumber;
    this.registreringsNummer = registreringsNummer;
    this.stelnummer = stelnummer;
    this.maerke = maerke;
    this.model = model;
    this.udstyrNiveau = udstyrNiveau;
    this.udlejningsStatus = udlejningsStatus;
    this.gear = gear;
    this.braendstofType = braendstofType;
    this.kmL = kmL;
    this.co2Udledning = co2Udledning;
    this.prisPrMaaned = prisPrMaaned;
  }

  public BilModel() {
  }

  public int getIdNumber() {
    return idNumber;
  }

  public GearEnum getGearEnum(){
    return gear;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getRegistreringsNummer() {
    return registreringsNummer;
  }

  public void setRegistreringsNummer(String registreringsNummer) {
    this.registreringsNummer = registreringsNummer;
  }

  public String getStelnummer() {
    return stelnummer;
  }

  public void setStelnummer(String stelnummer) {
    this.stelnummer = stelnummer;
  }

  public String getMaerke() {
    return maerke;
  }

  public void setMaerke(String maerke) {
    this.maerke = maerke;
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

  public String getBraendstofType() {
    return braendstofType;
  }

  public void setBraendstofType(String braendstofType) {
    this.braendstofType = braendstofType;
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

  public int getPrisPrMaaned() {
    return prisPrMaaned;
  }

  public void setPrisPrMaaned(int prisPrMaaned) {
    this.prisPrMaaned = prisPrMaaned;
  }

  @Override
  public String toString() {
    return "BilModel{" +
        "registreringsNummer=" + registreringsNummer +
        ", stelnummer='" + stelnummer + '\'' +
        ", mærke='" + maerke + '\'' +
        ", udstyrNiveau='" + udstyrNiveau + '\'' +
        ", udlejningsStatus=" + udlejningsStatus +
        ", gear=" + gear +
        ", brændstofType='" + braendstofType + '\'' +
        ", kmL=" + kmL +
        ", co2Udledning=" + co2Udledning +
        ", prisPrMåned=" + prisPrMaaned +
        '}';
  }
}
