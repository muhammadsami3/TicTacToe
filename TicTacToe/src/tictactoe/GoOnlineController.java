/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import server.GameDatabase;
import static tictactoe.Login_pageController.dis;
import static tictactoe.Login_pageController.loginname;
import static tictactoe.Login_pageController.ps;

/**
 * FXML Controller class
 *
 * @author Muhammad Sami
 */
public class GoOnlineController implements Initializable, Runnable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button refreshBtn;
    @FXML
    private ListView<String> usersList;
    @FXML
    private Label errorLabel;
    @FXML
    private Button connectBtn;
    @FXML
    private Label selectedLabel;
    static Vector<String> onlinePlayers = new Vector<String>();
    Thread th;
    @FXML
    private Label requestReceivedLabel;
    @FXML
    private Pane popupPane;
    @FXML
    private Button acceptBtn;
    @FXML
    private Button refuseBtn;
    boolean flag=true;
    public  String asker;
   public String wanted;
   String myname;
//    static  String wanted="";
//    static  String asker="";

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        ps.println("go online");
        myname=loginname;
        th = new Thread(this);
        th.start();
    }

    @FXML
    private void handleRefreshButtonAction(MouseEvent event) {
        ps.println("get players");
        ps.println(loginname);
    }

    @FXML
    private void handleMouseClicked(MouseEvent event) {
    }

    @Override
    public void run() {
        try {
            while (true) {

                String replyMsg = dis.readLine();

                System.out.println(replyMsg);

                if (replyMsg.equals("steady")) {

                    System.out.println("online players response");

                    while (flag) {

                        String recieved = dis.readLine();//receive users

                        if (recieved.equals("done")) {

                            System.out.println("online players got");

                            flag=false;
                        } else {

                            usersList.getItems().add(recieved);
                            System.out.println(recieved);
                        }

                    }

                } else if (replyMsg.equals("choosen one")) {
                   
                  wanted = dis.readLine();
                  System.out.println(wanted);
                    System.out.println(loginname);
//                    System.out.println("kkkkkkkkkkkkkkkkkkkkkk");
                    if (wanted.equals(loginname)) {
                        
                         asker = dis.readLine();
                         wanted=loginname;
                         popupPane.setVisible(true);
                    }

                }
                
                else if(replyMsg.equals("start session")){
                    
               System.out.println("sesssssaaaaaaaaaaaaaaaaaaaaaaaan");
               
                     wanted = dis.readLine();
                     asker = dis.readLine();
                    System.out.println(wanted);
                    System.out.println(asker);
                    if (wanted.equals(myname)||asker.equals(myname)) {
                         Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            switchToPage();
                        }
                    });
                        
                        
                         
                    }
                    
                
                 }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void selectedBtn(MouseEvent event) {
        String selected = usersList.getSelectionModel().getSelectedItem();

        selectedLabel.setText("send request " + selected);
        ps.println("send invitation");
        System.out.println("ahoooooooo-111> "+selected);
         // GoOnlineController.name1=selected;
          //System.out.println(GoOnlineController.name1);
           //name2=loginname;
        ps.println(selected);
        ps.println(loginname);

    }

    @FXML
    private void refuseHandler(MouseEvent event) {
    }

    @FXML
    private void AcceptHandler(MouseEvent event) {
        
        ps.println("accept invitation");
        System.out.println("ayyyyyyyyy 7agaaaaaaa111   "+asker+" to "+wanted);
        ps.println(asker);
        ps.println(myname);
        
        
        
       
    }
    
       public void switchToPage() {
        Stage stage;
        Parent root;
        try {
           
            stage = (Stage) refreshBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("XO.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
             
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Login_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
