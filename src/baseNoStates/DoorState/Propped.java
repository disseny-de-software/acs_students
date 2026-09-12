package baseNoStates.DoorState;

// State where door is propped (as in should be locked but is open)
public class Propped extends DoorState {
    public Propped(String doorId) {
        super(doorId);
    }

    @Override
    public DoorState open() {
        System.out.println("Can't open door " + this.doorId + " because it's already open");
        return this;
    }

    @Override
    public DoorState close() {
        return new Locked(this.doorId);
    }

    @Override
    public DoorState lock() {
        System.out.println("Can't lock door " + this.doorId + " because it's propped");
        return this;
    }

    @Override
    public DoorState unlock() {
        System.out.println("Can't unlock door " + this.doorId + " because it's propped");
        return this;
    }

    @Override
    public DoorState unlockShortly() {
        System.out.println("Can't unlock door " + this.doorId + " shortly because it's propped");
        return this;
    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public String getState() {
        return "propped";
    }
}
