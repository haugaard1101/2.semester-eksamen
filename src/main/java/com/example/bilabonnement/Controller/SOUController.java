package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.SOUService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

public class SOUController {

    SOUService souService = new SOUService();
    /*@PostMapping("/SOU")
    public String createWish(WebRequest request) {
        souService.beregnPrisSOU(request);
        return "SOU";
    }

    @PostMapping("/SOU")
    public String createWish(WebRequest request) {
        souService.beregnPrisSOU(request);
        return "SOU";
    }
    
     */


}
