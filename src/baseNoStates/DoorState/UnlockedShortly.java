package baseNoStates.DoorState;

// Temporary state where door is unlocked for a short period of time
public class UnlockedShortly extends DoorState {
    boolean isOpen;

    public UnlockedShortly(String doorId) {
        super(doorId);
        isOpen = false;
    }

    @Override
    public DoorState open() {
        isOpen = true;
        return this;
    }

    @Override
    public DoorState close() {
        isOpen = false;
        return this;
    }

    @Override
    public DoorState lock() {
        System.out.println("Can't lock door" + this.doorId + " because it's waiting for a clock timeout");
        return this;
    }

    @Override
    public DoorState unlock() {
        System.out.println("Can't unlock door " + this.doorId + " shortly because it's already unlocked");
        return this;
    }

    @Override
    public DoorState unlockShortly() {
        System.out.println("Can't unlock door " + this.doorId + " shortly because it's already unlocked");
        return this;
    }

    @Override
    public boolean isClosed() {
        return !this.isOpen;
    }

    @Override
    public String getState() {
        return "unlocked_shortly";
    }
}
