package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import static server.GameDatabase.*;


public class Server {

    static boolean validatePlayer(String uname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ServerSocket myServerSocket;
    Socket s;
    Thread th;
    public static int clientIndex=0;
     static Vector<String> onlinePlayers= new Vector<String>(); 

    public Server() {

        try {
            myServerSocket = new ServerSocket(5005);
            while (true) {
                s = myServerSocket.accept();
                    
                    System.out.println("clientIndex="+clientIndex);
                new ServerHandler(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        th.start();
   
    }
    
    

    public static void main(String[] args) {
        connectToDatabase();
//        GameDatabase.setOnline("sami");
//       addPlayers("yehia","123456");
//       GameDatabase.getPlayers();
//       GameDatabase.getNextId();
//      GameDatabase.getPlayerpasswd("sami");
//          GameDatabase.validatePlayer("sami","123456");
//        int passwd=GameDatabase.getPassword("aziz");
//        System.out.println(passwd);
     //   System.out.println(getPlayerId("arwa"));
//          GameDatabase.setOnline("arwa");
// onlinePlayers= GameDatabase.getOnlinePlayers("sami");

GameDatabase.storeGameRecord(124,0);

        System.out.println("game id "+GameDatabase.addGameSession("omnia", "youns"));  
//GameDatabase.getPlayerId("sami");
 
//   for (String s : onlinePlayers) {
//                System.out.println(s);
//            }
 
     new Server();

        
    }
}

