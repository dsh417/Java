package ProxyPattern.StaticProxy.instance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class OrderServiceStaticProxy implements IOrderService{
    private SimpleDateFormat yearFamat=new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long time=order.getCreateTime();
        Integer dbRouter=Integer.valueOf(yearFamat.format(new Date()));


        return 0;
    }

    private void before() {
        System.out.println("Proxy befor method");
    }
}
