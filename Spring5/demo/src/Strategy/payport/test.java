package Strategy.payport;

public class test {
    public static void main(String[] args) {
        Order order=new Order("1","201391249131321",324.45);
//        开始支付，选择方式
        System.out.println(order.pay(PayStrategy.ALI_PAY));

    }
}
