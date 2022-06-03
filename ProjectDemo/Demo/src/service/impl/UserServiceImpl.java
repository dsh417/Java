package service.impl;

import dao.UserDao;
import entity.*;
import exception.ServiceException;
import factory.ObjectFactory;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List select() throws ServiceException {

        UserDao userDao= (UserDao) ObjectFactory.getObject("userDao");

        return userDao.select();

    }

    @Override
    public List Talk() throws ServiceException {

        UserDao userDao= (UserDao) ObjectFactory.getObject("userDao");

        return userDao.talk();
    }

    @Override
    public void regis(UserRegis userRegis) throws ServiceException {
        UserDao userDao= (UserDao) ObjectFactory.getObject("userDao");
        userDao.regis(userRegis);
    }

    @Override
    public Boolean ajax(UserAjax userAjax) throws ServiceException {
        UserDao userDao= (UserDao) ObjectFactory.getObject("userDao");
        return userDao.ajax(userAjax);
    }

    @Override
    public User Loding(UserLoding userLoding) throws ServiceException {
        UserDao userDao= (UserDao) ObjectFactory.getObject("userDao");
        return userDao.Loding(userLoding);
    }


    @Override
    public boolean massege(UserMessage userMessage) throws ServiceException {
        UserDao userDao= (UserDao) ObjectFactory.getObject("userDao");
        System.out.println("业务层进入0");
        //获取uid
        int uid=userDao.getUserForAppellation(userMessage.getAppellation());

        System.out.println("业务层进入1");
        System.out.println("uid="+uid);
        if(uid<0){
            System.out.println("获取user失败");
            return false;
            //留言失败
        }
        System.out.println("业务层进入2");
        if(!userDao.messageUpdata(userMessage,uid)){
            System.out.println("更新留言失败");
            return false;
            //留言失败
        }
        System.out.println("成功");
        return true;


    }
}
