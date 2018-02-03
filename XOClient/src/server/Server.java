package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

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
        GameDatabase.addPlayers("mariem");
        GameDatabase.getPlayers();
      
//        int passwd=GameDatabase.getPassword("aziz");
//        System.out.println(passwd);
       new Server();

        
    }
}

