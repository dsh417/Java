package day01;

import java.sql.*;

public class TestJDBC2 {
    public static void main(String[] args) {
        Student s=new Student();
        s.setName("111");
        s.setAge(22);
        s.setSex(false);
        insert(s);
    }



    private  static  void selectByName(String name2){
        Connection con=null;
        PreparedStatement ps=null;

        ResultSet rs=null;
        try{
            String url="jdbc:mysql://127.0.0.1:3306/jdbc";
            String username="root";
            String password="admin";
            String driverClassName="com.mysql.cj.jdbc.Driver";

            Class.forName(driverClassName);

            con= DriverManager.getConnection(url,username,password);

            String sql=new StringBuffer()
                    .append("select * ")
                    .append("from t_student ")
                    .append("where name=? ")
                    .toString();

            ps=con.prepareStatement(sql);

            ps.setString(1,name2);

            rs=ps.executeQuery();

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
            if(ps!=null){
                try {
                    ps.close();
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

    private  static  void insert(Student s){
        Connection con=null;
        PreparedStatement ps=null;
//        ResultSet rs=null;

        try{
            String url="jdbc:mysql://127.0.0.1:3306/jdbc";
            String username="root";
            String password="admin";
            String driverClassName="com.mysql.cj.jdbc.Driver";

            Class.forName(driverClassName);

            con= DriverManager.getConnection(url,username,password);

            String sql=new StringBuffer()
                    .append("insert into t_student ")
                    .append("     (name,age,sex) ")
                    .append("values ")
                    .append("     (?,?,?) ")
                    .toString();

            ps=con.prepareStatement(sql);
            ps.setString(1,s.getName());
            ps.setInt(2,s.getAge());
            ps.setBoolean(3,s.getSex());
//            rs=ps.executeQuery();
            ps.executeUpdate();

//            while(rs.next()){
//                System.out.print(rs.getString("name"));
//                System.out.print(rs.getInt("age"));
//                System.out.print(rs.getBoolean("sex"));
//                System.out.println();
//            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try {
                    ps.close();
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

}
