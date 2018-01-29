package tictactoe;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public  class mainpageBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final RowConstraints rowConstraints6;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final CheckBox checkBox;

    public mainpageBase() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        checkBox = new CheckBox();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(191.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(181.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(213.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(213.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(100.0);
        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(100.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMaxHeight(74.0);
        rowConstraints6.setMinHeight(0.0);
        rowConstraints6.setPrefHeight(0.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(button, 1);
        GridPane.setRowIndex(button, 1);
        button.setContentDisplay(javafx.scene.control.ContentDisplay.TEXT_ONLY);
        button.setId("");
        button.setMinWidth(162.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(44.0);
        button.setPrefWidth(200.0);
        button.setText("Single Player");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#4711bc"));
        button.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        button.setFont(new Font("Impact", 22.0));
        button.setCursor(Cursor.HAND);

        GridPane.setColumnIndex(button0, 1);
        GridPane.setRowIndex(button0, 3);
        button0.setContentDisplay(javafx.scene.control.ContentDisplay.TEXT_ONLY);
        button0.setId("");
        button0.setLayoutX(201.0);
        button0.setLayoutY(132.0);
        button0.setMinWidth(162.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(44.0);
        button0.setPrefWidth(200.0);
        button0.setText("Go Online");
        button0.setTextFill(javafx.scene.paint.Color.valueOf("#4711bc"));
        button0.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        button0.setFont(new Font("Informal Roman", 22.0));
        button0.setCursor(Cursor.OPEN_HAND);

        GridPane.setColumnIndex(button1, 1);
        GridPane.setRowIndex(button1, 2);
        button1.setContentDisplay(javafx.scene.control.ContentDisplay.TEXT_ONLY);
        button1.setId("");
        button1.setLayoutX(10.0);
        button1.setLayoutY(17.0);
        button1.setMinWidth(162.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(44.0);
        button1.setPrefWidth(200.0);
        button1.setText("Two Players");
        button1.setTextFill(javafx.scene.paint.Color.valueOf("#4711bc"));
        button1.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        button1.setFont(new Font("Informal Roman", 22.0));
        button1.setCursor(Cursor.HAND);

        GridPane.setColumnIndex(button2, 1);
        GridPane.setRowIndex(button2, 4);
        button2.setContentDisplay(javafx.scene.control.ContentDisplay.TEXT_ONLY);
        button2.setId("");
        button2.setMinWidth(162.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(44.0);
        button2.setPrefWidth(200.0);
        button2.setText("Play Record");
        button2.setTextFill(javafx.scene.paint.Color.valueOf("#4711bc"));
        button2.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        button2.setFont(new Font("Informal Roman", 22.0));
        button2.setCursor(Cursor.HAND);

        GridPane.setColumnIndex(button3, 1);
        GridPane.setRowIndex(button3, 6);
        button3.setContentDisplay(javafx.scene.control.ContentDisplay.TEXT_ONLY);
        button3.setId("");
        button3.setMinWidth(162.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(44.0);
        button3.setPrefWidth(200.0);
        button3.setText("Return");
        button3.setTextFill(javafx.scene.paint.Color.valueOf("#4d00ff"));
        button3.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        button3.setFont(new Font("Informal Roman", 22.0));
        button3.setCursor(Cursor.CLOSED_HAND);

        GridPane.setColumnIndex(checkBox, 1);
        GridPane.setRowIndex(checkBox, 5);
        checkBox.setMnemonicParsing(false);
        checkBox.setText("Record The session");
        checkBox.setTextFill(javafx.scene.paint.Color.valueOf("#0213ff"));
        checkBox.setFont(new Font("Informal Roman", 21.0));
        setPadding(new Insets(0.0, 10.0, 0.0, 0.0));

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getRowConstraints().add(rowConstraints3);
        getRowConstraints().add(rowConstraints4);
        getRowConstraints().add(rowConstraints5);
        getRowConstraints().add(rowConstraints6);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);
        getChildren().add(button2);
        getChildren().add(button3);
        getChildren().add(checkBox);

    }
}
