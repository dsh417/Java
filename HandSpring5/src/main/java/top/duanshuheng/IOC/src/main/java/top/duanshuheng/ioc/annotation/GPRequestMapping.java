package top.duanshuheng.IOC.src.main.java.top.duanshuheng.ioc.annotation;


import java.lang.annotation.*;

@Target({ElementType.TYPE ,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestMapping {
    String value() default "";
}
