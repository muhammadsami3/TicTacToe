/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import static xoclient.LoginFXMLController.dis;
import static xoclient.LoginFXMLController.mySocket;
import static xoclient.LoginFXMLController.ps;

/**
 *
 * @author MohamedSalah
 */
public class FXMLDocumentController implements Initializable,Runnable {
    
    Thread th1;
    Vector<String> onlineUsers=new Vector<String>();
    private Label label;
    @FXML
    private Button refreshBtn;
    @FXML
    private ListView<String> usersList;
    private Label selectedItemLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private TextField userNameText;
    @FXML
    private Button connectBtn;
    @FXML
    private Label errorLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField passwordText;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            th1=new Thread(this);
//            mySocket=new Socket(InetAddress.getLocalHost(), 5005);
//            ps=new PrintStream(mySocket.getOutputStream());
//            dis=new DataInputStream(mySocket.getInputStream());
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        th1=new Thread(this);
        th1.start();
        
//        onlineUsers.add("mohamed");
//        onlineUsers.add("aziz");onlineUsers.add("sami");
        
    }    

    @FXML
    private void handleMouseClicked(MouseEvent event) {
        selectedItemLabel.setText(usersList.getSelectionModel().getSelectedItem());
    }

   

    @FXML
    private void handleConnectBtnClicked(MouseEvent event) {
        String name=userNameText.getText();
        String password=passwordText.getText();
        ps.println(name);
        ps.println(password);
    }

    @FXML
    private void handleRefreshButtonAction(MouseEvent event) {
       usersList.getItems().clear();
       ps.println("r");
//        for (String x: onlineUsers){
//            usersList.getItems().add(x);
//        }
    }

    @Override
    public void run() {
         try {
            while(true){
                String replyMsg=dis.readLine();
                usersList.getItems().add(replyMsg);
                System.out.println(replyMsg);
            }
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
