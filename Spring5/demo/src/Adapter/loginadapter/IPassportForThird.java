package Adapter.loginadapter;

public interface IPassportForThird {
    ResultMsg loginForQQ(String id);

    ResultMsg loginForSing(String id);

    ResultMsg loginForTable(String id);


    ResultMsg loginForRegist(String username,String password);

}
