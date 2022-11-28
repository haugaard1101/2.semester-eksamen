package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForretningsudviklerController {

    @GetMapping("/Forretningsudvikling")
    public String index(){
        return "Forretningsudvikling";
    }

}
