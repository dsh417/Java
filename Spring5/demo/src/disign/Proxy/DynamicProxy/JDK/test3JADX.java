package disign.Proxy.DynamicProxy.JDK;


public class test3JADX {
    public static void main(String[] args) {
        try {
            Person obj= (Person) new JDKMeiop().getInstance(new Customer());
            obj.findLove();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
