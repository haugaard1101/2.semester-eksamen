package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.BilModel;
import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Model.SkadeModel;
import com.example.bilabonnement.Repositories.SkadeRepository;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.List;

public class SkadeService {

    SkadeRepository skadeRepo = new SkadeRepository();

    public LejeAftaleModel findEnLejekontrakt(String RegNr){
        return skadeRepo.findEnLejekontrakt(RegNr);
    }

    public List<SkadeModel> getAllSkader() {
        return skadeRepo.getSkadeListe();
    }
}
