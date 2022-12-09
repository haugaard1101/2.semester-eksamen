package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Service.DataregistreringsService;
import com.example.bilabonnement.Service.ForretningsudviklerService;
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
    ForretningsudviklerService forretningsudviklerService = new ForretningsudviklerService();

    //viser fejlside til fejlsideskade.html
    @GetMapping("/fejlsideskade")
    public String fejlsideskade() {
        return "skade/fejlsideskade";
    }


    //viser siden til indtastRegNr.html
    @GetMapping("/indtastregistreringsnummer")
    public String SkadeRegNr() {
        return "/skade/indtastRegNr";
    }

    //viser siden til seOgRedigerSkader.html
    @GetMapping("/skadeliste")
    public String visSkadeListe(Model model) {
        model.addAttribute("SkadeListe", skadeService.getAllSkader());
        return "/skade/seOgRedigerSkader";
    }

    //postmapping til indtastRegNr.html
    @PostMapping("/registrerskade")
    public String showContract(WebRequest req, Model model, HttpSession session) {
        try {
            LejeAftaleModel lejeaftale = skadeService.findEnLejekontrakt(req.getParameter("RegNr"));
            BilModel bil = skadeService.findEnBil(req.getParameter("RegNr"));
            String RegNr = bil.getRegistreringsNummer();

            session.setAttribute("registreringsnummerPåBil", RegNr);
            model.addAttribute("lejeAftale", lejeaftale);
            model.addAttribute("Bil", bil);
        } catch (Exception e) {
            System.out.println("wtf controller");
            return "redirect:fejlsideskade";
        }
        return "/skade/registrerskade";
    }

    //postmapping til visregning.html
    @PostMapping("/registrerskade2")
    public String registrerSkade(HttpSession session, WebRequest request, Model model) {
        try {
            String RegNr = (String) session.getAttribute("registreringsnummerPåBil");
            String aflæstKm = request.getParameter("KmVedIndlevering");
            String lakfelt = request.getParameter("Lakfelt");
            String ridsetAlufælgerequest = request.getParameter("Ridset alufælge");
            String nyForrude = request.getParameter("Ny forrude");


            //----------------------------

            //Regning Attributter bliver sendt videre til html-filen
            model.addAttribute("regning", skadeService.showBill(RegNr));
            model.addAttribute("kmVedIndlevering", skadeService.kmVedIndlevering(RegNr));
            model.addAttribute("kmVedAflevering", skadeService.kmVedAflevering(RegNr));
            model.addAttribute("kmRegning", skadeService.kmRegning(RegNr));
            model.addAttribute("aftaleKM", skadeService.aftaleKM(RegNr));
            model.addAttribute("skadeRegning", skadeService.skadeRegning(RegNr));
            model.addAttribute("RegNr", RegNr);
            model.addAttribute("Adresse", skadeService.adresse(RegNr));
            model.addAttribute("Email", skadeService.email(RegNr));
            model.addAttribute("Maerke", forretningsudviklerService.maerke(RegNr));
            model.addAttribute("Model", forretningsudviklerService.model(RegNr));
            model.addAttribute("lejeAftaleNavn", skadeService.findEnLejekontrakt(RegNr).getNavn());
            System.out.println("kmVedIndlevering i controller = " + skadeService.kmVedIndlevering(RegNr));

            skadeService.createSkade(RegNr, aflæstKm, lakfelt, ridsetAlufælgerequest, nyForrude);
            model.addAttribute("regning", skadeService.showBill(RegNr));
        } catch (Exception e) {
            return "redirect:fejlsideskade";
        }

        return "/skade/visregning";
    }

    //viser siden til visregning.html
    @GetMapping("/visregning")
    public String showBill(HttpSession session, Model model) {
        try {
            String RegNr = (String) session.getAttribute("registreringsnummerPåBil");
            model.addAttribute("regning", skadeService.showBill(RegNr));
            model.addAttribute("kmVedIndlevering", skadeService.kmVedIndlevering(RegNr));
            model.addAttribute("kmVedAflevering", skadeService.kmVedAflevering(RegNr));
            model.addAttribute("kmRegning", skadeService.kmRegning(RegNr));
            model.addAttribute("aftaleKM", skadeService.aftaleKM(RegNr));
            model.addAttribute("skadeRegning", skadeService.skadeRegning(RegNr));

            model.addAttribute("RegNr", RegNr);
            model.addAttribute("lejeAftaleNavn", skadeService.findEnLejekontrakt(RegNr).getNavn());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "/skade/visregning";
    }

    //postmapping til seOgRedigerSkader.html
    @PostMapping("/sletskade")
    public String deleteSkade(WebRequest request) {
        try {
            int x = Integer.parseInt(request.getParameter("SkadeID"));
            skadeService.deleteSkade(x);
        } catch (Exception e) {
            return "redirect:fejlsideskade";
        }
        System.out.println("skadeliste wtf");
        return "redirect:/skadeliste";
    }


}
