package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.UdlejningsStatusEnum;
import com.example.bilabonnement.Service.BilService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;


@Controller
public class BilController {

  BilService bilService = new BilService();


    @GetMapping("/login")
  public String trylogin(){
    return "Login";
  }

  @GetMapping("/opdaterbilstatus")
  public String opdaterbilstatus(){
    return "biler/opdaterbilstatus";
  }
  @PostMapping("/opdatererbilstatus")
  public String opdatererbilstatus(WebRequest request){
      try{
        bilService.updateSingleValue(request.getParameter("RegistreringsNummer"), UdlejningsStatusEnum.valueOf(request.getParameter("UdlejningsStatus").toUpperCase()));
      }catch (Exception e){
        return "redirect:fejlside";
      }
    return "biler/opdaterbilstatus";
  }
}
