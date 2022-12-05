package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Repositories.Util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LejeAftaleRepository {
  private Connection connection = DatabaseConnectionManager.getConnection();

  public void createLejeAftale(LejeAftaleModel lejeAftaleModel,String command) {

    try {
      PreparedStatement preparedStatement;
      if (Objects.equals(command, "create")) {
        preparedStatement = connection.prepareStatement("insert into LejeAftale (RegistreringsNummer,Navn,Adresse,Postnummer,Kommune," +
            "TelefonNr,CPR,Email,LejeperiodeFra,LejeperiodeTil,AntalMaaneder,Afhentningssted," +
            "Afleveringssted,KmVedAfhentning,AftaleKM,KmVedIndlevering) " +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

      } else {
        preparedStatement = connection.prepareStatement("UPDATE LejeAftale (RegistreringsNummer,Navn,Adresse,Postnummer,Kommune," +
            "TelefonNr,CPR,Email,LejeperiodeFra,LejeperiodeTil,AntalMaaneder,Afhentningssted,"+
            "Afleveringssted,KmVedAfhentning,AftaleKM,KmVedIndlevering) " +
            "where RegistreringsNummer = ? values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, lejeAftaleModel.getRegistreringsNummer());
      }
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

      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  public void deleteLejeAftaleListe(String registreringnummer){
   try{
     PreparedStatement psts = connection.prepareStatement("DELETE FROM LejeAftale where RegistreringsNummer = ?");
     psts.setString(1, registreringnummer);
     psts.execute();
   }
  catch (SQLException e) {
    throw new RuntimeException(e);
    }
  }
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
}

