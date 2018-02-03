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
import javax.swing.JOptionPane;

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
    //Label labels[]={cell0,cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8};
    ArrayList label=new ArrayList();
    int[][] wins = new int[][] 
        { { 0, 1, 2 },
        { 3, 4, 5 }, 
        { 6, 7, 8 }, 
        { 0, 3, 6 }, 
        { 1, 4, 7 }, 
        { 2, 5, 8 }, 
        { 0, 4, 8 }, 
        { 2, 4, 6 } };
    String[] xo = new String[9];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initial();
        
    }    
    void initial()
    {
        label.add(cell0);
        label.add(cell1);
        label.add(cell2);
        label.add(cell3);
        label.add(cell4);
        label.add(cell5);
        label.add(cell6);
        label.add(cell7);
        label.add(cell8);
        
        
    }
   
    public void computerTurn()
    {
        Random rand = new Random();
        int  n = rand.nextInt(9);
        while(isEmpty[n]==false )
        {
            n = rand.nextInt(9);
        }
        
        Label x=(Label)label.get(n);
        x.setGraphic(new ImageView(imgX));
        isEmpty[n]=false;
        xo[n]="x";
       
    }

    boolean checkFull()
    {   
        boolean c=false;
        int counter=0;
        for(int i=0;i<9;i++)
        {
            if (isEmpty[i]==false)
            {
                counter++;
                
            }
        }
        if(counter>=8){
            c= true;
        }
        return c;
    }

   /* private void cell0(MouseEvent event) {
        if(isEmpty[0])
        {
  
            cell0.setGraphic(new ImageView(imgO));
            isEmpty[0]=false;
           labels[0]=null;
           if(!checkFull()){computerTurn();}
            
        }
    }*/

    @FXML
    private void cell1(MouseEvent event)
{
        
        if(isEmpty[1]&&!(
                (checkForCompWin())||(checkForWin())
                ))
        {
            cell1.setGraphic(new ImageView(imgO));
            isEmpty[1]=false;
            xo[1]="o";
            //label.set(1,null);
            //computerTurn();
             if(!(checkFull())&&!checkForWin()){computerTurn();}
        }
}


    @FXML

    private void cell2(MouseEvent event) {
       if(isEmpty[2]&&!(
                (checkForCompWin())||(checkForWin())
                ))
        {
            cell2.setGraphic(new ImageView(imgO));
            isEmpty[2]=false;
            xo[2]="o";
            //label.set(2,null);
             if(!(checkFull())&&!checkForWin())computerTurn();
    }
}

    @FXML
    private void cell3(MouseEvent event) {
        if(isEmpty[3]&&!(
                (checkForCompWin())||(checkForWin())
                ))
        {
            cell3.setGraphic(new ImageView(imgO));
            isEmpty[3]=false;
            xo[3]="o";
            //label.set(3,null);
             if(!(checkFull())&&!checkForWin())computerTurn();
    }
}

    @FXML
    private void cell4(MouseEvent event) {
       if(isEmpty[4]&&!(
                (checkForCompWin())||(checkForWin())
                ))
        {
            cell4.setGraphic(new ImageView(imgO));
            isEmpty[4]=false;
            xo[4]="o";
           // label.set(4,null);
             if(!(checkFull())&&!checkForWin())computerTurn();
    }
}

    @FXML


    private void cell5(MouseEvent event) {if(isEmpty[5]&&!(
                (checkForCompWin())||(checkForWin())
                ))
        {
            cell5.setGraphic(new ImageView(imgO));
            isEmpty[5]=false;
            xo[5]="o";
           // label.set(5,null);
            if(!(checkFull())&&!checkForWin())
            {computerTurn();}
    }
}

    @FXML
    private void cell6(MouseEvent event) {
        if(isEmpty[6]&&!(
                (checkForCompWin())||(checkForWin())
                ))
        {
            cell6.setGraphic(new ImageView(imgO));
            xo[6]="o";
            isEmpty[6]=false;
          //  label.set(6,null);
              if(!(checkFull())&&!checkForWin())computerTurn();
    }
}
    @FXML
       private void cell7(MouseEvent event) {
        if(isEmpty[7]&&!(
                (checkForCompWin())||(checkForWin())
                ))
        {
            cell7.setGraphic(new ImageView(imgO));
            xo[7]="o";
            isEmpty[7]=false;
           // label.set(7,null);
            if(!checkFull()&&!checkForWin())
            {computerTurn();}
    }
       }
    @FXML
    private void cell8(MouseEvent event){
        if(isEmpty[8]&&!(
                (checkForCompWin())||(checkForWin())
                ))
        {
            cell8.setGraphic(new ImageView(imgO));
            isEmpty[8]=false;
            xo[8]="o";
           // label.set(8,null);
            if(!checkFull()&&!checkForWin())computerTurn();
    }

}

    @FXML
    private void Cell0(MouseEvent event) {
        if(isEmpty[0]&&!(
                (checkForCompWin())||(checkForWin())
                ))
        {
  
            cell0.setGraphic(new ImageView(imgO));
            isEmpty[0]=false;
            xo[0]="o";
           //label.set(0,null);
           if(!(checkFull())&&!checkForWin())
           {computerTurn();}
            
        }
    }
    boolean checkForWin() {
        boolean z=false;
        for (int i = 0; i < wins.length; i++) {

            if (xo[wins[i][0]]=="o" && xo[wins[i][1]]=="o" && xo[wins[i][2]]=="o") {
                    z=true;
                    // int input1 = JOptionPane.showConfirmDialog(null, "ANA WINS");
            }
             

        }return z;
    }

    boolean checkForCompWin() {
        boolean z=false;
        for (int i = 0; i < wins.length; i++) {
            if (xo[wins[i][0]]=="x" && xo[wins[i][1]]=="x" && xo[wins[i][2]]=="x") {
               // int input1 = JOptionPane.showConfirmDialog(null, "COMPUTER WINS");
                    z=true;   }
        } return z;

    }
    
}
	
       