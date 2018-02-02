/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
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
public class XOController implements Initializable {
    Image imgO=new Image(getClass().getResourceAsStream("o.png"));
    Image imgX=new Image(getClass().getResourceAsStream("x.png"));
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
    
    boolean isEmpty[]={true,true,true,true,true,true,true,true,true};
    Label labels[]={cell0,cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    public void computerTurn()
    {
        Random rand = new Random();
        int  n = rand.nextInt(9);
        while(isEmpty[n]==false )
        {
            n = rand.nextInt(9);
        }
        
        Label x=labels[n];
        x.setGraphic(new ImageView(imgX));
        isEmpty[n]=false;
        labels[n]=null;
       
    }

    boolean checkFull()
    {   
        int counter=0;
        for(int i=0;i<9;i++)
        {
            if (isEmpty[i]==false)
            {
                counter++; 
            }
        }
        if(counter==9){
            return true;
        }else
            return false;
    }

    private void cell0(MouseEvent event) {
        if(isEmpty[0])
        {
  
            cell0.setGraphic(new ImageView(imgO));
            isEmpty[0]=false;
           labels[0]=null;
           if(!checkFull()){computerTurn();}
            
        }
    }

    @FXML
    private void cell1(MouseEvent event)
{
        
        if(isEmpty[1])
        {
            cell1.setGraphic(new ImageView(imgO));
            isEmpty[1]=false;
            labels[1]=null;
            if(!checkFull()){computerTurn();}
        }
}


    @FXML

    private void cell2(MouseEvent event) {
       if(isEmpty[2])
        {
            cell1.setGraphic(new ImageView(imgO));
            isEmpty[2]=false;
            labels[2]=null;
            if(!checkFull())computerTurn();
    }
}

    @FXML
    private void cell3(MouseEvent event) {
        if(isEmpty[3])
        {
            cell1.setGraphic(new ImageView(imgO));
            isEmpty[3]=false;
            labels[3]=null;
            if(!checkFull())computerTurn();
    }
}

    private void cell4(MouseEvent event) {
       if(isEmpty[4])
        {
            cell1.setGraphic(new ImageView(imgO));
            isEmpty[4]=false;
            labels[4]=null;
            if(!checkFull())computerTurn();
    }
}

    @FXML


    private void cell5(MouseEvent event) {if(isEmpty[5])
        {
            cell1.setGraphic(new ImageView(imgO));
            isEmpty[5]=false;
            labels[5]=null;
            if(!checkFull())computerTurn();
    }
}

    private void cell6(MouseEvent event) {
        if(isEmpty[6])
        {
            cell1.setGraphic(new ImageView(imgO));
            isEmpty[6]=false;
            labels[6]=null;
            if(!checkFull())computerTurn();
    }
}
       private void cell7(MouseEvent event) {
        if(isEmpty[7])
        {
            cell1.setGraphic(new ImageView(imgO));
            isEmpty[7]=false;
            labels[7]=null;
            if(!checkFull())computerTurn();
    }
       }
    @FXML
    private void cell8(MouseEvent event){
        if(isEmpty[8])
        {
            cell1.setGraphic(new ImageView(imgO));
            isEmpty[8]=false;
            labels[8]=null;
            if(!checkFull())computerTurn();
    }

}
       }