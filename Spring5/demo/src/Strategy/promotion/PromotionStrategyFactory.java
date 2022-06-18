package Strategy.promotion;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {

//    饿汉式单例，在加载类时就new了单例
    private static Map<String,PromotionStrategy> PROMOTION_STRATEGY_MAP=new HashMap<String,PromotionStrategy>();

    static{
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK,new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY,new GroupbuyStrategy());
    }


    private static final PromotionStrategy NON_PROMOTION=new EmptyStrategy();

    private PromotionStrategyFactory(){}

    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy=PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy==null?NON_PROMOTION:promotionStrategy;
    }

    private interface PromotionKey{
        String COUPON="COUPON";
        String CASHBACK="CASHBACK";
        String GROUPBUY="GROUPBUY";

    }

}
