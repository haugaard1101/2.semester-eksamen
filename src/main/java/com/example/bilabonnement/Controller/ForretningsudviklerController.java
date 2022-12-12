package com.example.bilabonnement.Controller;


import com.example.bilabonnement.Service.ForretningsudviklerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Benjamin
@Controller
public class ForretningsudviklerController {

    ForretningsudviklerService service = new ForretningsudviklerService();

    // GetMapping er en annotation der fungere som en gennemvej for en @RequestMethod.GET metode.
    // Den mapper HTTP GET requests til specifikke metoder nedenunder.

    // Denne metode henter først alle biler med udlejningsstatus 'AKTIV' og sender dem over til HTML filen med Model klassen.
    @GetMapping("/udlejedebiler")
    public String showRentedCars(Model model){
        model.addAttribute("RentedCars", service.getAllRentedCars());
        return "/forretningsudvikling/udlejedebiler";
    }

    // Denne metode henter antallet af udlejede biler med udlejningsstatus 'AKTIV',
    //  og samlede månedslige pris for disse biler, samt samlede CO2-udledning i g/km.
    @GetMapping("/KPI")
    public String showKPI(Model model) {
        int amountOfRentedCars = service.getAllRentedCars().size();
        model.addAttribute("AmountOfRentedCars", amountOfRentedCars);
        model.addAttribute("priceRentedCars", service.getPriceRentedCars());
        model.addAttribute("CO2OfRentedCars", service.getCO2RentedCars());
        return "/forretningsudvikling/kpi";
    }
}
