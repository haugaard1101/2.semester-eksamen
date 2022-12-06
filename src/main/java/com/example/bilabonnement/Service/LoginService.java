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
        System.out.println("liste " + liste1.toString());

        for (UserModel i : liste1){

            if(user.getUserName().equals(i.getUserName()) && user.getUserPassword().equals(i.getUserPassword())){
                System.out.println(i.getUserId());
                return i.getUserId();

            }
        }
        return -1;

    }


}
