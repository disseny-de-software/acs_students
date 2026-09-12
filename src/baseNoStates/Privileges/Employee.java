package baseNoStates.Privileges;

import baseNoStates.Actions;
import baseNoStates.Space;

import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.time.Month;

// Can unlock doors shortly, but only between 9AM and 5PM during workdays and between
// 2025/09/01 and 2026/02/28 (both included), and the door must not be connected to the parking
public class Employee extends Privileges {
    public boolean canSendRequests(LocalDateTime now) {
        if (now.getDayOfWeek() == DayOfWeek.SATURDAY || now.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return false;
        }

        if (now.getHour() < 9 || now.getHour() >= 17) {
            return false;
        }

        return this.isWithinAllowedPeriod(now);
    }

    public boolean canBeInSpace(Space space) {
        return !space.getId().equals("parking");
    }

    public boolean canDoAction(String action) {
        return action.equals(Actions.UNLOCK_SHORTLY);
    }
}
