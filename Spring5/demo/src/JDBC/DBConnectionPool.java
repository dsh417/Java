package JDBC;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class DBConnectionPool extends Pool{
    private int checkedOut;//正在使用连接数

    //存放产生的连接对象容器
    private Vector<Connection> freeConnections=new Vector<Connection>();

    private String passWord=null;
    private String url=null;
    private String userName=null;
    private static int num=0;
    private static int numActive=0;
    private static DBConnectionPool pool=null;

    //产生数据连接池
    public static synchronized DBConnectionPool getInstance(){
        if (pool==null) {
            pool=new DBConnectionPool();
        }
        return pool;
    }

    //获得一个数据库连接池的实例
    private DBConnectionPool(){
        try {
            init();
            for (int i = 0; i < normalConnect; i++) {
                Connection c=newConnection();
                if (c!=null) {
                    freeConnections.addElement(c);
                    num++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init()throws Exception{
        InputStream is=DBConnectionPool.class.getResourceAsStream(propertiesName);
        Properties p=new Properties();
        p.load(is);
        this.userName=p.getProperty("userName");
        this.passWord=p.getProperty("passWord");
        this.driverName=p.getProperty("driverName");
        this.url=p.getProperty("url");
        this.maxConnect=Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect=Integer.parseInt(p.getProperty("norlmalConnect"));

    }

    private Connection newConnection() {
        Connection con=null;
        try {
            if (userName==null) {
                con= DriverManager.getConnection(url);
            }else {
                con=DriverManager.getConnection(url,userName,passWord);
            }
            System.out.println("连接池创建一个新的链接");
        } catch (Exception e) {
            System.out.println("无法创建这个url的链接"+url);
            e.printStackTrace();
            return null;
        }
        return con;
    }


    @Override
    public void createPool() {
        pool=new DBConnectionPool();
        if(pool!=null){
            System.out.println("创建连接词成功");
        }else {
            System.out.println("创建连接池失败");
        }
    }

    @Override
    public Connection getConnection() {
        Connection con=null;
        if (freeConnections.size()>0) {
            //还有空闲链接
            num--;
            con=(Connection) freeConnections.firstElement();
            freeConnections.removeElement(0);
            try{
                if (con.isClosed()) {
                    System.out.println("从连接池输出一个无效链接");
                    con=getConnection();
                }
            } catch (SQLException e) {
                System.out.println("从连接池输出一个无效链接");
                con=getConnection();
                e.printStackTrace();

            }

        }else if(maxConnect==0 || checkedOut<maxConnect){
            con=newConnection();
        }

        if (con!=null){
            //当前链接+1
            checkedOut++;
        }
        numActive++;
        return con;
    }

    @Override
    public synchronized Connection getConnection(long time) {
        long startTime=new Date().getTime();
        Connection con;
        while ((con=getConnection())==null){
            try {
                wait(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (new Date().getTime() - startTime >= time) {
                return null;
            }
        }
        return con;
    }

    @Override
    public synchronized void freeConnection(Connection connection) {
        freeConnections.addElement(connection);
        num++;
        checkedOut--;
        numActive--;
        notifyAll();//解锁
    }


    @Override
    public int getNum() {
        return num;
    }

    @Override
    public int getNumActive() {
        return numActive;
    }

    public synchronized void release(){
        try {
            //将当前链接复制到枚举中
            Enumeration allConnection=freeConnections.elements();
            //使用循环关闭所用链接
            while (allConnection.hasMoreElements()){
                Connection con= (Connection) allConnection.nextElement();
                try {
                    con.close();
                    num--;
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("无法关闭连接池中的链接");
                }
            }
        } finally {
            super.release();
        }
    }
}
