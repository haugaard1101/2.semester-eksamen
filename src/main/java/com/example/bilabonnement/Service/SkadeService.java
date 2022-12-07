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
  public LejeAftaleModel findEnLejekontrakt(String RegNr) {
    return skadeRepo.findEnLejekontrakt(RegNr);
  }

  //finder og viser en bil udfra RegNr
  public BilModel findEnBil(String RegNr) {
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
    public void createSkade(String RegNr, String aflæstKm, String lakfelt, String ridsetAlufælgerequest, String nyForrude) {
    skadeRepo.createSkade(RegNr, aflæstKm, lakfelt, ridsetAlufælgerequest, nyForrude);
    showBill(RegNr);

  }

  //udregner og viser hvad kunden skal betale
  public int showBill(String RegNr) {
    System.out.println("her tjekker vi om regnnr kommer med op i serivide" +RegNr);
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
    System.out.println("her printer vi fra showbill i service" + regning);
    return (int) regning;
  }

  public List<BilModel> getAllReturnedCars() {
    return skadeRepo.getAllReturnedCars();
  }
}
