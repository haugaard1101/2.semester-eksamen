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

  //viser alle skader
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
            resultSet.getString("SkadePris")
        ));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return skadeListe;
  }

  //finder og lægger prisen af skader sammen på en bestemt lejeaftale
  public int getPriceOnSkader(String RegNr) {
    int skadeRegning = 0;
    List<SkadeModel> skader = new ArrayList<>();
    try {
      PreparedStatement psts = connection.prepareStatement("SELECT * FROM skader WHERE RegistreringsNummer = ?");
      psts.setString(1, RegNr);
      ResultSet resultSet = psts.executeQuery();

      while (resultSet.next()) {
        skader.add(new SkadeModel(
            resultSet.getInt("SkadeID"),
            resultSet.getString("RegistreringsNummer"),
            resultSet.getString("SkadeNavn"),
            resultSet.getString("SkadePris")
        ));
      }

      for (SkadeModel skadeModel : skader) {
        skadeRegning += Integer.parseInt(String.valueOf(skadeModel.getSkadePris()));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return skadeRegning;
  }

  //finder og viser en lejeaftale udfra RegNr
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
            resultSet.getString("Postnummer"),
            resultSet.getString("Kommune"),
            resultSet.getString("TelefonNr"),
            resultSet.getString("CPR"),
            resultSet.getString("Email"),
            resultSet.getString("LejeperiodeFra"),
            resultSet.getString("LejeperiodeTil"),
            resultSet.getString("AntalMaaneder"),
            resultSet.getString("Afhentningssted"),
            resultSet.getString("Afleveringssted"),
            resultSet.getString("KmVedAfhentning"),
            resultSet.getString("AftaleKM"),
            resultSet.getString("KmVedIndlevering"),
            resultSet.getString("RegistreringsNummer")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lejeaftale;
  }

  //finder og viser en bil udfra RegNr
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

  //sletter en skader udfra skadeID
  public void deleteSkade(int ID) {
    try {
      PreparedStatement psts = connection.prepareStatement("DELETE FROM skader where SkadeID = ?");
      psts.setInt(1, ID);
      psts.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  //oprette en skade og ændre KM ved indlevering på en bil (den burde nok også ændre KM ved aflevering, så den er opdateret til næste gang bilen udlejes
  public void createSkade(String RegNr, String aflæstKm, String lakfelt, String ridsetAlufælgerequest, String nyForrude) {
    PreparedStatement psts;

    try {
      if (!aflæstKm.equals("")) {
        psts = connection.prepareStatement("UPDATE lejeaftale SET KmVedIndlevering = ? where RegistreringsNummer = ?");
        psts.setString(1, aflæstKm);
        psts.setString(2, RegNr);
        psts.executeUpdate();
      }
      if (!(lakfelt == null)) {
        psts = connection.prepareStatement("INSERT INTO skader (RegistreringsNummer, SkadeNavn, SkadePris) VALUES (?, 'lakfelt', 1500)");
        psts.setString(1, RegNr);
        psts.execute();
      }
      if (!(ridsetAlufælgerequest == null)) {
        psts = connection.prepareStatement("INSERT INTO skader (RegistreringsNummer, SkadeNavn, SkadePris) VALUES (?, 'ridset alufælge', 400)");
        psts.setString(1, RegNr);
        psts.execute();
      }
      if (!(nyForrude == null)) {
        psts = connection.prepareStatement("INSERT INTO skader (RegistreringsNummer, SkadeNavn, SkadePris) VALUES (?, 'ny forrude', 3000)");
        psts.setString(1, RegNr);
        psts.execute();
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
