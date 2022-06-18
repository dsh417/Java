package Strategy.promotion;

public class CashbackStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返校促销，返回金额到支付宝");
    }
}
