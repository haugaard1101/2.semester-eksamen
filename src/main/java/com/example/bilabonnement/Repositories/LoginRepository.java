package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.UserModel;
import com.example.bilabonnement.Repositories.Util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginRepository {


    private Connection connection = DatabaseConnectionManager.getConnection();




    public List<UserModel> getDataFromDatabaseIntoArraylist(){
        ArrayList<UserModel> UserArraylist = new ArrayList<>();


        try {
            //preparedstatement vælger alt fra databasen - Select everything* from users
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");


            //putter preparedstatement ned i et resultset som bliver executed.
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                //lav et bruger objekt og tilføj den til arraylisten
                UserArraylist.add(new UserModel(
                        rs.getInt("userID"),
                        rs.getString("userName"),
                        rs.getString("userPassword")));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return UserArraylist;


    }


}
