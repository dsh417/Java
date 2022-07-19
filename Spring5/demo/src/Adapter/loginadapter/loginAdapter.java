package Adapter.loginadapter;

public interface loginAdapter {
    boolean support(Object adapter);

    ResultMsg login(String id,Object adapter);
}


