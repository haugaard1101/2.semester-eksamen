package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.UserModel;
import com.example.bilabonnement.Repositories.LoginRepository;

import java.util.ArrayList;
import java.util.List;

public class LoginService {


    LoginRepository loginRepository = new LoginRepository();

    ArrayList<UserModel> list = new ArrayList<>();


    //Benjamin, Marcus og Mathias
    public int login(UserModel user){


        List<UserModel> usersFromDatabase = loginRepository.getDataFromDatabaseIntoArraylist(user.getUserName(),user.getUserPassword());


        //Looper igennem arraylisten og sammenligner UserModel I med data fra databasen
        for (UserModel i : usersFromDatabase){
            if(user.getUserName().equals(i.getUserName()) && user.getUserPassword().equals(i.getUserPassword())){
                return i.getUserId();

            }
        }
        //Alle users har et userID over 0, så hvis metoden retunere -1 kan du ikke logge ind.
        return -1;

    }


}
