use
BilAbonnement;

DROP table lejeaftale;
DROP table biler;
DROP table skader;
DROP table users;


Create table Biler
(
    IDNumber            int not null auto_increment,
    RegistreringsNummer varchar(50),
    Stelnummer          varchar(50),
    Mærke               varchar(50),
    Model               varchar(50),
    UdstyrsNiveau       varchar(50),
    UdlejningsStatus    ENUM ('LEDIG','AKTIV','AFLEVERET'),
    Gear                ENUM ('MANUELT','AUTOMATISK'),
    BrændstofType       varchar(50),
    KmL                 int,
    CO2_Udledning       int,
    PrisPrMåned         int,
    primary key (IDNumber)
);

Create table Skader
(
    SkadeID             int not null auto_increment,
    SkadeNavn           varchar(100),
    SkadePris           int,
    primary key (SkadeID),
    RegistreringsNummer int,
    foreign key (RegistreringsNummer) references Biler (IDNumber)
);

CREATE table LejeAftale
(
    AftaleID            int not null auto_increment,
    primary key (AftaleID),
    Navn                varchar(50),
    Adresse             varchar(100),
    Postnummer          int,
    Kommune             varchar(50),
    TelefonNr           int,
    CPR                 varchar(30),
    Email               varchar(100),
    LejeperiodeFra      date,
    LejeperiodeTil      date,
    AntalMåneder        int,
    Afhentningssted     varchar(100),
    Afleveringssted     varchar(100),
    KmVedAfhentning     int,
    AftaleKM            int,
    KmVedIndlevering    int,
    RegistreringsNummer int,
    foreign key (RegistreringsNummer) references Biler (IDNumber)
);

Create table Users
(
    userID   int not null auto_increment,
    userName varchar(50),
    password varchar(50),
    primary key (userID)
);

use
BilAbonnement;
INSERT into Biler (Stelnummer, Mærke, Model, UdstyrsNiveau, UdlejningsStatus, Gear, BrændstofType, KM_L, CO2_Udledning,
                   Pris_pr_Måned)
values (123412, 'Ford', 'Power', 'Premium', 'LEDIG', 'MANUELT', 'Diesel', 20, 100, 2999);
INSERT into Biler (Stelnummer, Mærke, Model, UdstyrsNiveau, UdlejningsStatus, Gear, BrændstofType, KM_L, CO2_Udledning,
                   Pris_pr_Måned)
values (199434, 'Porche', 'Classic', 'Premium', 'AKTIV', 'MANUELT', 'Diesel', 35, 50, 9999);
INSERT into Biler (Stelnummer, Mærke, Model, UdstyrsNiveau, UdlejningsStatus, Gear, BrændstofType, KM_L, CO2_Udledning,
                   Pris_pr_Måned)
values (153823, 'Toyota', 'Ultra', 'Premium', 'AFLEVERET', 'AUTOMATISK', 'Diesel', 45, 70, 3999);

INSERT into LejeAftale(Navn, Adresse, Postnummer, Kommune, TelefonNr, CPR, Email, LejeperiodeFra, LejeperiodeTil,
                       Antal_Måneder, Afhentningssted, Afleveringssted, KM_ved_Afhentning, MaxKilometer,
                       AktueltKørteKilometer, RegistreringsNummer)
values ('Andreas Noget', 'gastonvej 23', 2610, 'Rødovre', 25230232, '101292-1234', 'personensemail@gmail.com',
        '2022-09-12', '2023-02-12', 6, 'Rødovre bilværksted', 'Rødovre bilværksted', 23000, 1500, 1600, 1);
INSERT into LejeAftale(Navn, Adresse, Postnummer, Kommune, TelefonNr, CPR, Email, LejeperiodeFra, LejeperiodeTil,
                       Antal_Måneder, Afhentningssted, Afleveringssted, KM_ved_Afhentning, MaxKilometer,
                       AktueltKørteKilometer, RegistreringsNummer)
values ('Benjamin Buhl', 'monkonvej 3', 2310, 'København', 22522232, '101299-4334', 'someotheremail@gmail.com',
        '2022-10-10', '2023-03-10', 6, 'Hvidovre bilværksted', 'Hvidovre bilværksted', 30000, 2000, 1600, 2);
INSERT into LejeAftale(Navn, Adresse, Postnummer, Kommune, TelefonNr, CPR, Email, LejeperiodeFra, LejeperiodeTil,
                       Antal_Måneder, Afhentningssted, Afleveringssted, KM_ved_Afhentning, MaxKilometer,
                       AktueltKørteKilometer, RegistreringsNummer)
values ('Marcus Buhl', 'Hvidovrevej 23', 2520, 'Hvidovre', 25230299, '110301-1874', 'randommail@gmail.com',
        '2021-11-12', '2022-04-12', 6, 'Vanløse bilværksted', 'Vanløse bilværksted', 34000, 1500, 2000, 3);
INSERT INTO skader (SkadeNavn, SkadePris, RegistreringsNummer)
values ('skade', 1000, 'AT67550')