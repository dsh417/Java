package Adapter.loginadapter;

import Template.jdbc.Member;

public class SiginService {

    /*
    *
    * 老系统
    * 注册方法
    * */
    public ResultMsg regis(String username,String password){
        return new ResultMsg(200,"注册成功",new Member());
    }

    /*
    * 老系统
    * 登陆方法
    * */

    public ResultMsg login(String username,String password){
        return null;
    }
}
