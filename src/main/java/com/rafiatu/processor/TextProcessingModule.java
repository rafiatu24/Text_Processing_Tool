package com.rafiatu.processor;

// Importing the RegexModule to utilize its functionality
import com.rafiatu.processor.RegexModule;

/**
 * A module for processing text using regex-based operations.
 */
public class TextProcessingModule {

    /**
     * Processes the given text by applying regex matching and replacement operations.
     *
     * @param text        The input text to process.
     * @param regex       The regex pattern to use for matching and replacement.
     * @param replacement The replacement string to use for substitutions.
     */
    public static void processText(String text, String regex, String replacement) {
        // Display the original input text
        System.out.println("Original Text:\n" + text);

        // Perform regex matching and display the results
        System.out.println("\nRegex Results:");
        System.out.println(RegexModule.matchPattern(text, regex));

        // Perform text replacement and display the modified text
        System.out.println("\nReplaced Text:");
        System.out.println(RegexModule.replaceText(text, regex, replacement));
    }


    public static void main(String[] args) {
        // Input text, regex pattern, and replacement string
        String text = "Processing data is fun!";  // Sample text to process
        String regex = "data";                    // Regex pattern to match the word "data"
        String replacement = "text";              // Replacement for the matched pattern

        // Call the method to process the text
        processText(text, regex, replacement);
    }
}
