package Wordle;

public class Colour {
    String GREEN = "\u001B[32m";
    String YELLOW = "\u001B[33m";
    String RESET = "\033[0m";

    public void printGreen(char character) {
        System.out.print(GREEN + character + RESET);
    }

    public void printYellow(char character) {
        System.out.print(YELLOW + character + RESET);
    }
}
