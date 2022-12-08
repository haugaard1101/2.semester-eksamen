package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.DataregistreringsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;


@Controller
public class Dataregistreringscontroller {
//Instantiering af dataregistreringsservice, så den kan kaldes op i controlleren
  DataregistreringsService dataregistreringsService = new DataregistreringsService();
//Getmapping til fejlsiden for data specifikt
  @GetMapping("/fejlsidedata")
  public String fejlsidedata(){
    return "dataregistrering/fejlsidedata";
  }
  //Getmapping til standard dataregistreringssiden
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
    model.addAttribute("LejeAftale", dataregistreringsService.getAlleLejeAftaler());
    return "dataregistrering/lejeaftaleliste";
  }
  @GetMapping("/updatesinglevalue")
  public String updatesinglevalue(){
    return "dataregistrering/updatesinglevalue";
  }
  @PostMapping("/deleteLegeAftale")
  public String deleteLegeAftale(WebRequest request){
    try{
      dataregistreringsService.deleteLejeAftale(request.getParameter("RegistreringsNummer"));
    }catch (Exception e){
      return "redirect:fejlsidedata";
    }
    return "redirect:lejeaftaleliste";
  }
  @PostMapping("/updatingsinglevalue")
  public String updatingsinglevalue(WebRequest request){
    try{
      int x = Integer.parseInt(Objects.requireNonNull(request.getParameter("KmVedIndlevering")));
      dataregistreringsService.updateSingleValue(request.getParameter("RegistreringsNummer"),x);
    }catch (Exception e){
      return "redirect:fejlsidedata";
    }
    return "dataregistrering/updatesinglevalue";
  }

  @PostMapping("/lejeaftalefundet")
  public String findLejeaftale(WebRequest request,Model model){
    try{
      model.addAttribute("LejeAftale", dataregistreringsService.getLejeAftaleById(request.getParameter("RegistreringsNummer")));
    }catch (Exception e){
      return "redirect:fejlsidedata";
    }
    return "dataregistrering/lejeaftalefundet";
  }
  @PostMapping("/lejeaftaleliste")
  public String sendlejekontrakt(WebRequest request,Model model){
    try{
      dataregistreringsService.createLejeAftale(request,"create");
      model.addAttribute("LejeAftale", dataregistreringsService.getAlleLejeAftaler());

    }catch (Exception e){
      return "redirect:fejlsidedata";
    }
    return "dataregistrering/lejeaftaleliste";
  }
  @PostMapping("/opdaterlejeaftale")
  public String opdaterlejeaftale(WebRequest request,Model model){
    try{
      dataregistreringsService.createLejeAftale(request,"");
      model.addAttribute("LejeAftale", dataregistreringsService.getAlleLejeAftaler());
    }catch (Exception e){
      return "redirect:fejlsidedata";
    }

    return "dataregistrering/opdaterlejeaftale";
  }

//  @GetMapping("/seledigebiler")
//  public String showRentedCars(Model model){
//    model.addAttribute("RentedCars", service.getAllRentedCars());
//    model.addAttribute("amountOfCars", service.getAllRentedCars().size());
//    return "/forretningsudvikling/forretningsudvikling";
//  }
}