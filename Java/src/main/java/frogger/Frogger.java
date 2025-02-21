package frogger;

import javax.xml.catalog.CatalogFeatures.Feature;

/**
 * Refactor Task 1 & 2: Frogger
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22), Duan Liang (F23)
 */
public class Frogger {

    // Field for task 1.
    private final Road road;
    private int position;
    
    // Field for task 2. Anything to add/change?
    private final Records records;

    // God Class
    // Explanation: Frogger class contains a lot of ID information fields
    // Solution: Moved identity-related fields into FroggerID record class
    // private String firstName, lastName, phoneNumber, zipCode, state, gender;
    private final FroggerID id;

    public Frogger(Road road, int position, Records records, FroggerID id) {
        this.road = road;
        this.position = position;
        this.records = records;
        this.id = id;
    }

    /**
     * Moves Frogger.
     *
     * @param forward true is move forward, else false.
     * @return true if move successful, else false.
     */
    public boolean move(boolean forward) {
        int nextPosition = this.position + (forward ? 1 : -1);
        if (road.canMoveTo(nextPosition)) {
            this.position = nextPosition;
            return true;
        }
        return false;
    }

    // TODO: Do you notice any issues here?
    // Feature Envy (Anti-pattern) / violate information expert pattern, low coupling, high cohesion
    // Explanation: Frogger class was too interested in Road's internal data. Frogger does not need to know
    //     - the state of the entire road
    //     - how to determin whether the location is occupied
    //     - how to verify whether the location is valid
    // Solution: Moved the responsibility back to the Road class where it belongs


    // public boolean isOccupied(int position) {
    //     boolean[] occupied = this.road.getOccupied();
    //     return occupied[position];
    // }
    
    // public boolean isValid(int position) {
    //     if (position < 0) return false;
    //     boolean[] occupied = this.road.getOccupied();
    //     return position < occupied.length;
    // }

    /**
     * Records Frogger to the list of records.
     * 
     * @return true if record successful, else false.
     */
    public boolean recordMyself() {
      boolean success = records.addRecord(id);
      return success;
    }

}
