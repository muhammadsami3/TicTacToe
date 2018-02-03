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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author maryam
 */
public class XOController implements Initializable ,Runnable{

    static Socket mySocket;
    static DataInputStream dis;
    static PrintStream ps;
    Thread th1;
    
    Image imgO=new Image(getClass().getResourceAsStream("o.png"));
    Image imgX=new Image(getClass().getResourceAsStream("x.png"));
    //Image display=imgX;
     boolean isX=true;
     boolean isEmpty[]={true,true,true,true,true,true,true,true,true};
    
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label cell8;
    @FXML
    private Label cell5;
    @FXML
    private Label cell1;
    @FXML
    private Label cell7;
    @FXML
    private Label cell3;
    @FXML
    private Label cell0;
    @FXML
    private Label cell2;
    @FXML
    private Label cell4;
    @FXML
    private Label cell6;

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

    @FXML
    private void cell0(MouseEvent event) {
        if(isEmpty[0]){
        {
        if(isX)   
        {
             cell0.setGraphic(new ImageView(imgX));
             isX=false;
             isEmpty[0]=false;
        }
        else {
            cell0.setGraphic(new ImageView(imgO));
                         isX=true;
                        isEmpty[0]=false;

        }
        }
        }
    }

    public  void setImg(){
        
        if(isEmpty[1]){
        {
        if(isX)   
        {
             cell1.setGraphic(new ImageView(imgX));
             isX=false;
             isEmpty[1]=false;
             
        }
        else {
            cell1.setGraphic(new ImageView(imgO));
                         isX=true;
                        isEmpty[1]=false;

        }
        }
        }
    
    }
    
    @FXML
    private void cell1(MouseEvent event) throws IOException {
        
        ps.println(1);
        System.out.println(dis.readInt());
        
        
    }

    @FXML
    private void cell2(MouseEvent event) {
        if(isEmpty[2]){
        {
        if(isX)   
        {
             cell2.setGraphic(new ImageView(imgX));
             isX=false;
             isEmpty[2]=false;
        }
        else {
            cell2.setGraphic(new ImageView(imgO));
                         isX=true;
                        isEmpty[2]=false;

        }
        }
        }
    }

    @FXML
    private void cell3(MouseEvent event) {if(isEmpty[3]){
        {
        if(isX)   
        {
             cell3.setGraphic(new ImageView(imgX));
             isX=false;
             isEmpty[3]=false;
        }
        else {
            cell3.setGraphic(new ImageView(imgO));
                         isX=true;
                        isEmpty[3]=false;

        }
        }
        }
    }

    @FXML
    private void cell4(MouseEvent event) {if(isEmpty[4]){
        {
        if(isX)   
        {
             cell4.setGraphic(new ImageView(imgX));
             isX=false;
             isEmpty[4]=false;
        }
        else {
            cell4.setGraphic(new ImageView(imgO));
                         isX=true;
                        isEmpty[4]=false;

        }
        }
        }
    }

    @FXML
    private void cell5(MouseEvent event) {if(isEmpty[5]){
        {
        if(isX)   
        {
             cell5.setGraphic(new ImageView(imgX));
             isX=false;
             isEmpty[5]=false;
        }
        else {
            cell5.setGraphic(new ImageView(imgO));
                         isX=true;
                        isEmpty[5]=false;

        }
        }
        }
    }

    @FXML
    private void cell6(MouseEvent event) {if(isEmpty[6]){
        {
        if(isX)   
        {
             cell6.setGraphic(new ImageView(imgX));
             isX=false;
             isEmpty[6]=false;
        }
        else {
            cell6.setGraphic(new ImageView(imgO));
                         isX=true;
                        isEmpty[6]=false;

        }
        }
        }
    }

    @FXML
    private void cell7(MouseEvent event) {if(isEmpty[7]){
        {
        if(isX)   
        {
             cell7.setGraphic(new ImageView(imgX));
             isX=false;
             isEmpty[7]=false;
        }
        else {
            cell7.setGraphic(new ImageView(imgO));
                         isX=true;
                        isEmpty[0]=false;

        }
        }
        }
    }

    @FXML
    private void cell8(MouseEvent event) {if(isEmpty[8]){
        {
        if(isX)   
        {
             cell8.setGraphic(new ImageView(imgX));
             isX=false;
             isEmpty[8]=false;
        }
        else {
            cell8.setGraphic(new ImageView(imgO));
                         isX=true;
                        isEmpty[8]=false;

        }
        }
        }
    }

    @Override
    public void run() {
        while (true) {            
            try {
                int position= dis.readInt();
                System.out.println("xocontroler "+position); 
                setImg();
            } catch (IOException ex) {
                Logger.getLogger(XOController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
    

    
}
