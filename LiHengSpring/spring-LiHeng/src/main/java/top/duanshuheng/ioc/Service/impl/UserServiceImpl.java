package top.duanshuheng.ioc.Service.impl;

import top.duanshuheng.ioc.Dao.UserDao;
import top.duanshuheng.ioc.Service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void regist(){
        userDao.selectByUsername();
        userDao.insert();
    }
}
