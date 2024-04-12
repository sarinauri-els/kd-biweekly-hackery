package Mastermind;

import java.util.Scanner;

public class Mastermind {
    public static void main(String[] args) {
        var maxCodeLength = 4;
        var codeMaker = new CodeMaker(maxCodeLength);
        var codeBreakerType = getCodeBreakerType().toLowerCase();

        if (CodeBreakerType.COMPUTER.toString().toLowerCase().equals(codeBreakerType)) {
            var geneticAlgorithm = new GeneticAlgorithm();
            geneticAlgorithm.run(codeMaker.getCode());
        }

        if (CodeBreakerType.HUMAN.toString().toLowerCase().equals(codeBreakerType)) {

            var board = new Board();
            var codeBreaker = new CodeBreaker();

            while (!codeMaker.isSolved()) {
                System.out.println("Enter guess (red, blue, yellow, green, white, or black):");

                var guess = codeBreaker.guess(maxCodeLength);
                board.addGuess(guess);

                System.out.println();

                var feedback = codeMaker.feedback(codeMaker.getCode(), guess, maxCodeLength);
                board.addFeedback(feedback);
                board.print();

                System.out.println();
            }
        }
    }

    private static String getCodeBreakerType() {
        var scanner = new Scanner(System.in);

        System.out.println("Who is playing? (human or computer)");
        var type = scanner.nextLine();
        System.out.println();

        return type;
    }
}
