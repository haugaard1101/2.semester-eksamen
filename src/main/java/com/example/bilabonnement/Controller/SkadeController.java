package com.example.bilabonnement.Controller;

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
    @GetMapping ("/findBil")
    public String SkadeRegNr () {
        return "SkadeRegNr";
    }


    @PostMapping("/findBil")
    public String skadeRegNr(HttpSession session){
        //skadeService.getLejeAftaleByRegNr(session);
        return "SkadeRegNr";
    }

    @GetMapping("/opretSkadeAngivelse")
    public String skadeAngivelse(){

    return "opretSkadeAngivelse";
    }


}
