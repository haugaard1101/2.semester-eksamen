package com.Repositories.Util;

import com.sun.jdi.connect.spi.Connection;

public class DatabaseConnectionManager {
  //Variabler
  private static String hostname;
  private static String username;
  private static String password;
  private static Connection connection;

  //Metoder

  public static Connection getConnection(){
    hostname = "jdbc:mysql://.database.azure.com/BilAbonnementDB";
    username = "Glennhansen";
    password = "kalvin";

    try {
      connection = DriverManager.getConnection(hostname,username,password);

    } catch (SQLException e) {
      System.out.println("Kan ikke forbinde til database");
      throw new RuntimeException(e);
    }
    System.out.println("Forbindelse til database godkendt!");
    return connection;
  }
}
