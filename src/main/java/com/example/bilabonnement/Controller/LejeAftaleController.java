package com.example.bilabonnement.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LejeAftaleController {
  @GetMapping("/dataregistrering")
  public String dataregistrering(){
    return "dataregistrering";
  }
}
