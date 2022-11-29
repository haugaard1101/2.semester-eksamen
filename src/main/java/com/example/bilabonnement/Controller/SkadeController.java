package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.SkadeService;
import org.springframework.web.bind.annotation.GetMapping;

public class SkadeController {

    SkadeService souService = new SkadeService();
    @GetMapping ("/Skade")
    public String asd () {
        return "SkadeRegNr";
    }


}
