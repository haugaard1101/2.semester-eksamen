package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.SOUService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

public class SOUController {

    SOUService souService = new SOUService();
    @GetMapping ("/SOU")
    public String asd () {
        return "SOURegNr";
    }


}
