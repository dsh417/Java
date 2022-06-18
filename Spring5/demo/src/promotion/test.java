package promotion;

public class test {
    public static void main(String[] args) {
        PromotionActivity activity618=new PromotionActivity(new CouponStrategy());

        PromotionActivity activity1111=new PromotionActivity(new CashbackStrategy());

        activity618.execute();

        activity1111.execute();
    }
/*
* 实际业务场景不适用
* 做活动根据不同需求进行动态选择
* 需要修改->test2
*
* */
}
