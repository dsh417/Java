package disign.JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Pool {
    public String propertiesName = "connection-INF.properties";

    public static Pool instance = null; //唯一实例

    protected int maxConnect = 100;

    protected int normalConnect = 10; //保持连接数

    protected String driverName = null;

    protected Driver driver = null;

    //私有函数
    protected Pool() {
        try {
            init();
            loadDrivers(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception{
        InputStream is=Pool.class.getResourceAsStream(propertiesName);

        Properties p=new Properties();
        p.load(is);

        this.driverName=p.getProperty("driverName");
        this.maxConnect=Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect=Integer.parseInt(p.getProperty("normalConnect"));
    };

    protected void loadDrivers(String dri){
        String driverClassName=dri;
        try {
            driver= (Driver) Class.forName(driverClassName).newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册JDBC驱动程序"+driverClassName);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    };

    //单例模式，返回数据库连接池Pool实例
    public abstract void createPool();

    public static synchronized Pool getInstance() throws IOException,InstantiationException,IllegalAccessException,
            ClassNotFoundException{

        if(instance!=null) {
            instance = (Pool) Class.forName("org.jdbc.sqlhelper.Pool").newInstance();
        }

        return instance;
    }


    public abstract Connection getConnection();

    public abstract Connection getConnection(long time);

    public abstract void freeConnection(Connection connection);

    public abstract int getNum();

    public abstract int getNumActive();

    protected synchronized void release(){
        //撤销驱动

        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销jdbc驱动程序"+driver.getClass().getName());

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("无法撤销JDBC驱动程序的注册"+driver.getClass().getName());
        }
    }

}