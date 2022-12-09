package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Repositories.ForretningsudviklerRepository;

import java.util.List;

public class ForretningsudviklerService {

  ForretningsudviklerRepository repo = new ForretningsudviklerRepository();

  public List<BilModel> getAllRentedCars(){
    return repo.getAllRentedCars();
  }

  public int getPriceRentedCars(){
    return repo.getPriceOfAllRentedCars();
  }

  public String maerke(String RegNr){
    try {
      return repo.findEnBil(RegNr).getMaerke();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public String model(String RegNr){
    try {
      return repo.findEnBil(RegNr).getModel();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int getCO2RentedCars(){
    return repo.getCO2OfAllRentedCars();
  }
}
