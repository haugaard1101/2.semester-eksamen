package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Repositories.Util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForretningsudviklerRepository {

  private Connection conn = DatabaseConnectionManager.getConnection();


  public List<BilModel> getAllRentedCars() {
    List<BilModel> students = new ArrayList<>();

    try {
      // Her laver vi variable der kan udføre en SQL statement i databasen
      PreparedStatement psts = conn.prepareStatement("SELECT * FROM biler");
      // Nu beder vi databasen om at execute den SQL commando og gemmer resultatet i en "ResultSet" klasse variabel.
      ResultSet resultSet = psts.executeQuery();

      // Nu looper vi sættet igennem for hver student, og laver en ny student med constructoren for hver student, med vores variabler vi kan finde i sættet som vi indsætter i constructoren.
      while (resultSet.next()) {
        students.add(new BilModel(
            resultSet.getString("RegistreringsNummer"),
            resultSet.getString("Stelnummer"),
            resultSet.getString("Mærke"),
            resultSet.getString("Model"),
            resultSet.getString("UdstyrsNiveau"),
            resultSet.getString("UdlejningsStatus"),
            resultSet.getString("Gear"),
            resultSet.getString("BrændstofType"),
            resultSet.getInt("KM_L"),
            resultSet.getInt("CO2_Udledning"),
            resultSet.getInt("Pris_pr_Måned")
            ));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return students;
  }
}
