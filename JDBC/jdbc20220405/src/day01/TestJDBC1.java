package day01;

import java.sql.*;
import java.util.Properties;

public class TestJDBC1 {
    public static void main(String[] args){

//        insert();
//        delete();
//        update();
//        select();
//        selectById(3);
        //
//

    }

    private  static  void selectById(int uid){
        Connection con=null;
        Statement stat=null;
        ResultSet rs=null;
        try{
            String url="jdbc:mysql://127.0.0.1:3306/jdbc";
            String username="root";
            String password="admin";
            String driverClassName="com.mysql.cj.jdbc.Driver";

            Class.forName(driverClassName);

            con=DriverManager.getConnection(url,username,password);

            stat=con.createStatement();

            String sql=new StringBuffer()
                    .append("select * ")
                    .append("from t_student ")
                    .append("where id=")
                    .append(uid)
                    .toString();

            rs=stat.executeQuery(sql);

            if(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                boolean sex=rs.getBoolean("sex");
                System.out.println(id+" "+name+" "+age+" "+sex);
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static void select(){
        Connection con=null;
        Statement stat=null;
        ResultSet rs=null;
        try{
            String url="jdbc:mysql://127.0.0.1:3306/jdbc";
            String username="root";
            String password="admin";
            String driverClassName="com.mysql.cj.jdbc.Driver";

            Class.forName(driverClassName);

            con=DriverManager.getConnection(url,username,password);

            stat=con.createStatement();

            String sql=new StringBuffer()
                    .append("select * ")
                    .append("from t_student ")
                    .toString();

            rs=stat.executeQuery(sql);

            while(rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                int age=rs.getInt(3);
                boolean sex=rs.getBoolean(4);
                System.out.println(id+" "+name+" "+age+" "+sex);
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void update(){
        Connection con=null;
        Statement stat=null;
        String url="jdbc:mysql://127.0.0.1:3306/jdbc";
        String username="root";
        String password="admin";
        String driverClassName="com.mysql.cj.jdbc.Driver";

        try{
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url,username,password);
            stat=con.createStatement();

            String sql=new StringBuffer()
                    .append("update t_student ")
                    .append("set name='abc' ")
                    .append("where id=3")
                    .toString();

            stat.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static void delete(){
        Connection con=null;
        Statement stat=null;
        String url="jdbc:mysql://127.0.0.1:3306/jdbc";
        String username="root";
        String password="admin";
        String driverClassName="com.mysql.cj.jdbc.Driver";

        try{
            Class.forName(driverClassName);
            con=DriverManager.getConnection(url,username,password);
            stat=con.createStatement();

            String sql=new StringBuffer()
                    .append("delete from t_student ")
                    .append("where id=2 ")
                    .toString();

            stat.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void insert(){
            //背得
        String url="jdbc:mysql://127.0.0.1:3306/jdbc";
        String username="root";
        String password="admin";
        String driverClassName="com.mysql.cj.jdbc.Driver";

        Connection con=null;
        Statement stat=null;

        try{

            Class.forName(driverClassName);
            con=DriverManager.getConnection(url,username,password);

            stat=con.createStatement();

            String sql=new StringBuffer()
                    .append("insert into t_student ")
                    .append("   (name,age,sex) ")
                    .append("values ")
                    .append("   ('aaa',22,true) ")
                    .toString();

            //增删改用executeUpdate(更新数据)
            stat.executeUpdate(sql);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void create() {
        String url="jdbc:mysql://127.0.0.1:3306/jdbc";
        String username="root";
        String password="admin";
        String driverClassName="com.mysql.cj.jdbc.Driver";

        Connection con=null;
        Statement stat=null;
        try{
            //驱动
            Driver driver=new com.mysql.jdbc.Driver();

            System.out.println(driver);

            //1.注册驱动
//            DriverManager.registerDriver(driver);
            Class.forName(driverClassName);

            //2.和数据库建立连接
            con=DriverManager.getConnection(url,username,password);

            System.out.println(con);

            //获得操作对象
            stat=con.createStatement();

            String sql=new StringBuffer()
                    .append("create table t_student( ")
                    .append("	id int primary key auto_increment, ")
                    .append("	name varchar(10), ")
                    .append("	age int, ")
                    .append("	sex boolean ")
                    .append("	) ")
                    .toString();

            stat.execute(sql);

            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
