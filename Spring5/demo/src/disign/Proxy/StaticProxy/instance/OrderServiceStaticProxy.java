package disign.Proxy.StaticProxy.instance;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        System.out.println("静态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();

        return 0;
    }

    private void after() {
        System.out.println("Disign.Proxy after method");
    }

    private void before() {
        System.out.println("Disign.Proxy befor method");
    }


}
