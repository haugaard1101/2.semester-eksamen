package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.LejeAftaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  @GetMapping("/lejeaftalefundet")
  public String lejeaftalefundet(){
    return "dataregistrering/lejeaftalefundet";
  }
  @GetMapping("/seogredigerlejeaftaler")
  public String seogredigerlejeaftaler(){
    return "dataregistrering/seogredigerlejeaftaler";
  }
  @GetMapping("/opdaterlejeaftale")
  public String opdaterlejeaftale(){
    return "dataregistrering/opdaterlejeaftale";
  }
  @GetMapping("/lejeaftaleliste")
  public String lejeaftaleliste(){
    return "dataregistrering/lejeaftaleliste";
  }
  @PostMapping("/lejeaftalefundet")
  public String findLejeaftale(WebRequest request,Model model){
    model.addAttribute("LejeAftale", lejeAftaleService.getLejeAftaleById(request.getParameter("RegistreringsNummer")));
    return "dataregistrering/lejeaftalefundet";
  }
  @PostMapping("/deleteLegeAftale")
  public String deleteLegeAftale(WebRequest request){
    lejeAftaleService.deleteLejeAftale(request.getParameter("RegistreringsNummer"));
    return "dataregistrering/seogredigerlejeaftaler";
  }

  @PostMapping("/lejeaftaleliste")
  public String sendlejekontrakt(WebRequest request,Model model){
    lejeAftaleService.createLejeAftale(request,"create");
    model.addAttribute("LejeAftale", lejeAftaleService.getAlleLejeAftaler());
    return "dataregistrering/lejeaftaleliste";
  }
  @PostMapping("/opdaterlejeaftale")
  public String opdaterlejeaftale(WebRequest request,Model model){
    lejeAftaleService.createLejeAftale(request,"");
    model.addAttribute("LejeAftale", lejeAftaleService.getAlleLejeAftaler());
    return "dataregistrering/opdaterlejeaftale";
  }
}
