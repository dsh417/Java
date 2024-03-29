package top.duanshuheng.IOC.src.main.java.top.duanshuheng.ioc.Action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.duanshuheng.IOC.src.main.java.top.duanshuheng.ioc.annotation.GPAutowired;
import top.duanshuheng.IOC.src.main.java.top.duanshuheng.ioc.annotation.GPController;
import top.duanshuheng.IOC.src.main.java.top.duanshuheng.ioc.annotation.GPRequestMapping;
import top.duanshuheng.IOC.src.main.java.top.duanshuheng.ioc.annotation.GPRequestParam;
import top.duanshuheng.IOC.src.main.java.top.duanshuheng.ioc.service.IDemoService;
import java.io.IOException;

@GPController
@GPRequestMapping("/demo")
public class DemoAction {
    @GPAutowired private IDemoService service;

    @GPRequestMapping("/query")
    public void query(HttpServletRequest req, HttpServletResponse resp, @GPRequestParam("name") String name){
        String result=service.get(name);
        try {
            resp.getWriter().write(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GPRequestMapping("/add")
    public void add(HttpServletRequest req,HttpServletResponse resp,@GPRequestParam("a") Integer a,@GPRequestParam("b") Integer b){
        try {
            resp.getWriter().write(a+"+"+b+"="+(a+b));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GPRequestMapping("/remove")
    public void remove(HttpServletRequest req,HttpServletResponse resp,@GPRequestParam("id") Integer id){

    }
}
