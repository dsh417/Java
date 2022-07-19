package DisignMode.Strategy.promotion;

public class test2 {
    public static void main(String[] args) {

        PromotionActivity activity=null;

        String promotionKey="COUPON";

        if("COUPON".equals(promotionKey)){
            activity  = new PromotionActivity(new CouponStrategy());
        }else if("CASHBACK".equals(promotionKey)) {
            activity  = new PromotionActivity(new CashbackStrategy());
        }

        activity.execute();
    }
    /*
    * 这样满足了业务需求
    * 客户可以自己选择优惠策略
    * 但是业务越来越大，业务积累，每次活动上线需要改代码，重复测试，这是不好的
    *
    * 优化方案：
    * 工厂模式+单例模式
    *
    * 优化->test3
    * */

}
