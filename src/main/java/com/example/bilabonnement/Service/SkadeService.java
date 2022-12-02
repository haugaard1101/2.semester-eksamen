package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Model.SkadeModel;
import com.example.bilabonnement.Repositories.SkadeRepository;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public class SkadeService {

    SkadeRepository skadeRepo = new SkadeRepository();

    public LejeAftaleModel findEnLejekontrakt(String RegNr){
        return skadeRepo.findEnLejekontrakt(RegNr);
    }
    public BilModel findEnBil(String RegNr){
        return skadeRepo.findEnBil(RegNr);
    }

    public List<SkadeModel> getAllSkader() {
        return skadeRepo.getSkadeListe();
    }

    public void deleteSkade(int ID){
        skadeRepo.deleteSkade(ID);
    }

    public void createSkade(WebRequest payload) {
        SkadeModel skade = new SkadeModel(
            payload.getParameter("RegistreringsNummer"),
            payload.getParameter("SkadeNavn"),
            payload.getParameter("SkadePris")
        );
        skadeRepo.createSkade(skade);
    }
}
