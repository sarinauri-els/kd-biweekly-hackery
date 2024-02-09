package TexasHoldEm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EvaluateGame {
    public static void declareWinner(Hand playerOneHand, Hand playerTwoHand) {
        int playerOneScore = ScoreHand.scoreHand(playerOneHand);
        System.out.print("Player One Hand: ");
        playerOneHand.getHand().forEach(card -> System.out.print(Arrays.toString(card) + " "));
        System.out.println();
        System.out.println("Player One Score: " + playerOneScore);
        System.out.println("Player One Hand Type: " + playerOneHand.getType());

        int playerTwoScore = ScoreHand.scoreHand(playerTwoHand);
        System.out.print("Player Two Hand: ");
        playerTwoHand.getHand().forEach(card -> System.out.print(Arrays.toString(card) + " "));
        System.out.println();
        System.out.println("Player Two Score: " + playerTwoScore);
        System.out.println("Player Two Hand Type: " + playerTwoHand.getType());
        System.out.println();

        if (playerOneScore == 0 && playerTwoScore == 0) {
            List<Integer> playerOneValues = CardValueMapper.mapValues(playerOneHand.getAllValues());
            Collections.sort(playerOneValues, Collections.reverseOrder());

            List<Integer> playerTwoValues = CardValueMapper.mapValues(playerTwoHand.getAllValues());
            Collections.sort(playerTwoValues, Collections.reverseOrder());

            evaluateHighCard(playerOneValues, playerTwoValues);

        } else if (playerOneScore == playerTwoScore) {
            System.out.println("IT'S A TIE!");
        } else if (playerOneScore > playerTwoScore) {
            System.out.println("PLAYER ONE WINS");
        } else {
            System.out.println("PLAYER TWO WINS");
        }
    }

    private static void evaluateHighCard(List<Integer> playerOneValues, List<Integer> playerTwoValues) {
        if (playerOneValues.isEmpty() && playerTwoValues.isEmpty()) {
            System.out.println("IT'S A TIE!");
        } else {
            int playerOneHighCard = playerOneValues.get(0);
            int playerTwoHighCard = playerTwoValues.get(0);

            if (playerOneHighCard > playerTwoHighCard) {
                System.out.println(("PLAYER ONE WINS"));
            } else if (playerTwoHighCard > playerOneHighCard) {
                System.out.println("PLAYER TWO WINS");
            } else {
                playerOneValues.remove(0);
                playerTwoValues.remove(0);

                evaluateHighCard(playerOneValues, playerTwoValues);
            }
        }
    }
}
