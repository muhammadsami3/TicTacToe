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
    static PreparedStatement stmt3;
    static PreparedStatement stmt_getpasswd;
    static ResultSet rs;
    static ResultSet rs2;
   // static int playersIdSeries; 
//    static Vector<String> players_name = new Vector<String>();
    
      public static void connectToDatabase() {
        conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tictactoe", "postgres", "1022591400");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
      
    public static void addPlayers(String uname,String passwd) {
        String query = "insert into players values(?,?,?)";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,getNextId());
            stmt.setString(2,uname);
            stmt.setString(3,passwd);
            stmt.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

     public static Integer getNextId() {
        int id=-2;
        try {
            stmt2 = conn.createStatement();
            String queryString = new String("Select * from players order by id desc limit 1");
            rs = stmt2.executeQuery(queryString);
             
            rs.next();
                id=rs.getInt(1)+1;
                System.out.println(id);

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return id;
    }
  

    public static Vector<String> getPlayers() {
        Vector<String> players_name= new Vector<String>(); 
        try {
            stmt2 = conn.createStatement();
            String queryString = new String("Select * from players");
            rs = stmt2.executeQuery(queryString);
            while (rs.next()) {
              
                players_name.add(rs.getString(2));
            }
            for (String s : players_name) {
                System.out.println(s);
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return players_name;
    }

    
      public static String getPlayerpasswd(String uname) {
        String players_passwd= new String(); 
        try {
            stmt2 = conn.createStatement();
            String queryString = new String("Select * from players where name = '"+uname+"'");
            rs = stmt2.executeQuery(queryString);
             
            rs.next();
            players_passwd=rs.getString(3);

                System.out.println(players_passwd);

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return players_passwd;
    }
    
      public static boolean validatePlayer(String uname,String passwd) {
        boolean valid = true;
        String playerPass=getPlayerpasswd(uname);
        
        for (String s : getPlayers()) {
            if (uname.equals(s) && passwd.equals(playerPass)) {
                valid = false;
                System.out.println("password is valid");
                break;
            }

        }
        return valid;
    }


}
