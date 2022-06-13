package ProxyPattern.DynamicProxy.JDK;

public class test {
    public static void main(String[] args) {
        try {
            Person obj= (Person) new JDKMeiop().getInstance(new Customer());
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
