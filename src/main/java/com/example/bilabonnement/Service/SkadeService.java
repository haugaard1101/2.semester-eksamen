package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Model.SkadeModel;
import com.example.bilabonnement.Repositories.SkadeRepository;

import java.util.List;

public class SkadeService {

    SkadeRepository skadeRepo = new SkadeRepository();
    //Kasper
    //retunerer og viser en lejeaftale udfra RegNr
    public LejeAftaleModel getLejeaftale(String RegNr) {
        return skadeRepo.getLejeaftale(RegNr);
    }
    //Kasper
    //retunerer og viser en bil udfra RegNr
    public BilModel getBil(String RegNr) {
        return skadeRepo.getBil(RegNr);
    }
    //Kasper
    //retunerer alle skader fra databasen
    public List<SkadeModel> getAllSkader() {
        return skadeRepo.getSkadeList();
    }
    /*
    //Kasper
    // retunerer alle 'Afleveret biler' fra databasen
    public List<BilModel> getAllReturnedCars() {
        return skadeRepo.getAllReturnedCars();
    }
    */
    //Kasper
    //sletter en skade udfra skadeID, derefter sætter den automatisk bilens status til 'Ledig', hvis det var den sidste skade på bilen
    public void deleteSkade(int ID) {
        skadeRepo.deleteSkade(ID);
    }
    //Kasper
    //opretter en skade og ændre KM ved indlevering på en bil og sætter bilen som skadet
    public void createSkade(String RegNr, String aflæstKm, String lakfelt, String ridsetAlufælgerequest, String nyForrude) {
        skadeRepo.createSkade(RegNr, aflæstKm, lakfelt, ridsetAlufælgerequest, nyForrude);
        showBill(RegNr);
    }
    //Kasper, Marcus
    //udregner og retunerer hvad kunden skal betale
    public double showBill(String RegNr) {
        double regning;

        if (kmVedIndlevering(RegNr) - kmVedAflevering(RegNr) > aftaleKM(RegNr)) {

            regning = kmRegning(RegNr) + skadeRegning(RegNr);

        } else {
            regning = skadeRegning(RegNr);
        }
        return regning;
    }
    //Kasper
    //retunerer KM ved indlevering
    public double kmVedIndlevering(String RegNr) {
        try {
            return Double.parseDouble(skadeRepo.getLejeaftale(RegNr).getKmVedIndlevering());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Kasper
    //retunerer KM ved aflevering
    public double kmVedAflevering(String RegNr) {
        try {
            return Double.parseDouble(skadeRepo.getLejeaftale(RegNr).getKmVedAfhentning());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Kasper
    //retunerer prisen på overkørte KM, og sætter prisen til 0, hvis aftalte KM ikke er overskredet
    public double kmRegning(String RegNr) {
        if (kmVedIndlevering(RegNr) - kmVedAflevering(RegNr) > aftaleKM(RegNr)) {
            return ((kmVedIndlevering(RegNr) - kmVedAflevering(RegNr)) - aftaleKM(RegNr)) * 0.75;
        } else return 0;
    }
    //Kasper
    //retunerer aftalte KM
    public double aftaleKM(String RegNr) {
        try {
            return Double.parseDouble(skadeRepo.getLejeaftale(RegNr).getAftaleKM());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Kasper
    //retunerer adresse udfra RegNr
    public String adresse(String RegNr) {
        try {
            return getLejeaftale(RegNr).getAdresse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Kasper
    //retunerer email udfra RegNr
    public String email(String RegNr) {
        try {
            return getLejeaftale(RegNr).getEmail();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Kasper
    //retunerer prisen på skader
    public double skadeRegning(String RegNr) {
        return skadeRepo.getPriceOnSkader(RegNr);
    }

    public String maerke(String RegNr){
        try {
            return skadeRepo.FindACar(RegNr).getMaerke();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String model(String RegNr){
        try {
            return skadeRepo.FindACar(RegNr).getModel();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}