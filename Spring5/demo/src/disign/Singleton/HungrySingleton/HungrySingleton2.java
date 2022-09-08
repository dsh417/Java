package disign.Singleton.HungrySingleton;

//饿汉式
public class HungrySingleton2 {
    private static final HungrySingleton2 hungrysingleton;
    static{
        hungrysingleton=new HungrySingleton2();
    }
    private HungrySingleton2(){}

    public static HungrySingleton2 getInstance(){
        return hungrysingleton;
    }
}
