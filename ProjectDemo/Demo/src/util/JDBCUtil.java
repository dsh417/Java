package util;

import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static Properties config;
    private static ThreadLocal<Connection> threadLocal;

    static {
        try {
            //threadlocal是后面插入的
            threadLocal=new ThreadLocal<Connection>();

            config=new Properties();
            config.load(JDBCUtil.class
                    .getClassLoader()
                    .getResourceAsStream("data.properties"));
            Class.forName(config.getProperty("driverClassName"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //要做： 保证一个事务一个连接 or 保证一个业务是一个连接
    //      如果在web上，每个人都来请求查询或者注册功能，那么要的其实是
    //      一个线程是一个连接（每个人都是一个线程）
    //      一个事务是一个线程
    //连接需要对线程单例
    public static Connection getConnection() {

//        Thread.currentThread().getId();
//        我用threadLocal来做，如果没有get到，就创建一个con
        Connection con = threadLocal.get();

        if(con==null){
            try {

                con = DriverManager.getConnection(
                        config.getProperty("url"),
                        config.getProperty("username"),
                        config.getProperty("password"));
                //在get的时候创建
                threadLocal.set(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return con;
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    //关闭跟本线程相关链接
    public static void close() {
        Connection con=threadLocal.get();

        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocal.remove();
        }

    }



    //    public static void main(String[] args) {
//        Connection con = JDBCUtil.getConnection();
////		System.out.println(con);
//        JDBCUtil.close(con, null, null);
//    }
}
