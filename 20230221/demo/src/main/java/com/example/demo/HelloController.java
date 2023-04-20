package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label bottomText;
    @FXML
    ImageView imageView = new ImageView();

    /*FileInputStream stream1 = new FileInputStream("C:\\GUIPics\\MarkSadge.png");
    FileInputStream stream2 = new FileInputStream("C:\\GUIPics\\MarkShock.jpg");

    Image img1 = new Image(stream1);
    Image img2 = new Image(stream2);

    public HelloController() throws FileNotFoundException {
    }

     */


    @FXML
    protected void onCumButtonClick() {
        welcomeText.setText("Cum");
        bottomText.setText("Cum");
        /*Setting image to the image view
        imageView.setImage(img1);
        //Setting the image view parameters
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(575);
        imageView.setPreserveRatio(true);
        */
    }
    @FXML
    protected void onPissButtonClick() {
        welcomeText.setText("Piss");
        bottomText.setText("Piss");
        //Setting image to the image view
        /*imageView.setImage(img2);
        //Setting the image view parameters
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(575);
        imageView.setPreserveRatio(true);
        */

    }
}