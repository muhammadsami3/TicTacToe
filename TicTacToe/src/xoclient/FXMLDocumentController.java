/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Muhammad Sami
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button refreshBtn;
    @FXML
    private ListView<?> usersList;
    @FXML
    private Label errorLabel;
    @FXML
    private Button connectBtn;
    @FXML
    private Label selectedLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleRefreshButtonAction(MouseEvent event) {
    }

    @FXML
    private void handleMouseClicked(MouseEvent event) {
    }

    @FXML
    private void handleConnectBtnClicked(MouseEvent event) {
    }
    
}
