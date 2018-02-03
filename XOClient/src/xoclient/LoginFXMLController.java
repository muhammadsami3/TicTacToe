/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoclient;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MohamedSalah
 */
public class LoginFXMLController implements Initializable, Runnable {

    static Socket mySocket;
    static DataInputStream dis;
    static PrintStream ps;
    Thread th1;

    @FXML
    private Label usernameLabel;
    @FXML
    private TextField userNameText;
    @FXML
    private Button connectBtn;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField passwordText;
    @FXML
    private Label errorLabel;
    @FXML
    private Button connectBtn1;
    @FXML
    private AnchorPane rootPane;
    private boolean flag;

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
                            errorLabel.setText("invalid");
                        }
                    });
                    
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void handleLoginBtnClicked(MouseEvent event) {
        ps.println("login");
        ps.println(userNameText.getText());

    }

    @FXML
    private void handleSignUpBtnClicked(MouseEvent event) {
        ps.println("signup");
        ps.println(userNameText.getText());
    }

    public void switchToPage() {
        Stage stage;
        Parent root;
        try {
            stage = (Stage) connectBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("secondPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
