package Mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class GeneticAlgorithm {
    public int generation = 0;

    public void run(String[] answer) {
        List<String[]> population = generateRandomPopulation(50);

        Map<String[], Integer> scores = population.stream().collect(Collectors.toMap(guess -> guess, guess -> score(guess, answer)));

        System.out.println();
    }

    private String[] getRandomGuess() {
        var random = new Random();
        var guess = new String[4];
        var colours = Peg.getAllValues();

        for (int i = 0; i < 4; i++) {
            int rand = random.nextInt(colours.size());
            guess[i] = colours.get(rand);
        }

        return guess;
    }

    private List<String[]> generateRandomPopulation(int populationSize) {
        List<String[]> data = new ArrayList<>();

        for (int i = 0; i < populationSize; i++) {
            data.add(getRandomGuess());
        }

        return data;
    }

    private int score(String[] guess, String[] answer) {
        var score = 0;

        for (int i = 0; i < 4; i++) {
            if (guess[i].equals(answer[i])) {
                score++;
            }
        }

        return score;
    }




}
