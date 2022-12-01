package com.example.bilabonnement.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

public class LejeAftaleController {
  @GetMapping("/Dataregistrering")
  public String index(){
    return "Random";
  }
}
