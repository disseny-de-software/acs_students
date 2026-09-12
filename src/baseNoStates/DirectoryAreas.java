package baseNoStates;

// Static class containing a tree of all areas and doors
public final class DirectoryAreas {
    private static Area rootArea;
    private static Door[] allDoors;

    // Creates full area tree and array of all doors
    public static void makeAreas() {
        // Creating partitions/spaces
        Partition building = new Partition("building", null);

        Partition basement = new Partition("basement", building);
        Space parking = new Space("parking", basement);

        Partition groundFloor = new Partition("ground_floor", building);
        Space hall = new Space("hall", groundFloor);
        Space room1 = new Space("room1", groundFloor);
        Space room2 = new Space("room2", groundFloor);

        Partition floor1 = new Partition("floor1", building);
        Space room3 = new Space("room3", floor1);
        Space corridor = new Space("corridor", floor1);
        Space IT = new Space("IT", floor1);

        Space stairs = new Space("stairs", building);
        Space exterior = new Space("exterior", building);

        // Create doors
        Door D1 = new Door("D1", exterior, parking);
        Door D2 = new Door("D2", stairs, parking);
        Door D3 = new Door("D3", exterior, hall);
        Door D4 = new Door("D4", stairs, hall);
        Door D5 = new Door("D5", hall, room1);
        Door D6 = new Door("D6", hall, room2);
        Door D7 = new Door("D7", stairs, corridor);
        Door D8 = new Door("D8", corridor, room3);
        Door D9 = new Door("D9", corridor, IT);

        rootArea = building;
        allDoors = new Door[]{D1, D2, D3, D4, D5, D6, D7, D8, D9};
    }

    public static Area findAreaById(String id) {
        return rootArea.findAreaById(id);
    }

    public static Door findDoorById(String id) {
        for (int i = 0; i < allDoors.length; i++) {
            if (allDoors[i].getId().equals(id)) {
                return allDoors[i];
            }
        }

        return null;
    }

    public static Door[] getAllDoors() {
        return allDoors;
    }
}
