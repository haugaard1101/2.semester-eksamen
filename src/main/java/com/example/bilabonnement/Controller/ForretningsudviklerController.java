package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Service.ForretningsudviklerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ForretningsudviklerController {

    ForretningsudviklerService service = new ForretningsudviklerService();

    @GetMapping("/forretningsudvikling")
    public List<BilModel> index(){
        return  service.getAll

        return "/forretningsudvikling/forretningsudvikling";
    }

}
