package Mastermind;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<String[]> guesses = new ArrayList<>();
    private final List<String> allFeedback = new ArrayList<>();

    void addGuess(String[] guess) {
        guesses.add(guess);
    }

    void addFeedback(String feedback) {
        allFeedback.add(feedback);
    }

    void print() {
        System.out.println("White Peg = Right Colour, Wrong Place");
        System.out.println("Black Peg = Right Colour, Right Place");
        System.out.println();
        System.out.printf("%s%n", "==================================================================================");
        System.out.printf("%s %-7s %s %-8s %s %-8s %s %-8s %s %-8s %s %-24s %s%n", "|", "Guess #", "|", "Colour 1", "|", "Colour 2", "|", "Colour 3", "|", "Colour 4", "|", "Feedback", "|");
        System.out.printf("%s%n", "==================================================================================");

        for (int i = 0; i < guesses.size(); i++) {
            System.out.printf("%s %-7s %s %-8s %s %-8s %s %-8s %s %-8s %s %-24s %s%n", "|", (i + 1), "|", guesses.get(i)[0], "|", guesses.get(i)[1], "|", guesses.get(i)[2], "|", guesses.get(i)[3], "|", allFeedback.get(i), "|");
            System.out.printf("%s%n", "----------------------------------------------------------------------------------");
        }
    }
}
