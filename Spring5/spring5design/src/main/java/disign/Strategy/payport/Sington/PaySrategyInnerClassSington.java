package disign.Strategy.payport.Sington;

import disign.Strategy.payport.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

public class PaySrategyInnerClassSington implements Serializable,Cloneable {

    PaySrategyInnerClassSington(){
        System.out.println("调用了外部类构造方法");
        if(GETSINGTON.s==null){
            throw new RuntimeException("不要试图通过反射new对象！");
        }


    }

    public static PaySrategyInnerClassSington getInstance(){
        return GETSINGTON.s;
    }

    @Serial
    public Object readResolve(){
        return GETSINGTON.s;
    }

    public static Payment get(String key){
        return GETSINGTON.get(key);
    }


    public static class GETSINGTON{

        /*
        * 通过静态内部类加载时机
        * 在调用外部类时，不会加载静态内部类
        * 在实例化外部类，外部类加载静态内部类，才会实际的实例话对象，增强空间利用率的同时
        * 避免了双检索的效率问题，
        * 并且重写readResolve方法，在序列化反序列化后单例对象不变
        * 在外部类的构造方法进行静态内部类的成员判断，由于未曾加载内部类，未实例前一定为null，如果试图反射获取构造器new对象则直接抛错误
        * ，返回单例对象时候
        *
        *
        * */

        private static final PaySrategyInnerClassSington s=new PaySrategyInnerClassSington();
        public static final String ALI_PAY="AliPay";
        public static final String JD_PAY="JDPay";
        public static final String UNION_PAY="UnionPay";
        public static final String WECHAT_PAY="WechatPay";
        public static final String DEFAULT_PAY="AliPay";
        public static HashMap<String, Payment> payStategy =new HashMap<String,Payment>();

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


}
