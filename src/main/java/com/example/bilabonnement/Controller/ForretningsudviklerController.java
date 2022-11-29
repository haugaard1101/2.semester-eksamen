package com.example.bilabonnement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForretningsudviklerController {

    @GetMapping("/forretningsudvikling")
    public String index(){
        return "/forretningsudvikling/forretningsudvikling";
    }

}
