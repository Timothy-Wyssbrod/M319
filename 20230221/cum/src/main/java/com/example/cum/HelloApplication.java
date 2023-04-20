package com.example.cum;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*creating the image object
        InputStream stream = new FileInputStream("C:\\GUIPics\\MarkSadge.jpg");
        Image image = new Image(stream);
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(575);
        imageView.setPreserveRatio(true);
        //Setting the Scene object
        Group root = new Group(imageView);
        Scene scene = new Scene(root, 595, 370);
        stage.setTitle("Displaying Image");
        stage.setScene(scene);
        stage.show();

         */
        /*FileInputStream stream1 = new FileInputStream("C:\\GUIPics\\MarkSadge.png");
        FileInputStream stream2 = new FileInputStream("C:\\GUIPics\\MarkShock.jpg");

        Image img1 = new Image(stream1);
        Image img2 = new Image(stream2);

         */

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Ass.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Cum Button");


        stage.setTitle("Cum Pisser");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}