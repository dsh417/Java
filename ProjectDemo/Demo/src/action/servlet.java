package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface servlet {
    //从服务器拿数据并封装成Flight
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}