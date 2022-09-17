//package top.duanshuheng.IOC.src.main.java.top.duanshuheng.ioc;
//
//import top.duanshuheng.ioc.annotation.GPAutowired;
//import top.duanshuheng.ioc.annotation.GPController;
//import top.duanshuheng.ioc.annotation.GPRequestMapping;
//import top.duanshuheng.ioc.annotation.GPService;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.net.URL;
//import java.util.*;
//
//import static javax.xml.xpath.XPathFactory.newInstance;
//
//
////最初版本的手写ioc
////所有核心业务逻辑全部卸载init()方法中
//public class GPDispatcherServlet extends HttpServlet {
//    private Map<String,Object> mapping=new HashMap<String,Object>();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {this.doPost(req,resp);} {
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        try {
//            doDispatch(req,resp);
//        } catch (Exception e) {
//            resp.getWriter().write("500 Exception "+ Arrays.toString(e.getStackTrace()));
//        }
//    }
//
//    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception{
////        获取url,把前部分去掉留下请求路径
//        String url= String.valueOf(req.getRequestURL());
//        System.out.println("获取到url="+url);
//        String contextPath=req.getContextPath();
//        url=url.replace(contextPath,"").replaceAll("/+","/");
//        System.out.println("替换后url="+url);
//
//        if(!this.mapping.containsKey(url)){
////            如果容器里不存在这个url返回404
//            resp.getWriter().write("404 Not Found!!");
//            return;
//        }
//
//        Method method= (Method) this.mapping.get(url);
////        从url里将参数转换成map
//        Map<String,String[]> params=req.getParameterMap();
//
//        method.invoke(this.mapping.get(method.getDeclaringClass().getName()),new Object[]{req,resp,params.get("name")[0]});
//    }
//
//
////        =====以下是1.0版本，使用设计模式后进化2.0，代码是同名java_v2==================================================================
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        InputStream is=null;
//        try {
//            Properties configContext=new Properties();
//            is=this.getClass().getClassLoader().getResourceAsStream(config.getInitParameter("contextConfigLocation"));
//
//            configContext.load(is);
//            String scanPackage=configContext.getProperty("scanPackage");
//            doScanner(scanPackage);
//
//
//            for (String className : mapping.keySet()) {
//                if(!className.contains(".")){continue;}
//
////                入口
//
//
//                Class<?> clazz=Class.forName(className);
//                if(clazz.isAnnotationPresent(GPController.class)){
////                    对带有Controller注释的类进行处理
//                    mapping.put(className,newInstance());
//                    String baseUrl="";
//
//                    if(clazz.isAnnotationPresent(GPRequestMapping.class)){
//                    //判断requestMapping注解在类上，并从而获取url的内容存储在baseUrl里
//                        GPRequestMapping requestMapping=clazz.getAnnotation(GPRequestMapping.class);
//                        baseUrl=requestMapping.value();
//                    }
////                    获取类里所有方法并遍历
//                    Method[] methods=clazz.getMethods();
//                    for (Method method: methods) {
////                       处理的是url所对应的方法，所以没有requestMapping的方法直接略过
//                        if(!method.isAnnotationPresent(GPRequestMapping.class)){continue;}
//
////                        获取方法上注解里的url
//                        GPRequestMapping requestMapping=method.getAnnotation(GPRequestMapping.class);
////                        拼接完整的请求路径，并将路径-方法 存储在mapping容器里
//                        String url=(baseUrl+"/"+requestMapping.value()).replaceAll("/+","/");
//                        mapping.put(url,method);
//                        System.out.println("Mapped "+url+","+method);
//                    }
//
//                }else if(clazz.isAnnotationPresent(GPService.class)){
////                    对带有GPService注释的类进行处理
//                    GPService service=clazz.getAnnotation(GPService.class);
//                    String beanName=service.value();
//                    if("".equals(beanName)){
//                        beanName=clazz.getName();
//                    }
////                    将这个service类以默认值 "类名" 或者已定义的字符串 以键值对的形式存储在mapping容器里
//                    Object instance=clazz.newInstance();
//                    mapping.put(beanName,instance);
//
//                    for (Class<?> i:clazz.getInterfaces()) {
////                        通过反射将获取到的所有接口名存储到mapping容器里，对应这个service类
//                        mapping.put(i.getName(),instance);
//                    }
//                }else {continue;}
//            }
//
//            for (Object o :mapping.values()) {
////                遍历所有mapping容器里的对象
//                if(o==null){continue;}
//
//                Class clazz=o.getClass();
//                if(clazz.isAnnotationPresent(GPController.class)){
//                    Field[] fields=clazz.getDeclaredFields();
//                    for (Field field :fields) {
//                        if(!field.isAnnotationPresent(GPAutowired.class)){continue;}
////                        现在要获取controller注解里所有带有自动装配注解的属性进行装配
//
//                        GPAutowired autowired=field.getAnnotation(GPAutowired.class);
//                        String beanName=autowired.value();
//                        if("".equals(beanName)){
//                            beanName=field.getType().getName();
//                        }
////                        同样的，如果有自定义值作为key直接使用，否则默认为属性声明时的对象名
////                        反射暴力破解，即使是私有
//                        field.setAccessible(true);
//                        try {
////                            通过key从mapping容器里寻找对象，并将其设置到属性值里，这就是ioc自动装配
//                            field.set(mapping.get(clazz.getName()),mapping.get(beanName));
//
//                        } catch (IllegalArgumentException e) {
//                            throw new RuntimeException(e);
//                        } catch (IllegalAccessException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }finally {
////            close
//            if(is!=null){
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//
//    }
//
//    private void doScanner(String scanPackage) {
////        将包里所有类名存储在mapping容器里
//        URL url=this.getClass().getClassLoader().getResource("/"+scanPackage.replaceAll("\\.","/"));
//        File classDir=new File(url.getFile());
//        for (File file : classDir.listFiles()) {
//            if(file.isDirectory()){
//                doScanner(scanPackage+"."+file.getName());
//            }else {
//                if(!file.getName().endsWith(".class")){continue;}
//                String clazzName=(scanPackage+"."+file.getName().replace(".class",""));
//                mapping.put(clazzName,null);
//            }
//
//        }
//    }
//}
