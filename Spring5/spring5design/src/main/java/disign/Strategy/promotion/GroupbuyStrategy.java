package disign.Strategy.promotion;

public class GroupbuyStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("拼团20人，全团折扣");
    }
}
