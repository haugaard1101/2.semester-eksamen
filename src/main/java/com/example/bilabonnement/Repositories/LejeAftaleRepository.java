package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Repositories.Util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LejeAftaleRepository {
  private Connection connection = DatabaseConnectionManager.getConnection();

  public void createLejeAftale(LejeAftaleModel lejeAftaleModel) {

    try {
      PreparedStatement preparedStatement = connection.prepareStatement("insert into LejeAftale (Navn,Adresse,Postnummer,Kommune,TelefonNr,CPR,Email,LejeperiodeFra,LejeperiodeTil,Antal_Måneder,Afhentningssted,Afleveringssted,KM_ved_Afhentning,MaxKilometer,AktueltKørteKilometer,RegistreringsNummer) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      preparedStatement.setString(1, lejeAftaleModel.getNavn());
      preparedStatement.setString(2, lejeAftaleModel.getAdresse());
      preparedStatement.setInt(3, lejeAftaleModel.getPostnummer());
      preparedStatement.setString(4, lejeAftaleModel.getKommune());
      preparedStatement.setInt(5, lejeAftaleModel.getTelefonNr());
      preparedStatement.setString(6, lejeAftaleModel.getCpr());
      preparedStatement.setString(7, lejeAftaleModel.geteMail());
      preparedStatement.setDate(8, (Date) lejeAftaleModel.getLejeperiodeFra());
      preparedStatement.setDate(9, (Date) lejeAftaleModel.getLejeperiodeTil());
      preparedStatement.setInt(10, lejeAftaleModel.getAntalMåneder());
      preparedStatement.setString(11, lejeAftaleModel.getAfhentningssted());
      preparedStatement.setString(12, lejeAftaleModel.getAfleveringssted());
      preparedStatement.setInt(13, lejeAftaleModel.getKmVedAfhentning());
      preparedStatement.setInt(14, lejeAftaleModel.getMaxKilometer());
      preparedStatement.setInt(15, lejeAftaleModel.getAktueltKørteKilometer());
      preparedStatement.setInt(16, lejeAftaleModel.getRegistreringsNummer());

      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public List<LejeAftaleModel> getLejeAftaleById(int id){
      List<LejeAftaleModel> LejeAftaleListe = new ArrayList<>();

      try {
        PreparedStatement psts = connection.prepareStatement("SELECT * FROM LejeAftale where AftaleID = id");
        ResultSet resultSet = psts.executeQuery();

        while (resultSet.next()) {
          LejeAftaleListe.add(new LejeAftaleModel(
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
              resultSet.getInt("KM_ved_Afhentning"),
              resultSet.getInt("AftaleID"),
              resultSet.getInt("MaxKilometer"),
              resultSet.getInt("AktueltKørteKilometer"),
              resultSet.getInt("RegistreringsNummer")
              ));
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
      return LejeAftaleListe;
    }
  }

