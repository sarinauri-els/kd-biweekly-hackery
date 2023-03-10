package MarsRover;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Enter desired grid dimensions: ");
        String input = scanner.nextLine();
        Grid grid = generateGrid(input);

        System.out.print("Enter location of Rover One: ");
        input = scanner.nextLine();
        Rover roverOne = generateRover(input, grid);

        System.out.print("Give Rover One some instructions: ");
        input = scanner.nextLine();
        roverOne.parseInstructions(input);

        System.out.print("Enter location of Rover One: ");
        input = scanner.nextLine();
        Rover roverTwo = generateRover(input, grid);

        System.out.print("Give Rover Two some instructions: ");
        input = scanner.nextLine();
        roverTwo.parseInstructions(input);

        System.out.println();

        System.out.println("Final position of rovers:");
        System.out.println("Rover One: " + roverOne);
        System.out.println("Rover Two: " + roverTwo);
    }

    private Grid generateGrid(String input) {
        String[] dimensions = input.split(" ");
        return new Grid(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
    }

    private Rover generateRover(String input, Grid grid) {
        String[] loc = input.split(" ");
        return new Rover(Integer.parseInt(loc[0]), Integer.parseInt(loc[1]), loc[2], grid);
    }
}

