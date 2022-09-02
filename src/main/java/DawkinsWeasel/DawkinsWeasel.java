package DawkinsWeasel;

import java.util.Random;

public class DawkinsWeasel {
    public static void main(String[] args) {
        String target = "METHINKS IT IS LIKE A WEASEL";
        mutateStringIntoTarget(generateRandomString(target.length()), target);
    }

    private static final Random random = new Random();

    public static char getRandomCharFromString() {
        final String allCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        int index = random.nextInt(allCharacters.length());
        return allCharacters.charAt(index);
    }

    public static String generateRandomString(int maxStringLength) {
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < maxStringLength; i++) {
            randomString.append(getRandomCharFromString());
        }
        return randomString.toString();
    }

    public static boolean mutateChar() {
        int n = random.nextInt(20);
        return n == 1;
    }

    public static String mutateString(String randomString) {
        StringBuilder mutatedString = new StringBuilder();
        for (int i = 0; i < randomString.length(); i++) {
            if (mutateChar()) {
                mutatedString.append(getRandomCharFromString());
            } else {
                mutatedString.append(randomString.charAt(i));
            }
        }
        return mutatedString.toString();
    }

    public static int score(String randomString, String target) {
        int score = 0;
        for (int i = 0; i < randomString.length(); i++) {
            if (target.charAt(i) == randomString.charAt(i)) {
                score++;
            }
        }
        return score;
    }

    public static void mutateStringIntoTarget(String startingString, String target) {
        int highestScore = 0;
        boolean fullScore = false;
        int iterationCount = 0;

        while (!fullScore) {
            for (int i = 0; i < 100; i++) {
                String mutatedString = mutateString(startingString);
                int score = score(mutatedString, target);
                iterationCount++;
                System.out.println(mutatedString);
                if (score == 28) {
                    fullScore = true;
                    System.out.println("WE DID IT!!!");
                    System.out.println("ITERATION COUNT: " + iterationCount);
                    break;
                } else if (score > highestScore) {
                    startingString = mutatedString;
                    highestScore = score;
                }
            }
        }
    }
}
