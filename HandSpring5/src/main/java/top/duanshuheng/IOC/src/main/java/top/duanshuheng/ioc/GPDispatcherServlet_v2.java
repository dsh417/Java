package top.duanshuheng.IOC.src.main.java.top.duanshuheng.ioc;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.duanshuheng.IOC.src.main.java.top.duanshuheng.ioc.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

//使用工厂、单例、委派、策略模式重构的手写ioc
public class GPDispatcherServlet_v2 extends HttpServlet {

//    配置文件
    private Properties contextConfig=new Properties();

//    保存扫描到的所有类名
    private List<String> classNames=new ArrayList<String>();

//    最为关键的ioc容器
    private Map<String,Object> ioc=new HashMap<String,Object>();

//    保存url和Method的关系
    private Map<String,Method> handlerMapping=new HashMap<String,Method>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {this.doPost(req,resp);} {
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
//            委派模式
            doDispatch(req,resp);
        } catch (Exception e) {
            resp.getWriter().write("500 Exception "+ Arrays.toString(e.getStackTrace()));
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String url= String.valueOf(req.getRequestURL());
        String contextPath=req.getContextPath();

        url=url.replaceAll(contextPath,"").replaceAll("/+","/");
        if(!this.handlerMapping.containsKey(url)){
//            未注册的url无法解析
            resp.getWriter().write("404");
            return;
        }
//       方法已经注册过 根据请求的url得到相应的方法
        Method method=this.handlerMapping.get(url);
//        方法所在的实例和调用时需要的形参
        Map<String,String[]> params=req.getParameterMap();
//        获取方法行参
        Class<?>[] parameterTypes=method.getParameterTypes();
//        保存请求的url参数列表
        Map<String,String[]> parameterMap=req.getParameterMap();
//        保存复制参数的位置
        Object[] parameterValues=new Object[parameterTypes.length];
//        根据参数位置动态赋值
        for (int i = 0; i < parameterTypes.length; i++) {
            Class parameterType=parameterTypes[i];
            if(parameterType == HttpServletRequest.class){
                parameterValues[i] =req;
                continue;
            }else if(parameterType == HttpServletResponse.class){
                parameterValues[i]=resp;
                continue;
            }else if(parameterType==String.class){

//                提取方法中加了注解的参数
                Annotation[][] pa=method.getParameterAnnotations();
                for (int j = 0; j < pa.length; j++) {
                    for (Annotation a : pa[i]) {
                        if(a instanceof GPRequestParam){
                            String paramName=((GPRequestParam) a).value();
                            if(!"".equals(paramName.trim())){
                                String value=Arrays.toString(parameterMap.get(paramName))
                                        .replaceAll("\\[|\\]","")
                                        .replaceAll("\\s",",");
                                parameterValues[i]=value;
                            }
                        }

                    }
                }
            }
        }

//        这时候values已经保存了所有的参数
        String beanName=toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        method.invoke(ioc.get(beanName),new Object[]{req,resp,params.get("name")[0]});



//        ===========刚开始对url的参数处理是静态的，要实现url参数动态获取，所以进行了如上修改================
//        url=url.replaceAll("/+","/");
//        if(!this.handlerMapping.containsKey(url)){
//            resp.getWriter().write("404");
//            return;
//        }
//
//        Method method=this.handlerMapping.get(url);
////        方法所在的实例、方法所需要的实参
//
//        Map<String,String[]> params=req.getParameterMap();
//
//        String beanName=toLowerFirstCase(method.getDeclaringClass().getSimpleName());
//        method.invoke(ioc.get(beanName),new Object[]{req,resp,params.get("name")[0]});
//        System.out.println("invoke:"+method);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
//        1  加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
//        2  扫描相关类
        doScanner(contextConfig.getProperty("scanPackage"));
//        3  初始化扫描到的类
//          工厂模式的具体实现
        doInstance();
//        4  完成依赖注入(DI)
        doAutowired();
//        5  初始化HandlerMapping(url和method一对一关系）
        initHandlerMapping();

        System.out.println("My GPSpring framework is init.");

    }

    private void initHandlerMapping() {
        if(ioc.isEmpty()){return;}

        for (Map.Entry<String,Object> entry : ioc.entrySet()) {
            Class<?> clazz=entry.getValue().getClass();

            if(!clazz.isAnnotationPresent(GPController.class)){continue;}

//            保存设置类上面的/demo
            String baseUrl="";

            if(clazz.isAnnotationPresent(GPRequestMapping.class)){
                GPRequestMapping requestMapping=clazz.getAnnotation(GPRequestMapping.class);
                baseUrl=requestMapping.value();
            }

//            获取所有类型的方法
            for (Method method : clazz.getMethods()) {
                if(!method.isAnnotationPresent(GPRequestMapping.class)){continue;}

                GPRequestMapping requestMapping=method.getAnnotation(GPRequestMapping.class);

                String url=("/"+baseUrl+"/"+requestMapping.value()).replaceAll("/+","/");

                handlerMapping.put(url,method);
                System.out.println("url对应方法：url："+url+","+method);

            }
        }
    }

    private void doAutowired() {
        if(ioc.isEmpty()){return;}

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
//            获取所有类型字段，私有的，default的等等
            Field[] fields=entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if(!field.isAnnotationPresent(GPAutowired.class)){continue;}

//                获取参数
                GPAutowired autowired=field.getAnnotation(GPAutowired.class);
//                q1
                String beanName=autowired.value().trim();
                if("".equals(beanName)){
                    beanName=field.getType().getName();
                }
//                反射暴力访问
                field.setAccessible(true);

                try {
//                    反射动态赋值
                    field.set(entry.getValue(),ioc.get(beanName));

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void doInstance() {
//        开始DI
        if(classNames.isEmpty()){return;}

        for (String className: classNames) {
            try {
                Class<?> clazz = Class.forName(className);

//                q：思考，什么样的类才需要初始化
//                a：加了注解的类需要
//                q：怎么判断？
//                a：通过方法isAnnotationPresent

                if (clazz.isAnnotationPresent(GPController.class)) {
//                    服务发现入口，唯一一个，直接进行保存
                    Object instance = clazz.newInstance();

//                    spring默认类名首字母小写
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName, instance);
                } else if (clazz.isAnnotationPresent(GPService.class)) {
//                    自定义的beanName

                    GPService service = clazz.getAnnotation(GPService.class);
                    String beanName = service.value();
                    if ("".equals(beanName)) {
                        beanName = toLowerFirstCase(clazz.getSimpleName());
                    }

                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);
//

//                    将service实现的接口都保存下来并指向这个service实现类，因为后面在依赖注入肯定有多态，就是接口调用子类
//                    根据类型自动赋值
                    for (Class<?> i : clazz.getInterfaces()) {
                        if (ioc.containsKey(i.getName())) {
                            throw new Exception("这个\"" + i.getName() + "\"退出！");
                        }
//                        把接口的类型直接当成key
                        ioc.put(i.getName(), instance);
                    }
                } else {
                    continue;
                }

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }

    private String toLowerFirstCase(String simpleName) {
//        工具类
        char[] chars=simpleName.toCharArray();
//        大小写字母相差32
//        java实际上对char算术运算是对ascii运算
        chars[0]+=32;
        return String.valueOf(chars);
    }

    private void doScanner(String scanPackage) {
//        实际上是scanPackage=top.duanshuheng.ioc 包路径
//        要转换为文件路径，即.转换为/
        URL url=this.getClass().getClassLoader().getResource("/"+scanPackage.replaceAll("\\.","/"));

        File classPath=new File(url.getFile());
        for (File file :classPath.listFiles()) {
            if(file.isDirectory()){
//                包里还有包，进行递归
                doScanner(scanPackage+"."+file.getName());
            }else {
//                跳过非class文件
                if(!file.getName().endsWith(".class")){continue;}
//                将类以包名.类名形式保存下来
                String className=(scanPackage+"."+file.getName().replaceAll(".class",""));
                classNames.add(className);
            }

        }
    }

    private void doLoadConfig(String contextConfigLocation) {
//        通过 类路径 找到Spring主配置文件所在的路径
//        并且将其读取出来放到Properties对象中
//        相当于将scanPackage=top.duanshuheng.ioc保存到了内存中
        InputStream fis=this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);

        try {
            contextConfig.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(null!=fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
