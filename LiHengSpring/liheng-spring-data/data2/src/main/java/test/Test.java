package test;


import com.alibaba.fastjson.JSON;
import dao.UserDao;
import entiry.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");


//        默认帮我们做了事务
        UserDao userDao= (UserDao) ac.getBean("userDao");
        User user=new User();
        user.setUsername("aaa");
        user.setPassword("111");
//        userDao.insert(user);

//        User user=userDao.selectById(1);
//        System.out.println(JSON.toJSONString(userDao.save(user)));
        System.out.println(userDao.save(user));
//        DataSource dataSource= (DataSource) ac.getBean("dataSource");
//
//        try {
//            Connection con=dataSource.getConnection();
//            System.out.println(con  );
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
}
