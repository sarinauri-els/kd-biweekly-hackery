package ConnectFour;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int rows;
    private final int columns;
    private String[][] piecePlacements;
    private Map<Integer, Character> columnNameLookUp;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.piecePlacements = new String[rows][columns];
        this.columnNameLookUp = new HashMap<>();
        createColumnLookUp();
    }

    public void createColumnLookUp() {
        for (int i=0; i<columns; i++) {
            char colAscii = (char) (i+97);
            System.out.println(colAscii);
            columnNameLookUp.put(i, colAscii);
        }
    }
}
