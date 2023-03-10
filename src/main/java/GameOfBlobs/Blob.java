package GameOfBlobs;

public class Blob {
    private int x;
    private int y;
    private int size;

    public Blob(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean hasSameLocation(Blob blob) {
        return this.x == blob.x && this.y == blob.y;
    }

    public boolean equals(Object comparedObj) {
        if (this == comparedObj) {
            return true;
        }

        if (!(comparedObj instanceof Blob)) {
            return false;
        }

        Blob comparedBlob = (Blob) comparedObj;

        if (this.x == comparedBlob.x && this.y == comparedBlob.y && this.size == comparedBlob.size) {
            return true;
        }

        return false;
    }

    public Blob clone() {
        return new Blob(this.x, this.y, this.size);
    }

    public String toString() {
        return "(" + this.x + "," + this.y + "," + this.size + ")";
    }

}
