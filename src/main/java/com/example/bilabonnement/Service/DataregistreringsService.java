package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Repositories.DataregistreringsRepository;
import org.springframework.web.context.request.WebRequest;

import java.util.List;


// Mathias, Benjamin, Marcus
public class DataregistreringsService {

  DataregistreringsRepository LejeAftaleRepo = new DataregistreringsRepository();


  // Mathias
  public String updateSingleValue(String registreringsnummer, int kmVedIndlevering){
     LejeAftaleRepo.updateSingleValue(registreringsnummer, kmVedIndlevering);
     return registreringsnummer;
  }

  // Mathias, Marcus
  public void createLejeAftale(WebRequest request) {
    LejeAftaleModel lejeAftale = new LejeAftaleModel(
        request.getParameter("Navn"),
        request.getParameter("Adresse"),
        request.getParameter("Postnummer"),
        request.getParameter("Kommune"),
        request.getParameter("TelefonNr"),
        request.getParameter("CPR"),
        request.getParameter("Email"),
        request.getParameter("LejeperiodeFra"),
        request.getParameter("LejeperiodeTil"),
        request.getParameter("AntalMaaneder"),
        request.getParameter("Afhentningssted"),
        request.getParameter("Afleveringssted"),
        request.getParameter("KmVedAfhentning"),
        request.getParameter("AftaleKM"),
        request.getParameter("KmVedIndlevering"),
        request.getParameter("RegistreringsNummer"));

    LejeAftaleRepo.createLejeAftale(lejeAftale);
  }

  //Mathias
  public List<LejeAftaleModel> getLejeAftaleById(String registreringsnummer){
    return LejeAftaleRepo.getLejeAftaleById(registreringsnummer);
  }

  // Mathias
  public List<LejeAftaleModel> getAlleLejeAftaler(){
    return LejeAftaleRepo.getAlleLejeAftaler();
  }

  // Mathias
  public void deleteLejeAftale(String registreringnummer){
      LejeAftaleRepo.deleteLejeAftaleListe(registreringnummer);
  }

  // Benjamin
  public List<BilModel> getAllLedigeBiler(){
    return LejeAftaleRepo.getAllLedigeBiler();
  }




}
