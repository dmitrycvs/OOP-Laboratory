package oop.practice.TextParsing;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the path to the .txt file as a command-line argument.");
            return;
        }
        for (String arg : args) {
            try {
                String textContent = FileReader.readFileIntoString(arg);
                TextData textData = new TextData(arg, textContent);
                System.out.println(textData);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
