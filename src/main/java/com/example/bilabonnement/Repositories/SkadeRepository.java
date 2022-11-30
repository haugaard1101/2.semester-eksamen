package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.*;
import com.example.bilabonnement.Repositories.Util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkadeRepository {


  private Connection connection = DatabaseConnectionManager.getConnection();

  public List<SkadeModel> getSkadeListe() {
    List<SkadeModel> skadeListe = new ArrayList<>();

    try {
      PreparedStatement psts = connection.prepareStatement("SELECT * FROM skader");
      ResultSet resultSet = psts.executeQuery();

      while (resultSet.next()) {
        skadeListe.add(new SkadeModel(
            resultSet.getInt("SkadeID"),
            resultSet.getString("SkadeNavn"),
            resultSet.getInt("SkadePris"),
            resultSet.getString("RegistreringsNummer")
        ));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return skadeListe;
  }

  public List<LejeAftaleModel> getLejeAftaleByRegNr() {
    List<LejeAftaleModel> LejeAftaleListeSkade = new ArrayList<>();


    try {
      PreparedStatement psts = connection.prepareStatement("SELECT * FROM lejeaftale");
      ResultSet resultSet = psts.executeQuery();

      while (resultSet.next()) {
        LejeAftaleListeSkade.add(new LejeAftaleModel(
            resultSet.getInt("AftaleID"),
            resultSet.getString("Navn"),
            resultSet.getString("Adresse"),
            resultSet.getInt("Postnummer"),
            resultSet.getString("Kommune"),
            resultSet.getInt("TelefonNr"),
            resultSet.getString("CPR"),
            resultSet.getString("Email"),
            resultSet.getDate("LejeperiodeFra"),
            resultSet.getDate("LejeperiodeTil"),
            resultSet.getInt("Antal_Måneder"),
            resultSet.getString("Afhentningssted"),
            resultSet.getString("Afleveringssted"),
            resultSet.getInt("KmVedAfhentning"),
            resultSet.getInt("AftaleKM"),
            resultSet.getInt("KmVedIndlevering"),
            resultSet.getString("RegistreringsNummer")
        ));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return LejeAftaleListeSkade;
  }

  public List<BilModel> getBilByRegistreringsNummer() {
    List<BilModel> BilListe = new ArrayList<>();

    try {
      PreparedStatement psts = connection.prepareStatement("SELECT * FROM biler where RegistreringsNummer = ?");
      ResultSet resultSet = psts.executeQuery();

      while (resultSet.next()) {
        BilListe.add(new BilModel(
            resultSet.getInt("IDNumber"),
            resultSet.getString("RegistreringsNummer"),
            resultSet.getString("Stelnummer"),
            resultSet.getString("Mærke"),
            resultSet.getString("Model"),
            resultSet.getString("UdstyrsNiveau"),
            UdlejningsStatusEnum.valueOf(resultSet.getString("UdlejningsStatus")),
            GearEnum.valueOf(resultSet.getString("Gear")),
            resultSet.getString("BrændstofType"),
            resultSet.getInt("KM_L"),
            resultSet.getInt("CO2_Udledning"),
            resultSet.getInt("Pris_pr_Måned")
        ));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return BilListe;
  }

  public LejeAftaleModel findEnLejekontrakt(String RegNr) {

    try {
      PreparedStatement psts = connection.prepareStatement("SELECT * FROM lejeaftale where RegistreringsNummer = ?");
      psts.setString(1, RegNr);
      ResultSet resultSet = psts.executeQuery();

      while (resultSet.next()) {
        return new LejeAftaleModel(
            resultSet.getInt("AftaleID"),
            resultSet.getString("Navn"),
            resultSet.getString("Adresse"),
            resultSet.getInt("Postnummer"),
            resultSet.getString("Kommune"),
            resultSet.getInt("TelefonNr"),
            resultSet.getString("CPR"),
            resultSet.getString("Email"),
            resultSet.getDate("LejeperiodeFra"),
            resultSet.getDate("LejeperiodeTil"),
            resultSet.getInt("Antal_Måneder"),
            resultSet.getString("Afhentningssted"),
            resultSet.getString("Afleveringssted"),
            resultSet.getInt("KmVedAfhentning"),
            resultSet.getInt("AftaleKM"),
            resultSet.getInt("KmVedIndlevering"),
            resultSet.getString("RegistreringsNummer")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
