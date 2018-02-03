package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    static boolean validatePlayer(String uname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ServerSocket myServerSocket;
    Socket s;
    Thread th;

    public Server() {

        try {
            myServerSocket = new ServerSocket(5005);
            while (true) {
                s = myServerSocket.accept();
                new ClientHandler(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        th.start();
   
    }

    public static void main(String[] args) {
        GameDatabase.connectToDatabase();
       // GameDatabase.addPlayers("youns",123456);
       GameDatabase.getPlayers();
      
//        int passwd=GameDatabase.getPassword("aziz");
//        System.out.println(passwd);
       new Server();

        
    }
}

