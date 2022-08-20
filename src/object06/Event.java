package object06;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    public boolean isSatisfied(RecurringSchedule recurringSchedule) {
        if (from.getDayOfWeek() != recurringSchedule.getDayOfWeek() ||
                !from.toLocalTime()
                     .equals(recurringSchedule.getFrom())
                || !duration.equals(recurringSchedule.getDuration())) {
            //쿼리개념적인 isSatisfied 에 부수적인 효과를 가지는 명령인 reschedule 가 존재한다. -> 분리를 해줘야한다.
            reschedule(recurringSchedule);
            return false;
        }
        return true;
    }

    private void reschedule(RecurringSchedule recurringSchedule) {
        this.from = LocalDateTime.of(from.toLocalDate()
                                         .plusDays(dayDistancce(recurringSchedule)), recurringSchedule.getFrom());
        duration = recurringSchedule.getDuration();
    }

    private long dayDistancce(RecurringSchedule recurringSchedule) {
        return recurringSchedule.getDayOfWeek()
                                .getValue() - from.getDayOfWeek()
                                                  .getValue();
    }

}
