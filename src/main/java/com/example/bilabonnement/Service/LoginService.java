package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.UserModel;
import com.example.bilabonnement.Repositories.LoginRepository;

import java.util.ArrayList;
import java.util.List;

public class LoginService {


    LoginRepository loginRepository = new LoginRepository();

    ArrayList<UserModel> list = new ArrayList<>();
    public int login(UserModel user){



        List<UserModel> liste1 = loginRepository.getDataFromDatabaseIntoArraylist(user.getUserName(),user.getUserPassword());

        for (UserModel i : liste1){

            if(user.getUserName().equals(i.getUserName()) && user.getUserPassword().equals(i.getUserPassword())){
                return i.getUserId();

            }
        }
        return -1;

    }


}
