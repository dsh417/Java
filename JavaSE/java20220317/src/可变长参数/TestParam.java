package 可变长参数;

public class TestParam {
    public static void main(String... args) {
        String[] s={"111","222","333"};

        f(s);
        System.out.println("---------------------");

        f("aaa");
        System.out.println("---------------------");
        f("aaa","aaa","aaa","aaa");
        f();
    }
//String...只能作为最后一个参数
    public static void f(String... s){
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);

        }
    }
}
