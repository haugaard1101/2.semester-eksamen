package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Model.SkadeModel;
import com.example.bilabonnement.Repositories.SkadeRepository;

import java.util.Collection;
import java.util.List;

public class SkadeService {

    SkadeRepository skadeRepo = new SkadeRepository();

    //finder og viser en lejeaftale udfra RegNr
    public LejeAftaleModel findEnLejekontrakt(String RegNr) throws Exception {
        return skadeRepo.findEnLejekontrakt(RegNr);
    }

    //finder og viser en bil udfra RegNr
    public BilModel findEnBil(String RegNr) throws Exception {
        return skadeRepo.findEnBil(RegNr);
    }

    //viser alle skader
    public List<SkadeModel> getAllSkader() {
        return skadeRepo.getSkadeListe();
    }

    //sletter en skader udfra skadeID
    public void deleteSkade(int ID) {
        skadeRepo.deleteSkade(ID);
    }

    //oprette en skade og ændre KM ved indlevering på en bil og sætter bilen som skadet
    public void createSkade(String RegNr, String aflæstKm, String lakfelt, String ridsetAlufælgerequest, String nyForrude) throws Exception {
        skadeRepo.createSkade(RegNr, aflæstKm, lakfelt, ridsetAlufælgerequest, nyForrude);
        showBill(RegNr);

    }

    //udregner og viser hvad kunden skal betale
    public int showBill(String RegNr) throws Exception {
        System.out.println("her tjekker vi om regnnr kommer med op i service" + RegNr);
        double regning;

        if (kmVedIndlevering(RegNr) - kmVedAflevering(RegNr) > aftaleKM(RegNr)) {

            regning = kmRegning(RegNr) + skadeRegning(RegNr);

        } else {
            regning = skadeRegning(RegNr);
        }
        System.out.println("her printer vi fra showbill i service" + regning);
        return (int) regning;
    }

    public List<BilModel> getAllReturnedCars() {
        return skadeRepo.getAllReturnedCars();
    }


    public double kmVedIndlevering(String RegNr) {
        try {
            return Double.parseDouble(skadeRepo.findEnLejekontrakt(RegNr).getKmVedIndlevering());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double kmVedAflevering(String RegNr) {
        try {
            return Double.parseDouble(skadeRepo.findEnLejekontrakt(RegNr).getKmVedAfhentning());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double kmRegning(String RegNr) {

        return ((kmVedIndlevering(RegNr) - kmVedAflevering(RegNr)) - aftaleKM(RegNr)) * 0.75;
    }

    public double aftaleKM(String RegNr) {
        try {
            return Double.parseDouble(skadeRepo.findEnLejekontrakt(RegNr).getAftaleKM());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double skadeRegning(String RegNr) {
       return skadeRepo.getPriceOnSkader(RegNr);
    }



}