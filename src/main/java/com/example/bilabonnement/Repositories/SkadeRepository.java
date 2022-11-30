package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Model.SkadeModel;
import com.example.bilabonnement.Repositories.Util.DatabaseConnectionManager;

import javax.servlet.http.HttpSession;
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

    public List<LejeAftaleModel> getLejeAftaleByRegNr(HttpSession session) {
        List<LejeAftaleModel> skadeLejeAftale = new ArrayList<>();

        try {
            PreparedStatement psts = connection.prepareStatement("SELECT * FROM lejeaftale WHERE ");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                skadeLejeAftale.add(new LejeAftaleModel(
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
                        resultSet.getString("RegistreringsNummer")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return skadeLejeAftale;
    }

    public List<BilModel> getBilByRegistreringsNummer() {
        List<BilModel> BilListe = new ArrayList<>();

        try {
            PreparedStatement psts = connection.prepareStatement("SELECT * FROM biler where RegistreringsNummer = ?");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                BilListe.add(new BilModel(
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
            throw new RuntimeException(e);
        }
        return BilListe;
    }

}
