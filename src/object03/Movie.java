package object03;

import object02.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


public class Movie {
    //필요한 오퍼레이션 : 영화요금을 계산하는 오퍼레이션과 할인여부를 판한하느 오퍼레이션
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    //할인요금을 포함해 영화요금을 계산하는 메서드
    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee.minus(discountAmount);
    }
    public Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee.times(discountPercent);
    }
    public Money calculateNoneDiscountedFee() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee;
    }

    //Movie 는 DiscountConditions 를 포함하기 때문에 할인여부를 판단하는 오퍼레이션이 포함되어야한다.
    public boolean isDiscountable(LocalDateTime whenScreened,int sequence) {
        for (DiscountCondition discountCondition : discountConditions) {
            if(discountCondition.getType()==DiscountConditionType.PERIOD)
                if (discountCondition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
                    return true;
                } else {
                    if (discountCondition.isDiscountable(sequence)) {
                        return true;
                    }
                }
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Duration runningTime) {
        this.runningTime = runningTime;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountCondtions() {
        return discountConditions;
    }

    public void setDiscountCondtions(List<DiscountCondition> discountCondtions) {
        this.discountConditions = discountCondtions;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
