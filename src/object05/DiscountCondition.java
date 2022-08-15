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
    /**
     * 변경에 취약한 이유
     * 새로운 할인조건 추가시 isSatisfiedBy 코드가 변경과 새로운 데이터가 요구되면 DiscountCondition의 속성도 추가되어야함
     * 순서조건 판단이나 기간 조건판단 로직이 변경되면 isSatisfied~ 를 변경해야함. 조건을 판단시 필요한 데이터 변경되면 해당하는 속성도 변경되어야함
     * -> DiscountCondition 은 하나 이상의 변경이유를 가지기 때문에 응집도 낮다고 볼 수 있다. 응집도가 낮다는 것은 연관성 없는 기능이나 데이터가 하나의 클래스에
     * 있다는 걸 말한다. 그래서 변경의 이유에 따라 클래스를 분리해야한다.
     */
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
