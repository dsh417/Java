package top.duanshuheng.aop.a1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class methodCacheAdvice implements MethodInterceptor {

    private static Map<Key,Object> resulet=new HashMap<>();

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Object o=methodInvocation.getThis();
        Method mt=methodInvocation.getMethod();
        Object[] os=methodInvocation.getArguments();

        Key key=new Key(o,mt,os);
        Object result=resulet.get(key);
        if(result==null){
            result=methodInvocation.proceed();
            resulet.put(key,result);
        }
        return result;

    }


    private static class Key{
        private  Object o;
        private  Method method;
        private Object[] os;

        public Key(Object o, Method method, Object[] os) {
            this.o = o;
            this.method = method;
            this.os = os;
        }

        @Override
        public boolean equals(Object o1) {
            if (this == o1) return true;
            if (o1 == null || getClass() != o1.getClass()) return false;
            Key key = (Key) o1;
            return Objects.equals(o, key.o) && Objects.equals(method, key.method) && Arrays.equals(os, key.os);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(o, method);
            result = 31 * result + Arrays.hashCode(os);
            return result;
        }
    }
}
