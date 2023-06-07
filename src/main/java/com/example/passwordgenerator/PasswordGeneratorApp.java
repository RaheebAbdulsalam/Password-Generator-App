package com.example.passwordgenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class PasswordGeneratorApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("password-generator.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Password Generator App");
        Image image = new Image("file:src/main/resources/icons.png");
        primaryStage.getIcons().add(image);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
