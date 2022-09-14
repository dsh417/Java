package disign.Adapter.Project;

import java.lang.reflect.Method;

public class SingtonService {


    public MeUse regist(String user,String pass,String emil){
        return new MeUse(user,pass,emil);

    }

    public MeUse loging(Method metho){
        return null;
    }
}
