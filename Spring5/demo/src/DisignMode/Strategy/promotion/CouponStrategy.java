package DisignMode.Strategy.promotion;

public class CouponStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，可抵扣部分商品");
    }
}
