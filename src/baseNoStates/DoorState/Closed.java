package baseNoStates.DoorState;

// State where door is closed but not locked
public class Closed extends DoorState {
    public Closed(String doorId) {
        super(doorId);
    }

    @Override
    public DoorState open() {
        return new Open(this.doorId);
    }

    @Override
    public DoorState close() {
        System.out.println("Can't close door " + this.doorId + " because it's already closed");
        return this;
    }

    @Override
    public DoorState lock() {
        return new Locked(this.doorId);
    }

    @Override
    public DoorState unlock() {
        System.out.println("Can't unlock door " + this.doorId + " because it's already unlocked");
        return this;
    }

    @Override
    public DoorState unlockShortly() {
        System.out.println("Can't unlock " + this.doorId + " shortly because it's not locked");
        return this;
    }

    @Override
    public boolean isClosed() {
        return true;
    }

    @Override
    public String getState() {
        return "unlocked";
    }
}
