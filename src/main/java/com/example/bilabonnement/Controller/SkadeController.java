package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Service.SkadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;


@Controller
public class SkadeController {

  SkadeService skadeService = new SkadeService();

  //viser siden til indtastRegNr.html
  @GetMapping("/indtastregistreringsnummer")
  public String SkadeRegNr() {

    return "/skade/indtastRegNr";
  }

  //postmapping til indtastRegNr.html
  @PostMapping("/registrerskade")
  public String showContract(WebRequest req, Model model, HttpSession session) {
    LejeAftaleModel lejeaftale = skadeService.findEnLejekontrakt(req.getParameter("RegNr"));
    BilModel bil = skadeService.findEnBil(req.getParameter("RegNr"));
    String RegNr = bil.getRegistreringsNummer();

    session.setAttribute("registreringsnummerPåBil", RegNr);
    model.addAttribute("lejeAftale", lejeaftale);
    model.addAttribute("Bil", bil);

    return "/skade/registrerskade";
  }

  //postmapping til registrerskade.html
  @PostMapping("/registrerskade2")
  public String registrerSkade(HttpSession session, WebRequest request, Model model) {
    String RegNr = (String) session.getAttribute("registreringsnummerPåBil");
    String aflæstKm = request.getParameter("KmVedIndlevering");
    String lakfelt = request.getParameter("Lakfelt");
    String ridsetAlufælgerequest = request.getParameter("Ridset alufælge");
    String nyForrude = request.getParameter("Ny forrude");
    skadeService.createSkade(RegNr, aflæstKm, lakfelt, ridsetAlufælgerequest, nyForrude);
    model.addAttribute("regning", skadeService.showBill(RegNr));

    return "/skade/visregning";
  }

  //viser siden til visregning.html
  @GetMapping("/visregning")
  public String showBill(HttpSession session, Model model) {
    String RegNr = (String) session.getAttribute("registreringsnummerPåBil");
    System.out.println("her tjekker vi i controlleren" +  RegNr );
    System.out.println("helloooo" + skadeService.showBill(RegNr));
    model.addAttribute("regning", skadeService.showBill(RegNr));
    System.out.println("hello" );
    return "/skade/visregning";
  }

  //viser siden til seOgRedigerSkader.html
  @GetMapping("/skadeliste")
  public String visSkadeListe(Model model) {
    model.addAttribute("SkadeListe", skadeService.getAllSkader());
    return "/skade/seOgRedigerSkader";
  }

//postmapping til seOgRedigerSkader.html
  @PostMapping("/sletskade")
  public String deleteSkade(WebRequest request) {
    int x = Integer.parseInt(request.getParameter("SkadeID"));
    skadeService.deleteSkade(x);
    return "redirect:/skadeliste";
  }


}
