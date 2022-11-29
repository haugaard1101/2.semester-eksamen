package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.SOUModel;
import com.example.bilabonnement.Repositories.SOURepository;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

public class SOUService {

    SOURepository souRepo = new SOURepository();
    private int pris;


    public int beregnPrisSOU(WebRequest request) {
        souRepo.getSkadeListe();







        return pris;
    }

    public int beregnKmPris(WebRequest request) {
        int kmKørtIPeriode;


        //lejeAftale.getKmVedAfhentning
        return pris;
    }

}
