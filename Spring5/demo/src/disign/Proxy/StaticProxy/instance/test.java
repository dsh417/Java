package disign.Proxy.StaticProxy.instance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        try {
            Order order=new Order();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/ss");
            Date date=sdf.parse("2017/02/01");
            order.setCreateTime(date.getTime());

            IOrderService orderService=new OrderServiceStaticProxy(new OrderService());
            orderService.createOrder(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
