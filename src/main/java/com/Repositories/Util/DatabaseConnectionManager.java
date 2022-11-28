package com.Repositories.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnectionManager {

  //Variabler
  private static String hostname;
  private static String username;
  private static String password;
  private static Connection connection;

  //Metoder

  public static Connection getConnection(){
    hostname = "jdbc:mysql://myfirstdatabase.mysql.database.azure.com";
    username = "Mathias";
    password = "Kalvin123";

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
