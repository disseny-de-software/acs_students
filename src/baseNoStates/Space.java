package baseNoStates;

// Area that contains all doors leading to it
public class Space extends Area {
    Door[] doorsGivingAccess;

    Space(String id, Partition father) {
        super(id, father);
        this.doorsGivingAccess = new Door[0];
    }

    @Override
    public Door[] getDoorsGivingAccess() {
        return this.doorsGivingAccess;
    }

    @Override
    public Area findAreaById(String id) {
        return (this.id.equals(id)) ? this : null;
    }

    @Override
    public Space[] getSpaces() {
        Space[] thisSpace = new Space[1];
        thisSpace[0] = this;
        return thisSpace;
    }

    public void addDoor(Door newDoor) {
        // creating deep copy of doors array
        Door[] currentDoors = new Door[this.doorsGivingAccess.length];
        for (int i = 0; i < this.doorsGivingAccess.length; i++) {
            currentDoors[i] = this.doorsGivingAccess[i];
        }

        // creating new array and filling
        this.doorsGivingAccess = new Door[currentDoors.length + 1];
        for (int i = 0; i < currentDoors.length; i++) {
            this.doorsGivingAccess[i] = currentDoors[i];
        }
        this.doorsGivingAccess[this.doorsGivingAccess.length - 1] = newDoor;
    }
}
