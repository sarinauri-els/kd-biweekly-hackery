package Minesweeper;

import java.util.Scanner;

public class Player {
    private final Scanner scanner;

    public Player() {
        this.scanner = new Scanner(System.in);
    }

    String[] takeTurn() {
        var turn = new String[2];
        turn[0] = getTurnType();
        turn[1] = chooseCell();

        return turn;
    }

    String getTurnType() {
        System.out.println("Do you want to reveal a cell (c), place a flag (pf), or remove a flag (rf)?");
        System.out.print("> ");
        var choice = scanner.nextLine();
        System.out.println();

        if (choice.equals("c") || choice.equals("pf") || choice.equals("rf")) {
            return choice;
        } else {
            System.out.println("Invalid choice. Please enter c, pf, or rf.");
            getTurnType();
        }
        return null;
    }

    String chooseCell() {
        System.out.println("Enter your guess in the format row,column: ");
        System.out.print("> ");
        var cell = scanner.nextLine();
        System.out.println();
        return cell;
    }
}
