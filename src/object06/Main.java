package object06;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Event 회의 = new Event("회의", LocalDateTime.of(2022, 8, 30, 10, 30), Duration.ofMinutes(30));
        RecurringSchedule recurringSchedule = new RecurringSchedule("회의", LocalDateTime.of(2022, 8, 30, 10, 30), Duration.ofMinutes(30), DayOfWeek.WEDNESDAY);

        assert 회의.isSatisfied(recurringSchedule)==false;
        assert 회의.isSatisfied(recurringSchedule)==true;
    }
}
