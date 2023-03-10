package ConnectFour;

//  Player X = Uppercase
//  Player O = Lowercase

/*
readMovesFromFile()
    dropPieceInColumn()
        getColumnHeight()
        checkIfWin()
 */

public class ConnectFour {
    public static void main(String[] args) {

    }

    public Board createBoard(int rows, int columns) {
        return new Board(rows, columns);
    }

    public void praseMoves() {

    }

    public void placePieceInBoard(String move) {

    }

    public void play() {
        createBoard(6, 7);
        placePieceInBoard("d");
    }
}
