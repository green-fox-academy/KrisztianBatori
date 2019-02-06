package comparable;

import java.lang.*;

class Domino implements Comparable<Domino> {
    private final int left;
    private final int right;

    public Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeftSide() {
        return left;
    }

    public int getRightSide() {
        return right;
    }

    @Override
    public int compareTo(Domino o) {
        return this.toString().compareTo(o.toString());
    }

    @Override
    public String toString() {
        return "[" + left + ", " + right + "]";
    }
}
