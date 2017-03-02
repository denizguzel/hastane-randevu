package com.hastanerandevu.DAO;

import com.hastanerandevu.database.DatabaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
  public static boolean addUser (String username, String password) {
    Connection        con = null;
    PreparedStatement ps;

    try {
      con = DatabaseConnect.getConnection();
      assert con != null;
      ps = con.prepareStatement("INSERT INTO users(username, password) VALUES(?,?)");
      ps.setString(1, username);
      ps.setString(2, password);

      ps.executeUpdate();
    } catch ( SQLException ex ) {
      System.out.println("Register error --> " + ex.getMessage());
    } finally {
      try {
        DatabaseConnect.closeConnection(con);
      } catch ( Exception e ) {
        e.printStackTrace();
      }
    }
    return true;
  }
}
