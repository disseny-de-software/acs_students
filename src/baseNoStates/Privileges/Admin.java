package baseNoStates.Privileges;

import baseNoStates.Space;

import java.time.LocalDateTime;

// Can perform any action at any time
public class Admin extends Privileges {
    public boolean canSendRequests(LocalDateTime now) {
        return true;
    }

    public boolean canBeInSpace(Space space) {
        return true;
    }

    public boolean canDoAction(String action) {
        return true;
    }
}
