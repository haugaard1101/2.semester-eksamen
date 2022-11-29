package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.SOUModel;
import com.example.bilabonnement.Repositories.SOURepository;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

public class SOUService {

    SOURepository souRepo = new SOURepository();

    List<SOUModel> skadeListe = new ArrayList<>();
/*
    public void addSkader() {
        skadeListe.add("Lakfelt", 1500);
        skadeListe.add("Ridset alufælge", 400);
        skadeListe.add("Ny forrude", 3000);
    }

 */

    public double beregnKmPris(WebRequest request) {

        //Hardcoded
        int kmVedAfhentning = 1;
        int kmVedAflevering = 2;

        int kmKørt = kmVedAflevering - kmVedAfhentning;
        int aftalteKm = 3;

        if (kmKørt > aftalteKm) {
            int kmKørtForLangt = kmKørt - aftalteKm;
            return kmKørtForLangt * 0.75;
        } else return 0;
    }
/*
    public double beregnPrisSOU(WebRequest request) {
        addSkader();





        return 0;
    }

 */

}
