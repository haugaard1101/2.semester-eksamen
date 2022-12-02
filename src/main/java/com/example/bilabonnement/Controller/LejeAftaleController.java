package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.LejeAftaleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;


@Controller
public class LejeAftaleController {


  LejeAftaleService lejeAftaleService = new LejeAftaleService();
  @GetMapping("/dataregistrering")
  public String dataregistrering(){
    return "dataregistrering/dataregistrering";
  }

  @PostMapping("/sendLejeKontrakt")
  public String sendlejekontrakt(WebRequest request){
    System.out.println(request.getParameter("Navn"));
    lejeAftaleService.createLejeAftale(request,"create");
    return "dataregistrering/dataregistrering";
  }
}
