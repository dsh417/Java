package disign.Adapter.loginadapter;

public class test2 {
    public static void main(String[] args) {
        IPassportForThird passportForThird =new PassportForThirdAdapter();
        passportForThird.loginForQQ("");
    }
}
