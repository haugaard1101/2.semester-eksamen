package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.UserModel;
import com.example.bilabonnement.Repositories.LoginRepository;

import java.util.ArrayList;

public class LoginService {


    LoginRepository loginRepository = new LoginRepository();

    ArrayList<UserModel> list = new ArrayList<>();
    public int login(UserModel user){


        for (UserModel i : loginRepository.getDataFromDatabaseIntoArraylist()){
            if(user.getUserName().equals(i.getUserName()) && user.getUserPassword().equals(i.getUserPassword())){
                System.out.println(i.getUserId());
                return i.getUserId();

            }
        }
        return -1;

    }


}
