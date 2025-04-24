package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the story file: ");
        System.out.println("Goldilocks (goldilocks.txt)");
        System.out.println("Mary had a Little Lamb (mary_had_a_little_lamb.txt)");
        System.out.println("Hansel and Gretel (hansel_and_gretel.txt.)");
        String filename = input.nextLine();

        File storyFile = new File(filename);

        try {
            Scanner fileScanner = new Scanner(storyFile);
            int lineNumber = 1;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the file '" + filename + "' was not found.");
        }
    }
}
