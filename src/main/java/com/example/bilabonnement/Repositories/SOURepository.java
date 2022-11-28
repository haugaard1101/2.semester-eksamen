package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.SOUModel;
import com.example.bilabonnement.Repositories.Util.DatabaseConnectionManager;

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

}
