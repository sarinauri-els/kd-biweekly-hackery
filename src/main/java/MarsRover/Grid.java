package MarsRover;

public class Grid {
    private final int maxX;
    private final int maxY;
    private final int minX;
    private final int minY;

    public Grid(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.minX = 0;
        this.minY = 0;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public String toString() {
        return "Grid Dimensions: [" + maxX + "," + maxY + "]";
    }
}
