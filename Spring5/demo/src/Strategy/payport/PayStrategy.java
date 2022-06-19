package Strategy.payport;

import java.util.HashMap;
import java.util.Map;

public class PayStrategy {
    public static final String ALI_PAY="AliPay";
    public static final String JD_PAY="JDPay";
    public static final String UNION_PAY="UnionPay";
    public static final String WECHAT_PAY="WechatPay";
    public static final String DEFAULT_PAY="AliPay";

    private static Map<String,Payment> payStategy=new HashMap<String,Payment>();

    static {
        payStategy.put(ALI_PAY,new AliPay());
        payStategy.put(JD_PAY,new JDPay());
        payStategy.put(WECHAT_PAY,new WechatPay());
        payStategy.put(UNION_PAY,new UnionPay());
        payStategy.put(DEFAULT_PAY,new AliPay());
    }

    public static Payment get(String payKey){
        if(!payStategy.containsKey(payKey)){
            return payStategy.get(DEFAULT_PAY);
        }
        return payStategy.get(payKey);
    }



}
