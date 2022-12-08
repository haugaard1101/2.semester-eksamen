package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.LejeAftaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;


@Controller
public class Dataregistreringscontroller {

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
  public String lejeaftaleliste(Model model){
    model.addAttribute("LejeAftale", lejeAftaleService.getAlleLejeAftaler());
    return "dataregistrering/lejeaftaleliste";
  }
  @GetMapping("/updatesinglevalue")
  public String updatesinglevalue(){
    return "dataregistrering/updatesinglevalue";
  }
  @PostMapping("/deleteLegeAftale")
  public String deleteLegeAftale(WebRequest request){
    try{
      lejeAftaleService.deleteLejeAftale(request.getParameter("RegistreringsNummer"));
    }catch (Exception e){
      return "redirect:fejlside";
    }
    return "redirect:/lejeaftaleliste";
  }
  @PostMapping("/updatingsinglevalue")
  public String updatingsinglevalue(WebRequest request){
    try{
      int x = Integer.parseInt(Objects.requireNonNull(request.getParameter("KmVedIndlevering")));
      lejeAftaleService.updateSingleValue(request.getParameter("RegistreringsNummer"),x);
    }catch (Exception e){
      return "redirect:fejlside";
    }
    return "dataregistrering/updatesinglevalue";
  }
  @PostMapping("/lejeaftalefundet")
  public String findLejeaftale(WebRequest request,Model model){
    try{
      model.addAttribute("LejeAftale", lejeAftaleService.getLejeAftaleById(request.getParameter("RegistreringsNummer")));
    }catch (Exception e){
      return "redirect:fejlside";
    }
    return "dataregistrering/lejeaftalefundet";
  }
  @PostMapping("/lejeaftaleliste")
  public String sendlejekontrakt(WebRequest request,Model model){
    try{
      lejeAftaleService.createLejeAftale(request,"create");
      model.addAttribute("LejeAftale", lejeAftaleService.getAlleLejeAftaler());

    }catch (Exception e){
      return "redirect:fejlside";
    }
    return "dataregistrering/lejeaftaleliste";
  }
  @PostMapping("/opdaterlejeaftale")
  public String opdaterlejeaftale(WebRequest request,Model model){
    try{
      lejeAftaleService.createLejeAftale(request,"");
      model.addAttribute("LejeAftale", lejeAftaleService.getAlleLejeAftaler());
    }catch (Exception e){
      return "redirect:fejlside";
    }

    return "dataregistrering/opdaterlejeaftale";
  }
}