package TexasHoldEm;

import java.util.*;

public class ScoreHand {

    private static boolean isRoyalFlush(Hand hand) {
        return isFlush(hand) && new HashSet<>(hand.getAllValues()).containsAll(List.of("A", "K", "Q", "J", "10"));
    }

    private static boolean isStraightFlush(Hand hand) {
        return isStraight(hand) && isFlush(hand);
    }

    private static boolean isFlush(Hand hand) {
        return hand.getUniqueSuits().size() == 1 && consecutiveCount(hand) != 4;
    }

    private static boolean isStraight(Hand hand) {
        return hand.getUniqueSuits().size() > 1 && consecutiveCount(hand) == 4;
    }

    private static int consecutiveCount(Hand hand) {
        List<Integer> intValues = CardValueMapper.mapValues(hand.getAllValues());
        Collections.sort(intValues);

        int consecutive = 0;

        for (int i = 0; i < intValues.size() - 1; i++) {
            if (intValues.get(i) - intValues.get(i + 1) == -1) {
                consecutive++;
            }
        }

        return consecutive;
    }

    private static boolean isFullHouse(Hand hand) {
        return isThreeOfAKind(hand) && isOnePair(hand);
    }

    private static boolean isFourOfAKind(Hand hand) {
        return isOfAKind(hand, 4);
    }

    private static boolean isThreeOfAKind(Hand hand) {
        return isOfAKind(hand, 3);
    }

    private static boolean isOfAKind(Hand hand, int numOfMatches) {
        List<Integer> intValues = CardValueMapper.mapValues(hand.getAllValues());

        int[] counts = new int[14];

        for (int value : intValues) {
            counts[value]++;
            if (counts[value] == numOfMatches) {

                return true;
            }
        }

        return false;
    }

    private static boolean isTwoPair(Hand hand) {
        return pairsCount(hand) == 2;
    }

    private static boolean isOnePair(Hand hand) {
        return pairsCount(hand) > 1;
    }

    private static int pairsCount(Hand hand) {
        List<Integer> intValues = CardValueMapper.mapValues(hand.getAllValues());

        int[] counts = new int[14];

        for (int value : intValues) {
            counts[value]++;
        }

        int pairs = 0;

        for (int count : counts) {
            if (count >= 2) {
                pairs++;
            }
        }

        return pairs;
    }

    static int scoreHand(Hand hand) {
        System.out.println();

        if (isRoyalFlush(hand)) {
            hand.setType("Royal Flush");
            return 9;
        } else if (isStraightFlush(hand)) {
            hand.setType("Straight Flush");
            return 8;
        } else if (isFourOfAKind(hand)) {
            hand.setType("Four of a Kind");
            return 7;
        } else if (isFullHouse(hand)) {
            hand.setType("Full House");
            return 6;
        } else if (isFlush(hand)) {
            hand.setType("Flush");
            return 5;
        } else if (isStraight(hand)) {
            hand.setType("Straight");
            return 4;
        } else if (isThreeOfAKind(hand)) {
            hand.setType("Three of a Kind");
            return 3;
        } else if (isTwoPair(hand)) {
            hand.setType("Two Pair");
            return 2;
        } else if (isOnePair(hand)) {
            hand.setType("One Pair");
            return 1;
        } else {
            hand.setType("High Card");
            return 0;
        }
    }
}
