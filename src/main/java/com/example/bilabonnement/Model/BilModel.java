package com.example.bilabonnement.Model;

// Kasper, Mathias, Marcus
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

  // Kasper, Marcus
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

  //Kasper
  public BilModel() {
  }

  // Marcus
  public BilModel(String maerke, String model) {
    this.maerke = maerke;
    this.model =model;
  }

  // Benjamin
  public int getIdNumber() {
    return idNumber;
  }

  // Benjamin
  public GearEnum getGearEnum(){
    return gear;
  }

  // Kasper
  public String getModel() {
    return model;
  }

  // Kasper
  public void setModel(String model) {
    this.model = model;
  }


  // Kasper, Marcus
  public String getRegistreringsNummer() {
    return registreringsNummer;
  }

  // Kasper
  public void setRegistreringsNummer(String registreringsNummer) {
    this.registreringsNummer = registreringsNummer;
  }

  // Kasper
  public String getStelnummer() {
    return stelnummer;
  }

  // Kasper
  public void setStelnummer(String stelnummer) {
    this.stelnummer = stelnummer;
  }

  // Marcus, Benjamin
  public String getMaerke() {
    return maerke;
  }

  // Marcus, Benjamin
  public void setMaerke(String maerke) {
    this.maerke = maerke;
  }

  // Kasper
  public String getUdstyrNiveau() {
    return udstyrNiveau;
  }

  // Kasper
  public void setUdstyrNiveau(String udstyrNiveau) {
    this.udstyrNiveau = udstyrNiveau;
  }

  // Kasper
  public UdlejningsStatusEnum getUdlejningsStatus() {
    return udlejningsStatus;
  }

  // Kasper
  public void setUdlejningsStatus(UdlejningsStatusEnum udlejningsStatus) {
    this.udlejningsStatus = udlejningsStatus;
  }

  // Kasper
  public GearEnum getGear() {
    return gear;
  }

  // Kasper
  public void setGear(GearEnum gear) {
    this.gear = gear;
  }

  // Kasper, Benjamin
  public String getBraendstofType() {
    return braendstofType;
  }

  // Kasper, Benjamin
  public void setBraendstofType(String braendstofType) {
    this.braendstofType = braendstofType;
  }

  // Kasper
  public int getKmL() {
    return kmL;
  }

  // Kasper
  public void setKmL(int kmL) {
    this.kmL = kmL;
  }

  // Kasper
  public int getCo2Udledning() {
    return co2Udledning;
  }

  // Kasper
  public void setCo2Udledning(int co2Udledning) {
    this.co2Udledning = co2Udledning;
  }

  // Kasper, Benjamin
  public int getPrisPrMaaned() {
    return prisPrMaaned;
  }

  // Kasper, Benjamin
  public void setPrisPrMaaned(int prisPrMaaned) {
    this.prisPrMaaned = prisPrMaaned;
  }

  // Kasper
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
