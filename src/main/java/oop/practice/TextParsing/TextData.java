package oop.practice.TextParsing;

public class TextData {
    private final String fileName;
    private final String text;
    private String longestWord;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;

    TextData(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
        analyzeText();
    }

    private void analyzeText() {
        String[] words = text.split("\\s+");
        numberOfSentences = text.split("[.!?]").length;
        numberOfVowels = 0;
        numberOfConsonants = 0;
        numberOfLetters = 0;
        longestWord = "";

        for (char c: text.toCharArray()) {
            if (Character.isLetter(c)) {
                numberOfLetters++;
                if ("AEIOUaeiou".indexOf(c) != -1) {
                    numberOfVowels++;
                } else {
                    numberOfConsonants++;
                }
            }
        }

        for (String word: words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
    }

    @Override
    public String toString() {
        return "File: " + fileName + "\n" +
                "Text: " + text + "\n" +
                "Number of Vowels: " + numberOfVowels + "\n" +
                "Number of Consonants: " + numberOfConsonants + "\n" +
                "Number of Letters: " + numberOfLetters + "\n" +
                "Number of Sentences: " + numberOfSentences + "\n" +
                "Longest Word: " + longestWord;
    }
}
