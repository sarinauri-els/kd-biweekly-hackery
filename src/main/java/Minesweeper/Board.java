package Minesweeper;

import java.util.Objects;

public class Board {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private final int totalRows;
    private final int totalColumns;
    private final String[][] answerBoard;
    private String[][] playerBoard;

    public Board(final int rows, final int columns, final int totalMines) {
        this.totalRows = rows;
        this.totalColumns = columns;
        this.playerBoard = populatePlayerBoard(rows, columns);
        this.answerBoard = populateBoard(rows, columns, totalMines);
    }

    String[][] populateBoard(final int totalRows, final int totalColumns, final int totalMines) {
        var board = new String[totalRows][totalColumns];
        populateMines(board, totalMines);
        populateMineProximityCounts(board);
        return board;
    }

    String[][] populatePlayerBoard(final int totalRows, final int totalColumns) {
        String[][] board = new String[totalRows][totalColumns];

        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                board[row][column] = " ";
            }
        }

        return board;
    }

    void populateMines(final String[][] board, final int totalMines) {
        var minesPlaced = 0;

        while (minesPlaced < totalMines) {
            var row = (int) (Math.random() * this.totalRows);
            var column = (int) (Math.random() * this.totalColumns);
            var value = board[row][column];

            if (!Objects.equals(value, "*")) {
                board[row][column] = "*";
                minesPlaced++;
            }
        }
    }

    void populateMineProximityCounts(final String[][] board) {
        for (int row = 0; row < this.totalRows; row++) {
            for (int column = 0; column < this.totalColumns; column++) {
                var value = board[row][column];
                if (!Objects.equals(value, "*")) {
                    var mineProximityCount = getMineProximityCount(board, row, column);
                    if (mineProximityCount > 0) {
                        board[row][column] = String.valueOf(mineProximityCount);
                    } else {
                        board[row][column] = "-";
                    }
                }
            }
        }
    }

    private int getMineProximityCount(String[][] board, int row, int column) {
        int mineProximityCount = 0;
        for (int x = row - 1; x <= row + 1; x++) {
            for (int y = column - 1; y <= column + 1; y++) {
                if (x >= 0 && x < this.totalRows && y >= 0 && y < this.totalColumns) {
                    var value = board[x][y];
                    if (Objects.equals(value, "*")) {
                        mineProximityCount++;
                    }
                }
            }
        }
        return mineProximityCount;
    }

    void flagCell(int row, int column) {
        this.playerBoard[row][column] = "F";
    }

    void removeFlag(int row, int column) {
        if (isFlagged(row, column)) {
            this.playerBoard[row][column] = " ";
        }
    }

    void revealCells(int row, int column) {
        var answer = this.answerBoard[row][column];

        if (answer.equals("-")) {
            this.playerBoard[row][column] = answer;
            for (int x = row - 1; x <= row + 1; x++) {
                for (int y = column - 1; y <= column + 1; y++) {
                    if (x >= 0 && x < this.totalRows
                            && y >= 0 && y < this.totalColumns
                            && this.playerBoard[x][y].equals(" ")) {
                        revealCells(x, y);
                    }
                }
            }
        } else {
            this.playerBoard[row][column] = answer;
        }
    }

    boolean isFlagged(int row, int column) {
        return this.playerBoard[row][column].equals("F");
    }

    boolean isMine(int row, int column) {
        return this.answerBoard[row][column].equals("*");
    }

    boolean isSolved() {
        var emptyCells = 0;

        for (int row = 0; row < this.totalRows; row++) {
            for (int column = 0; column < this.totalColumns; column++) {
                if (this.playerBoard[row][column].equals(" ") && !this.answerBoard[row][column].equals("*")) {
                    emptyCells++;
                }
            }

        }

        return emptyCells == 0;
    }

    private void print(String[][] board) {
        StringBuilder border = new StringBuilder("-");

        for (int columns = 0; columns <= this.totalColumns; columns++) {
            border.append("----");
        }

        System.out.printf("%s%n", border);
        System.out.printf("%s", ANSI_WHITE_BACKGROUND + "|   |" + ANSI_RESET);
        for (int column = 0; column < this.totalColumns; column++) {
            System.out.printf(ANSI_WHITE_BACKGROUND + " %s |", column);
        }
        System.out.print(ANSI_RESET);
        System.out.println();
        System.out.printf("%s%n", border);

        for (int row = 0; row < this.totalRows; row++) {
            System.out.printf(ANSI_WHITE_BACKGROUND + "%s" + ANSI_RESET, "| " + row + " |");
            for (int column = 0; column < this.totalColumns; column++) {
                System.out.printf(" %s |", board[row][column]);
            }
            System.out.println();
            System.out.printf("%s%n", border);
        }
    }

    void printPlayerBoard() {
        print(this.playerBoard);
    }

    void printSolution() {
        print(this.answerBoard);
    }
}
