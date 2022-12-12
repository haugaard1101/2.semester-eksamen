package com.example.bilabonnement.Repositories;

import com.example.bilabonnement.Model.*;
import com.example.bilabonnement.Repositories.Util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkadeRepository {

    private Connection connection = DatabaseConnectionManager.getConnection();
    //Kasper
    //retunerer alle skader fra databasen
    public List<SkadeModel> getSkadeList() {
        List<SkadeModel> skadeListe = new ArrayList<>();

        try {
            PreparedStatement psts = connection.prepareStatement("SELECT * FROM skader");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                skadeListe.add(new SkadeModel(
                        resultSet.getInt("SkadeID"),
                        resultSet.getString("RegistreringsNummer"),
                        resultSet.getString("SkadeNavn"),
                        resultSet.getString("SkadePris")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return skadeListe;
    }
    //Kasper
    //retunerer og viser en lejeaftale udfra RegNr
    public LejeAftaleModel getLejeaftale(String RegNr) {
        LejeAftaleModel lejeaftale = null;
        try {
            PreparedStatement psts = connection.prepareStatement("SELECT * FROM lejeaftale where RegistreringsNummer = ?");
            psts.setString(1, RegNr);
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                lejeaftale = new LejeAftaleModel(
                        resultSet.getInt("AftaleID"),
                        resultSet.getString("Navn"),
                        resultSet.getString("Adresse"),
                        resultSet.getString("Postnummer"),
                        resultSet.getString("Kommune"),
                        resultSet.getString("TelefonNr"),
                        resultSet.getString("CPR"),
                        resultSet.getString("Email"),
                        resultSet.getString("LejeperiodeFra"),
                        resultSet.getString("LejeperiodeTil"),
                        resultSet.getString("AntalMaaneder"),
                        resultSet.getString("Afhentningssted"),
                        resultSet.getString("Afleveringssted"),
                        resultSet.getString("KmVedAfhentning"),
                        resultSet.getString("AftaleKM"),
                        resultSet.getString("KmVedIndlevering"),
                        resultSet.getString("RegistreringsNummer")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lejeaftale;
    }
    //Kasper
    //retunerer og viser en bil udfra RegNr
    public BilModel getBil(String RegNr) {
        BilModel bil = null;
        try {
            PreparedStatement psts = connection.prepareStatement("SELECT * FROM biler where RegistreringsNummer = ?");
            psts.setString(1, RegNr);
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                bil = new BilModel(
                        resultSet.getInt("IDNumber"),
                        resultSet.getString("RegistreringsNummer"),
                        resultSet.getString("Stelnummer"),
                        resultSet.getString("Mærke"),
                        resultSet.getString("Model"),
                        resultSet.getString("UdstyrsNiveau"),
                        UdlejningsStatusEnum.valueOf(resultSet.getString("UdlejningsStatus")),
                        GearEnum.valueOf(resultSet.getString("Gear")),
                        resultSet.getString("BrændstofType"),
                        resultSet.getInt("KmL"),
                        resultSet.getInt("CO2_Udledning"),
                        resultSet.getInt("PrisPrMåned")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bil;
    }
    //Kasper
    //retunerer og lægger prisen af skader sammen på et bestemt registreringsnummer
    public int getPriceOnSkader(String RegNr) {
        int skadeRegning = 0;
        List<SkadeModel> skader = new ArrayList<>();
        try {
            PreparedStatement psts = connection.prepareStatement("SELECT * FROM skader WHERE RegistreringsNummer = ?");
            psts.setString(1, RegNr);
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                skader.add(new SkadeModel(
                        resultSet.getInt("SkadeID"),
                        resultSet.getString("RegistreringsNummer"),
                        resultSet.getString("SkadeNavn"),
                        resultSet.getString("SkadePris")
                ));
            }
            //lægger prisen sammen for alle skaderne
            for (SkadeModel skadeModel : skader) {
                skadeRegning += Integer.parseInt(String.valueOf(skadeModel.getSkadePris()));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return skadeRegning;
    }

    //Kasper, Mathias, Benjamin, Marcus
    //sletter en skade udfra skadeID, derefter sætter den automatisk bilens status til 'Ledig', hvis det var den sidste skade på bilen
    public void deleteSkade(int ID) {
        PreparedStatement psts;
        String RegNr = null;
        //kører igennem alle registreret skader og finder Registeringsnummeret udfra skadeID
        for (SkadeModel s : getSkadeList()) {
            if (s.getSkadeID() == ID) {
                RegNr = s.getRegistreringsNummer();
            }
        }
        //sletter skaden fra databasen
        try {
            psts = connection.prepareStatement("DELETE FROM skader where SkadeID = ?");
            psts.setInt(1, ID);
            psts.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //opretter en ny arraylist, med alle skaderne fra registeringsnummeret
        List<SkadeModel> skadeListeMedRegNr = new ArrayList<>();
        try {
            PreparedStatement psts2 = connection.prepareStatement("SELECT * FROM skader where RegistreringsNummer = ?");
            psts2.setString(1, RegNr);
            ResultSet resultSet = psts2.executeQuery();

            while (resultSet.next()) {
                skadeListeMedRegNr.add(new SkadeModel(
                        resultSet.getInt("SkadeID"),
                        resultSet.getString("RegistreringsNummer"),
                        resultSet.getString("SkadeNavn"),
                        resultSet.getString("SkadePris")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //hvis arraylisten er tom, updateres bilens udlejningsStatus til LEDIG
        if (skadeListeMedRegNr.size() == 0) {
            try {
                psts = connection.prepareStatement("UPDATE Biler SET udlejningsStatus = 'LEDIG' where registreringsNummer = ?");
                psts.setString(1, RegNr);
                psts.execute();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //Kasper
    //opretter en skade og ændre KM ved indlevering på en bil og sætter bilen som skadet/ledig
    public void createSkade(String RegNr, String aflæstKm, String lakfelt, String ridsetAlufælge, String nyForrude) {
        PreparedStatement psts;

        //hvis aflæstKm er lig med alt andet end ingenting, updateres værdien inde på lejeaftalen
        try {
            if (!aflæstKm.equals("")) {
                psts = connection.prepareStatement("UPDATE lejeaftale SET KmVedIndlevering = ? where RegistreringsNummer = ?");
                psts.setString(1, aflæstKm);
                psts.setString(2, RegNr);
                psts.executeUpdate();
            }
            //hvis lakfelt ikke er lig med null, indsættes værdien inde på skader
            if (!(lakfelt == null)) {
                psts = connection.prepareStatement("INSERT INTO skader (RegistreringsNummer, SkadeNavn, SkadePris) VALUES (?, 'lakfelt', 1500)");
                psts.setString(1, RegNr);
                psts.execute();
            }
            //hvis ridsetAlufælge ikke er lig med null, indsættes værdien inde på skader
            if (!(ridsetAlufælge == null)) {
                psts = connection.prepareStatement("INSERT INTO skader (RegistreringsNummer, SkadeNavn, SkadePris) VALUES (?, 'ridset alufælge', 400)");
                psts.setString(1, RegNr);
                psts.execute();
            }
            //hvis nyForrude ikke er lig med null, indsættes værdien inde på skader
            if (!(nyForrude == null)) {
                psts = connection.prepareStatement("INSERT INTO skader (RegistreringsNummer, SkadeNavn, SkadePris) VALUES (?, 'ny forrude', 3000)");
                psts.setString(1, RegNr);
                psts.execute();
            }
            //hvis mindst en af skaderne ikke er lig null, updateres udlejningsStatus til SKADET. Ellers updateres den til LEDIG
            if (!(lakfelt == null) || !(ridsetAlufælge == null) || !(nyForrude == null)) {
                psts = connection.prepareStatement("UPDATE Biler SET udlejningsStatus = 'SKADET' where registreringsNummer = ?");
                psts.setString(1, RegNr);
                psts.execute();
            } else {
                psts = connection.prepareStatement("UPDATE Biler SET udlejningsStatus = 'LEDIG' where registreringsNummer = ?");
                psts.setString(1, RegNr);
                psts.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public BilModel findEnBil(String RegNr) throws Exception {
        BilModel bilModel = null;
        try {
            PreparedStatement psts = connection.prepareStatement("SELECT * FROM biler where RegistreringsNummer = ?");
            psts.setString(1, RegNr);
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                bilModel = new BilModel(
                        resultSet.getString("Mærke"),
                        resultSet.getString("Model"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bilModel;
    }

}
