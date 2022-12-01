package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Repositories.ForretningsudviklerRepository;

import java.util.List;

public class ForretningsudviklerService {

  ForretningsudviklerRepository repo = new ForretningsudviklerRepository();

  public List<BilModel> getAllRentedCars(){
    return repo.getAllRentedCars();
  }
}
