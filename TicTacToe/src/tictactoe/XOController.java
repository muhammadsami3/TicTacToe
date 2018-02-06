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
import static tictactoe.Login_pageController.loginname;
import static tictactoe.Login_pageController.ps;

/**
 * FXML Controller class
 *
 * @author maryam
 */
public class XOController implements Initializable, Runnable {

    Thread th;

    Image imgO = new Image(getClass().getResourceAsStream("o.png"));
    Image imgX = new Image(getClass().getResourceAsStream("x.png"));
    //Image display=imgX;
    boolean isX = true;
    boolean isEmpty[] = {true, true, true, true, true, true, true, true, true};

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
    ArrayList labels = new ArrayList();
    String myname;
    public boolean continuePlying;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ps.println("game");
        System.out.println("game");
//        ps.println(Login_pageController.loginname);
//        ps.println();
//        myname = Login_pageController.loginname;
        
        
        continuePlying = true;
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

    String player = "x";

    public void setImg(int position) {
        System.out.println("Change Image");

        Label x = (Label) labels.get(position);
        if (isEmpty[position]) {
            {
                if (isX) {
                    System.out.println(position);
                    x.setGraphic(new ImageView(imgX));
                    isX = false;
                    isEmpty[position] = false;

                } else {
                    x.setGraphic(new ImageView(imgO));
                    isX = true;
                    isEmpty[position] = false;

                }
            }
        }

    }

    int localCllID = -1;

    @FXML
    private void cell0(MouseEvent event) {

        if (continuePlying) {
            ps.println(" 0");
            localCllID = 0;
            continuePlying = false;
        }
    }

    @FXML
    private void cell1(MouseEvent event) throws IOException {

        if (continuePlying) {
            ps.println(" 1");
            localCllID = 1;
            continuePlying = false;
        }
    }

    @FXML
    private void cell2(MouseEvent event) {

        if (continuePlying) {
            localCllID = 2;
            ps.println(" 2");

            continuePlying = false;
        }

    }

    @FXML
    private void cell3(MouseEvent event) {

        if (continuePlying) {
            ps.println(" 3");
            continuePlying = false;
            localCllID = 3;
        }
    }

    @FXML
    private void cell4(MouseEvent event) {

        if (continuePlying) {
            ps.println(" 4");
            continuePlying = false;
            localCllID = 4;
        }
    }

    @FXML
    private void cell5(MouseEvent event) {

        if (continuePlying) {
            localCllID = 5;
            ps.println(" 5");
            continuePlying = false;
        }

    }

    @FXML
    private void cell6(MouseEvent event) {

        if (continuePlying) {
            ps.println(" 6");
            continuePlying = false;
            localCllID = 6;
        }

    }

    @FXML
    private void cell7(MouseEvent event) {

        if (continuePlying) {
            ps.println(" 7");
            continuePlying = false;
            localCllID = 7;
        }
    }

    @FXML
    private void cell8(MouseEvent event) {

        if (continuePlying) {
            ps.println(" 8");
            localCllID = 8;
            continuePlying = false;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {

                System.out.println("runnnnnnnnnnnnnnnnnnnnn");
              String player1 = dis.readLine().trim();
               String player2 = dis.readLine().trim();
                 String temp = dis.readLine().trim();
                 
                    System.out.println("position at "+loginname+" = "+temp);

                   
             System.out.println("1p "+player1+" 2p "+player2);
                
                if (loginname.equals(player1) || loginname.equals(player2)) {

                      System.out.println("only 2");
                   
                      
                    int position = Integer.parseInt(temp);
                    if (position != localCllID) {
                        continuePlying = true;
                    } else {
                        continuePlying = false;
                    }

                    System.out.println("tictactoe.XOController.run(),LoclId=" + localCllID + ",Postion=" + position);
                    Platform.runLater(() -> {
                        System.out.println("xocontroler " + position);
                        setImg(position);
                    });
                                }
            } catch (IOException ex) {
                System.out.println("null");
                Logger.getLogger(XOController.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }

}
