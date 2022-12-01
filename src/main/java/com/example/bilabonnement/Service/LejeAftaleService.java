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
        request.getParameter("Navn"),
        request.getParameter("Adresse"),
        Integer.parseInt(Objects.requireNonNull(request.getParameter("Postnummer"))),
        request.getParameter("Kommune"),
        Integer.parseInt(Objects.requireNonNull(request.getParameter("TelefonNr"))),
        request.getParameter("cpr"),
        request.getParameter("eMail"),
        Date.valueOf(Objects.requireNonNull(request.getParameter("lejeperiodeFra"))),
        Date.valueOf(Objects.requireNonNull(request.getParameter("lejeperiodeTil"))),
        Integer.parseInt(Objects.requireNonNull(request.getParameter("antalMåneder"))),
        request.getParameter("afhentningssted"),
        request.getParameter("afleveringssted"),
        Integer.parseInt(Objects.requireNonNull(request.getParameter("kmVedAfhentning"))),
        Integer.parseInt(Objects.requireNonNull(request.getParameter("aftaleId"))),
        Integer.parseInt(Objects.requireNonNull(request.getParameter("maxKilometer"))),
        Integer.parseInt(Objects.requireNonNull(request.getParameter("aktueltKørteKilometer"))),
        Integer.parseInt(Objects.requireNonNull(request.getParameter("registreringsNummer"))));
    LejeAftaleRepo.createLejeAftale(lejeAftale,command);
  }
  public List<LejeAftaleModel> getLejeAftaleById(int id){
    return LejeAftaleRepo.getLejeAftaleById(id);
  }
  public List<LejeAftaleModel> getAlleLejeAftaler(){
    return LejeAftaleRepo.getAlleLejeAftaler();
  }


}
