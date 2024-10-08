package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.GearEnum;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Model.UdlejningsStatusEnum;
import com.example.bilabonnement.Repositories.Util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Benjamin, Mathias, Marcus
public class DataregistreringsRepository {
  private Connection connection = DatabaseConnectionManager.getConnection();

  // Mathias
  public void updateSingleValue(String registreringnummer, int kmVedIndlevering){

      try {
        PreparedStatement psts = connection.prepareStatement("UPDATE LejeAftale SET KmVedIndlevering = ? where RegistreringsNummer = ?");
        psts.setInt(1,kmVedIndlevering);
        psts.setString(2,registreringnummer);
        psts.execute();

      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
  }

  // Mathias, Marcus
  public void createLejeAftale(LejeAftaleModel lejeAftaleModel) {
    String RegNr = null;
    int check = 0;
    PreparedStatement preparedStatement;
    try {
        preparedStatement = connection.prepareStatement("insert into LejeAftale (RegistreringsNummer,Navn,Adresse,Postnummer,Kommune," +
            "TelefonNr,CPR,Email,LejeperiodeFra,LejeperiodeTil,AntalMaaneder,Afhentningssted," +
            "Afleveringssted,KmVedAfhentning,AftaleKM,KmVedIndlevering) " +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


      preparedStatement.setString(1, lejeAftaleModel.getRegistreringsNummer());
      preparedStatement.setString(2, lejeAftaleModel.getNavn());
      preparedStatement.setString(3, lejeAftaleModel.getAdresse());
      preparedStatement.setString(4, lejeAftaleModel.getPostnummer());
      preparedStatement.setString(5, lejeAftaleModel.getKommune());
      preparedStatement.setString(6, lejeAftaleModel.getTelefonNr());
      preparedStatement.setString(7, lejeAftaleModel.getCPR());
      preparedStatement.setString(8, lejeAftaleModel.getEmail());
      preparedStatement.setString(9, lejeAftaleModel.getLejeperiodeFra());
      preparedStatement.setString(10, lejeAftaleModel.getLejeperiodeTil());
      preparedStatement.setString(11, lejeAftaleModel.getAntalMaaneder());
      preparedStatement.setString(12, lejeAftaleModel.getAfhentningssted());
      preparedStatement.setString(13, lejeAftaleModel.getAfleveringssted());
      preparedStatement.setString(14, lejeAftaleModel.getKmVedAfhentning());
      preparedStatement.setString(15, lejeAftaleModel.getAftaleKM());
      preparedStatement.setString(16, lejeAftaleModel.getKmVedIndlevering());
      RegNr = lejeAftaleModel.getRegistreringsNummer();
      System.out.println("Repo RegNr, når vi prøver at få værdien ind i den: " + RegNr);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      check = 1;
      System.out.println("Registreringen fejlede. Check er nu lig med: " + check);
      e.printStackTrace();
    }
    if(check == 0){
      try {
        System.out.println("hvis vi når her til burde check være: " + check);
        preparedStatement = connection.prepareStatement("UPDATE Biler SET udlejningsStatus = 'AKTIV' where registreringsNummer = ?");
        preparedStatement.setString(1, RegNr);
        preparedStatement.execute();

      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }

  // Mathias
  public void deleteLejeAftaleListe(String registreringnummer){
    PreparedStatement preparedStatement;
    String RegNr = null;
   try{
     preparedStatement = connection.prepareStatement("DELETE FROM LejeAftale where RegistreringsNummer = ?");
     preparedStatement.setString(1, registreringnummer);
     preparedStatement.execute();
     RegNr = registreringnummer;
   }
  catch (SQLException e) {
    throw new RuntimeException(e);
    }
    try {
      preparedStatement = connection.prepareStatement("UPDATE Biler SET udlejningsStatus = 'LEDIG' where registreringsNummer = ?");
      preparedStatement.setString(1, RegNr);
      preparedStatement.execute();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // Mathias, Marcus
  public List<LejeAftaleModel> getLejeAftaleById(String registreringsnummer){
      List<LejeAftaleModel> LejeAftaleListe = new ArrayList<>();

      try {
        PreparedStatement psts = connection.prepareStatement("SELECT * FROM LejeAftale where RegistreringsNummer = ?");
        psts.setString(1, registreringsnummer);
        ResultSet resultSet = psts.executeQuery();

        while (resultSet.next()) {
          LejeAftaleListe.add(new LejeAftaleModel(
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
                  ));
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
      return LejeAftaleListe;
    }

    //Mathias, Marcus
  public List<LejeAftaleModel> getAlleLejeAftaler(){
    List<LejeAftaleModel> LejeAftaleListe = new ArrayList<>();

    try {
      PreparedStatement psts = connection.prepareStatement("SELECT * FROM lejeaftale");
      ResultSet resultSet = psts.executeQuery();

      while (resultSet.next()) {
        LejeAftaleListe.add(new LejeAftaleModel(
            resultSet.getInt("aftaleId"),
            resultSet.getString("RegistreringsNummer"),
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
            resultSet.getString("KmVedIndlevering")
            ));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return LejeAftaleListe;
  }

  // Benjamin
  public List<BilModel> getAllLedigeBiler(){

    List<BilModel> ledigeBiler = new ArrayList<>();

    try {

      PreparedStatement psts = connection.prepareStatement("SELECT * FROM biler where UdlejningsStatus = 'LEDIG'");

      ResultSet resultSet = psts.executeQuery();

      while (resultSet.next()) {
        ledigeBiler.add(new BilModel(
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
        ));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ledigeBiler;
  }

}

