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
        Integer.parseInt(request.getParameter("Postnummer")),
        request.getParameter("Kommune"),
        Integer.parseInt(request.getParameter("TelefonNr")),
        request.getParameter("cpr"),
        request.getParameter("eMail"),
        request.getParameter("LejeperiodeFra"),
        request.getParameter("LejeperiodeTil"),
        request.getParameter("AntalMaaneder"),
        request.getParameter("afhentningssted"),
        request.getParameter("afleveringssted"),
        Integer.parseInt((request.getParameter("kmVedAfhentning"))),
        Integer.parseInt((request.getParameter("AftaleKM"))),
        Integer.parseInt((request.getParameter("KmVedIndlevering"))),
        request.getParameter("registreringsNummer"));

    LejeAftaleRepo.createLejeAftale(lejeAftale,command);
  }
  public List<LejeAftaleModel> getLejeAftaleById(int id){
    return LejeAftaleRepo.getLejeAftaleById(id);
  }
  public List<LejeAftaleModel> getAlleLejeAftaler(){
    return LejeAftaleRepo.getAlleLejeAftaler();
  }


}
