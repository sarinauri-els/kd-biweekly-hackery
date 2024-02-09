package TexasHoldEm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deal {
    public static List<String[]> loadDeck() {
        List<String> suits = List.of("H", "D", "S", "C");
        List<String> values = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
        List<String[]> deck = new ArrayList<>();

        for (String suit : suits) {
            for (String value : values) {
                deck.add(new String[]{suit, value});
            }
        }

        return deck;
    }

    public static int getRandomNumber(List<String[]> cards) {
        Random random = new Random();
        return random.nextInt(cards.size());
    }

    public static void dealCards(List<String[]> hand, List<String[]> deck, int numOfCards) {
        for (int i = 0; i < numOfCards; i++) {
            int randomNumber = getRandomNumber(deck);
            hand.add(deck.get(randomNumber));
            deck.remove(randomNumber);
        }
    }

    public static void discard(List<String[]> deck, int numOfCards) {
        for (int i = 0; i < numOfCards; i++) {
            int randomNumber = getRandomNumber(deck);
            deck.remove(randomNumber);
        }
    }
}
