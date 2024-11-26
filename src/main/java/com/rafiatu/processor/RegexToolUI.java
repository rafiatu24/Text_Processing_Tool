package com.rafiatu.processor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A simple JavaFX application for performing regex matching and replacement
 * operations through a graphical user interface (GUI).
 */
public class RegexToolUI extends Application {

    /**
     * The main entry point for JavaFX applications.
     *
     * @param primaryStage The primary stage for this application.
     */
    @Override
    public void start(Stage primaryStage) {
        // TextField for input text
        TextField textInput = new TextField();
        textInput.setPromptText("Enter your text here"); // Placeholder text for user input

        // TextField for regex pattern input
        TextField regexInput = new TextField();
        regexInput.setPromptText("Enter your regex pattern"); // Placeholder for regex pattern

        // TextField for replacement text input
        TextField replacementInput = new TextField();
        replacementInput.setPromptText("Enter replacement text"); // Placeholder for replacement text

        // TextArea for displaying results
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false); // Make the output area read-only

        // Button for matching regex patterns
        Button matchButton = new Button("Match");
        matchButton.setOnAction(e -> {
            String text = textInput.getText();    // Get text from input field
            String regex = regexInput.getText(); // Get regex pattern
            outputArea.setText(RegexModule.matchPattern(text, regex)); // Display matching results
        });

        // Button for replacing text based on regex patterns
        Button replaceButton = new Button("Replace");
        replaceButton.setOnAction(e -> {
            String text = textInput.getText();         // Get text from input field
            String regex = regexInput.getText();       // Get regex pattern
            String replacement = replacementInput.getText(); // Get replacement text
            outputArea.setText(RegexModule.replaceWord(text, regex, replacement)); // Display replaced text
        });

        // Layout container for the UI components
        VBox layout = new VBox(10, textInput, regexInput, replacementInput, matchButton, replaceButton, outputArea);
        layout.setSpacing(10); // Set spacing between elements

        // Create a scene and set it on the primary stage
        Scene scene = new Scene(layout, 400, 300);

        // Configure the primary stage
        primaryStage.setTitle("Regex Tool"); // Set the title of the window
        primaryStage.setScene(scene);       // Set the scene to the stage
        primaryStage.show();                // Show the stage
    }

    /**
     * The main method launches the JavaFX application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
