package 反射;

import 集合.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class TestClass2 {
    public static void main(String[] args) throws Exception{
//        Class c= Person.class;
//
        Scanner sc=new Scanner(System.in);
        Class c=Class.forName(sc.nextLine());





        //获得包
        Package pack=c.getPackage();

        //获得类名
//        String className= c.getName();
        String className=c.getSimpleName();

        //获得父类
        Class superClass=c.getSuperclass();
//        String superClassName=superClass.getSimpleName();



//        System.out.println(pack);
//        System.out.println(className);

        System.out.print("public class "+className+" extends ");
        System.out.print(superClass.getSimpleName()+" implements ");


        //获得实现的接口
        Class[] interfaces=c.getInterfaces();
        for (Class inter :
                interfaces) {
            System.out.print(inter.getSimpleName()+" ");
        }
        System.out.println("{");

        //获得属性
//        Field[] fields=c.getFields();   //只能获得公开属性
        Field[] fields=c.getDeclaredFields();

        for (Field filed :
                fields) {
            //获得属性修饰符
            int mod = filed.getModifiers();
            String modifier= Modifier.toString(mod);
            System.out.print(modifier+" ");

            //获得属性类型
            Class fieldClass=filed.getType();
            System.out.print(fieldClass.getSimpleName()+" ");

            //获得属性名
            String fieldName=filed.getName();
            System.out.println(fieldName+";");
        }

        System.out.println();

        //获得构造方法
        Constructor[] constructors=c.getDeclaredConstructors();

        for (Constructor con :
                constructors) {

            //方法访问权限
            int mod=con.getModifiers();
            String conField=Modifier.toString(mod);
            System.out.print("    "+conField+" ");

            System.out.print(c.getSimpleName()+"(");



            //获得参数类型
            Class[] paramClasses=con.getParameterTypes();
            for (Class paramClass:
                    paramClasses
                 ) {
                System.out.print(paramClass.getSimpleName()+" ");
            }
            System.out.print(")");



            //获得构造方法抛出异常
            Class[] exceptionClasses=con.getExceptionTypes();
            for (Class exc :
                    exceptionClasses) {
                System.out.print(" throws "+exc.getSimpleName()+" ");
            }
            System.out.println("{");

            //反射无法看到方法里的东西，但是可以调用（可以看到叫反编译，非正常手段）

            System.out.println("    }");


        }


        Method[] methods=c.getMethods();
        for (Method method :
                methods) {
            int mod=method.getModifiers();
            String modifier=Modifier.toString(mod);
            System.out.print("    "+modifier);

            //返回类型
            Class returnType=method.getReturnType();
            System.out.print(returnType.getSimpleName()+" ");

            //方法名
            String methodName=method.getName();
            System.out.print(methodName);

            System.out.print(" (");

            Class[] paramClass=method.getExceptionTypes();
            for (Class paramClass2 :
                    paramClass) {
                System.out.print(paramClass2.getSimpleName()+" ");

            }
            System.out.print(") throws ");



            //获得异常
            Class[] exceptionClasses=method.getExceptionTypes();
            for (Class exc :
                    exceptionClasses) {
                System.out.print(" throws "+exc.getSimpleName()+" ");
            }

            System.out.print("{");


            System.out.println("    }");






            System.out.println();
        }


        System.out.println("}");
    }
}
