package object05;

import object02.Money;
import object03.MovieType;


import java.time.Duration;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<PeriodCondition> periodConditions;
    private List<SequenceCondition> sequenceConditions;


    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;
    public Money calculateFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private Money calculateDiscountAmount() {
        switch (this.movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }
        throw new IllegalStateException();
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }

    private Money calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }
    private Money calculateAmountDiscountAmount() {
        return this.discountAmount;
    }

    /**
     *
     * DiscountCondition 타입을 분리헀지만 Movie 는 두개의 condition type 을 알고있어야해 결합도가 증가해버렸다.
     * 또한 새로운 타입이 추가되거나 변경될 때 해당 조건을 담기위해 또다른 List 가 추가되여야하고 isDiscountable 의 변경과 check~ 메서드가 추가되어야한다.
     * 따라서 설계의 입장에서 응집도가 높아졌지만 변경과 캡슐화에 관점에서 보면 설계의 품질이 나빠졋다고 말할 수 있다.
     */
    private boolean isDiscountable(Screening screening) {
        return checkPeriodCondition(screening) || checkSequenceCondition(screening);
    }

    private boolean checkSequenceCondition(Screening screening) {
        return sequenceConditions.stream()
                          .anyMatch(sequenceCondition -> sequenceCondition.isSatisfiedBy(screening));
    }

    private boolean checkPeriodCondition(Screening screening) {
        return periodConditions.stream()
                               .anyMatch(periodCondition -> periodCondition.isSatisfiedBy(screening));
    }
}
