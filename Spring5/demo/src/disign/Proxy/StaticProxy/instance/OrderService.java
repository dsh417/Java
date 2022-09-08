package disign.Proxy.StaticProxy.instance;

public class OrderService implements IOrderService{
    private OrderDao orderDao;

    public OrderService() {
        //如果使用spring是自动注入的
        //为了使用方便，在构造方法中就直接将orderDao直接初始化
        orderDao=new OrderDao();
    }

    @Override
    public int createOrder(Order order) {

        System.out.println("OrderService调用orderDao创建订单");
        return orderDao.insert(order);

    }
}
