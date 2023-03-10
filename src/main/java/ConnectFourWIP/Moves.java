package ConnectFourWIP;

import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Moves {
    private final List<String> playerOneMoves;
    private final List<String> playerTwoMoves;

    public Moves(List<String> playerOneMoves, List<String> playerTwoMoves) {
        this.playerOneMoves = playerOneMoves;
        this.playerTwoMoves = playerTwoMoves;
    }

    public void readMovesFromFile() {
        try (Scanner scanner = new Scanner(Paths.get("testData.txt"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] splitRow = row.split(",");
                playerOneMoves.add(splitRow[0]);
                playerTwoMoves.add(splitRow[1]);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
