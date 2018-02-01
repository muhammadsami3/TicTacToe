package tictactoe;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public  class Login extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final Button button;
    protected final Button button0;
    protected final TextField textField;
    protected final TextField textField0;

    public Login() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        button = new Button();
        button0 = new Button();
        textField = new TextField();
        textField0 = new TextField();

        setFocusTraversable(true);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(294.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(195.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(405.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(242.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(405.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(208.0);

        rowConstraints.setMaxHeight(125.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(92.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(175.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(65.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(152.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(84.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(155.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(12.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(155.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(125.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(182.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(87.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Welcome");
        text.setWrappingWidth(238.13671875);
        GridPane.setMargin(text, new Insets(10.0, 10.0, 10.0, 30.0));
        text.setFont(new Font(35.0));

        GridPane.setRowIndex(text0, 1);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("User Name");
        text0.setWrappingWidth(151.13671875);
        GridPane.setMargin(text0, new Insets(0.0, 0.0, 0.0, 30.0));
        text0.setFont(new Font(18.0));

        GridPane.setRowIndex(text1, 2);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Password");
        text1.setWrappingWidth(184.13671875);
        GridPane.setMargin(text1, new Insets(0.0, 0.0, 0.0, 30.0));
        text1.setFont(new Font(18.0));

        GridPane.setRowIndex(button, 4);
        button.setMnemonicParsing(false);
        button.setText("Login");
        GridPane.setMargin(button, new Insets(0.0, 0.0, 0.0, 30.0));
        button.setFont(new Font(15.0));

        GridPane.setColumnIndex(button0, 1);
        GridPane.setRowIndex(button0, 4);
        button0.setMnemonicParsing(false);
        button0.setText("Sign Up");
        GridPane.setMargin(button0, new Insets(0.0));
        button0.setFont(new Font(15.0));

        GridPane.setColumnIndex(textField, 1);
        GridPane.setRowIndex(textField, 1);
        textField.setMinHeight(25.0);
        textField.setMinWidth(100.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(100.0);

        GridPane.setColumnIndex(textField0, 1);
        GridPane.setRowIndex(textField0, 2);

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getRowConstraints().add(rowConstraints3);
        getRowConstraints().add(rowConstraints4);
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(text1);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(textField);
        getChildren().add(textField0);

    }
} 
