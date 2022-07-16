package ProxyPattern.DynamicProxy.TearJDKProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

//用来生成源代码的工具类
public class GPProxy {
    public static final String ln="\r\n";

    public static Object newProxyInstance(GPClassLoader classLoader, Class<?>[] interfaces, GPInvocationHandler h){
        try {
            //动态生成
            String src=generateSrc(interfaces);

            //java文件输出磁盘
            String filePath=GPProxy.class.getResource("").getPath();
            File f=new File(filePath+"$Proxy0.java");
            FileWriter fw=new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            //生成的java文件编译成class文件
            JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage=compiler.getStandardFileManager(null,null,null);
            Iterable iterable= manage.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task=compiler.getTask(null,manage,null,null,null,iterable);
            task.call();
            manage.close();

            //编译的.class加载到jvm中
            Class proxyClass=classLoader.findClass("$Proxy0");
            Constructor c=proxyClass.getConstructor(GPInvocationHandler.class);
            f.delete();

            //返回字节码重组后新的代理对象
            return c.newInstance(h);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        不可达语句注释，环境:jdk17.0.1  idea2022.1.2    2022年6月16日16:00:36
//        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb=new StringBuffer();
        //包名
        sb.append("package ProxyPattern.DynamicProxy.TearProxy;"+ln);
        //依赖名
        sb.append("import ProxyPattern.DynamicProxy.JDK.Person;"+ln);
        sb.append("import java.lang.reflect.*;"+ln);
        //实现所有接口
        sb.append("public class $Proxy0 implements "+interfaces[0].getName()+"{"+ln);
            //成员名(记得+;)
            sb.append("GPInvocationHandler h;"+ln);
            //新对象的参构造方法
            sb.append("public $Proxy0(GPInvocationHandler h) {"+ln);
                sb.append("this.h=h;"+ln);
            sb.append("}"+ln);
            //获取方法对象
            for (Method m : interfaces[0].getMethods()) {
                Class<?>[] params=m.getParameterTypes();

                StringBuffer paramNames=new StringBuffer();
                StringBuffer paramValuess=new StringBuffer();
                StringBuffer paramClassess=new StringBuffer();

                for (int i = 0; i < params.length; i++) {
                    Class clazz = params[i];
                    String type = clazz.getName();
                    String paramName = toLowerFirstCase(clazz.getSimpleName());

                    //类型修饰符+简单名字
                    paramNames.append(type + " " + paramName);
                    //
                    paramValuess.append(paramName);
                    //类型.class
                    paramClassess.append(clazz.getName() + ".class");
                    if (i > 0 && i < params.length - 1) {
                        paramNames.append(",");
                        paramClassess.append(",");
                        paramValuess.append(",");
                    }
                }

//                    public Object name(paramnames){
                    sb.append("public "+m.getReturnType().getName()+" "+m.getName()+"("+paramNames.toString()+") {"+ln);
//                        try{
                        sb.append("try{"+ln);
//                           Method m=name.class.getMethod("name",new Class[]{Type})
                            sb.append("Method m = "+interfaces[0].getName()+".class.getMethod(\""+m.getName()+"\",new Class[]{"+paramClassess.toString()+"});"+ln);
                            sb.append((hasReturnValue(m.getReturnType())?"return ":"")+getCaseCode("this.h.invoke(this,m,new Object[]{"+paramValuess+"})",m.getReturnType())+";"+ln);
                            sb.append("}catch(Error _ex){ }");
                            sb.append("catch(Throwable e){"+ln);
                            sb.append("throw new UndeclaredThrowableException(e);"+ln);
                        sb.append("}");
                        sb.append(getReturnEmptyCode(m.getReturnType()));
                    sb.append("}");
                }
            sb.append("}"+ln);
            return sb.toString();
    }
    private static Map<Class,Class> mappings=new HashMap<Class,Class>();
    static{
        mappings.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass) {
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        } else if (returnClass==void.class) {
            return "";
        }else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code, Class<?> returnClass) {
        if(mappings.containsKey(returnClass)){
            return "(("+mappings.get(returnClass).getName()+")"+code+")."+returnClass.getSimpleName()+"Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz!=void.class;
    }

    private static String toLowerFirstCase(String src) {
        char[] chars= src.toCharArray();
        chars[0] +=32;
        return String.valueOf(chars);
    }
}
