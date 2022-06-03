package action.Impl;

import action.servlet;
import entity.*;
import exception.ServiceException;
import factory.ObjectFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import util.JDBCTemplate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class servletImpl extends HttpServlet implements servlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();

//        注册
//        if("/regist.servlet".equals(path)){
//            regist(request,response);
//        }
        //短注册
        if("/AjaxDongman.servlet".equals(path)){
            dongman(request,response);
        }
        //短注册
        if("/regist.min.servlet".equals(path)){
            registMin(request,response);
        }
        //控制台显示
        if("/list.servlet".equals(path)){
            list(request,response);
        }
        //登录
        if("/loding.servlet".equals(path)){
            loding(request,response);
        }
        //验证账号名
        if("/AjaxRegist.servlet".equals(path)){
            try {
                ajaxregist(request,response);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        //显示聊天
        if("/gettalk.servlet".equals(path)){
            gettalk(request,response);
        }
        //留言
        if("/message.servlet".equals(path)){
            message(request,response);
        }


    }


    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询所有账号


        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();


        UserService userService= (UserService) ObjectFactory.getObject("userService");
        List<User> list=null;
        try {
            list=userService.select();
            request.setAttribute("UserList", list);
            request.getRequestDispatcher("/ShowUse.jsp").forward(request,response);
            out.flush();
        } catch (ServiceException e) {
            e.printStackTrace();
            System.out.println("请求失败");
        }


    }


//
//    private void regist(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
//
//        response.setContentType("application/json;charset=utf-8");
//        PrintWriter out=response.getWriter();
//
//        String uid=request.getParameter("uid");
//        String user=request.getParameter("user");
//        String pass=request.getParameter("pass");
//        String gold=request.getParameter("gold");
//        String time=request.getParameter("time");
//        String attennum=request.getParameter("attennum");
//        String extnum=request.getParameter("extnum");
//        String appellation=request.getParameter("appellation");
//
//        User o=new User();
//        o.setUid(Integer.parseInt(uid));
//        o.setUser(user);
//        o.setPass(pass);
//        o.setGold(Integer.parseInt(gold));
//        o.setTime(time);
//        o.setAttennum(Integer.parseInt(attennum));
//        o.setExtnum(Integer.parseInt(extnum));
//        o.setAppellation(appellation);
//
//
//        UserService userService= (UserService) ObjectFactory.getObject("userService");
//
//        try {
//            List list=new ArrayList();
//            list=userService.select(o);
//            request.setAttribute("UserList", list);
//            request.getRequestDispatcher("/ShowUse.jsp").forward(request,response);
//            out.flush();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//            request.getRequestDispatcher("/ShowUse.jsp").forward(request,response);
//            out.flush();
//        }
//    }
//
    private void registMin(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();

        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        String appellation=request.getParameter("appellation");

        UserRegis userRegis=new UserRegis();
        userRegis.setUser(user);
        userRegis.setPass(pass);
        userRegis.setAppellation(appellation);
        UserService userService= (UserService) ObjectFactory.getObject("userService");
        try {
            userService.regis(userRegis);
            response.sendRedirect(request.getContextPath()+"/lodingPage2.jsp");
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        out.flush();

    }
//
    private void loding(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();

        String user=request.getParameter("user");
        String pass=request.getParameter("pass");

        UserLoding o=new UserLoding();
        o.setUser(user);
        o.setPass(pass);

        UserService userService= (UserService) ObjectFactory.getObject("userService");

        User userReturn=null;
        try {
            userReturn=userService.Loding(o);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        if(userReturn==null){
            response.sendRedirect(request.getContextPath()+"/lodingPage2.jsp");
            return;
        }

        request.setAttribute("Appellation",userReturn);
        request.getRequestDispatcher("/lodingPage2.jsp").forward(request,response);

        out.flush();

    }
//
//    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //查询所有账号
//
//
//        response.setContentType("application/json;charset=utf-8");
//        PrintWriter out=response.getWriter();
//
//        String uid=request.getParameter("uid");
//        String user=request.getParameter("user");
//        String pass=request.getParameter("pass");
//        String gold=request.getParameter("gold");
//        String time=request.getParameter("time");
//        String attennum=request.getParameter("attennum");
//        String extnum=request.getParameter("extnum");
//        String appellation=request.getParameter("appellation");
//
//        User o=new User();
//        o.setUid(Integer.parseInt(uid));
//        o.setUser(user);
//        o.setPass(pass);
//        o.setGold(Integer.parseInt(gold));
//        o.setTime(time);
//        o.setAttennum(Integer.parseInt(attennum));
//        o.setExtnum(Integer.parseInt(extnum));
//        o.setAppellation(appellation);
//
//
//        UserService userService= (UserService) ObjectFactory.getObject("userService");
//
//        try {
//            List list=new ArrayList();
//            list=userService.select(o);
//            request.setAttribute("UserList", list);
//            request.getRequestDispatcher("/ShowUse.jsp").forward(request,response);
//            out.flush();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//            request.getRequestDispatcher("/ShowUse.jsp").forward(request,response);
//            out.flush();
//        }
//
//
//    }
//
    private void ajaxregist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        response.setContentType("text/plain;charset=utf-8");

        PrintWriter out=response.getWriter();
        String user=request.getParameter("user");

        UserAjax userAjax=new UserAjax();
        userAjax.setUser(user);

        UserService userService= (UserService) ObjectFactory.getObject("userService");


        if(userService.ajax(userAjax)) {
            out.println(true);

        }

        out.flush();
    }
//
    private void gettalk(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");


        UserService userService= (UserService) ObjectFactory.getObject("userService");

        try {
            List<UserTalk> list=userService.Talk();
            request.setAttribute("talk", list);
            request.getRequestDispatcher("/talk.jsp").forward(request,response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }



    }
//
    private void message(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();

        String appellation = request.getParameter("appellation");
        String time = request.getParameter("time");
        String some = request.getParameter("some");


        UserMessage userMessage = new UserMessage();
        userMessage.setAppellation(appellation);
        userMessage.setSome(some);
        userMessage.setTime(time);


        UserService userService = (UserService) ObjectFactory.getObject("userService");

        try {
            if(userService.massege(userMessage)){

                gettalk(request,response);

            }
        } catch (ServiceException e) {
            e.printStackTrace();
            out.println("留言失败");
        }
    }

    private void dongman(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");

        String dongman = request.getParameter("key");

        System.out.println(dongman);

        if(!"417".equals(dongman)){
            System.out.println(1);
            response.sendRedirect("/dongman.jsp");

        }else {
            System.out.println(2);
            request.getRequestDispatcher("/vio.jsp").forward(request,response);
        }

    }
}



