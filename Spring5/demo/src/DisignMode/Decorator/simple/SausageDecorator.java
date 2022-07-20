package DisignMode.Decorator.simple;

public class SausageDecorator extends BatterDecorator{
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }


    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"1个香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+2;
    }
}
