/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muhammad Sami
 */
public class Login_pageController implements Initializable ,Runnable{
    static Socket mySocket;
    static DataInputStream dis;
    static PrintStream ps;
    Thread th1;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private GridPane logpane;
    @FXML
    private Button login_btn;
    @FXML
    private Button sign_btn;
    @FXML
    private TextField uname;
    @FXML
    private TextField passwd;

    static String loginname;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            th1 = new Thread(this);
            mySocket = new Socket(InetAddress.getLocalHost(), 5005);
            ps = new PrintStream(mySocket.getOutputStream());
            dis = new DataInputStream(mySocket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        th1.start();
       
    }
    @Override
    public void run() {
        try {
            while (true) {
                String reply = dis.readLine();
                if (reply.equals("valid")) {
                    
                    
                    System.out.println("valid");
                    loginname=uname.getText();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            switchToPage();
                        }
                    });

                    break;

                } else {
                    System.out.println("invalid");
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });
                    
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

  
    @FXML
    private void signUp(MouseEvent event) throws IOException {
        if(!uname.getText().trim().isEmpty() && !passwd.getText().trim().isEmpty()  )
                {
                    ps.println("signup");
                    ps.println(uname.getText());
                   ps.println(passwd.getText());
                }

    }

    @FXML
    private void login(MouseEvent event)  throws IOException{
          if(!uname.getText().trim().isEmpty() && !passwd.getText().trim().isEmpty())
        {
                   ps.println("login");
                    ps.println(uname.getText());
                   ps.println(passwd.getText());

        }
    }
    public void switchToPage() {
        Stage stage;
        Parent root;
        try {
           
            stage = (Stage) login_btn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("goOnline.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
             
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Login_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
