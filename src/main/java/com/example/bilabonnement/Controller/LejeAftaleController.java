package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.LejeAftaleModel;
import com.example.bilabonnement.Service.LejeAftaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Objects;


@Controller
public class LejeAftaleController {

  LejeAftaleService lejeAftaleService = new LejeAftaleService();


  @GetMapping("/dataregistrering")
  public String dataregistrering(){
    return "dataregistrering/dataregistrering";
  }
  @GetMapping("/lejeaftalefundet")
  public String lejeaftalefundet(){
    return "dataregistrering/lejeaftalefundet";
  }
  @GetMapping("/seogredigerlejeaftaler")
  public String seogredigerlejeaftaler(){
    return "dataregistrering/seogredigerlejeaftaler";
  }
  @PostMapping("/deleteLegeAftale")
  public String deleteLegeAftale(WebRequest request){
    lejeAftaleService.deleteLejeAftale(request.getParameter("RegistreringsNummer"));
    return "dataregistrering/seogredigerlejeaftaler";
  }
  @GetMapping("/opdaterlejeaftale")
  public String opdaterlejeaftale(){
    return "dataregistrering/opdaterlejeaftale";
  }
  @GetMapping("/lejeaftaleliste")
  public String lejeaftaleliste(Model model){
    model.addAttribute("LejeAftale", lejeAftaleService.getAlleLejeAftaler());
    return "dataregistrering/lejeaftaleliste";
  }
  @GetMapping("/updatesinglevalue")
  public String updatesinglevalue(){
    return "dataregistrering/updatesinglevalue";
  }
  @PostMapping("/updatingsinglevalue")
  public String updatingsinglevalue(WebRequest request){
    int x = Integer.parseInt(Objects.requireNonNull(request.getParameter("KmVedIndlevering")));
    lejeAftaleService.updateSingleValue(request.getParameter("RegistreringsNummer"),x);
    return "dataregistrering/updatesinglevalue";
  }
  @PostMapping("/lejeaftalefundet")
  public String findLejeaftale(WebRequest request,Model model){
    model.addAttribute("LejeAftale", lejeAftaleService.getLejeAftaleById(request.getParameter("RegistreringsNummer")));
    return "dataregistrering/lejeaftalefundet";
  }


  @PostMapping("/lejeaftaleliste")
  public String sendlejekontrakt(WebRequest request,Model model){
    lejeAftaleService.createLejeAftale(request,"create");
    model.addAttribute("LejeAftale", lejeAftaleService.getAlleLejeAftaler());
    return "dataregistrering/lejeaftaleliste";
  }
  @PostMapping("/opdaterlejeaftale")
  public String opdaterlejeaftale(WebRequest request,Model model){
    lejeAftaleService.createLejeAftale(request,"");
    //List<LejeAftaleModel> s1 = lejeAftaleService.getAlleLejeAftaler();
    model.addAttribute("LejeAftale", lejeAftaleService.getAlleLejeAftaler());
    //model.addAttribute("aftaleID", s1.get(0).)
    return "dataregistrering/opdaterlejeaftale";
  }
}
/*
  public void updateSingle(Object param, String columnName, String columnCondition, String updateTo) {

    String VIN = (String) param;

    String QUARY_GAS = "UPDATE data.gascar SET "+ columnName + " = '" + updateTo + "' where "+ columnCondition + " =?";

    try {
      PreparedStatement ptst = conn.prepareStatement(QUARY_GAS);

      ptst.setString(1,VIN);
      ptst.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    String QUARY_ELECTRIC = "UPDATE data.electriccar SET "+ columnName + " = '" + updateTo + "' where "+ columnCondition + " =?";

    try {
      PreparedStatement ptst = conn.prepareStatement(QUARY_ELECTRIC);

      ptst.setString(1,VIN);
      ptst.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

public void updateUser(User user, WebRequest req){

        try {
            PreparedStatement psts = conn.prepareStatement("UPDATE wishfulldb.users SET firstName=?, surName=?, phoneNumber=?, birthday=?, password=? where userID =?");
            psts.setString(1, req.getParameter("firstname"));
            psts.setString(2, req.getParameter("surname"));
            psts.setString(3, req.getParameter("phone"));
            psts.setString(4, req.getParameter("birthday") );
            psts.setString(5, req.getParameter("pWord") );
            psts.setInt(6, user.getUserID() );
            psts.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

  */