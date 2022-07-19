package DisignMode.Adapter.loginadapter;

public class PassportForThirdAdapter extends SiginService implements IPassportForThird{
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForSing(String id) {
        return processLogin(id, LoginForSinaAdapter.class);
    }

    @Override
    public ResultMsg loginForTable(String id) {
        return processLogin(id, LoginForTableAdapter.class);
    }


    @Override
    public ResultMsg loginForRegist(String username, String password) {
        super.regis(username,password);
        return super.login(username,password);
    }

    private ResultMsg processLogin(String key, Class<?  extends loginAdapter> clazz) {
//        简单工厂和策略模式
        try {
            loginAdapter adapter=clazz.newInstance();
            if (adapter.support(adapter)) {
                return adapter.login(key,adapter);
            }else {
                return null;
            }

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
