package disign.Adapter.loginadapter;

public class LoginForTableAdapter implements loginAdapter{
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTableAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
