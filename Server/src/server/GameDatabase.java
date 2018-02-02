/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MohamedSalah
 */
public class GameDatabase {
    static Connection conn;
    static PreparedStatement stmt;
    static Statement stmt2;
    static ResultSet rs;
//    static Vector<String> players_name = new Vector<String>();
    
      public static void connectToDatabase() {
        conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.4:5932/xo", "postgres", "147596382");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void addPlayers(String uname) {
        String query = "insert into login(player_name)" + "values(?)";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, uname);
            stmt.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

  

    public static Vector<String> getPlayers() {
        Vector<String> players_name= new Vector<String>(); 
        try {
            
            stmt2 = conn.createStatement();
            String queryString = new String("Select * from login");
            rs = stmt2.executeQuery(queryString);
            while (rs.next()) {
              
                players_name.add(rs.getString(1));
            }
            for (String s : players_name) {
                System.out.println(s);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return players_name;
    }
    
      public static boolean validatePlayer(String uname) {
        boolean valid = true;
        
        for (String s : getPlayers()) {
            if (uname.equals(s)) {
                valid = false;
                break;
            }

        }
        return valid;
    }

  

}
