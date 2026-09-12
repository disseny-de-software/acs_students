package baseNoStates.Privileges;

import baseNoStates.Space;

import java.time.LocalDateTime;
import java.time.Month;

/*
Defines all functions a privilege class should have
Any privilege class must implement this
AKA state pattern
*/
public abstract class Privileges {
    public abstract boolean canSendRequests(LocalDateTime now);
    public abstract boolean canBeInSpace(Space space);
    public abstract boolean canDoAction(String action);

    // Checks if date is within 2025/09/01 and 2026/02/28
    protected boolean isWithinAllowedPeriod(LocalDateTime now) {
        if (now.getYear() == 2025 &&
                (now.getMonth() == Month.SEPTEMBER
                || now.getMonth() == Month.OCTOBER
                || now.getMonth() == Month.NOVEMBER
                || now.getMonth() == Month.DECEMBER)) {

            return true;
        }

        if (now.getYear() == 2026 &&
                (now.getMonth() == Month.JANUARY
                || now.getMonth() == Month.FEBRUARY)) {

            return true;
        }

        return false;
    }
}
