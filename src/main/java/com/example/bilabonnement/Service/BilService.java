package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.UdlejningsStatusEnum;
import com.example.bilabonnement.Repositories.BilRepository;

public class BilService {

    BilRepository bilRepository = new BilRepository();
    public String updateSingleValue(String registreringsnummer, UdlejningsStatusEnum udlejningsStatus){
        bilRepository.updateSingleValue(registreringsnummer, udlejningsStatus);
        return registreringsnummer;
    }
}
