package baseNoStates.Privileges;

import baseNoStates.Space;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

// Can perform any action, but only between 8AM and 8PM during workdays + saturday and between 2025/09/01 and 2026/02/28 (both included)
public class Manager extends Privileges {
    public boolean canSendRequests(LocalDateTime now) {
        if (now.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return false;
        }

        if (now.getHour() < 8 || now.getHour() >= 20) {
            return false;
        }

        return this.isWithinAllowedPeriod(now);
    }

    public boolean canBeInSpace(Space space) {
        return true;
    }

    public boolean canDoAction(String action) {
        return true;
    }
}
