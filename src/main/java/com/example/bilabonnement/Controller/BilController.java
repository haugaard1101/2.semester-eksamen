package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.UdlejningsStatusEnum;
import com.example.bilabonnement.Service.BilService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;


// Marcus, Mathias
@Controller
public class BilController {
//Instantiering af bilservice, så den kan kaldes op i controlleren
  BilService bilService = new BilService();
//Getmapping til fejlside for biler specifikt
  @GetMapping("/fejlsidebil")
  public String fejlsidebil(){
    return "biler/fejlsidebil";
  }
//Getmapping til login siden
  // Marcus
    @GetMapping("/login")
  public String trylogin(){
    return "Login";
  }
//Getmapping til selve bilstatussiden
  // Mathias
  @GetMapping("/opdaterbilstatus")
  public String opdaterbilstatus(){
    return "biler/opdaterbilstatus";
  }
  //Postmapping det kalder på metoden til at opdatere en bils udlejningsstatus
  //Postmapping har try catch til at redirect til en fejl-informationsside, hvis en error eller exception skulle ske
  // Mathias
  @PostMapping("/opdatererbilstatus")
  public String opdatererbilstatus(WebRequest request){
      try{
        bilService.updateSingleValue(request.getParameter("RegistreringsNummer"), UdlejningsStatusEnum.valueOf(request.getParameter("UdlejningsStatus").toUpperCase()));
      }catch (Exception e){
        return "redirect:fejlsidebil";
      }
    return "biler/opdaterbilstatus";
  }

  //Metode der kaldes for at automatisk opdaterer bilens udlejningsstatus til AKTIV
  // Mathias
  @PostMapping("/opdatererautobilstatus")
  public String opdatererautobilstatus(WebRequest request){
    try {
      bilService.updateUpdateUdlejningsStatus(request.getParameter("RegistreringsNummer"));
    } catch (Exception e){
      return "redirect:fejlsidebil";
    }
    return "biler/opdatererautobilstatus";
  }
}
