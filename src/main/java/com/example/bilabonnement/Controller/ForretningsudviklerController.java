package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Service.ForretningsudviklerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ForretningsudviklerController {

    ForretningsudviklerService service = new ForretningsudviklerService();

    @GetMapping("/forretningsudvikling")
    public String showRentedCars(Model model){
        model.addAttribute("RentedCars", service.getAllRentedCars());
        return "/forretningsudvikling/forretningsudvikling";
    }

    @GetMapping("/KPI")
    public String showKPI(Model model) {
        int amountOfRentedCars = service.getAllRentedCars().size();
        model.addAttribute("AmountOfRentedCars", amountOfRentedCars);
        return "/forretningsudvikling/KPI";
    }



}
