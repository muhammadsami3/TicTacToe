package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;

class ClientHandler extends Thread {

    DataInputStream dis;
    PrintStream ps;
    String uname;
    String Password;

    static Vector<ClientHandler> clientsVector = new Vector<ClientHandler>();
    static Vector<String> playersName = new Vector<String>();
    static Vector<String> Players = new Vector<String>();

    public ClientHandler(Socket cs) {
        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            clientsVector.add(this);
            start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {

            try {
                String clientRequest = dis.readLine();
                if (clientRequest.equals("login")) {

                    String username = dis.readLine();
                    String passwd = dis.readLine();
                    if (GameDatabase.validatePlayer(username, passwd)) {
                        
                        System.out.println("valid login name");
                        ps.println("valid");
                    } else {

                        System.out.println("not valid login name");
                        ps.println("not valid");
                    }

                } else if (clientRequest.equals("signup")) {

                    String username = dis.readLine();
                    String passwd = dis.readLine();
                    if (!GameDatabase.validatePlayer(username, passwd)) {

                        GameDatabase.addPlayers(username, passwd);
                        ps.println("valid");

                    } else {
                        ps.println("not valid");
                    }
                } else if (clientRequest.equals("go online")) {
                    
                   String response=dis.readLine();
                    if (response.equals("get players")) {
                        playersName = GameDatabase.getPlayers();
                        for (String p : playersName) {
                            ps.println(p);
                            System.out.println(p);
                        }

                    } else {
                        
                    }
                } else if (clientRequest.equals("game")) {

                    System.out.println("game");

                    while (true) {

                        String position = dis.readLine();
                        for (ClientHandler ch : clientsVector) {
                            ch.ps.println(position);
                            System.out.println(position);
          
                        }

                    }
                }
            } catch (IOException ex) {
                clientsVector.remove(this);
                playersName.remove(this.uname);
                System.out.println("remove");
                break;
            }

        }
    }
}
