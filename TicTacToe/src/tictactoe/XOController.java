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

/**
 * FXML Controller class
 *
 * @author maryam
 */
public class XOController implements Initializable {

    @FXML
    private Label cell0;
    @FXML
    private Label cell6;
    @FXML
    private Label cell1;
    @FXML
    private Label cell3;
    @FXML
    private Label cell4;
    @FXML
    private Label cell7;
    @FXML
    private Label cell5;
    @FXML
    private Label cell8;
    Image image = new Image(getClass().getResourceAsStream("test1.png"));
    Image computer = new Image(getClass().getResourceAsStream("comp.png"));
    
    boolean isEmpty[]={true,true,true,true,true,true,true,true,true};
    //ArrayList isEmpty = new ArrayList();
    
    ArrayList obj = new ArrayList();
    @FXML
    private Label cell2;
    

  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    @FXML
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
    private void cell00(MouseEvent event) {
        if(isEmpty[0])
        {
          
            obj.add(cell0);
            obj.add(cell1);
            obj.add(cell2);
            obj.add(cell3);
            obj.add(cell4);
            obj.add(cell5);
            obj.add(cell6);
            obj.add(cell7);
            obj.add(cell8);
            cell0.setGraphic(new ImageView(image));
            isEmpty[0]=false;
            //obj.remove(cell0);
            obj.set(0,null);
           // computerTurn();
           if(!checkFull()){computerTurn();}
            
        }
        
    }

    @FXML
    private void cell02(MouseEvent event) {
        
        if(isEmpty[6])
        {
            cell6.setGraphic(new ImageView(image));
            isEmpty[6]=false;
            //obj.remove(cell6);
            obj.set(6,null);
            if(!checkFull())computerTurn();
            //computerTurn();
        }
    }

    @FXML
    private void cell10(MouseEvent event) {
        if(isEmpty[1])
        {
            cell1.setGraphic(new ImageView(image));
            isEmpty[1]=false;
           // obj.remove(cell1);
           obj.set(1,null);
            //computerTurn();
            if(!checkFull())computerTurn();
        }
    }

    @FXML
    private void cell01(MouseEvent event) {
        if(isEmpty[3])
        {
            cell3.setGraphic(new ImageView(image));
            isEmpty[3]=false;
            //obj.remove(cell3);
            obj.set(3,null);
           // computerTurn();
            if(!checkFull())computerTurn();
        }
    }

    @FXML
    private void cell11(MouseEvent event) {
        if(isEmpty[4])
        {
            cell4.setGraphic(new ImageView(image));
            isEmpty[4]=false;
            //obj.remove(cell4);
            obj.set(4,null);
            //computerTurn();
            if(!checkFull())computerTurn();
        }
    }

    @FXML
    private void cell12(MouseEvent event) {
        if(isEmpty[7])
        {
            cell7.setGraphic(new ImageView(image));
            isEmpty[7]=false;
            //obj.remove(cell7);
            obj.set(7,null);
            //computerTurn();
            if(!checkFull())computerTurn();
        }
    }

    @FXML
    private void cell20(MouseEvent event) {
        if(isEmpty[2])
        {
            cell2.setGraphic(new ImageView(image));
            isEmpty[2]=false;
            //obj.remove(cell2);
            obj.set(2,null);
           // computerTurn();
           if(!checkFull())computerTurn();
        }
    }

    @FXML
    private void cell21(MouseEvent event) {
        if(isEmpty[5])
        {
            cell5.setGraphic(new ImageView(image));
            isEmpty[5]=false;
            //obj.remove(cell5);
            obj.set(5,null);
            //computerTurn();
            if(!checkFull()){computerTurn();}
        }
    }

    @FXML
    private void cell22(MouseEvent event) {
        if(isEmpty[8])
        {
            cell8.setGraphic(new ImageView(image));
            isEmpty[8]=false;
            //obj.remove(cell8);
            obj.set(8,null);
           // computerTurn();
           if(!checkFull())
           {computerTurn();}
        }
    }
 
    public void computerTurn()
    {
        Random rand = new Random();
        //int z=9;
        int  n = rand.nextInt(9);
        while(isEmpty[n]==false )
        {
            n = rand.nextInt(9);
        }
        
        Label x=(Label)obj.get(n);
        x.setGraphic(new ImageView(computer));
        isEmpty[n]=false;
        obj.set(n,null);
        //obj.remove(x);
        //z--;
       
    }
}
