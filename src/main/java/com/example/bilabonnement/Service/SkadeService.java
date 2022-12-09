package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Model.SkadeModel;
import com.example.bilabonnement.Repositories.SkadeRepository;

import java.util.List;

public class SkadeService {

    SkadeRepository skadeRepo = new SkadeRepository();

    //retunerer og viser en lejeaftale udfra RegNr
    public LejeAftaleModel findEnLejekontrakt(String RegNr) throws Exception {
        return skadeRepo.findEnLejekontrakt(RegNr);
    }

    //retunerer og viser en bil udfra RegNr
    public BilModel findEnBil(String RegNr) throws Exception {
        return skadeRepo.findEnBil(RegNr);
    }

    //retunerer alle skader fra databasen
    public List<SkadeModel> getAllSkader() {
        return skadeRepo.getSkadeListe();
    }

    /*
    // retunerer alle 'Afleveret biler' fra databasen
    public List<BilModel> getAllReturnedCars() {
        return skadeRepo.getAllReturnedCars();
    }
    */

    //sletter en skader udfra skadeID
    public void deleteSkade(int ID) {
        skadeRepo.deleteSkade(ID);
    }

    //opretter en skade og ændre KM ved indlevering på en bil og sætter bilen som skadet
    public void createSkade(String RegNr, String aflæstKm, String lakfelt, String ridsetAlufælgerequest, String nyForrude) throws Exception {
        skadeRepo.createSkade(RegNr, aflæstKm, lakfelt, ridsetAlufælgerequest, nyForrude);
        showBill(RegNr);

    }

    //udregner og retunerer hvad kunden skal betale
    public int showBill(String RegNr) {
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

    //retunerer KM ved indlevering
    public double kmVedIndlevering(String RegNr) {
        try {
            return Double.parseDouble(skadeRepo.findEnLejekontrakt(RegNr).getKmVedIndlevering());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //retunerer KM ved aflevering
    public double kmVedAflevering(String RegNr) {
        try {
            return Double.parseDouble(skadeRepo.findEnLejekontrakt(RegNr).getKmVedAfhentning());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //retunerer prisen på overkørte KM
    public double kmRegning(String RegNr) {
        if (kmVedIndlevering(RegNr) - kmVedAflevering(RegNr) > aftaleKM(RegNr)) {
            return ((kmVedIndlevering(RegNr) - kmVedAflevering(RegNr)) - aftaleKM(RegNr)) * 0.75;
        } else return 0;
    }

    //retunerer aftalte KM
    public double aftaleKM(String RegNr) {
        try {
            return Double.parseDouble(skadeRepo.findEnLejekontrakt(RegNr).getAftaleKM());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String adresse(String RegNr) {
        try {
            return findEnLejekontrakt(RegNr).getAdresse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String email(String RegNr) {
        try {
            return findEnLejekontrakt(RegNr).getEmail();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //retunerer prisen på skader
    public double skadeRegning(String RegNr) {
        return skadeRepo.getPriceOnSkader(RegNr);
    }

}