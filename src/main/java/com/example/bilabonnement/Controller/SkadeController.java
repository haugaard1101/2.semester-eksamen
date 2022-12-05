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

    @GetMapping ("/registrerskade")
    public String SkadeRegNr () {

        return "/skade/SkadeRegNr";
    }

    @PostMapping("/visLejekontrakt")
    public String showContract(WebRequest req, Model model, HttpSession session){
        LejeAftaleModel lejeaftale = skadeService.findEnLejekontrakt(req.getParameter("RegNr"));
        BilModel bil = skadeService.findEnBil(req.getParameter("RegNr"));
        String RegNr = bil.getRegistreringsNummer();

        session.setAttribute("420",RegNr);
        model.addAttribute("lejeAftale",lejeaftale);
        model.addAttribute("Bil",bil);
        return "/skade/registrerSkade";
    }

    @GetMapping("/opretSkadeAngivelse")
    public String skadeAngivelse(){
    return "/skade/opretSkadeAngivelse";
    }

    @GetMapping("/skadeliste")
    public String visSkadeListe(Model model) {
        model.addAttribute("SkadeListe", skadeService.getAllSkader());
        System.out.println(skadeService.getAllSkader());
        return "/skade/seOgRedigerSkader";
    }


    @PostMapping("/skadeliste")
    public String deleteSkade(WebRequest request) {
        int x = Integer.parseInt(request.getParameter("SkadeID"));
        skadeService.deleteSkade(x);
        return "/skade/seOgRedigerSkader";
    }




    @PostMapping("/registrerSkade")
    public String registrerSkade(HttpSession session,WebRequest request){
       String asd = (String) session.getAttribute("420");
        //Skade skade = skadeService.opretEnSkade(req.getParameter("AflæstKM"), req.getParameter("Lakfelt"), req.getParameter("RidsetAlu", req.getParameter("NyForrude")))

        System.out.println(asd);
        return "/skade/seOgRedigerSkader";
    }
}
