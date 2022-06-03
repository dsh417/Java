package dao;

import entity.*;

import java.util.List;

public interface UserDao {
    /*
     * 1，封装用户信息异常
     * 2，访问数据库异常
     *
     * */
    public List select();

    public List talk();

    public void regis(UserRegis userRegis);

    public Boolean ajax(UserAjax userAjax);

    public User Loding(UserLoding userLoding);

    public Boolean messageUpdata(UserMessage userMessage,int uid);

    public int getUserForAppellation(String s);
}
