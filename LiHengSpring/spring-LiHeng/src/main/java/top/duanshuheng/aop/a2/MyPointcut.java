package top.duanshuheng.aop.a2;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;

//自定义切入点
public class MyPointcut implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {

        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
//                类型匹配，这里匹配SomeServiceImple
                return ISomeServiceImpl.class.equals(aClass);
            }
        };

    }

    @Override

    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> aClass) {
//                无参方法匹配
                return "doSome".equals(method.getName());
            }

            @Override
            public boolean isRuntime() {
                return false;
            }

            @Override
            public boolean matches(Method method, Class<?> aClass, Object... objects) {
//                有参方法匹配
                return false;
            }
        };
    }
}
