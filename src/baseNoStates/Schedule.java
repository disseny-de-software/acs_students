package baseNoStates;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

//User schedule class
public class Schedule {
  private final LocalDateTime fromDate;
  private final LocalDateTime toDate;
  private final LocalTime fromHour;
  private final LocalTime toHour;
  private final DayOfWeek toDayOfWeek;
  private final DayOfWeek fromDayOfWeek;

  public Schedule(LocalDateTime fromdate, LocalDateTime todate, LocalTime fromhour, LocalTime tohour, DayOfWeek fromDayOfWeek, DayOfWeek toDayOfWeek) {
    this.fromDate = fromdate;
    this.toDate = todate;
    this.fromHour = fromhour;
    this.toHour = tohour;
    this.toDayOfWeek = toDayOfWeek;
    this.fromDayOfWeek = fromDayOfWeek;

    System.out.println("Schedule created: " + fromdate + " to " + todate +
        ", Hours: " + fromhour + "-" + tohour +
        ", Days: " + fromDayOfWeek + "-" + toDayOfWeek);
  }

  public int canAccess(LocalDateTime now) {
    LocalTime horaActual = now.toLocalTime();
    DayOfWeek dia = now.getDayOfWeek();

    System.out.println("Checking schedule for: " + now + " (Day: " + dia + ", Time: " + horaActual + ")");

    // Verificar fecha
    if (now.isBefore(fromDate) || now.isAfter(toDate)) {
      System.out.println("Date out of range: " + now + " not between " + fromDate + " and " + toDate);
      return 3; // Invalid date
    }

    // Verificar día de la semana
    int diaValue = dia.getValue();
    int fromDayValue = fromDayOfWeek.getValue();
    int toDayValue = toDayOfWeek.getValue();

    // Manejar rangos que cruzan el domingo (ej: Viernes a Lunes)
    boolean diaValido;
    if (fromDayValue <= toDayValue) {
      // Rango normal (ej: Lunes a Viernes)
      diaValido = (diaValue >= fromDayValue && diaValue <= toDayValue);
    } else {
      // Rango que cruza domingo (ej: Viernes a Lunes)
      diaValido = (diaValue >= fromDayValue || diaValue <= toDayValue);
    }

    if (!diaValido) {
      System.out.println("Day not allowed: " + dia + " not between " + fromDayOfWeek + " and " + toDayOfWeek);
      return 4; // Invalid day of the week
    }

    // Verificar hora
    if (horaActual.isBefore(fromHour) || horaActual.isAfter(toHour)) {
      System.out.println("Time not allowed: " + horaActual + " not between " + fromHour + " and " + toHour);
      return 5; // Invalid time
    }

    System.out.println("Schedule check passed for: " + now);
    return 0; // Access granted
  }

}