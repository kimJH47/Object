package object03;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType type;

    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    //기간할인 조건여부 를 확인하는 메서드
    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (this.type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }
        return this.dayOfWeek.equals(dayOfWeek) && this.startTime.compareTo(time) <= 0 && this.endTime.compareTo(time) >= 0;
    }

    //순번할인 조건 여부를 확인하는 메서드
    public boolean isDiscountable(int sequence) {
        if (this.type != DiscountConditionType.SEQENCE) {
            throw new IllegalArgumentException();
        }
        return this.sequence == sequence;
    }

    public DiscountConditionType getType() {
        return type;
    }

    public void setType(DiscountConditionType type) {
        this.type = type;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
