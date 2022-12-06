package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Model.SkadeModel;
import com.example.bilabonnement.Repositories.SkadeRepository;

import java.util.List;

public class SkadeService {

    SkadeRepository skadeRepo = new SkadeRepository();

    public LejeAftaleModel findEnLejekontrakt(String RegNr) {
        return skadeRepo.findEnLejekontrakt(RegNr);
    }

    public BilModel findEnBil(String RegNr) {
        return skadeRepo.findEnBil(RegNr);
    }

    public List<SkadeModel> getAllSkader() {
        return skadeRepo.getSkadeListe();
    }

    public void deleteSkade(int ID) {
        skadeRepo.deleteSkade(ID);
    }

    public void createSkade(String RegNr, String aflæstKm, String lakfelt, String ridsetAlufælgerequest, String nyForrude) {
        skadeRepo.createSkade(RegNr, aflæstKm, lakfelt, ridsetAlufælgerequest, nyForrude);

        //regningen på overkørte KM og skader
        double regning;
        double kmRegning;
        double skadeRegning = skadeRepo.getPriceOnSkader(RegNr);
        double kmVedIndlevering = Double.parseDouble(skadeRepo.findEnLejekontrakt(RegNr).getKmVedIndlevering());
        double kmVedAflevering = Double.parseDouble(skadeRepo.findEnLejekontrakt(RegNr).getKmVedAfhentning());
        double aftaleKM = Double.parseDouble(skadeRepo.findEnLejekontrakt(RegNr).getAftaleKM());

        if (kmVedIndlevering - kmVedAflevering > aftaleKM) {

            kmRegning = ((kmVedIndlevering - kmVedAflevering) - aftaleKM) * 0.75;

            regning = kmRegning + skadeRegning;



        } else {
            regning = skadeRegning;

        }

        System.out.println(regning);
    }
}
