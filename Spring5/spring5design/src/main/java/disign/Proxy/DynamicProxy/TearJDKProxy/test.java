package disign.Proxy.DynamicProxy.TearJDKProxy;

import disign.Proxy.DynamicProxy.JDK.Customer;
import disign.Proxy.DynamicProxy.JDK.Person;

public class test {
    public static void main(String[] args) {
        try {
            Person obj= (Person) new GPMeipo().getInstance(new Customer());
            System.out.println(obj.getClass());
            obj.findLove();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
