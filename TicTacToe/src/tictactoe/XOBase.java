package tictactoe;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public abstract class XOBase extends AnchorPane {

    protected final ImageView imageView;
    protected final GridPane gridPane;
    protected final Label cell0;
    protected final Label cell1;
    protected final Label cell2;
    protected final Label cell3;
    protected final Label cell4;
    protected final Label cell5;
    protected final Label cell6;
    protected final Label cell7;
    protected final Label cell8;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;

    public XOBase() {

        imageView = new ImageView();
        gridPane = new GridPane();
        cell0 = new Label();
        cell1 = new Label();
        cell2 = new Label();
        cell3 = new Label();
        cell4 = new Label();
        cell5 = new Label();
        cell6 = new Label();
        cell7 = new Label();
        cell8 = new Label();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(620.0);

        imageView.setFitHeight(400.0);
        imageView.setFitWidth(621.0);
        imageView.setImage(new Image(getClass().getResource("bg.jpg").toExternalForm()));

        gridPane.setLayoutX(1.0);
        gridPane.setPrefHeight(400.0);
        gridPane.setPrefWidth(620.0);

        cell0.setAlignment(javafx.geometry.Pos.CENTER);
        cell0.setOnMouseClicked(this::cell0);
        cell0.setPrefHeight(133.0);
        cell0.setPrefWidth(207.0);
        cell0.setFont(new Font("Microsoft Sans Serif", 60.0));

        GridPane.setColumnIndex(cell1, 1);
        cell1.setAlignment(javafx.geometry.Pos.CENTER);
        cell1.setOnMouseClicked(this::cell1);
        cell1.setPrefHeight(133.0);
        cell1.setPrefWidth(207.0);
        cell1.setFont(new Font("Microsoft Sans Serif", 60.0));

        GridPane.setColumnIndex(cell2, 2);
        cell2.setAlignment(javafx.geometry.Pos.CENTER);
        cell2.setOnMouseClicked(this::cell2);
        cell2.setPrefHeight(133.0);
        cell2.setPrefWidth(207.0);
        cell2.setFont(new Font("Microsoft Sans Serif", 60.0));

        GridPane.setRowIndex(cell3, 1);
        cell3.setAlignment(javafx.geometry.Pos.CENTER);
        cell3.setOnMouseClicked(this::cell3);
        cell3.setPrefHeight(133.0);
        cell3.setPrefWidth(207.0);
        cell3.setFont(new Font("Microsoft Sans Serif", 60.0));

        GridPane.setColumnIndex(cell4, 1);
        GridPane.setRowIndex(cell4, 1);
        cell4.setAlignment(javafx.geometry.Pos.CENTER);
        cell4.setOnMouseClicked(this::cell4);
        cell4.setPrefHeight(133.0);
        cell4.setPrefWidth(207.0);
        cell4.setFont(new Font("Microsoft Sans Serif", 60.0));

        GridPane.setColumnIndex(cell5, 2);
        GridPane.setRowIndex(cell5, 1);
        cell5.setAlignment(javafx.geometry.Pos.CENTER);
        cell5.setOnMouseClicked(this::cell5);
        cell5.setPrefHeight(133.0);
        cell5.setPrefWidth(207.0);
        cell5.setFont(new Font("Microsoft Sans Serif", 60.0));

        GridPane.setRowIndex(cell6, 2);
        cell6.setAlignment(javafx.geometry.Pos.CENTER);
        cell6.setOnMouseClicked(this::cell6);
        cell6.setPrefHeight(133.0);
        cell6.setPrefWidth(207.0);
        cell6.setFont(new Font("Microsoft Sans Serif", 60.0));

        GridPane.setColumnIndex(cell7, 1);
        GridPane.setRowIndex(cell7, 2);
        cell7.setAlignment(javafx.geometry.Pos.CENTER);
        cell7.setOnMouseClicked(this::cell7);
        cell7.setPrefHeight(133.0);
        cell7.setPrefWidth(207.0);
        cell7.setFont(new Font("Microsoft Sans Serif", 60.0));

        GridPane.setColumnIndex(cell8, 2);
        GridPane.setRowIndex(cell8, 2);
        cell8.setAlignment(javafx.geometry.Pos.CENTER);
        cell8.setOnMouseClicked(this::cell8);
        cell8.setPrefHeight(133.0);
        cell8.setPrefWidth(207.0);
        cell8.setFont(new Font("Microsoft Sans Serif", 60.0));

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

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

        getChildren().add(imageView);
        gridPane.getChildren().add(cell0);
        gridPane.getChildren().add(cell1);
        gridPane.getChildren().add(cell2);
        gridPane.getChildren().add(cell3);
        gridPane.getChildren().add(cell4);
        gridPane.getChildren().add(cell5);
        gridPane.getChildren().add(cell6);
        gridPane.getChildren().add(cell7);
        gridPane.getChildren().add(cell8);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        getChildren().add(gridPane);

    }

    protected abstract void cell0(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void cell1(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void cell2(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void cell3(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void cell4(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void cell5(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void cell6(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void cell7(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void cell8(javafx.scene.input.MouseEvent mouseEvent);

}
