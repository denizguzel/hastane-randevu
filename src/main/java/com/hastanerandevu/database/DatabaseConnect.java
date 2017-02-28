package com.hastanerandevu.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {
  public static Connection getConnection () {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfdeneme", "root", "");
    } catch ( Exception ex ) {
      System.out.println("Database.getConnection() --> Error " + ex.getMessage());
      return null;
    }
  }

  public static void closeConnection (Connection con) {
    try {
      con.close();
    } catch ( Exception ex ) {
      System.out.println("Database.closeConnection() --> Error " + ex.getMessage());
    }
  }
}
