package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import static server.Server.clientIndex;

class ServerHandler extends Thread {

    DataInputStream dis;
    PrintStream ps;
    String uname;
    String Password;
    String asker;
    String wanted;
    boolean flag1=true;
//    class Players{
//    
//    public ServerHandler Handler;
//     int index;
//
//        public Players(ServerHandler h) {
//            Handler=h;
//            
//        }
//    
//          
//    }

    static Vector<ServerHandler> clientsVector = new Vector<ServerHandler>();
    static Vector<String> playersName = new Vector<String>();

//    static Vector<Players> Players = new Vector<Players>();

    public ServerHandler(Socket cs) {
        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
//            Players.add(new Players(this));
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
                    if (!GameDatabase.validatePlayer(username, passwd)) {
                        
                        System.out.println("valid login name");
                        clientIndex++;
                        GameDatabase.setOnline(username);
                        
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
                    
                    System.out.println("is online");
                    while (true) {   
                   
                    String response=dis.readLine();
                    
                    
                    if (response.equals("get players")) {
                             System.out.println("get players");
                        playersName.removeAllElements();                      
                        String onlineUname=dis.readLine();
                       System.out.println(onlineUname+" request online users");
                        playersName = GameDatabase.getOnlinePlayers(onlineUname);
                        
                        ps.println("steady");
                        
                        for (String p : playersName) {
                            ps.println(p);
                            System.out.println(p);
                        }
                        ps.println("done");
                    System.out.println("server done");


                    } else if(response.equals("send invitation")){
                        System.out.println("send invitation");
                        wanted=dis.readLine();
                        asker=dis.readLine();
                        
                          System.out.println("wanted is " +wanted);
                          System.out.println("asker is " +asker);
                    

                         for (ServerHandler ch : clientsVector) {
                             ch.ps.println("choosen one");
                             
                              ch.ps.println(wanted);
                             ch.ps.println(asker);
                            
          
                        }
                        
                    }
                    
                    else if (response.equals("accept invitation")) {
                        
                        System.out.println("invitation accepted");
                           String asker1=dis.readLine();
                           String wanted1=dis.readLine();

                        
                            System.out.println("wanted is " +wanted1);
                          System.out.println("asker is " +asker1);
                    
                            GameDatabase.addGameSession(asker1, wanted1);
                            
                            for (ServerHandler ch : clientsVector) {
                             ch.ps.println("start session");
                             
                              ch.ps.println(wanted1);
                             ch.ps.println(asker1);
                            
          
                        }
                        
                            
                            
                            
                        }
                    
                    else if (response.equals("game")){
                           System.out.println("game");

                    while (true) {

                        String position = dis.readLine();
                        for (ServerHandler ch : clientsVector) {
                            ch.ps.println(position);
                            System.out.println(position);
          
                        }

                    }
                    }
                        
                    }
                   
                } /*else if (clientRequest.equals("game")) {

                    System.out.println("nnoooo game");
//
//                    while (true) {
//
//                        String position = dis.readLine();
//                        for (ServerHandler ch : clientsVector) {
//                            ch.ps.println(position);
//                            System.out.println(position);
//          
//                        }
//
//                    }
                }*/
            } catch (IOException ex) {
                clientsVector.remove(this);
                playersName.remove(this.uname);
                System.out.println("remove");
                clientIndex --;
                System.out.println("clientIndex="+clientIndex);

                break;
            }

        }
    }
}
