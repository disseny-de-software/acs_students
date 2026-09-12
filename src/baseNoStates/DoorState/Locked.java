package baseNoStates.DoorState;

// State where door is closed and locked
public class Locked extends DoorState {
    public Locked(String doorId) {
        super(doorId);
    }

    @Override
    public DoorState open() {
        System.out.println("Can't open door " + this.doorId + " because it's locked");
        return this;
    }

    @Override
    public DoorState close() {
        System.out.println("Can't close door " + this.doorId + " because it's already closed");
        return this;
    }

    @Override
    public DoorState lock() {
        System.out.println("Can't lock door " + this.doorId + " because it's already locked");
        return this;
    }

    @Override
    public DoorState unlock() {
        return new Closed(this.doorId);
    }

    @Override
    public DoorState unlockShortly() {
        return new UnlockedShortly(this.doorId);
    }

    @Override
    public boolean isClosed() {
        return true;
    }

    @Override
    public String getState() {
        return "locked";
    }
}
