package com.hastanerandevu.DAO;

import com.hastanerandevu.converter.PasswordEncryptor;
import com.hastanerandevu.database.DatabaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
  public static boolean loginUser (String username, String password) {
    Connection        con = null;
    PreparedStatement ps;

    try {
      PasswordEncryptor encryptor = new PasswordEncryptor();
      password = encryptor.encryptPassword(password);

      con = DatabaseConnect.getConnection();
      assert con != null;
      ps = con.prepareStatement("SELECT username, password from account where username = ? AND password = ?");
      ps.setString(1, username);
      ps.setString(2, password);

      ResultSet result = ps.executeQuery();
      if ( result.next() )
        return true;
    } catch ( SQLException ex ) {
      System.out.println("Login error --> " + ex.getMessage());
    } finally {
      try {
        DatabaseConnect.closeConnection(con);
      } catch ( Exception e ) {
        e.printStackTrace();
      }
    }
    return false;
  }

  public static boolean createUser (String username, String password, String tcno) {
    Connection        con;
    PreparedStatement ps;

    try {
      PasswordEncryptor encryptor = new PasswordEncryptor();
      password = encryptor.encryptPassword(password);

      con = DatabaseConnect.getConnection();
      assert con != null;
      ps = con.prepareStatement("INSERT INTO account(username, password, tcno) VALUES(?,?,?)");
      ps.setString(1, username);
      ps.setString(2, password);
      ps.setString(3, tcno);

      ps.executeUpdate();
    } catch ( SQLException ex ) {
      System.out.println("Register error --> " + ex.getMessage());
    }
    return true;
  }
}
