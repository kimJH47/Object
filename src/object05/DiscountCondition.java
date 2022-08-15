package object05;

import object03.DiscountConditionType;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType discountConditionType;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isSatisfiedBy(Screening screening) {
        if (discountConditionType == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }
        return isSatisfiedBySequence(screening);
    }

    private boolean isSatisfiedBySequence(Screening screening) {
        return screening.getSequence()==this.sequence;
    }

    private boolean isSatisfiedByPeriod(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened()
                                         .getDayOfWeek()) &&
                startTime.compareTo(screening.getWhenScreened()
                                             .toLocalTime())<=0&&
                endTime.isAfter(screening.getWhenScreened()
                                         .toLocalTime());
    }
}
