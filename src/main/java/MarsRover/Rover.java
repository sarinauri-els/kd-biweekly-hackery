package MarsRover;

public class Rover {
    private int xLoc;
    private int yLoc;
    private String bearing;
    private final Grid grid;

    public Rover(int xLoc, int yLoc, String bearing, Grid grid) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.bearing = bearing;
        this.grid = grid;
    }

    // L = Rotate 90 degrees left
    // R = Rotate 90 degrees right
    // M = Move forward one grid point
    public void parseInstructions(String input) {
        String[] instructions = input.split("");

        for (String instruction : instructions) {
            if (instruction.equals("L")) {
                rotateLeft();
            }

            if (instruction.equals("R")) {
                rotateRight();
            }

            if (instruction.equals("M")) {
                moveForward();
            }
        }
    }

    private void rotateLeft() {
        switch (this.bearing) {
            case "N":
                this.bearing = "W";
                break;
            case "W":
                this.bearing = "S";
                break;
            case "S":
                this.bearing = "E";
                break;
            case "E":
                this.bearing = "N";
                break;
        }
    }

    private void rotateRight() {
        switch (this.bearing) {
            case "N":
                this.bearing = "E";
                break;
            case "E":
                this.bearing = "S";
                break;
            case "S":
                this.bearing = "W";
                break;
            case "W":
                this.bearing = "N";
                break;
        }
    }

    private void moveForward() {
        if (this.bearing.equals("N") & this.yLoc < grid.getMaxY()) {
            this.yLoc++;
        } else if (this.bearing.equals("E") & this.xLoc < grid.getMaxX()) {
            this.xLoc++;
        } else if (this.bearing.equals("S") & this.yLoc > grid.getMinY()) {
            this.yLoc--;
        } else if (this.bearing.equals("W") & this.xLoc > grid.getMinX()) {
            this.xLoc--;
        }
    }

    public String toString() {
        return this.xLoc + " " + this.yLoc + " " + this.bearing;
    }
}
