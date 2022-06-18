package DelegatePattern.springMVCDispatcherServlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//相当于项目经理的角色
public class DispatcherServlet extends HttpServlet {

    private void doDispatch(HttpServletRequest request, HttpServletResponse response){
        String uri=request.getRequestURI();

        String mid=request.getParameter("mid");

        if("getMemberById".equals(uri)){
            new MemberController().getMemberById(mid);
        }else if("getOrderById".equals(mid)){
            new OderController().getOrderById(mid);
        }else if ("logout".equals(uri)){
            new SystemController().logout();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



