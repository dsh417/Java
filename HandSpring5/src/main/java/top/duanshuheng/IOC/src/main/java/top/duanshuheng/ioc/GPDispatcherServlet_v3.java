//package top.duanshuheng.IOC.src.main.java.top.duanshuheng.ioc;
//
//import top.duanshuheng.ioc.annotation.*;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.net.URL;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
////3.0版本的ioc优化，最接近核心源码
////3个问题：
////保存url对应的方法的关系，handlermapping，要像spring MVC一样支持正则
////url参数要支持强制类型转换
////反射调用前还需要重新获取beanName
//public class GPDispatcherServlet_v3 extends HttpServlet {
//
////    配置文件
//    private Properties contextConfig=new Properties();
//
////    保存扫描到的所有类名
//    private List<String> classNames=new ArrayList<String>();
//
////    最为关键的ioc容器
//    private Map<String,Object> ioc=new HashMap<String,Object>();
//
////    保存url和Method的关系
////    优化：
////    private Map<String,Method> handlerMapping=new HashMap<String,Method>();
//    private List<Handler> handlerMapping=new ArrayList<Handler>();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {this.doPost(req,resp);} {
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        try {
////            委派模式
//            doDispatch(req,resp);
//        } catch (Exception e) {
//            resp.getWriter().write("500 Exception "+ Arrays.toString(e.getStackTrace()));
//        }
//    }
//
//    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception{
//        String url= String.valueOf(req.getRequestURL());
//        String contextPath=req.getContextPath();
//
////        ===========将handlermapping重构为list后，也要重构这个方法================
//        Handler handler=getHander(req);
//        if(handler==null){
//            resp.getWriter().write("404");
//            return;
//        }
//
////        获得方法形参列表
//        Class<?>[] parameType=handler.method.getParameterTypes();
//
////        实参保存
//        Object[] paramValues=new Object[parameType.length];
//
//        Map<String,String[]> params=req.getParameterMap();
//
//        for (Map.Entry<String, String[]> parm : params.entrySet()) {
//            String value=Arrays.toString(parm.getValue()).replaceAll("\\[|\\]","")
//                    .replaceAll("\\s",",");
//
////
//            if(!handler.paramIndexMapping.containsKey(parm.getKey())){
//                continue;
//            }
//
//            int index=handler.paramIndexMapping.get(parm.getKey());
//            paramValues[index]=convert(parameType[index],value);
//        }
//
//        if (!handler.paramIndexMapping.containsKey(HttpServletRequest.class)) {
//            int reqIndex=handler.paramIndexMapping.get(HttpServletRequest.class.getName());
//            paramValues[reqIndex]=req;
//        }
//
//        if (!handler.paramIndexMapping.containsKey(HttpServletResponse.class)) {
//            int respIndex=handler.paramIndexMapping.get(HttpServletResponse.class.getName());
//            paramValues[respIndex]=resp;
//        }
//
//        Object returnValue=handler.method.invoke(handler.controller,paramValues);
//        if(returnValue==null || returnValue instanceof Void){
//            return;
//        }
//        resp.getWriter().write(returnValue.toString());
////
////        url=url.replaceAll(contextPath,"").replaceAll("/+","/");
////        if(!this.handlerMapping.containsKey(url)){
//////            未注册的url无法解析
////            resp.getWriter().write("404");
////            return;
////        }
//////       方法已经注册过 根据请求的url得到相应的方法
////        Method method=this.handlerMapping.get(url);
//////        方法所在的实例和调用时需要的形参
////        Map<String,String[]> params=req.getParameterMap();
//////        获取方法行参
////        Class<?>[] parameterTypes=method.getParameterTypes();
//////        保存请求的url参数列表
////        Map<String,String[]> parameterMap=req.getParameterMap();
//////        保存复制参数的位置
////        Object[] parameterValues=new Object[parameterTypes.length];
//////        根据参数位置动态赋值
////        for (int i = 0; i < parameterTypes.length; i++) {
////            Class parameterType=parameterTypes[i];
////            if(parameterType == HttpServletRequest.class){
////                parameterValues[i] =req;
////                continue;
////            }else if(parameterType == HttpServletResponse.class){
////                parameterValues[i]=resp;
////                continue;
////            }else if(parameterType==String.class){
////
//////                提取方法中加了注解的参数
////                Annotation[][] pa=method.getParameterAnnotations();
////                for (int j = 0; j < pa.length; j++) {
////                    for (Annotation a : pa[i]) {
////                        if(a instanceof GPRequestParam){
////                            String paramName=((GPRequestParam) a).value();
////                            if(!"".equals(paramName.trim())){
////                                String value=Arrays.toString(parameterMap.get(paramName))
////                                        .replaceAll("\\[|\\]","")
////                                        .replaceAll("\\s",",");
////                                parameterValues[i]=value;
////                            }
////                        }
////
////                    }
////                }
////            }
////        }
////
//////        这时候values已经保存了所有的参数
////        String beanName=toLowerFirstCase(method.getDeclaringClass().getSimpleName());
////        method.invoke(ioc.get(beanName),new Object[]{req,resp,params.get("name")[0]});
//
//
//
////        ===========刚开始对url的参数处理是静态的，要实现url参数动态获取，所以进行了如上修改================
////        url=url.replaceAll("/+","/");
////        if(!this.handlerMapping.containsKey(url)){
////            resp.getWriter().write("404");
////            return;
////        }
////
////        Method method=this.handlerMapping.get(url);
//////        方法所在的实例、方法所需要的实参
////
////        Map<String,String[]> params=req.getParameterMap();
////
////        String beanName=toLowerFirstCase(method.getDeclaringClass().getSimpleName());
////        method.invoke(ioc.get(beanName),new Object[]{req,resp,params.get("name")[0]});
////        System.out.println("invoke:"+method);
//
//    }
//
//    private Handler getHander(HttpServletRequest req) {
//        if(handlerMapping.isEmpty()){
//            return null ;
//        }
//
//        String url= String.valueOf(req.getRequestURL());
//        String contextPath=req.getContextPath();
//        url=url.replaceAll(contextPath,"").replaceAll("/+","/");
//        for (Handler handler : handlerMapping) {
//            Matcher matcher=handler.pattern.matcher(url);
//
//            if(!matcher.matches()){
//                continue;
//            }
//            return handler;
//        }
//        return null;
//    }
//
////     如果传来的url的参数是String类型，由于HTTP是基于字符串协议，所以只需要把String转化任意类型
//
//    private Object convert(Class<?> type,String value){
//        if(Integer.class==type){
//            return Integer.valueOf(value);
//        }
////        还有很多类型，这里避免过多使用if，应该用策略模式实现
//
////        先不做了
//
//        return null;
//    }
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
////        1  加载配置文件
//        doLoadConfig(config.getInitParameter("contextConfigLocation"));
////        2  扫描相关类
//        doScanner(contextConfig.getProperty("scanPackage"));
////        3  初始化扫描到的类
////          工厂模式的具体实现
//        doInstance();
////        4  完成依赖注入(DI)
//        doAutowired();
////        5  初始化HandlerMapping(url和method一对一关系）
//        initHandlerMapping();
//
//        System.out.println("My GPSpring framework is init.");
//
//    }
//
//    private void initHandlerMapping() {
//        if(ioc.isEmpty()){return;}
//
//        for (Map.Entry<String,Object> entry : ioc.entrySet()) {
//            Class<?> clazz=entry.getValue().getClass();
//
//            if(!clazz.isAnnotationPresent(GPController.class)){continue;}
//
////            保存设置类上面的/demo
//            String baseUrl="";
//
//            if(clazz.isAnnotationPresent(GPRequestMapping.class)){
//                GPRequestMapping requestMapping=clazz.getAnnotation(GPRequestMapping.class);
//                baseUrl=requestMapping.value();
//            }
////            获取所有类型的方法
//            Method[] methods=clazz.getMethods();
//            for (Method method : methods) {
//                if(!method.isAnnotationPresent(GPRequestMapping.class)){continue;}
//
//                GPRequestMapping requestMapping=method.getAnnotation(GPRequestMapping.class);
//
//                String url=("/"+baseUrl+"/"+requestMapping.value()).replaceAll("/+","/");
//
//                Pattern pattern=Pattern.compile(url);
//                handlerMapping.add(new Handler(pattern,entry.getValue(),method));
//                System.out.println("mapping "+url+","+method);
//
////                handlerMapping.put(url,method);
////                System.out.println("url对应方法：url："+url+","+method);
//
//            }
//        }
//    }
//
//    private void doAutowired() {
//        if(ioc.isEmpty()){return;}
//
//        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
////            获取所有类型字段，私有的，default的等等
//            Field[] fields=entry.getValue().getClass().getDeclaredFields();
//            for (Field field : fields) {
//                if(!field.isAnnotationPresent(GPAutowired.class)){continue;}
//
////                获取参数
//                GPAutowired autowired=field.getAnnotation(GPAutowired.class);
////                q1
//                String beanName=autowired.value().trim();
//                if("".equals(beanName)){
//                    beanName=field.getType().getName();
//                }
////                反射暴力访问
//                field.setAccessible(true);
//
//                try {
////                    反射动态赋值
//                    field.set(entry.getValue(),ioc.get(beanName));
//
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }
//
//    private void doInstance() {
////        开始DI
//        if(classNames.isEmpty()){return;}
//
//        for (String className: classNames) {
//            try {
//                Class<?> clazz = Class.forName(className);
//
////                q：思考，什么样的类才需要初始化
////                a：加了注解的类需要
////                q：怎么判断？
////                a：通过方法isAnnotationPresent
//
//                if (clazz.isAnnotationPresent(GPController.class)) {
////                    服务发现入口，唯一一个，直接进行保存
//                    Object instance = clazz.newInstance();
//
////                    spring默认类名首字母小写
//                    String beanName = toLowerFirstCase(clazz.getSimpleName());
//                    ioc.put(beanName, instance);
//                } else if (clazz.isAnnotationPresent(GPService.class)) {
////                    自定义的beanName
//
//                    GPService service = clazz.getAnnotation(GPService.class);
//                    String beanName = service.value();
//                    if ("".equals(beanName)) {
//                        beanName = toLowerFirstCase(clazz.getSimpleName());
//                    }
//
//                    Object instance = clazz.newInstance();
//                    ioc.put(beanName, instance);
////
//
////                    将service实现的接口都保存下来并指向这个service实现类，因为后面在依赖注入肯定有多态，就是接口调用子类
////                    根据类型自动赋值
//                    for (Class<?> i : clazz.getInterfaces()) {
//                        if (ioc.containsKey(i.getName())) {
//                            throw new Exception("这个\"" + i.getName() + "\"退出！");
//                        }
////                        把接口的类型直接当成key
//                        ioc.put(i.getName(), instance);
//                    }
//                } else {
//                    continue;
//                }
//
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (InstantiationException e) {
//                throw new RuntimeException(e);
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//
//    }
//
//    private String toLowerFirstCase(String simpleName) {
////        工具类
//        char[] chars=simpleName.toCharArray();
////        大小写字母相差32
////        java实际上对char算术运算是对ascii运算
//        chars[0]+=32;
//        return String.valueOf(chars);
//    }
//
//    private void doScanner(String scanPackage) {
////        实际上是scanPackage=top.duanshuheng.ioc 包路径
////        要转换为文件路径，即.转换为/
//        URL url=this.getClass().getClassLoader().getResource("/"+scanPackage.replaceAll("\\.","/"));
//
//        File classPath=new File(url.getFile());
//        for (File file :classPath.listFiles()) {
//            if(file.isDirectory()){
////                包里还有包，进行递归
//                doScanner(scanPackage+"."+file.getName());
//            }else {
////                跳过非class文件
//                if(!file.getName().endsWith(".class")){continue;}
////                将类以包名.类名形式保存下来
//                String className=(scanPackage+"."+file.getName().replaceAll(".class",""));
//                classNames.add(className);
//            }
//
//        }
//    }
//
//    private void doLoadConfig(String contextConfigLocation) {
////        通过 类路径 找到Spring主配置文件所在的路径
////        并且将其读取出来放到Properties对象中
////        相当于将scanPackage=top.duanshuheng.ioc保存到了内存中
//        InputStream fis=this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
//
//        try {
//            contextConfig.load(fis);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }finally {
//            if(null!=fis){
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }
//
////
////    将map类型的handlermapping改成list
////    内部类Handler用于储存requestmapping和method的对应关系
//
//    private class Handler{
////        保存方法对应的实例
//        protected Object controller;
//
////        保存映射方法
//        protected Method method;
//
////        正则表达式
//        protected Pattern pattern;
//
////        参数顺序
//    protected Map<String,Integer> paramIndexMapping;
//
//    protected Handler(Pattern pattern,Object controller,Method method){
//        this.controller=controller;
//        this.method=method;
//        this.pattern=pattern;
//
//        paramIndexMapping = new HashMap<String,Integer>();
//
//        putParamIndexMapping(method );
//    }
//
//    private void putParamIndexMapping(Method method) {
////                提取方法中加了注解的参数,存储于内部类Map中
////                @interface
//        Annotation[][] pa=method.getParameterAnnotations();
//        for (int i = 0; i < pa.length; i++) {
//            for (Annotation a: pa[i]) {
//                if(a instanceof GPRequestParam){
//                    String paramName=((GPRequestParam) a).value();
//                    if(!"".equals(paramName.trim())){
//                        paramIndexMapping.put(paramName,i);
//                    }
//                }
//            }
//        }
////        提取方法中request的response参数
//        Class<?>[] paramsTypes=method.getParameterTypes();
//        for (int i = 0; i < paramsTypes.length; i++) {
//            Class<?> type=paramsTypes[i];
////            保存<>
//            if(type==HttpServletRequest.class || type==HttpServletResponse.class){
//                paramIndexMapping.put(type.getName(),i);
//            }
//        }
//
//    }
//
//
//
//
//    }
//}
