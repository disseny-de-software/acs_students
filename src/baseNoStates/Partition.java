package baseNoStates;

// Area that contain other areas (ex. building contains basement, ground floor, etc.
public class Partition extends Area {
    private Area[] subareas;

    public Partition(String id, Partition father) {
        super(id, father);
        this.subareas = new Area[0];
    }

    @Override
    public Door[] getDoorsGivingAccess() {
        // figuring out final array size
        int arraySize = 0;
        for (int i = 0; i < this.subareas.length; i++) {
            arraySize += this.subareas[i].getDoorsGivingAccess().length;
        }

        // creating array and filling
        Door[] allDoors = new Door[arraySize];
        int index = 0;
        for (int i = 0; i < this.subareas.length; i++) {
            Door[] subareaDoors = this.subareas[i].getDoorsGivingAccess();
            for (int j = 0; j < subareaDoors.length; j++) {
                allDoors[index] = subareaDoors[j];
                index++;
            }
        }

        return allDoors;
    }

    @Override
    public Area findAreaById(String id) {
        if (this.id.equals(id)) {
            return this;
        }
        else {
            for (int i = 0; i < this.subareas.length; i++) {
                if (this.subareas[i].findAreaById(id) != null) {
                    return this.subareas[i].findAreaById(id);
                }
            }
        }

        return null;
    }

    @Override
    public Space[] getSpaces() {
        // figuring out final array size
        int arraySize = 0;
        for (int i = 0; i < this.subareas.length; i++) {
            arraySize += this.subareas[i].getSpaces().length;
        }

        // creating array and filling
        Space[] allSpaces = new Space[arraySize];
        int index = 0;
        for (int i = 0; i < this.subareas.length; i++) {
            Space[] subareaDoors = this.subareas[i].getSpaces();
            for (int j = 0; j < subareaDoors.length; j++) {
                allSpaces[index] = subareaDoors[j];
                index++;
            }
        }

        return allSpaces;
    }

    public void addArea(Area newArea) {
        // creating deep copy of subarea array
        Area[] currentSubareas = new Area[this.subareas.length];
        for (int i = 0; i < this.subareas.length; i++) {
            currentSubareas[i] = this.subareas[i];
        }

        // creating new array and filling
        this.subareas = new Area[currentSubareas.length + 1];
        for (int i = 0; i < currentSubareas.length; i++) {
            this.subareas[i] = currentSubareas[i];
        }
        this.subareas[this.subareas.length - 1] = newArea;
    }
}
