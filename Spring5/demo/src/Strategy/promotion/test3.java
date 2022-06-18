package Strategy.promotion;

public class test3 {
    public static void main(String[] args) throws InterruptedException {
        String promotionKey="GROUPBUY";
        PromotionActivity activity=new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        activity.execute();
/*
* 于是这样修改后，未来有新活动，只需要在map里添加新活动即可字符串调用
*
* */
    }
}
