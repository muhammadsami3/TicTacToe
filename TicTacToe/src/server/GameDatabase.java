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
import static server.Server.clientIndex;

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
    
     public static Vector<String> getOnlinePlayers(String uname) {
        Vector<String> onlinePlayers= new Vector<String>(); 
        
        String query = " Select * from players where online='on' and name  != ? ";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1,uname);
            rs=stmt.executeQuery();
            
             System.out.println("online players request");
             
                while (rs.next()) {
              
                onlinePlayers.add(rs.getString(2));
            }
                
//              for (String s : onlinePlayers) {
//                System.out.println(s);
//            }
           

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
//        try {
//            stmt2 = conn.createStatement();
//            String queryString = new String(" Select * from players where online='on' and name  != ? ");
//            rs = stmt2.executeQuery(queryString);
//            while (rs.next()) {
//              
//                onlinePlayers.add(rs.getString(2));
//            }
//           
//           
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        return onlinePlayers;
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

           public static int getPlayerId(String uname) {
               int id=-1;
        try {
            stmt2 = conn.createStatement();
            String queryString = new String("Select * from players where name = '"+uname+"'");
            rs = stmt2.executeQuery(queryString);
             
            rs.next();
            id=rs.getInt(1);

                System.out.println(id);

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return id;
    }
      
//        public static void setOnline(String uname) {
//            
//            String query = "insert into onlinePlayers values(?,?,?)";
//        try {
//            stmt = conn.prepareStatement(query);
//            stmt.setInt(1,clientIndex);
//            stmt.setString(2,uname);
//            stmt.setInt(3,getPlayerId(uname));
//            stmt.execute();
//             System.out.println("player online");
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//            
//    }
           
       public static void setOnline(String uname) {
           
        try {
            int id=getPlayerId(uname);
            String query = "update players set online='on' where name=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,uname);
            stmt.execute();

                System.out.println(uname+" is online");

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
       
       public static int  addGameSession(String player1,String player2) {
            int gameId=-1;
            String query = "insert into game (first_player_id,second_player_id,created) values (?,?,now())";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,getPlayerId(player1));
            stmt.setInt(2,getPlayerId(player2));
            stmt.execute();
             System.out.println("inserted in table game");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
             try {
            stmt2 = conn.createStatement();
            String queryString = new String("Select * from game order by created  desc limit 1");
            rs = stmt2.executeQuery(queryString);
             
            rs.next();
                gameId=rs.getInt(1);
                System.out.println(gameId);

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         return gameId;
    }
       
        public static void  storeGameRecord(int  gameid,int position) {
          
            String query = "insert into moves_record (game_id,position,time_stamp) values (?,?,now());";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,gameid);
            stmt.setInt(2,position);
            stmt.execute();
             System.out.println("inserted in table moves_record");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }


}
