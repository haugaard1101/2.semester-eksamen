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
            "TelefonNr,CPR,Email,LejeperiodeFra,LejeperiodeTil,AntalMåneder,Afhentningssted," +
            "Afleveringssted,KmVedAfhentning,AftaleKM,KmVedIndlevering) " +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

      } else {
        preparedStatement = connection.prepareStatement("UPDATE LejeAftale (RegistreringsNummer,Navn,Adresse,Postnummer,Kommune," +
            "TelefonNr,CPR,Email,LejeperiodeFra,LejeperiodeTil,AntalMåneder,Afhentningssted,"+
            "Afleveringssted,KmVedAfhentning,AftaleKM,KmVedIndlevering) " +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      }

      preparedStatement.setString(1, lejeAftaleModel.getRegistreringsNummer());
      preparedStatement.setString(2, lejeAftaleModel.getNavn());
      preparedStatement.setString(3, lejeAftaleModel.getAdresse());
      preparedStatement.setInt(4, lejeAftaleModel.getPostnummer());
      preparedStatement.setString(5, lejeAftaleModel.getKommune());
      preparedStatement.setInt(6, lejeAftaleModel.getTelefonNr());
      preparedStatement.setString(7, lejeAftaleModel.getCpr());
      preparedStatement.setString(8, lejeAftaleModel.geteMail());
      preparedStatement.setDate(9, (Date) lejeAftaleModel.getLejeperiodeFra());
      preparedStatement.setDate(10, (Date) lejeAftaleModel.getLejeperiodeTil());
      preparedStatement.setInt(11, lejeAftaleModel.getAntalMåneder());
      preparedStatement.setString(12, lejeAftaleModel.getAfhentningssted());
      preparedStatement.setString(13, lejeAftaleModel.getAfleveringssted());
      preparedStatement.setInt(14, lejeAftaleModel.getKmVedAfhentning());
      preparedStatement.setInt(15, lejeAftaleModel.getAftaleKM());
      preparedStatement.setInt(16, lejeAftaleModel.getKmVedIndlevering());

      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  public void deleteLejeAftaleListe(int id){
   try{
     PreparedStatement psts = connection.prepareStatement("DELETE * FROM LejeAftale where RegistreringsNummer = ?");
     psts.setInt(1, id);
   }
  catch (SQLException e) {
    throw new RuntimeException(e);
    }
  }
  public List<LejeAftaleModel> getLejeAftaleById(int id){
      List<LejeAftaleModel> LejeAftaleListe = new ArrayList<>();

      try {
        PreparedStatement psts = connection.prepareStatement("SELECT * FROM LejeAftale where RegistreringsNummer = ?");
        psts.setInt(1, id);
        ResultSet resultSet = psts.executeQuery();

        while (resultSet.next()) {
          LejeAftaleListe.add(new LejeAftaleModel(
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
      PreparedStatement psts = connection.prepareStatement("SELECT * FROM LejeAftale");
      ResultSet resultSet = psts.executeQuery();

      while (resultSet.next()) {
        LejeAftaleListe.add(new LejeAftaleModel(
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
        ));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return LejeAftaleListe;
  }
}

