use
BilAbonnement;

DROP table lejeaftale;

DROP table skader;
DROP table users;
DROP table biler;



Create table Biler
(
    IDNumber            int not null auto_increment,
    RegistreringsNummer varchar(50) unique,
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
    RegistreringsNummer varchar(50) unique,
    SkadeNavn           varchar(100),
    SkadePris           int,
    primary key (SkadeID),
    foreign key (RegistreringsNummer) references Biler (RegistreringsNummer)
);

CREATE table LejeAftale
(
    AftaleID            int not null auto_increment,
    primary key (AftaleID),
    RegistreringsNummer varchar(50) unique,
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
    foreign key (RegistreringsNummer) references Biler (RegistreringsNummer)
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
INSERT into Biler (RegistreringsNummer, Stelnummer, Mærke, Model, UdstyrsNiveau, UdlejningsStatus, Gear, BrændstofType, KmL, CO2_Udledning,
                   PrisPrMåned)
values ('AT45634', 123412, 'Ford', 'Power', 'Premium', 'LEDIG', 'MANUELT', 'Diesel', 20, 100, 2999);
INSERT into Biler (RegistreringsNummer, Stelnummer, Mærke, Model, UdstyrsNiveau, UdlejningsStatus, Gear, BrændstofType, KmL, CO2_Udledning,
                   PrisPrMåned)
values ('AB12345',199434, 'Porche', 'Classic', 'Premium', 'AKTIV', 'MANUELT', 'Diesel', 35, 50, 9999);
INSERT into Biler (RegistreringsNummer, Stelnummer, Mærke, Model, UdstyrsNiveau, UdlejningsStatus, Gear, BrændstofType, KmL, CO2_Udledning,
                   PrisPrMåned)
values ('HF73287',153823, 'Toyota', 'Ultra', 'Premium', 'AFLEVERET', 'AUTOMATISK', 'Diesel', 45, 70, 3999);

INSERT into LejeAftale(RegistreringsNummer, Navn, Adresse, Postnummer, Kommune, TelefonNr, CPR, Email, LejeperiodeFra, LejeperiodeTil,
                       AntalMåneder, Afhentningssted, Afleveringssted, KmVedAfhentning, AftaleKM,
                       KmVedIndlevering)
values ('AT45634', 'Andreas Noget', 'gastonvej 23', 2610, 'Rødovre', 25230232, '101292-1234', 'personensemail@gmail.com',
        '2022-09-12', '2023-02-12', 6, 'Rødovre bilværksted', 'Rødovre bilværksted', 23000, 1500, 1600);
INSERT into LejeAftale(RegistreringsNummer, Navn, Adresse, Postnummer, Kommune, TelefonNr, CPR, Email, LejeperiodeFra, LejeperiodeTil,
                       AntalMåneder, Afhentningssted, Afleveringssted, KmVedAfhentning, AftaleKM,
                       KmVedIndlevering)
values ('AB12345', 'Benjamin Buhl', 'monkonvej 3', 2310, 'København', 22522232, '101299-4334', 'someotheremail@gmail.com',
        '2022-10-10', '2023-03-10', 6, 'Hvidovre bilværksted', 'Hvidovre bilværksted', 30000, 2000, 1600);
INSERT into LejeAftale(RegistreringsNummer, Navn, Adresse, Postnummer, Kommune, TelefonNr, CPR, Email, LejeperiodeFra, LejeperiodeTil,
                       AntalMåneder, Afhentningssted, Afleveringssted, KmVedAfhentning, AftaleKM,
                       KmVedIndlevering)
values ('HF73287','Marcus Buhl', 'Hvidovrevej 23', 2520, 'Hvidovre', 25230299, '110301-1874', 'randommail@gmail.com',
        '2021-11-12', '2022-04-12', 6, 'Vanløse bilværksted', 'Vanløse bilværksted', 34000, 1500, 2000);
INSERT INTO skader (RegistreringsNummer, SkadeNavn, SkadePris)
values ('HF73287', 'skade', 1000)