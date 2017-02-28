package com.hastanerandevu.DAO;

import com.hastanerandevu.database.DatabaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
  public static boolean validate (String username, String password) {
    Connection        con = null;
    PreparedStatement ps;

    try {
      con = DatabaseConnect.getConnection();
      assert con != null;
      ps = con.prepareStatement("SELECT username, password from users where username = ? AND password = ?");
      ps.setString(1, username);
      ps.setString(2, password);

      ResultSet result = ps.executeQuery();
      if ( result.next() )
        return true;
    } catch ( SQLException ex ) {
      System.out.println("Login error --> " + ex.getMessage());
      return false;
    } finally {
      DatabaseConnect.closeConnection(con);
    }
    return false;
  }
}
