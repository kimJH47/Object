package object05;

import object02.Money;

import java.time.Duration;

public class PercentDiscountMovie extends Movie {
    double percent;
    public PercentDiscountMovie(String title, Duration runningTime, Money fee,double percent, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }

}
