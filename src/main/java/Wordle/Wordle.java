package Wordle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wordle {
    public static void main(String[] args) {
//        String[] words = {"APPLE", "HELLO", "THREE"};

        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String RESET = "\033[0m";

        String[] words = {"APPLE"};

        String answer = getRandomWord(words);

        List<String> guesses = new ArrayList<>();

        for (int i=0; i < 5; i++) {
            String guess = getPlayersGuess();
            guesses.add(guess);
            checkCharacters(answer, guess);
            if (answer.equals(guess)) {
                System.out.println("\nYou won in " + (i+1) + " turns!");
                break;
            }
        }
    }

    private static String getRandomWord(String[] words) {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    private static String getPlayersGuess() {
        System.out.print("\nEnter 5 letter guess > ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void checkCharacters(String answer, String guess) {
        Colour colour = new Colour();

        char[] guessChars = guess.toCharArray();
        char[] answerChars = answer.toCharArray();


        for (int i = 0; i < guessChars.length; i++) {
            if (guessChars[i] == answerChars[i]) {
                colour.printGreen(guessChars[i]);
            } else if (isInCharArray(guessChars[i], answerChars)) {
                colour.printYellow(guessChars[i]);
            } else {
                System.out.print(guessChars[i]);
            }
        }

    }

    private static boolean isInCharArray(char character, char[] wordChars) {
        if (new String(wordChars).indexOf(character) != -1) {
            return true;
        }
        return false;
    }
}
