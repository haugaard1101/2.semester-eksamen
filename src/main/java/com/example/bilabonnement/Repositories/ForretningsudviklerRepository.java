package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.GearEnum;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Model.UdlejningsStatusEnum;
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
        List<BilModel> rentedCars = new ArrayList<>();

        try {
            // Her laver vi variable der kan udføre en SQL statement i databasen
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM biler where UdlejningsStatus = 'AKTIV'");
            // Nu beder vi databasen om at execute den SQL commando og gemmer resultatet i en "ResultSet" klasse variabel.
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                rentedCars.add(new BilModel(
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
        return rentedCars;
    }

    public int getPriceOfAllRentedCars() {
        List<BilModel> rentedCars = new ArrayList<>();
        rentedCars = getAllRentedCars();
        List<Integer> priceOfRentedCars = new ArrayList<>();
        for (BilModel car : rentedCars) {
            priceOfRentedCars.add(car.getPrisPrMaaned());
        }
        int sum = 0;

        for (int price : priceOfRentedCars) {
            sum = sum + price;
        }
        return sum;
    }

    public int getCO2OfAllRentedCars() {
        List<BilModel> rentedCars = new ArrayList<>();
        rentedCars = getAllRentedCars();
        List<Integer> CO2OfRentedCars = new ArrayList<>();
        for (BilModel car : rentedCars) {
            CO2OfRentedCars.add(car.getCo2Udledning());
        }
        int sum = 0;

        for (int price : CO2OfRentedCars) {
            sum = sum + price;
        }
        return sum;
    }



    public BilModel findEnBil(String RegNr) throws Exception {
        BilModel bilModel = null;
        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM biler where RegistreringsNummer = ?");
            psts.setString(1, RegNr);
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                bilModel = new BilModel(
                        resultSet.getString("Mærke"),
                        resultSet.getString("Model"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bilModel;
    }
}
