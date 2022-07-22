package top.duanshuheng.ioc.Dao.impl;

import top.duanshuheng.ioc.Dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void selectByUsername() {
        System.out.println("查询一个用户");
    }

    @Override
    public void insert() {
        System.out.println("创建一个用户");
    }
}
