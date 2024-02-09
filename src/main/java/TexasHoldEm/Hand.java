package TexasHoldEm;

import java.util.*;

public class Hand {
    private final List<String[]> hand;
    private String type;

    public Hand() {
        this.hand = new ArrayList<>();
        this.type = null;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String[]> getHand() {
        return hand;
    }

    public String getType() {
        return type;
    }

    public Set<String> getUniqueSuits() {
        Set<String> suits = new HashSet<>();

        for (String[] card : hand) {
            suits.add(card[0]);
        }

        return suits;
    }

    public List<String> getAllValues() {
        List<String> values = new ArrayList<>();

        for (String[] card : hand) {
            values.add(card[1]);
        }

        return values;
    }
}
