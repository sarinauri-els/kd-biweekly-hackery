package Mastermind;

import java.util.Arrays;
import java.util.Random;

public class CodeMaker {
    private final String[] code;
    private boolean isSolved;


    public CodeMaker(int maxCodeLength) {
        this.code = setCode(maxCodeLength);
        this.isSolved = false;
    }

    public String[] getCode() {
        return code;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public String[] setCode(int maxCodeLength) {
        var code = new String[maxCodeLength];

        var random = new Random();

        for (int i = 0; i < maxCodeLength; i++) {
            int rand = random.nextInt(Peg.values().length);
            code[i] = Peg.getAllValues().get(rand);
        }

        System.out.println("Answer is " + Arrays.toString(code));
        System.out.println();
        return code;
    }

    public static boolean isSolved(String[] code, String[] guess) {
        return Arrays.equals(guess, code);
    }

    public String feedback(String[] code, String[] guess, int maxCodeLength) {
        StringBuilder pegs = new StringBuilder();

        if (isSolved(code, guess)) {
            pegs.append("Correct Answer!");
            isSolved = true;
        } else {
            for (int i = 0; i < maxCodeLength; i++) {
                if (guess[i].equals(code[i])) {
                    pegs.append("black ");
                } else if (Arrays.asList(code).contains(guess[i])) {
                    pegs.append("white ");
                }
            }
        }

        return pegs.toString();
    }
}
