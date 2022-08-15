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
