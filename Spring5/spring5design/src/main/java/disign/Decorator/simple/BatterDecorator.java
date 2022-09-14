package disign.Decorator.simple;

public abstract class BatterDecorator extends Battercake{

    private Battercake battercake;

    public BatterDecorator(Battercake battercake) {
        this.battercake = battercake;
    }


    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
