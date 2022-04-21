package object02;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

    private Money discountAmount;

    //객체 생성시 고정적인 할인금액을 파라미터로 넣어줌
    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {


        super(conditions);
        this.discountAmount = discountAmount;

    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;

    }
}
