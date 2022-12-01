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
            resultSet.getString("RegistreringsNummer"),
            resultSet.getString("SkadeNavn"),
            resultSet.getInt("SkadePris")
        ));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return skadeListe;
  }

  public LejeAftaleModel findEnLejekontrakt(String RegNr) {
    LejeAftaleModel lejeaftale = null;
    try {
      PreparedStatement psts = connection.prepareStatement("SELECT * FROM lejeaftale where RegistreringsNummer = ?");
      psts.setString(1, RegNr);
      ResultSet resultSet = psts.executeQuery();

      while (resultSet.next()) {
        lejeaftale = new LejeAftaleModel(
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
            resultSet.getInt("AntalMåneder"),
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
    return lejeaftale;
  }

  public BilModel findEnBil(String RegNr) {
    BilModel bil = null;
    try {
      PreparedStatement psts = connection.prepareStatement("SELECT * FROM biler where RegistreringsNummer = ?");
      psts.setString(1, RegNr);
      ResultSet resultSet = psts.executeQuery();

      while (resultSet.next()) {
        bil = new BilModel(
            resultSet.getInt("IDNumber"),
            resultSet.getString("RegistreringsNummer"),
            resultSet.getString("Stelnummer"),
            resultSet.getString("Mærke"),
            resultSet.getString("Model"),
            resultSet.getString("UdstyrsNiveau"),
            UdlejningsStatusEnum.valueOf(resultSet.getString("UdlejningsStatus")),
            GearEnum.valueOf(resultSet.getString("Gear")),
            resultSet.getString("BrændstofType"),
            resultSet.getInt("KmL"),
            resultSet.getInt("CO2_Udledning"),
            resultSet.getInt("PrisPrMåned")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bil;
  }

  public void deleteSkade(int ID) {
    try {
      PreparedStatement psts = connection.prepareStatement("DELETE * FROM skader where SkadeID = ?");
      psts.setInt(1, ID);
      psts.executeQuery();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}