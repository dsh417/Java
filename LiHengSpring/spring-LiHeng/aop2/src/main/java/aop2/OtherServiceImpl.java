package aop2;

public class OtherServiceImpl implements IOtherService {
    @Override
    public void doSome() throws SomeException {
        System.out.println("OtherServiceImpl.some");
        throw new SomeException();
    }

    @Override
    public String doOther(String x) {
        System.out.println("OtherServiceImpl.other");
        return x.toUpperCase();
    }
}
