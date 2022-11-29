package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Model.SOUModel;
import com.example.bilabonnement.Repositories.Util.DatabaseConnectionManager;
import com.example.bilabonnement.Model.UdlejningsStatusEnum;
import com.example.bilabonnement.Model.GearEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SOURepository {

    private Connection connection = DatabaseConnectionManager.getConnection();

    public List<SOUModel> getSOUById(int id){
        List<SOUModel> SOUListe = new ArrayList<>();

        try {
            PreparedStatement psts = connection.prepareStatement("SELECT * FROM Skader where RegistreringsNummer = id");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                SOUListe.add(new SOUModel(
                        resultSet.getInt("SkadeID"),
                        resultSet.getString("SkadeNavn"),
                        resultSet.getInt("SkadePris"),
                        resultSet.getInt("RegistreringsNummer")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return SOUListe;
    }

    public List<LejeAftaleModel> getLejeAftaleByRegistreringsNummer(int id){
        List<LejeAftaleModel> LejeAftaleSOU = new ArrayList<>();

        try {
            PreparedStatement psts = connection.prepareStatement("SELECT * FROM LejeAftale where RegistreringsNummer = id");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                LejeAftaleSOU.add(new LejeAftaleModel(
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
        return LejeAftaleSOU;
    }

    public List<BilModel> getBilByRegistreringsNummer(int id){
        List<BilModel> BilListe = new ArrayList<>();

        try {
            PreparedStatement psts = connection.prepareStatement("SELECT * FROM Biler where RegistreringsNummer = id");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                BilListe.add(new BilModel(
                        resultSet.getInt("RegistreringsNummer"),
                        resultSet.getString("Stelnummer"),
                        resultSet.getString("Mærke"),
                        resultSet.getString("Model"),
                        resultSet.getString("UdstyrsNiveau"),
                        resultSet.getENUM("UdlejningsStatus"),
                        resultSet.getENUM("Gear"),
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

}
