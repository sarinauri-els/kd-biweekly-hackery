package Minesweeper;

public class Minesweeper {
    public static void main(String[] args) {
        var player = new Player();
        var board = new Board(5, 7, 6);

        board.printSolution();
        System.out.println();
        board.printPlayerBoard();

        System.out.println("Welcome to Minesweeper!");
        System.out.println("Try to find all the mines without detonating any of them");
        System.out.println();

        var solved = false;

        label:
        while (!solved) {
            var turn = player.takeTurn();

            var turnType = turn[0];
            var cell = turn[1].split(",");

            var row = Integer.parseInt(cell[0]);
            var column = Integer.parseInt(cell[1]);

            switch (turnType) {
                case "pf" -> {
                    board.flagCell(row, column);
                    board.printPlayerBoard();
                    continue;
                }
                case "rf" -> {
                    board.removeFlag(row, column);
                    board.printPlayerBoard();
                    continue;
                }
                case "c" -> {
                    if (board.isFlagged(row, column)) {
                        System.out.println("Cell is flagged. Remove flag to reveal.");
                        System.out.println();
                    } else if (board.isMine(row, column)) {
                        board.printSolution();
                        System.out.println("You hit a mine! Game over!");
                        break label;
                    } else {
                        board.revealCells(row, column);
                        board.printPlayerBoard();
                    }
                }
            }

            solved = board.isSolved();

            if (solved) {
                board.printSolution();
                System.out.println("Congrats! You found all the mines!");
            }
        }

    }
}

