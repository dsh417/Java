package Adapter.loginadapter;

import org.apache.coyote.Adapter;

public class LoginForQQAdapter implements loginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {

        return null;
    }
}
