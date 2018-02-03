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
    static Statement stmt_getpasswd;
    static ResultSet rs;
//    static Vector<String> players_name = new Vector<String>();
    
      public static void connectToDatabase() {
        conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://10.145.1.127:5432/xo", "postgres", "1022591400");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void addPlayers(String uname) {
        String query = "insert into players values(?,2)";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1,uname);
            stmt.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

  

    public static Vector<String> getPlayers() {
        Vector<String> players_name= new Vector<String>(); 
        try {
            
            stmt2 = conn.createStatement();
            String queryString = new String("Select * from players");
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
    
      public static boolean validatePlayer(String uname,String passwd) {
        boolean valid = true;
        
        for (String s : getPlayers()) {
            if (uname.equals(s)) {
                
                
                
                valid = false;
                break;
            }

        }
        return valid;
    }

      public static int getPassword(String uname) {
          int  passwd=-1;

//          for (String s : getPlayers()) {
//            if (uname.equals(s)) {

String query = "Select * from players where name = '?'";
        try {
            stmt_getpasswd = conn.prepareStatement(query);
            stmt.setString(1, uname);
            rs=stmt.executeQuery();
            passwd=rs.getInt(2);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//              
//              try {
//                     stmt_getpasswd = conn.createStatement();
//                     String queryString = new String("Select * from players where name = '"+uname+"'");
//                    rs = stmt_getpasswd.executeQuery(queryString);
//                  passwd=rs.getInt(2);
//                  return passwd;
//                } catch (SQLException ex) {
//                    Logger.getLogger(GameDatabase.class.getName()).log(Level.SEVERE, null, ex);
//                }

//                
//                break;
//            }

//        }
          
     return passwd;
    }
  

}
