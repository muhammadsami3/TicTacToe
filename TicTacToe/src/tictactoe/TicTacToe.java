/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Muhammad Sami
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       Parent root=FXMLLoader.load(getClass().getResource("Login_page.fxml"));
        Scene scene1 = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene1);
        
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
