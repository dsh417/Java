//package DelegatePattern.springMVCDispatcherServlet.more;
//
//import DelegatePattern.springMVCDispatcherServlet.MemberController;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DispatcherServlet extends HttpServlet {
//
//    private List<Handler> handlerMapping=new ArrayList<Handler>();
//
//    public void init() throws SecurityException{
//        try {
//            Class<?> memberControllerClass= MemberController.class;
//
//            handlerMapping.add(new Handler()
//                    .setController(memberControllerClass.newInstance())
//                    .setMethod(memberControllerClass.getMethod("getMemberById",new Class[]{String.class}))
//                    .setUrl("/web/getMemberById.json"));
//
//        } catch (Exception e) {
//
//        }
//
//
//    }
//
//    private void doDispatch(HttpServletRequest request, HttpServletResponse response){
//        String url=request.getRequestURI();
//
//        Handler handler=null;
//        for (Handler h :
//                handlerMapping) {
//            handler=h;
//            break;
//        }
//
//        Object object=null;
//        try {
//            object=handler.getMethod().invoke(handler.getController(),request.getParameter("mid"));
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    protected void service(HttpServletRequest request,HttpServletResponse response){
//        try {
//            doDispatch(request,response);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    class Handler{
//        private Object controller;
//        private Method method;
//        private String url;
//
//        public void setController(Object controller) {
//            this.controller = controller;
//        }
//
//        public void setMethod(Method method) {
//            this.method = method;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//        public Object getController() {
//            return controller;
//        }
//
//        public Method getMethod() {
//            return method;
//        }
//
//        public String getUrl() {
//            return url;
//        }
//    }
//
//}
