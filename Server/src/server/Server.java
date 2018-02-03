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
        new Server();
    }
}

