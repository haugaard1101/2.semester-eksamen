package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Repositories.ForretningsudviklerRepository;

import java.util.List;

//Benjamin
public class ForretningsudviklerService {

  ForretningsudviklerRepository repo = new ForretningsudviklerRepository();

  //Benjamin
  // Her går vi ned i repo og henter alle biler med 'AKTIV'
  public List<BilModel> getAllRentedCars(){
    return repo.getAllRentedCars();
  }
  //Benjamin
  // Her går vi ned i repo og henter alle bilers samlede pris pr måned
  public int getPriceRentedCars(){
    return repo.getPriceOfAllRentedCars();
  }
  //Benjamin
  // Her går vi ned i repo og henter alle bilers samlede CO2 udledning i g/km
  public int getCO2RentedCars(){
    return repo.getCO2OfAllRentedCars();
  }
}
