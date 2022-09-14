package disign.Strategy.payport;

public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    /*
    * 完美解决了switch过程，不需要写switch了
    * */

    public PayState pay(){
        return pay(PayStrategy.DEFAULT_PAY);
    }
    public PayState pay(String payKey){
        Payment payment=new PayStrategy().get(payKey);
        System.out.println("欢迎使用"+payment.getName());
        System.out.println("本次交易金额为"+amount+",开始扣款");
        return payment.pay(uid,amount);
    }


}
