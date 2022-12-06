package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.SkadeModel;
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




    public List<UserModel> getDataFromDatabaseIntoArraylist(String userName, String userPassword){
        ArrayList<UserModel> UserArraylist = new ArrayList<>();


        try {
            //preparedstatement vælger alt fra databasen - Select everything* from users
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users where userName = ? and password = ?");
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,userPassword);
            //putter preparedstatement ned i et resultset som bliver executed.
            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next()){

                //lav et bruger objekt og tilføj den til arraylisten
                UserArraylist.add(new UserModel(
                        rs.getInt("userID"),
                        rs.getString("userName"),
                        rs.getString("password")));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return UserArraylist;


    }
/*
    public int loggedin(UserModel userModel){
        getDataFromDatabaseIntoArraylist();
    for (UserModel i: UserArraylist){
        if (userModel.getUserName().equals(i.getUserId())&& userModel.getUserPassword().equals(i.getUserPassword())){
            return i.getUserId();
        }
    }
return -1;
    }


 */

}
