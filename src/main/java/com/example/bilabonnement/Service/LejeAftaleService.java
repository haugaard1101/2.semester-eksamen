package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Repositories.LejeAftaleRepository;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class LejeAftaleService {

  LejeAftaleRepository LejeAftaleRepo = new LejeAftaleRepository();

  public void createLejeAftale(WebRequest request,String command) {
    LejeAftaleModel lejeAftale = new LejeAftaleModel(
       // Integer.valueOf(request.getParameter("aftaleId")),
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



    LejeAftaleRepo.createLejeAftale(lejeAftale,command);
  }
  public List<LejeAftaleModel> getLejeAftaleById(int id){
    return LejeAftaleRepo.getLejeAftaleById(id);
  }
  public List<LejeAftaleModel> getAlleLejeAftaler(){
    return LejeAftaleRepo.getAlleLejeAftaler();
  }


}
