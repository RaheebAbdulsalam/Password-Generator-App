package com.example.passwordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.util.Random;

public class PasswordGeneratorController {

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button generateButton;

    @FXML
    private CheckBox eightCharCheckBox;

    @FXML
    private CheckBox tenCharCheckBox;

    @FXML
    private CheckBox twelveCharCheckBox;

    @FXML
    public void initialize() {
        generateButton.setOnAction(event -> generatePassword());
        copyButton.setOnAction(event -> copyPasswordToClipboard());
    }

    @FXML
    private Button copyButton;

    private void generatePassword() {
        int length;
        if (eightCharCheckBox.isSelected()) {
            length = 8;
            tenCharCheckBox.setSelected(false);
            twelveCharCheckBox.setSelected(false);
        } else if (tenCharCheckBox.isSelected()) {
            length = 10;
            eightCharCheckBox.setSelected(false);
            twelveCharCheckBox.setSelected(false);
        } else if (twelveCharCheckBox.isSelected()) {
            length = 12;
            eightCharCheckBox.setSelected(false);
            tenCharCheckBox.setSelected(false);
        } else {
            // Default length if no checkbox is selected
            length = 10;
        }

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[{]};:',<.>/?";
        StringBuilder password = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        passwordTextField.setText(password.toString());
    }


    private void copyPasswordToClipboard() {
        String password = passwordTextField.getText();
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(password);
        clipboard.setContent(content);
    }
}
