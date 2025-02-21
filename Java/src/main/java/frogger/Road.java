package frogger;

/**
 * Refactor Task 1.
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Road {
    private final boolean[] occupied;

    public Road(boolean[] occupied) {
        this.occupied = occupied;
    }

    // public boolean[] getOccupied() {
    //     return this.occupied;
    // }

    public boolean canMoveTo(int position) {
        if (position < 0 || position >= occupied.length) {
            return false;
        }
        return !occupied[position];
    }
}
