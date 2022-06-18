package Strategy.promotion;

public class test3 {
    public static void main(String[] args) throws InterruptedException {
        String promotionKey="GOUPBUY";
        PromotionActivity activity=new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        activity.execute();

    }
}
