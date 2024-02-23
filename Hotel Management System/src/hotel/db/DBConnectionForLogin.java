/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanjaya
 */
public class DBConnectionForLogin {
      private static DBConnectionForLogin dBConnectionForLogin;
    private Connection connection;

    private DBConnectionForLogin() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "sanjaya");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnectionForLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static DBConnectionForLogin getInstance() {
        if (dBConnectionForLogin == null) {
            dBConnectionForLogin = new DBConnectionForLogin();
        }
        return dBConnectionForLogin;

    }

    public Connection getConnection() {
        return connection;
    }
}
