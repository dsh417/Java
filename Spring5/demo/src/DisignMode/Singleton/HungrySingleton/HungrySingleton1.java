package DisignMode.Singleton.HungrySingleton;

//饿汉式,类加载的时候就初始化
public class HungrySingleton1 {
    private static final HungrySingleton1 hungrysingleton=new HungrySingleton1();

    private HungrySingleton1(){}

    public static HungrySingleton1 getInstance(){
        return hungrysingleton;
    }
}
