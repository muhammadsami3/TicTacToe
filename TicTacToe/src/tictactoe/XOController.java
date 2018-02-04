/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import com.sun.javafx.scene.control.skin.LabeledText;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import static tictactoe.Login_pageController.dis;
import static tictactoe.Login_pageController.ps;


/**
 * FXML Controller class
 *
 * @author maryam
 */
public class XOController implements Initializable ,Runnable{

   
    Thread th;
      

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
    @FXML
    private GridPane grid;
      ArrayList labels=new ArrayList();
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ps.println("game");
        th = new Thread(this);
        th.start();
        labels.add(cell0);
        labels.add(cell1);
        labels.add(cell2);
        labels.add(cell3);
        labels.add(cell4);
        labels.add(cell5);
        labels.add(cell6);
        labels.add(cell7);
        labels.add(cell8);
        
         
    }    

    @FXML
    private void cell0(MouseEvent event) {
         ps.println("0");
    }

    public  void setImg(int position){
        
        if(isEmpty[position]){
        {
        if(isX)   
        {
             Label x =(Label)labels.get(position);
             x.setGraphic(new ImageView(imgX));
             isX=false;
             isEmpty[position]=false;
             
        }
        else {
            cell1.setGraphic(new ImageView(imgO));
                         isX=true;
                        isEmpty[position]=false;

        }
        }
        }
    
    }
    
    @FXML
    private void cell1(MouseEvent event) throws IOException {
        
        ps.println("1");
        
    }

    @FXML
    private void cell2(MouseEvent event) {
         ps.println("2");
    }

    @FXML
    private void cell3(MouseEvent event) { 
        ps.println("3");
    }

    @FXML
    private void cell4(MouseEvent event) { ps.println("4");
    }

    @FXML
    private void cell5(MouseEvent event) { ps.println("5");
    }

    @FXML
    private void cell6(MouseEvent event) { ps.println("6");
    }

    @FXML
    private void cell7(MouseEvent event) { ps.println("7");
    }

    @FXML
    private void cell8(MouseEvent event) { ps.println("8");
    }

    @Override
    public void run() {
        while (true) {            
            try {
                
                String temp= dis.readLine();
                int position=Integer.parseInt(temp);
                System.out.println("xocontroler "+position); 
                
                
                Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            
                            setImg(position);
                            
                        }
                    });
                
             
            } catch (IOException ex) {
                Logger.getLogger(XOController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
    

    
}
