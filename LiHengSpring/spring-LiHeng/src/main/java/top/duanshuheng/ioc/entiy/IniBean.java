package top.duanshuheng.ioc.entiy;

import lombok.Data;

@Data
public class IniBean {
    private String str;
    {
//        System.out.println("调用静态代码块"+getStr());
        a();
    }

    public IniBean() {
//        System.out.println("调用构造方法");
    }

    void a(){
//        System.out.println("调用a方法"+str);
    }

    void b(){
//        System.out.println("调用销毁方法b");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("销毁方法");
        super.finalize();
    }
}
