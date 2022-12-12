package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.UdlejningsStatusEnum;
import com.example.bilabonnement.Repositories.Util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BilRepository {
    private Connection connection = DatabaseConnectionManager.getConnection();

    public void updateSingleValue(String registreringnummer, UdlejningsStatusEnum udlejningsStatus){

        try {
            PreparedStatement psts = connection.prepareStatement("UPDATE Biler SET udlejningsStatus = ? where registreringsNummer = ?");
            psts.setString(1, udlejningsStatus.toString());
            psts.setString(2,registreringnummer);
            psts.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  void updateLejeStatus(String registreringnummer){
        try {
            PreparedStatement psts = connection.prepareStatement("UPDATE Biler SET UdlejningsStatus = 'AKTIV' where RegistreringsNummer = ?");
            psts.setString(1,registreringnummer);
            System.out.println("registreringsnummer i repo af opdatering af udlejningsstatus " + registreringnummer);
            psts.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
