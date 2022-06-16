package ProxyPattern.DynamicProxy.JDK;

import ProxyPattern.DynamicProxy.JDK.OrderServiceDynamicProxy;
import ProxyPattern.StaticProxy.instance.IOrderService;
import ProxyPattern.StaticProxy.instance.Order;
import ProxyPattern.StaticProxy.instance.OrderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test2 {
    public static void main(String[] args) {
        try {
            Order order=new Order();

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
            Date date=sdf.parse("2022/06/13");
            order.setCreateTime(date.getTime());

            IOrderService orderService= (IOrderService) new OrderServiceDynamicProxy()
                    .getInstance(new OrderService());

            orderService.createOrder(order);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
