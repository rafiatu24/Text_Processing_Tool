package com.rafiatu.processor;

import java.util.regex.*;

// A utility class for performing regex operations
public class RegexModule {

    /**
     * Finds and returns all matches of a given regex pattern in a text.
     *
     * @param text The input text to search.
     * @param regex The regex pattern to match.
     * @return A string containing all matches or a message if no matches are found.
     */
    public static String matchPattern(String text, String regex) {
        Pattern pattern = Pattern.compile(regex); // Compile the regex pattern
        Matcher matcher = pattern.matcher(text);  // Match the pattern against the text
        StringBuilder results = new StringBuilder();

        // Iterate through all matches and collect them
        while (matcher.find()) {
            results.append("Match found: ").append(matcher.group()).append("\n");
        }

        // Return results or a message if no matches are found
        return !results.isEmpty() ? results.toString() : "No matches found.";
    }

    /**
     * Attempts to replace occurrences of a regex pattern in the text with a replacement.
     * (This method currently has a bug because `word.replaceFirst()` does not modify `word` in-place.)
     *
     * @param text The input text to process.
     * @param regex The regex pattern to replace.
     * @param replacement The replacement string.
     * @return The text with replacements applied.
     */
    public static String replaceText(String text, String regex, String replacement) {
        // Attempt to replace each word matching the regex
        for (String word : text.split(" ")) {
            word.replaceFirst(regex, replacement); // This does nothing because `word` is immutable
        }
        return text;

        // A simpler and correct implementation would be:
        // return text.replaceAll(regex, replacement);
    }

    /**
     * Replaces occurrences of a regex pattern in individual words within the text.
     *
     * @param text The input text to process.
     * @param regex The regex pattern to match within each word.
     * @param replacement The replacement string.
     * @return The text with replacements applied on individual words.
     */
    public static String replaceWord(String text, String regex, String replacement) {
        StringBuilder builder = new StringBuilder();

        // Split the text into words, apply replacements, and rebuild the string
        for (String word : text.split(" ")) {
            builder.append(word.replaceFirst(regex, replacement)).append(" ");
        }

        // Return the updated string
        return builder.toString();
    }

    /**
     * Main method to test the functionality of the regex utilities.
     */
    public static void main(String[] args) {
        // Sample input text and regex pattern
        String text = "Hello bye hello bye hello byE.";
        String regex = ".*llo"; // Matches words ending with "llo"

        // Test matching functionality
        System.out.println(matchPattern(text, regex));

        // Test word replacement functionality
        System.out.println(replaceWord(text, regex, "###"));
    }
}
