package baseNoStates.DoorState;

/*
Defines all functions a door state class should have
Any door state class must implement this
AKA state pattern
*/
public abstract class DoorState {
    protected String doorId;

    public DoorState(String doorId) {
        this.doorId = doorId;
    }

    public abstract DoorState open();
    public abstract DoorState close();
    public abstract DoorState lock();
    public abstract DoorState unlock();
    public abstract DoorState unlockShortly();

    public abstract boolean isClosed();
    public abstract String getState();
}