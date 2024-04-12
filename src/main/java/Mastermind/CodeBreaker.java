package Mastermind;

import java.util.Scanner;

public class CodeBreaker {
    public String[] guess(int maxCodeLength) {
        var guess = new String[maxCodeLength];

        var scanner = new Scanner(System.in);

        int i = 0;

        while (i < maxCodeLength) {
            System.out.print((i + 1) + ": ");
            var currGuess = scanner.nextLine().toLowerCase();

            if (Peg.getAllValues().contains(currGuess)) {
                guess[i] = currGuess;
                i++;
            } else {
                System.out.println("Invalid guess, try again");
            }
        }

        return guess;
    }
}
