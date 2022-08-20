package object06;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class RecurringSchedule {
    private String subject;
    private LocalTime from;
    private Duration duration;
    private DayOfWeek dayOfWeek;

    public RecurringSchedule(String subject, LocalTime from, Duration duration, DayOfWeek dayOfWeek) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
        this.dayOfWeek = dayOfWeek;
    }

    public String getSubject() {
        return subject;
    }

    public LocalTime getFrom() {
        return from;
    }

    public Duration getDuration() {
        return duration;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}

