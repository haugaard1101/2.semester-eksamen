package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Service.DataregistreringsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


// Mathias, Benjamin, Marcus, Kasper
@Controller
public class Dataregistreringscontroller {
  //Instantiering af dataregistreringsservice, så den kan kaldes op i controlleren
  DataregistreringsService dataregistreringsService = new DataregistreringsService();

  //Getmapping til fejlsiden for data specifikt
  // Mathias
  @GetMapping("/fejlsidedata")
  public String fejlsidedata() {
    return "dataregistrering/fejlsidedata";
  }
  //Benjamin, Marcus, Mathias
  //Getmapping til standard dataregistreringssiden
  @GetMapping("/dataregistrering")
  public String dataregistrering(Model model) {
   // model.addAttribute("ArrayMedLedigeBilersRegNr", metodeDerGiverArrayMedLedigeBilersRegNr();
    //lav en metode der kalder alle biler med 'LEDIG', og store deres regnr i et array
    //lav derefter et forloop, der tager hver af regnr, og lægger dem ind i dropdown-menuen så de bliver muligheder på hjemmesiden
    List<BilModel> ledigeBiler = dataregistreringsService.getAllLedigeBiler();
//    List<String> ledigeBilerRegNr = new ArrayList<>();
//    for (BilModel bil: ledigeBiler){
//      ledigeBilerRegNr.add(bil.getRegistreringsNummer());
//    }
//    System.out.println(ledigeBilerRegNr);
    model.addAttribute("BilListe", ledigeBiler);
    return "dataregistrering/dataregistrering";
  }

  //Mathias
  @GetMapping("/lejeaftalefundet")
  public String lejeaftalefundet() {
    return "dataregistrering/lejeaftalefundet";
  }

  //Mathias
  @GetMapping("/seogredigerlejeaftaler")
  public String seogredigerlejeaftaler() {
    return "dataregistrering/seogredigerlejeaftaler";
  }

  //Mathias
  @GetMapping("/opdaterlejeaftale")
  public String opdaterlejeaftale() {
    return "dataregistrering/opdaterlejeaftale";
  }

  @GetMapping("/lejeaftaleliste")
  public String lejeaftaleliste(Model model) {
    model.addAttribute("LejeAftale", dataregistreringsService.getAlleLejeAftaler());
    return "dataregistrering/lejeaftaleliste";
  }

  //Mathias
  @GetMapping("/updatesinglevalue")
  public String updatesinglevalue() {
    return "dataregistrering/updatesinglevalue";
  }

  // Mathias, Benjamin
  @PostMapping("/deleteLegeAftale")
  public String deleteLegeAftale(WebRequest request) {
    try {
      dataregistreringsService.deleteLejeAftale(request.getParameter("RegistreringsNummer"));
    } catch (Exception e) {
      return "redirect:fejlsidedata";
    }
    return "redirect:lejeaftaleliste";
  }

  // Mathias, Benjamin
  @PostMapping("/updatingsinglevalue")
  public String updatingsinglevalue(WebRequest request) {
    try {
      int x = Integer.parseInt(Objects.requireNonNull(request.getParameter("KmVedIndlevering")));
      dataregistreringsService.updateSingleValue(request.getParameter("RegistreringsNummer"), x);
    } catch (Exception e) {
      return "redirect:fejlsidedata";
    }
    return "dataregistrering/updatesinglevalue";
  }

  //Mathias, Benjamin
  @PostMapping("/lejeaftalefundet")
  public String findLejeaftale(WebRequest request, Model model) {
    try {
      model.addAttribute("LejeAftale", dataregistreringsService.getLejeAftaleById(request.getParameter("RegistreringsNummer")));
    } catch (Exception e) {
      return "redirect:fejlsidedata";
    }
    return "dataregistrering/lejeaftalefundet";
  }

  // Mathias, Benjamin
  @PostMapping("/lejeaftaleliste")
  public String sendlejekontrakt(WebRequest request, Model model) {
    try {
      dataregistreringsService.createLejeAftale(request);
      model.addAttribute("LejeAftale", dataregistreringsService.getAlleLejeAftaler());

    } catch (Exception e) {
      return "redirect:fejlsidedata";
    }
    return "dataregistrering/lejeaftaleliste";
  }

  // Mathias, Benjamin
 /* @PostMapping("/opdaterlejeaftale")
  public String opdaterlejeaftale(WebRequest request, Model model) {
    try {
      dataregistreringsService.createLejeAftale(request);
      model.addAttribute("LejeAftale", dataregistreringsService.getAlleLejeAftaler());
    } catch (Exception e) {
      return "redirect:fejlsidedata";
    }

    return "dataregistrering/opdaterlejeaftale";
  }*/

  // Benjamin
  @GetMapping("/seledigebiler")
  public String getAllLedigeBiler(Model model) {
    model.addAttribute("LedigeBiler", dataregistreringsService.getAllLedigeBiler());
    return "dataregistrering/seledigebiler";
  }


//  @RequestMapping(value = "/populateDropDownList", method = RequestMethod.GET)
//  public String populateList(Model model) {
//
//    return "dropDownList/dropDownList.html";
//  }

}