package TexasHoldEm;

import java.util.Arrays;
import java.util.List;

import static TexasHoldEm.Deal.*;

public class TexasHoldEm {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to Texas Hold'em");

        System.out.println("Initialising game...");
        List<String[]> deck = loadDeck();
        Hand playerOneHand = new Hand();
        Hand playerTwoHand = new Hand();
        Hand tableHand = new Hand();
        System.out.println();

        System.out.println("Dealing hole cards to each player...");
        dealCards(playerOneHand.getHand(), deck, 5);
        dealCards(playerTwoHand.getHand(), deck, 5);
        System.out.println();

        System.out.println("Discarding one from deck...");
        discard(deck, 1);
        System.out.println();

        System.out.println("Dealing the flop...");
        dealCards(tableHand.getHand(), deck, 3);
        tableHand.getHand().forEach(card -> System.out.print(Arrays.toString(card) + " "));
        System.out.println();

        System.out.println("Discarding one from deck...");
        discard(deck, 1);
        System.out.println();

        System.out.println("Dealing the turn...");
        dealCards(tableHand.getHand(), deck, 1);
        tableHand.getHand().forEach(card -> System.out.print(Arrays.toString(card) + " "));
        System.out.println();

        System.out.println("Discarding one from deck...");
        discard(deck, 1);
        System.out.println();

        System.out.println("Dealing the river...");
        dealCards(tableHand.getHand(), deck, 1);
        tableHand.getHand().forEach(card -> System.out.print(Arrays.toString(card) + " "));
        System.out.println();

        System.out.println();
        System.out.println("Evaluating game...");
        EvaluateGame.declareWinner(playerOneHand, playerTwoHand);
    }
}
