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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Muhammad Sami
 */
public class Login_pageController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

  
    @FXML
    private void signUp(MouseEvent event) throws IOException {
                if(!uname.getText().trim().isEmpty() && !passwd.getText().trim().isEmpty()  )
                {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        
        rootPane.getChildren().setAll(pane);
                }

    }

    @FXML
    private void login(MouseEvent event)  throws IOException{
          if(!uname.getText().trim().isEmpty() && !passwd.getText().trim().isEmpty())
        {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        rootPane.getChildren().setAll(pane);
        }
    }

}
