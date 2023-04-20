package com.game.cool;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
    private final Stage stage = new Stage();
    @FXML
    private Label ass = new Label();
    private final InputStream stream1;

    {
        try {
            stream1 = new FileInputStream("C:\\GUIPics\\MarkSadge.jpg");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private final InputStream stream2;

    {
        try {
            stream2 = new FileInputStream("C:\\GUIPics\\MarkShock.jpg");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private final Image mark1 = new Image(stream1);
    private final Image mark2 = new Image(stream2);
    @FXML
    private ImageView mark = new ImageView(mark1);

    public Controller() throws FileNotFoundException {
        mark.setImage(mark2);
    }
    @FXML
    protected void onChangeButtonClick(){
        if(mark.getImage().equals(mark1)){
            ass.setText("WAS THAT THE BITE OF '87!?");
            mark.setImage(mark2);
        } else {
            ass.setText("*crie*");
            mark.setImage(mark1);
        }
    }
    @FXML
    protected void onStartGameClick(){
        Main.game();
    }

    @FXML
    protected void onSelectImageClick() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if(file.isFile()){
            ass.setText(file.getName());
            InputStream tempStream = new FileInputStream(file.getPath());
            Image tempImage = new Image(tempStream);
            mark.setImage(tempImage);
        }
    }
    @FXML
    protected void onDeleteButtonClick(){
        mark.setImage(null);
    }
    @FXML
    protected void onHelpButtonClick(){
        System.out.println("Fuck u");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText("About");
        alert.setContentText("Eat shit and die :)");

        alert.showAndWait();
    }
    @FXML
    protected void onCloseButtonClick(){
        System.exit(0);
    }
}