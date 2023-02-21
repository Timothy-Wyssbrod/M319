package com.example.cum;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private Label text;
    private final InputStream stream1 = new FileInputStream("C:\\GUIPics\\MarkSadge.jpg");
    private final InputStream stream2 = new FileInputStream("C:\\GUIPics\\MarkShock.jpg");
    private final Image mark1 = new Image(stream1);
    private final Image mark2 = new Image(stream2);
    @FXML
    private ImageView mark = new ImageView(mark1);

    public HelloController() throws FileNotFoundException {
        mark.setImage(mark2);
    }
    @FXML
    protected void onChangeButtonClick() throws FileNotFoundException {
        ImageView marker1 = new ImageView();
        ImageView marker2 = new ImageView();
        marker1.setImage(mark1);
        marker2.setImage(mark2);
        mark.setImage(mark1);
        if(mark.getImage().equals(mark1)){
            text.setText("WAS THAT THE BITE OF '87!?");
            mark.setImage(mark2);
        } else {
            text.setText("*crie*");
            mark.setImage(mark1);
        }
    }
}