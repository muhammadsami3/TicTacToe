/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Muhammad Sami
 */
public class MainpageController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private GridPane gridpane1;
    @FXML
    private Button single_player_btn;
    @FXML
    private Button two_player_btn;
    @FXML
    private Button go_online_btn;
    @FXML
    private Button play_record_btn;
    @FXML
    private Button return_btn;
    @FXML
    private CheckBox record_check;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void single(MouseEvent event) throws IOException{
         AnchorPane pane = FXMLLoader.load(getClass().getResource("XO.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void GoOnline(MouseEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("XO.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void twoPlayers(MouseEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("XO.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void playRecord(MouseEvent event) throws IOException {
       record_check.isSelected();
//Gets the value of the property selected
    }

    @FXML
    private void returnToLogin(MouseEvent event) throws IOException{
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Login_page.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
}
