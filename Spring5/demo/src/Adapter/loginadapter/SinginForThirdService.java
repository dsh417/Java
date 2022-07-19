package Adapter.loginadapter;

//稳定的方法直接继承下来
public class SinginForThirdService extends SiginService {
    public ResultMsg loginForQQ(String openId){
        return loginForRegist(openId,null);

    }

    public ResultMsg loginForWechat(String openId){
        return null;
    }

    public ResultMsg loginForToken(String token){
        return null;
    }

    public ResultMsg loginForTelphone(String telphone,String code){
        return null;
    }
    private ResultMsg loginForRegist(String username, String password) {
        super.regis(username,null);
        return super.login(username,null);
    }
}
