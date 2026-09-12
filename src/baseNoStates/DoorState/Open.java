package baseNoStates.DoorState;

// State where door is simply open
public class Open extends DoorState {
    public Open(String doorId) {
        super(doorId);
    }

    @Override
    public DoorState open() {
        System.out.println("Can't open door " + this.doorId + " because it's already open");
        return this;
    }

    @Override
    public DoorState close() {
        return new Closed(this.doorId);
    }

    @Override
    public DoorState lock() {
        System.out.println("Can't lock door " + this.doorId + " because it's open");
        return this;
    }

    @Override
    public DoorState unlock() {
        System.out.println("Can't unlock " + this.doorId + " shortly because it's not closed");
        return this;
    }

    @Override
    public DoorState unlockShortly() {
        System.out.println("Can't unlock " + this.doorId + " shortly because it's not closed");
        return this;
    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public String getState() {
        return "unlocked";
    }
}
